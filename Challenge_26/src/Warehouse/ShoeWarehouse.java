package Warehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShoeWarehouse {

    private final List<Order> shippingItems;

    public final static String[] PRODUCT_LIST =
            {"Running", "Walking", "Football",
                    "Basketball", "Tennis", "Badminton"};

    private final ExecutorService consumerPool;

    public ShoeWarehouse(int consumerCount) {
        this.shippingItems = new ArrayList<>();
        this.consumerPool = Executors.newFixedThreadPool(consumerCount);
    }

    public synchronized void receiveOrder(Order item) {
        while (shippingItems.size() > 20) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        shippingItems.add(item);
        System.out.println("Incoming: " + item);
        notifyAll();
    }

    private synchronized Order fulfillOrder() {
        while (shippingItems.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Order item = shippingItems.remove(0);
        System.out.println(Thread.currentThread().getName()
                + " Fulfilled: " + item);
        notifyAll();
        return item;
    }

    public void startConsumers(int numberOfOrders) {
        for (int i = 0; i < numberOfOrders; i++) {
            consumerPool.submit(this::fulfillOrder);
        }
    }

    public void shutdown() {
        consumerPool.shutdown();
    }
}
