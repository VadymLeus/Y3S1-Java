package com.education.ztu;

import java.util.*;

public class MainCollections {
    public static void main(String[] args) {
        List<Product> productList = Arrays.asList(
                new Product("Car", 20000.00),
                new Product("Bike", 500.00),
                new Product("Scooter", 1500.00)
        );

        Collections.sort(productList, Comparator.comparingDouble(Product::getPrice));
        System.out.println("Sorted by price: " + productList);

        Collections.sort(productList, Comparator.comparing(Product::getName));
        System.out.println("Sorted by name: " + productList);

        int index = Collections.binarySearch(productList, new Product("Bike", 500.00), Comparator.comparingDouble(Product::getPrice));
        System.out.println("Binary search for Bike by price: " + index);

        Collections.reverse(productList);
        System.out.println("Reversed list: " + productList);

        Collections.shuffle(productList);
        System.out.println("Shuffled list: " + productList);

        List<Product> fillList = new ArrayList<>(Arrays.asList(new Product[3]));
        Collections.fill(fillList, new Product("Default com.education.ztu.Product", 100.0));
        System.out.println("Filled list: " + fillList);

        Product maxProduct = Collections.max(productList, Comparator.comparingDouble(Product::getPrice));
        Product minProduct = Collections.min(productList, Comparator.comparingDouble(Product::getPrice));
        System.out.println("Max price product: " + maxProduct);
        System.out.println("Min price product: " + minProduct);

        List<Product> copyList = new ArrayList<>(Arrays.asList(new Product[productList.size()]));
        Collections.copy(copyList, productList);
        System.out.println("Copied list: " + copyList);

        Collections.rotate(productList, 2);
        System.out.println("Rotated list: " + productList);

        Collection<Product> checkedCollection = Collections.checkedCollection(productList, Product.class);
        System.out.println("Checked collection: " + checkedCollection);

        int frequency = Collections.frequency(productList, new Product("Bike", 500.00));
        System.out.println("Frequency of Bike: " + frequency);
    }
}
