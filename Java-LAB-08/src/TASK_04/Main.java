package TASK_04;

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

        // 1. Отримати всі бренди та вивести в консоль
        System.out.println("Усі бренди:");
        products.stream()
                .map(Product::getBrand)
                .distinct()
                .forEach(System.out::println);

        // 2. Отримати 2 товари, ціна яких менше 1000
        System.out.println("\nДва товари з ціною менше 1000:");
        products.stream()
                .filter(p -> p.getPrice() < 1000)
                .limit(2)
                .forEach(System.out::println);

        // 3. Отримання суми всіх видів товарів
        int totalCount = products.stream()
                .map(Product::getCount)
                .reduce(0, Integer::sum);
        System.out.println("\nСума всіх видів товарів на складі: " + totalCount);

        // 4. Згрупувати товари по бренду
        System.out.println("\nТовари згруповані по бренду:");
        Map<String, List<Product>> groupedByBrand = products.stream()
                .collect(Collectors.groupingBy(Product::getBrand));
        groupedByBrand.forEach((brand, productList) -> {
            System.out.println(brand + ": " + productList);
        });

        // 5. Відсортувати товари за зростанням ціни та повернути масив
        System.out.println("\nТовари, відсортовані за ціною:");
        List<Product> sortedByPrice = products.stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.toList());
        sortedByPrice.forEach(System.out::println);

        double totalValue = products.stream()
                .mapToDouble(p -> p.getPrice() * p.getCount())
                .sum();
        System.out.println("\nЗагальна вартість всіх товарів на складі: " + totalValue);
    }
}
