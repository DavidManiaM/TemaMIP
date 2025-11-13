package org.example;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Menu {

    HashMap<String, Product> appetizers;
    HashMap<String, Product> mainDishes;
    HashMap<String, Product> desserts;
    HashMap<String, Product> coolingDrinks;
    HashMap<String, Product> alcoholicDrinks;

    HashMap<Product.ProductCategory, HashMap<String, Product>> menu;

    Menu() {
        appetizers = new HashMap<>(Map.of(
                "Mozzarella Sticks", new Food("Mozzarella Sticks", 15, 200, Product.ProductCategory.APPETIZER),
                "Garlic Parmesan Fries", new Food("Garlic Parmesan Fries", 18.5, 250, Product.ProductCategory.APPETIZER)
        ));
        mainDishes = new HashMap<>(Map.of(
                "Pizza Margherita", new Food("Pizza Margherita", 45, 450, Product.ProductCategory.MAIN_COURSE),
                "Paste Carbonara", new Food("Paste Carbonara", 52.5, 400, Product.ProductCategory.MAIN_COURSE)
        ));
        desserts = new HashMap<>(Map.of(
                "Lava Cake", new Food("Lava Cake", 20, 300, Product.ProductCategory.DESSERT),
                "Tiramisu", new Food("Tiramisu", 22, 350, Product.ProductCategory.DESSERT),
                "Cheesecake", new Food("Cheesecake", 30, 300, Product.ProductCategory.DESSERT)
        ));
        coolingDrinks = new HashMap<>(Map.of(
                "Limonada", new Drink("Limonada", 15, 400, Product.ProductCategory.COOLING_DRINK),
                "Apa plata", new Drink("Apa plata", 8, 500, Product.ProductCategory.COOLING_DRINK)
        ));
        alcoholicDrinks = new HashMap<>(Map.of(
                "Bere", new Drink("Bere", 8, 500, Product.ProductCategory.ALCOHOL_DRINK),
                "Vin alb sec", new Drink("Vin alb sec", 8, 500, Product.ProductCategory.ALCOHOL_DRINK),
                "Coniac", new Drink("Coniac", 8, 500, Product.ProductCategory.ALCOHOL_DRINK)
        ));
        menu = new HashMap<>(Map.of(
                Product.ProductCategory.APPETIZER, appetizers,
                Product.ProductCategory.MAIN_COURSE, mainDishes,
                Product.ProductCategory.DESSERT, desserts,
                Product.ProductCategory.COOLING_DRINK, coolingDrinks,
                Product.ProductCategory.ALCOHOL_DRINK, alcoholicDrinks
        ));
    }

}
