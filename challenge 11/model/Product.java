package model;

import java.util.Objects;
import java.util.UUID;

record Product(String sku, String name, String manufacturer, Category category) implements Comparable<Product> {
    public Product(String sku, String name, String manufacturer, Category category) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.category = category;
        if (sku == null) {
            this.sku = UUID.randomUUID().toString();
        } else {
            this.sku = sku;
        }
    }

    @Override
    public int compareTo(Product product) {
        return this.name.compareTo(product.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Product)) return false;
        final Product product = (Product) obj;
        return product.name.equals(this.name) && product.manufacturer.equals(this.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.manufacturer);
    }
}