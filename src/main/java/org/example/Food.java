package org.example;

public final class Food extends Product {

    private final int weight;

    public Food(String name, double price, int weight, ProductCategory category) {
        super(name, price, category);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString() + " – Gramaj: " + weight + "g";
    }

    public int getWeight() {
        return weight;
    }

}

