//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Meal meal = new Meal("Classic Burger", 5.99);
        meal.addToppings("cheese", "bacon", "lettuce", "tomato");
        meal.printMeal();

    }
}