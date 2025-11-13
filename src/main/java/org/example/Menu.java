package org.example;

import java.awt.*;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    ProductCategory appetizers = new ProductCategory("Aperitive");
    ProductCategory mainDishes;
    ProductCategory desserts;
    ProductCategory coolingDrinks;
    ProductCategory alcoholicDrinks;

    HashMap<ProductCategory.Type, ProductCategory> menu;


    Menu() {
        appetizers = new ProductCategory("Aperitive",
                new HashMap<>(Map.of(
                    "Mozzarella Sticks", new Food("Mozzarella Sticks", 15, 200),
                    "Garlic Parmesan Fries", new Food("Garlic Parmesan Fries", 18.5, 250)
                )));
        mainDishes = new ProductCategory("Main Dishes",
                new HashMap<>(Map.of(
                        "Pizza Margherita", new Food("Pizza Margherita", 45, 450),
                        "Paste Carbonara", new Food("Paste Carbonara", 52.5, 400)
                )));
        desserts =  new ProductCategory("Desserts",
                new HashMap<>(Map.of(
                        "Lava Cake", new Food("Lava Cake", 20, 300),
                        "Tiramisu", new Food("Tiramisu", 22, 350),
                        "Cheesecake", new Food("Cheesecake", 30, 300)
                )));
        coolingDrinks = new ProductCategory("Cooling Drinks",
                new HashMap<>(Map.of(
                        "Limonada", new Drink("Limonada", 15, 400),
                        "Apa plata", new Drink("Apa plata", 8, 500)
                )));
        alcoholicDrinks = new ProductCategory("Alcoholic",
                new HashMap<>(Map.of(
                        "Bere", new Drink("Bere", 8, 500),
                        "Vin alb sec", new Drink("Vin alb sec", 8, 500),
                        "Coniac", new Drink("Coniac", 8, 500)
                )));

        menu = new HashMap<>(Map.of(
                ProductCategory.Type.APPETIZER, appetizers,
                ProductCategory.Type.MAIN_COURSE, mainDishes,
                ProductCategory.Type.DESSERT, desserts,
                ProductCategory.Type.COOLING_DRINK, coolingDrinks,
                ProductCategory.Type.ALCOHOL_DRINK, alcoholicDrinks
        ));

    }

    private void appendCategoryToSB(StringBuilder sb, ProductCategory category) {
        sb.append(category.getName()).append("\n");
        for(Map.Entry<String, Product> entry : category.getProducts().entrySet()){
            sb.append("\t\t" + entry.getKey() + "\n");
        }
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Meniu:\n");

        appendCategoryToSB(sb, appetizers);
        appendCategoryToSB(sb, mainDishes);
        appendCategoryToSB(sb, desserts);
        appendCategoryToSB(sb, coolingDrinks);
        appendCategoryToSB(sb, alcoholicDrinks);

        return sb.toString();
    }

    public ProductCategory chooseCategory(){
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

    public void printCategory(ProductCategory  category) {
        for(Map.Entry<String, Product> entry : category.getProducts().entrySet()){
            System.out.println(entry.getKey());
        }
    }

}
