package TASK_06;
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
                .map(Product::getBrand) // Використання посилання на метод для отримання бренду
                .distinct()
                .forEach(System.out::println); // Посилання на метод для виведення в консоль

        // 2. Отримати 2 товари, ціна яких менше тисячі
        System.out.println("\nДва товари з ціною менше 1000:");
        products.stream()
                .filter(p -> p.getPrice() < 1000) // Фільтрація за ціною
                .limit(2)
                .forEach(System.out::println); // Посилання на метод для виведення

        // 3. Отримати суму всіх видів товарів, що є на складі
        int totalCount = products.stream()
                .map(Product::getCount) // Посилання на метод для отримання кількості
                .reduce(0, Integer::sum); // Посилання на метод для підсумовування
        System.out.println("\nСума всіх видів товарів на складі: " + totalCount);

        // 4. Згрупувати товари по бренду
        System.out.println("\nТовари згруповані по бренду:");
        Map<String, List<Product>> groupedByBrand = products.stream()
                .collect(Collectors.groupingBy(Product::getBrand)); // Посилання на метод для групування за брендом
        groupedByBrand.forEach((brand, productList) -> System.out.println(brand + ": " + productList));

        // 5. Відсортувати товари за зростанням ціни та повернути масив
        System.out.println("\nТовари, відсортовані за ціною:");
        List<Product> sortedByPrice = products.stream()
                .sorted(Comparator.comparing(Product::getPrice)) // Посилання на метод для сортування за ціною
                .collect(Collectors.toList());
        sortedByPrice.forEach(System.out::println); // Посилання на метод для виведення

        double totalValue = products.stream()
                .mapToDouble(p -> p.getPrice() * p.getCount()) // Використання lambda для обчислення загальної вартості товарів
                .sum();
        System.out.println("\nЗагальна вартість всіх товарів на складі: " + totalValue);
    }
}
