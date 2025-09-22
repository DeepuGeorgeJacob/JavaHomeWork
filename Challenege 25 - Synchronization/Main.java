import classes.Consumer;
import classes.Producer;
import classes.ShoeWarehouse;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        final ShoeWarehouse warehouse = new ShoeWarehouse();
        final Producer producer = new Producer(warehouse);
        final Consumer consumer1 = new Consumer(warehouse,"Alex");
        final Consumer consumer2 = new Consumer(warehouse,"Mike");
        producer.start();
        consumer1.start();
        consumer2.start();
        try {
            producer.join();
            consumer1.join();
            consumer2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("✅ All 10 orders have been fulfilled!");
    }
}