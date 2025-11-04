package org.example;

import org.example.utils.OrderElement;

import java.util.ArrayList;
import java.util.List;

public class Order {

    public static final int TVA = 9;
    List<OrderElement> elements = new ArrayList<OrderElement>();

    public Order(){}

    public double getTotal(){
        double total = 0;
        for (OrderElement element : elements){
            total += element.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Order{\n");
        for (OrderElement element : elements){
            str.append("\t" + element.toString() + "\n");
        }

        return str.append("}").toString();
    }

    public void addElement(OrderElement element){
        elements.add(element);
    }

    public void addElement(int quantity, Product product){
        elements.add(new OrderElement(quantity, product));
    }
}
