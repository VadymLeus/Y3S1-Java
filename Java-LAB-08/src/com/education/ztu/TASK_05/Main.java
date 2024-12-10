package com.education.ztu.TASK_05;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "BrandA", 1200, 5),
                new Product("Phone", "BrandB", 800, 10),
                new Product("Tablet", "BrandA", 400, 7),
                new Product("Monitor", "BrandC", 300, 15),
                new Product("Headphones", "BrandB", 150, 20)
        );

        // 1. Get all brands and display them in the console
        System.out.println("All brands:");
        products.stream()
                .map(Product::getBrand) // Using a method reference to get a brand
                .distinct()
                .forEach(System.out::println); // Reference to a method for outputting to the console

        // 2. Get 2 products with a price less than 1000
        System.out.println("\nTwo products with a price of less than 1000:");
        products.stream()
                .filter(p -> p.getPrice() < 1000)
                .limit(2)
                .forEach(System.out::println);

        // 3. Getting the sum of all types of goods
        int totalCount = products.stream()
                .map(Product::getCount) // Reference to the method for getting the quantity
                .reduce(0, Integer::sum); // Reference to the method to summarise
        System.out.println("\nThe sum of all types of goods in the warehouse: " + totalCount);

        // 4. Group products by brand
        System.out.println("\nProducts are grouped by brand:");
        Map<String, List<Product>> groupedByBrand = products.stream()
                .collect(Collectors.groupingBy(Product::getBrand)); // Reference to the method for grouping by brand
        groupedByBrand.forEach((brand, productList) -> System.out.println(brand + ": " + productList));

        // 5. Sort products by ascending price and return an array
        System.out.println("\nProducts sorted by price:");
        List<Product> sortedByPrice = products.stream()
                .sorted(Comparator.comparing(Product::getPrice)) // Reference to the method for sorting by price
                .collect(Collectors.toList());
        sortedByPrice.forEach(System.out::println); // Reference to the method to output

        double totalValue = products.stream()
                .mapToDouble(p -> p.getPrice() * p.getCount()) // Using lambda to calculate the total cost of goods
                .sum();
        System.out.println("\nThe total value of all goods in the warehouse: " + totalValue);
    }
}