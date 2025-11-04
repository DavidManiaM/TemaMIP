package org.example;

public class Main {
    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant("La Andrei");

        restaurant.addProduct(new Food("Pizza Margherita", 45, 450));
        restaurant.addProduct(new Food("Paste Carbonara", 52.5, 400));
        restaurant.addProduct(new Drink("Limonada", 15, 400));
        restaurant.addProduct(new Drink("Apa plata", 8, 500));

        System.out.println(restaurant);





        Order order = new Order();
        order.addElement(3, new Food("Pizza Margherita", 45, 450));
        System.out.println(order);

    }
}
