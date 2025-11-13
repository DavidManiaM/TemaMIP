package org.example;

import java.util.Comparator;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {

//        Restaurant restaurant = new Restaurant("La Andrei");
//
//        restaurant.addProduct(new Food("Pizza Margherita", 45, 450, Product.ProductCategory.MAIN_COURSE));
//        restaurant.addProduct(new Food("Paste Carbonara", 52.5, 400, Product.ProductCategory.MAIN_COURSE));
//        restaurant.addProduct(new Drink("Limonada", 15, 400, Product.ProductCategory.COOLING_DRINK));
//        restaurant.addProduct(new Drink("Apa plata", 8, 500, Product.ProductCategory.COOLING_DRINK));
//
//        System.out.println(restaurant);
//
//
//
//
//
//        Order order = new Order();
//        order.addElement(3, new Food("Pizza Margherita", 45, 450, Product.ProductCategory.MAIN_COURSE));
//        order.addElement(1, new Food("Paste Carbonara", 52.5, 400, Product.ProductCategory.MAIN_COURSE));
//        order.addElement(3, new Drink("Limonada", 15, 400, Product.ProductCategory.COOLING_DRINK));
//        System.out.println(order);

        Menu menu = new Menu();
//        System.out.println(menu);

        menu.printProductType(menu.chooseProductType());

        System.out.println("Vegetarian products sorted by name:");
        menu.getProducts().stream()
                .filter(Product::isVegetarian)
                .sorted(Comparator.comparing(Product::getName))
                .forEach(System.out::println);

        OptionalDouble avg = menu.getProducts().stream()
                .filter(product -> product.getType() == Product.Type.DESSERT)
                .mapToDouble(Product::getPrice)
                .average();

        if (avg.isPresent()) {
            String avgStr = String.format("%.1f", avg.getAsDouble());
            System.out.println("\nAverage price: " + avgStr + " RON");
        }

        System.out.println("Numarul produselor mai scumpe de 100 RON: " + menu.getProducts().stream()
                .filter(product -> product.getPrice() > 100.0)
                .count());

        System.out.println();
        menu.printSearchProduct("Apa plata");
        System.out.println();


        Pizza specialPizza = new Pizza.Builder()
                .addTopping(Pizza.Topping.MOZZARELLA)
                .addTopping(Pizza.Topping.MUSHROOMS)
                .addTopping(Pizza.Topping.HAM)
                .addTopping(Pizza.Topping.PEPPERONI)
                .build();

        System.out.println(specialPizza);
    }
}
