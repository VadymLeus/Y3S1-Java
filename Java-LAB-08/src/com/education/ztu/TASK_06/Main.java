package com.education.ztu.TASK_06;

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

        // 1. Retrieve all brands and display them in the console
        System.out.println("All brands:");
        products.stream()
                .map(Product::getBrand) // Method reference to get the brand
                .distinct()
                .forEach(System.out::println); // Method reference for console output

        // 2. Retrieve 2 products with a price less than 1000
        System.out.println("\nTwo products with a price less than 1000:");
        products.stream()
                .filter(p -> p.getPrice() < 1000)
                .limit(2)
                .forEach(System.out::println);

        // 3. Calculate the total count of all products
        int totalCount = products.stream()
                .map(Product::getCount) // Method reference to get the count
                .reduce(0, Integer::sum); // Method reference to calculate the sum
        System.out.println("\nTotal count of all products in stock: " + totalCount);

        // 4. Group products by brand
        System.out.println("\nProducts grouped by brand:");
        Map<String, List<Product>> groupedByBrand = products.stream()
                .collect(Collectors.groupingBy(Product::getBrand)); // Method reference for grouping by brand
        groupedByBrand.forEach((brand, productList) -> System.out.println(brand + ": " + productList));

        // 5. Sort products by ascending price and convert to a list
        System.out.println("\nProducts sorted by price:");
        List<Product> sortedByPrice = products.stream()
                .sorted(Comparator.comparing(Product::getPrice)) // Method reference to sort by price
                .collect(Collectors.toList());
        sortedByPrice.forEach(System.out::println); // Method reference for console output

        // Calculate the total value of all products
        double totalValue = products.stream()
                .mapToDouble(p -> p.getPrice() * p.getCount()) // Lambda to calculate the total value of products
                .sum();
        System.out.println("\nTotal value of all products in stock: " + totalValue);
    }
}
