package org.example;

import org.example.utils.OrderElement;
import org.example.utils.SpecialOffer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class Order {

    public static final int TVA = 9;
    List<OrderElement> elements = new ArrayList<OrderElement>();
    public int discount = 0;
    public Optional<SpecialOffer> activeSpecialOffer;

    SpecialOffer _10PercentOver5Products = new SpecialOffer() {
        @Override
        public String getName() {
            return "10% reducere pentru 5 sau mai multe produse";
        }

        @Override
        public boolean isApplicable() {
            int nrOfProducts = 0;
            for (OrderElement element : elements) {
                nrOfProducts += element.quantity;
            }
            return nrOfProducts >= 5;
        }

        @Override
        public void applyOffer() {

            if(isApplicable()) {
                discount = 20;
            }
        }
    };
    SpecialOffer pizza1Plus1Free = new SpecialOffer() {
        @Override
        public String getName() {
            return "Pizza 1 + 1 gratis";
        }

        @Override
        public boolean isApplicable() {
            boolean hasPizza = false;
            for (OrderElement element : elements) {
                if(element.getProduct().getName().equals("Pizza")) {
                    hasPizza = true;
                    break;
                }
            }

            return hasPizza;
        }

        @Override
        public void applyOffer() {
           if(isApplicable()) {
               elements.add(new OrderElement(1, new Food("Pizza Margherita", 45, 450)));
           }
        }
    };


    public Order(){
        activeSpecialOffer = Optional.ofNullable(_10PercentOver5Products);
    }

    public double getTotal(){
        double total = 0;

        if(activeSpecialOffer.isPresent()){
            activeSpecialOffer.get().applyOffer();
        }

        for (OrderElement element : elements){
            total += element.getPrice();
        }
        return total * ((100 - discount) / 100.0);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Order {\n");
        for (OrderElement element : elements){
            str.append("\t" + element.toString() + "\n");
        }

        if(activeSpecialOffer.isPresent() && activeSpecialOffer.get().isApplicable()){
            str.append("------------------------------\n\tOferta activa: " + activeSpecialOffer.get().getName() + "\n");
        }

        str.append("------------------------------\n\tTotal cu TVA: " + getTotal() + "\n");

        String rawPriceString = String.format("%.2f", getTotal() * 100 / (100 + TVA));
        str.append("\n\tTotal fara TVA: " + rawPriceString + "\n");

        return str.append("}").toString();
    }

    public void addElement(OrderElement element){
        elements.add(element);
    }

    public void addElement(int quantity, Product product){
        elements.add(new OrderElement(quantity, product));
    }
}
