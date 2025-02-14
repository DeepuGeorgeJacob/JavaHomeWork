package com.app.store;

import java.util.ArrayList;
import java.util.List;

abstract class ProductForSale {
    private final String type;
    private final double price;
    private final String description;

    public ProductForSale(final String type, final double price,final String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public double getSalesPrice(final int quantity) {
        return quantity * price;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public void printItemizedLine(final int quantity) {
        System.out.println(quantity + " x " + type + " - $" + String.format("%.2f", getSalesPrice(quantity)));
    }

    public abstract void showDetails();
}

class MobilePhone extends ProductForSale {
    private final String model;

    public MobilePhone(final String type, final double price,final String description,final String model) {
        super(type, price, description);
        this.model = model;
    }

    @Override
    public void showDetails() {
        System.out.println("Iphone - " + model + " - Description : "+ getDescription() +" -  price: " + super.getSalesPrice(1));
    }
}

class Furniture extends ProductForSale {
    private final String material;

    public Furniture(final String type, final double price,final String description,final String material) {
        super(type, price, description);
        this.material = material;
    }

    @Override
    public void showDetails() {
        System.out.println("Furniture("+ getType() +") - Material: " + material + " - " + super.getSalesPrice(1));
    }
}

class Grocery extends ProductForSale {
    private final String expirationDate;

    public Grocery(final String type, final double price, final String description, final String expirationDate) {
        super(type, price, description);
        this.expirationDate = expirationDate;
    }

    @Override
    public void showDetails() {
        System.out.println("Grocery("+ getType() +") - Expires on: " + expirationDate + " - " + super.getSalesPrice(1));
    }
}

class OrderItem {
    private final ProductForSale product;
    private final int quantity;

    public OrderItem(final ProductForSale product,final int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return product.getSalesPrice(quantity);
    }

    public void printOrderLine() {
        product.printItemizedLine(quantity);
    }
}

public class Store {
    private final List<ProductForSale> products;
    private final List<OrderItem> order;

    public Store() {
        products = new ArrayList<>();
        order = new ArrayList<>();
    }

    public void addProduct(final ProductForSale product) {
        products.add(product);
    }

    public void displayProducts() {
        System.out.println("\nAvailable Products:");
        for (final ProductForSale productForSale : products) {
            productForSale.showDetails();
        }
    }

    public void addToOrder(final int productIndex, final int quantity) {
        if (productIndex >= 1 && productIndex <= products.size()) {
            ProductForSale product = products.get(productIndex - 1);
            order.add(new OrderItem(product, quantity));
            System.out.println(quantity + " x " + product.getType() + " added to order.");
        } else {
            System.out.println("Invalid product selection.");
        }
    }

    public void printReceipt() {
        System.out.println("\nSales Receipt:");
        double total = 0;
        for (OrderItem item : order) {
            item.printOrderLine();
            total += item.getTotalPrice();
        }
        System.out.println("Total: $" + String.format("%.2f", total));
    }

    public static void main(String[] args) {
        final Store store = new Store();

        store.addProduct(new MobilePhone("Iphone", 399.99, "Revolutionary Iphone 13", "13"));
        store.addProduct(new Furniture("Chair", 59.99, "Wooden dining chair", "Oak"));
        store.addProduct(new Grocery("Milk", 3.49, "Fresh organic milk", "2025-05-01"));

        store.displayProducts();


        System.out.println("\nOrder in the basket");
        store.addToOrder(1, 1);
        store.addToOrder(2, 2);
        store.addToOrder(3, 2);

        store.printReceipt();
    }
}
