package org.example;

public final class Drink extends Product {

    private final int volume;

    public Drink(String name, double price, int volume ,ProductCategory category) {
        super(name, price, category);
        this.volume = volume;
    }

    @Override
    public String toString() {
        return super.toString() + " – Volum: " + volume + "ml";
    }

    public int getVolume() {
        return volume;
    }

}


