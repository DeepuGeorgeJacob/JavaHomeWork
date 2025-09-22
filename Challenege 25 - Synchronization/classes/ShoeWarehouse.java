package classes;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShoeWarehouse {
    private static final List<String> productList = List.of("Boots", "Sandals", "Sneakers");
    private final Queue<Order> orders = new LinkedList<>();
    private static final int MAXIMUM_CAPACITY = 5;

    public synchronized void receiveOrder(Order order) throws InterruptedException {
        while (orders.size() >= MAXIMUM_CAPACITY) {
            System.out.println("Producer waiting: warehouse is full");
            wait();
        }
        orders.add(order);
        System.out.println("Order [" + order + "] received");
        notifyAll();
    }

    public synchronized Order fulfillOrder(final String consumerName) throws InterruptedException {
        while (orders.isEmpty()) {
            System.out.println(consumerName + " has to wait for new order");
            wait();
        }
        final Order order = orders.poll();
        System.out.println("Order [" + order + "] fulfilled by " + consumerName);
        notifyAll();
        return order;
    }

    public List<String> getProductList() {
        return productList; // safe because it's immutable
    }
}
