package classes;

public class Consumer extends Thread {
    private final ShoeWarehouse shoeWarehouse;
    private final String consumerName;

    public Consumer(final ShoeWarehouse shoeWarehouse, final String consumerName) {
        this.shoeWarehouse = shoeWarehouse;
        this.consumerName = consumerName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Order order = shoeWarehouse.fulfillOrder(consumerName);
                Thread.sleep(600);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
