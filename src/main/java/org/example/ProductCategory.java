package org.example;

import java.util.HashMap;

public class ProductCategory {
    private final String name;
    private final HashMap<String, Product> products;

    public enum Type {
        APPETIZER,
        MAIN_COURSE,
        DESSERT,
        COOLING_DRINK,
        ALCOHOL_DRINK,
    }

    public String toString(Type category) {
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

    public ProductCategory(String name) {
        this.name = name;
        this.products = new HashMap<>();
    }
    public ProductCategory(String name, HashMap<String, Product> products) {
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("ProductCategory [name=").append(name).append(", products=").append(products).append("]");
        return sb.toString();
    }
}
