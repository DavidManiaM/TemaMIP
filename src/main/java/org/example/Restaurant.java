package org.example;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private final String name;
    @JsonIgnore
    private List<Product> products = new ArrayList<>();
    private Menu menu = new Menu();
    @JsonIgnore
    private List<Order> orders = new ArrayList<>();

    public Restaurant(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder toReturn = new StringBuilder("--- Meniul Restaurantului \"" + name + "\" ---\n");

        for (Product p : products) {
            toReturn.append(p.toString()).append("\n");
        }

        toReturn.append("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−\n");

        return toReturn.toString();
    }

    public void addProduct(Product p) {
        products.add(p);
    }
}
