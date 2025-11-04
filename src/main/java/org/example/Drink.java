package org.example;

public class Drink extends Product {

    private final int volume;

    public Drink(String name, double price, int volume) {
        super(name, price);
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


