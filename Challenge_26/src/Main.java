import Warehouse.Order;
import Warehouse.ShoeWarehouse;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final Random random = new Random();

    public static void main(String[] args) {

        final ShoeWarehouse warehouse = new ShoeWarehouse(2);


        final ExecutorService producerPool = Executors.newCachedThreadPool();

        final int numberOfOrder = 15;
        warehouse.startConsumers(numberOfOrder);

        producerPool.submit(()->{
            for (int j = 0; j < numberOfOrder; j++) {
                warehouse.receiveOrder(new Order(
                        random.nextLong(1000000, 9999999),
                        ShoeWarehouse.PRODUCT_LIST[random.nextInt(0,
                                ShoeWarehouse.PRODUCT_LIST.length)],
                        random.nextInt(1, 4)));
            }
        });



        producerPool.shutdown();
        warehouse.shutdown();

       /* for (int i = 0; i < 2; i++) {
            Thread consumerThread = new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    Order order = warehouse.fulfillOrder();
                }
            });
            consumerThread.start();
        }*/
    }

}
