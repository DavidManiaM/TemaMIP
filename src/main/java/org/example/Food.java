package org.example;

public class Food extends Product {

    private final int weight;

    public Food(String name, double price, int weight) {
        super(name, price);
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

