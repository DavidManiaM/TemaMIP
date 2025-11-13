package org.example;

public abstract sealed class Product permits Food, Drink {

    public enum ProductCategory {
        APPETIZER,
        MAIN_COURSE,
        DESSERT,
        COOLING_DRINK,
        ALCOHOL_DRINK,
    }

    private final String name;
    private double price;
    ProductCategory category;

    public Product(String name, double price, ProductCategory category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return "> " + name + " – " + price + " RON";
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }
}
