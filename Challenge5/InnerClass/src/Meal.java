import java.util.ArrayList;
import java.util.List;


// Meal class
class Meal {
    private Burger burger;

    public Meal(String burgerName, double burgerPrice) {
        this.burger = new Burger(burgerName, burgerPrice);
    }

    // Inner Burger class
    class Burger extends Item {
        private List<Item> toppings;

        public Burger(String name, double price) {
            super(name, "Burger", price);
            this.toppings = new ArrayList<>();
        }

        public void addToppings(String... toppingNames) {
            for (String topping : toppingNames) {
                double price = getToppingPrice(topping);
                toppings.add(new Item(topping, "Topping", price));
            }
        }

        private double getToppingPrice(String topping) {
            // Define some toppings with extra costs
            return switch (topping.toLowerCase()) {
                case "cheese", "bacon" -> 1.50;
                case "lettuce", "tomato", "onion" -> 0.00;
                default -> 0.50; // Default price for unknown toppings
            };
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(super.toString());
            sb.append("\nToppings:");
            if (toppings.isEmpty()) {
                sb.append(" None");
            } else {
                for (Item topping : toppings) {
                    sb.append("\n  - ").append(topping.toString());
                }
            }
            return sb.toString();
        }
    }

    public void addToppings(String... toppings) {
        burger.addToppings(toppings);
    }

    public void printMeal() {
        System.out.println(burger);
    }
}

