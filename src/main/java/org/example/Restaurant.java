package org.example;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private final String name;
    @JsonIgnore
    private List<Product> products = new ArrayList<>();
    private final Menu menu = new Menu();

    public Restaurant(String name) {
        this.name = name;
        products = menu.getProducts();
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

    public Menu getMenu() {
        return menu;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }
}
