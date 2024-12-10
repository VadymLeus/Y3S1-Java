package Task_04_05;

import Task_04_05.logic.FormatterTask;
import Task_04_05.logic.LocalizationTask;
import Task_04_05.logic.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Джинси", "Жіночий одяг", 1500.78));
        products.add(new Product("Спідниця", "Жіночий одяг", 1000.56));
        products.add(new Product("Краватка", "Чоловічий одяг", 500.78));

        // Adding more products
        for (int i = 0; i < 7; i++) {
            products.add(new Product("Товар" + (i + 4), "Категорія" + (i + 4), 200.00 + i * 50));
        }

        // Task 4: Formatted check
        FormatterTask.printReceipt(products);

        // Task 5: Localised check
        System.out.println("\n=== Локалізований чек (English) ===");
        LocalizationTask.printLocalizedReceipt(products, Locale.US);

        System.out.println("\n=== Локалізований чек (Français) ===");
        LocalizationTask.printLocalizedReceipt(products, Locale.FRANCE);
    }
}
