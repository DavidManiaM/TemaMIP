package org.example;

import java.awt.*;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    HashMap<String, Product> appetizers;
    HashMap<String, Product> mainDishes;
    HashMap<String, Product> desserts;
    HashMap<String, Product> coolingDrinks;
    HashMap<String, Product> alcoholicDrinks;

    HashMap<Product.ProductCategory, HashMap<String, Product>> menu;

    private void appendCategoryToSB(StringBuilder sb, HashMap<String, Product> category) {
        for(Map.Entry<String, Product> entry : category.entrySet()){
            sb.append("\t\t" + entry.getKey() + "\n");
        }
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Meniu:\n");

        sb.append("\t1. Aperitive:\n");
        appendCategoryToSB(sb, appetizers);
        sb.append("\t2. Feluri principale:\n");
        appendCategoryToSB(sb, mainDishes);
        sb.append("\t3. Deserturi:\n");
        appendCategoryToSB(sb, desserts);
        sb.append("\t4. Bauturi racoritoare:\n");
        appendCategoryToSB(sb, coolingDrinks);
        sb.append("\t5. Bauturi alcoolice:\n");
        appendCategoryToSB(sb, alcoholicDrinks);

        return sb.toString();
    }

    public HashMap<String, Product> chooseCategory(){
        System.out.println("Alege ce produse doresti sa vezi:");
        System.out.println("\t1. Aperitive:");
        System.out.println("\t2. Feluri principale:");
        System.out.println("\t3. Deserturi:");
        System.out.println("\t4. Bauturi racoritoare:");
        System.out.println("\t5. Bauturi alcoolice:");

        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("Alege un numar valid!");

            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                sc.nextLine();
            }

        } while(choice < 1 || choice > 5);

        return switch (choice) {
            case 1 -> appetizers;
            case 2 -> mainDishes;
            case 3 -> desserts;
            case 4 -> coolingDrinks;
            case 5 -> alcoholicDrinks;
            default -> null;
        };

    }

    public void printCategory(HashMap<String, Product> category) {
        for(Map.Entry<String, Product> entry : category.entrySet()){
            System.out.println(entry.getKey());
        }
    }

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
