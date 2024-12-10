package com.education.ztu;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Milk", 1.50));
        products.add(new Product("Bread", 0.90));
        products.add(new Product("Butter", 2.40));

        products.addAll(Collections.singletonList(new Product("Cheese", 3.10)));
        System.out.println("First product: " + products.get(0));
        System.out.println("Index of Bread: " + products.indexOf(new Product("Bread", 0.90)));
        System.out.println("Last index of Milk: " + products.lastIndexOf(new Product("Milk", 1.50)));
        System.out.println("Size: " + products.size());
    }
}