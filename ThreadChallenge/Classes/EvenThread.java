package Classes;

public class EvenThread extends Thread {

    @Override
    public void run() {
        final String currentThreadName = currentThread().getName();
        int count = 0;
        int num = 2;

        for (int i = 2; i <= 10; i += 2) {
            System.out.println("Even Thread name ("+ currentThreadName +"), Count " + i + " ");
            try {
                sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Event thread interrupted");
            }
        }
        System.out.println();
    }
}
