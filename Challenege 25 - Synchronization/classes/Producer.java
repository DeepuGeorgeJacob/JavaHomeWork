package classes;

import java.util.List;

public class Producer extends Thread {
    private final ShoeWarehouse shoeWarehouse;
    public Producer(final ShoeWarehouse shoeWarehouse) {
        this.shoeWarehouse = shoeWarehouse;

    }

    @Override
    public void run() {

        final List<String> productList = shoeWarehouse.getProductList();

        for (int i = 0; i < 10; i++) {
            String shoeType = productList.get( i % productList.size());
            Order order = new Order(i,shoeType,(i % 3) + 1);
            try {
                shoeWarehouse.receiveOrder(order);
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
