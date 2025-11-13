package org.example;

public abstract sealed class Product permits Food, Drink {

    public enum ProductCategory {
        APPETIZER,
        MAIN_COURSE,
        DESSERT,
        COOLING_DRINK,
        ALCOHOL_DRINK,
    }

    public String toString(ProductCategory category) {
        switch (category) {
            case APPETIZER:
                return "Aperitiv";
            case MAIN_COURSE:
                return "Fel principal";
            case DESSERT:
                return "Desert";
            case COOLING_DRINK:
                return "Bautura racoritoare";
            case ALCOHOL_DRINK:
                return "Bautura alcoolica";
        };
        return  "";
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
