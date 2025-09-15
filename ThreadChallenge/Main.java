import Classes.EvenThread;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        final EvenThread evenThread = new EvenThread();

        final Thread oddThread = new Thread(() -> {
            final String currentThreadName = currentThread().getName();

            for (int i = 1; i <= 9; i += 2) {
                System.out.println("Odd Thread name ("+ currentThreadName +") , Count " + i + " ");
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Odd thread interrupted");
                }
            }
            System.out.println();

        });
        oddThread.start();
        evenThread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        evenThread.interrupt();
        oddThread.interrupt();

        System.out.println("Main thread requested interruption!");

    }
}