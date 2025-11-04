package org.example;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private final String name;
    private final List<Product> products = new ArrayList<>();

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
