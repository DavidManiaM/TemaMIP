package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) throws IOException {


//        Order order = new Order();
//        order.addElement(3, new Food("Pizza Margherita", 45, 450, Product.ProductCategory.MAIN_COURSE));
//        order.addElement(1, new Food("Paste Carbonara", 52.5, 400, Product.ProductCategory.MAIN_COURSE));
//        order.addElement(3, new Drink("Limonada", 15, 400, Product.ProductCategory.COOLING_DRINK));
//        System.out.println(order);

//        Menu menu = new Menu();
////        System.out.println(menu);
//
//        menu.printProductType(menu.chooseProductType());
//
//        System.out.println("Vegetarian products sorted by name:");
//        menu.getProducts().stream()
//                .filter(Product::isVegetarian)
//                .sorted(Comparator.comparing(Product::getName))
//                .forEach(System.out::println);
//
//        OptionalDouble avg = menu.getProducts().stream()
//                .filter(product -> product.getType() == Product.Type.DESSERT)
//                .mapToDouble(Product::getPrice)
//                .average();
//
//        if (avg.isPresent()) {
//            String avgStr = String.format("%.1f", avg.getAsDouble());
//            System.out.println("\nAverage price: " + avgStr + " RON");
//        }
//
//        System.out.println("Numarul produselor mai scumpe de 100 RON: " + menu.getProducts().stream()
//                .filter(product -> product.getPrice() > 100.0)
//                .count());
//
//        System.out.println();
//        menu.printSearchProduct("Apa plata");
//        System.out.println();
//
//
//        Pizza specialPizza = new Pizza.Builder()
//                .addTopping(Pizza.Topping.MOZZARELLA)
//                .addTopping(Pizza.Topping.MUSHROOMS)
//                .addTopping(Pizza.Topping.HAM)
//                .addTopping(Pizza.Topping.PEPPERONI)
//                .build();
//
//        System.out.println(specialPizza);

        Path RestaurantConfigFilePath = Path.of("configRestaurant.json");
        Path MenuConfigFilePath = Path.of("configMenu.json");

        ObjectMapper mapper = new ObjectMapper();
        try {

            // Serialize the Restaurant object to configRestaurant.json
            Restaurant restaurant = new Restaurant("La Andrei");
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(restaurant);
            Files.writeString(RestaurantConfigFilePath, jsonString);
            System.out.println("Successfully wrote to '" + RestaurantConfigFilePath + "'");

            // Deserialize the Restaurant object from configRestaurant.json
            Restaurant newRestaurant = mapper.readValue(RestaurantConfigFilePath.toFile(), Restaurant.class);
            System.out.println("Successfully read from '" + RestaurantConfigFilePath + "'");
            System.out.println(newRestaurant);

        } catch (JsonProcessingException e) {
            System.err.println("JSON syntax or mapping error in '" + RestaurantConfigFilePath + "'. Please check the file content.");
        } catch (IOException e) {
            System.err.println("An error occurred while processing '" + RestaurantConfigFilePath + "'.");
        }


        try {

            // Serialize the Menu object to configMenu.json
            Menu menu = new Menu();
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(menu);
            Files.writeString(MenuConfigFilePath, jsonString);
            System.out.println("Successfully wrote to '" + MenuConfigFilePath + "'");

            // Deserialize the Menu object from configMenu.json
            Menu newMenu = mapper.readValue(MenuConfigFilePath.toFile(), Menu.class);
            System.out.println("Successfully read from '" + MenuConfigFilePath + "'");
            System.out.println(newMenu);

        } catch (JsonProcessingException e) {
            System.err.println("JSON syntax or mapping error in '" + MenuConfigFilePath + "'. Please check the file content.");
        } catch (IOException e) {
            System.err.println("An error occurred while processing '" + MenuConfigFilePath + "'.");
        }
    }
}