import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] names = {"Anna", "John", "Bob", "Emma", "Noon", "David", "Eve"};
        Random random = new Random();

        Arrays.setAll(names, i -> {
            String firstName = names[i].toLowerCase();
            char middleInitial = (char) ('A' + random.nextInt(26));
            String lastName = new StringBuilder(firstName).reverse().toString();
            return capitalize(firstName) + " " + middleInitial + ". " + capitalize(lastName);
        });

        for (String name : names) {
            System.out.println(name);
        }

    }

    public static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}