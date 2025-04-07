import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] names = {"Mari", "jOHN", "sArAh"};
        UnaryOperator<String> uCase = String::toUpperCase;
        List<UnaryOperator<String>> operations = List.of(
                String::trim,
                Main::addTitle,
                uCase,
                Main::addInitial,
                Main::addReversedLastName,
                Main::addSuffix
        );

        transformNames(names, operations);
        Arrays.asList(names).forEach(System.out::println);

    }

    public static String addInitial(String name) {
        UnaryOperator<String> addInitial = str -> {
            char middleInitial = (char) ('A' + new Random().nextInt(26));
            return str + " " + middleInitial + ".";
        };
        return addInitial.apply(name);

    }

    public static String addTitle(String name) {
        return name.length() > 4 ? "Ms. " + name : "Mr. " + name;
    }

    public static void transformNames(String[] names, List<UnaryOperator<String>> functions) {
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            for (UnaryOperator<String> fn : functions) {
                name = name.transform(fn);
            }
            names[i] = name;
        }
    }

    public static String addReversedLastName(String name) {
        UnaryOperator<String> reverseString = str -> new StringBuilder(str).reverse().toString();
        String[] parts = name.split(" ");
        String firstName = parts.length > 1 ? parts[1] : parts[0];
        String reversed = reverseString.apply(firstName);
        return name + " " + reversed;
    }

    public static String addSuffix(String name) {
        return name + " 🌟";
    }
}