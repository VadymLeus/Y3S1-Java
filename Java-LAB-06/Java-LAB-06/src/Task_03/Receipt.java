package Task_03;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.Locale;

public class Receipt {

    public static void main(String[] args) {
        String filePath = "Java-LAB-06/src/directory_for_files/receipt.txt";

        try {
            writeReceiptToFile(filePath);
            readReceiptFromFile(filePath);

        } catch (IOException e) {
            System.out.println("Error while working with the file: " + e.getMessage());
        }
    }

    private static void writeReceiptToFile(String filePath) throws IOException {
        Formatter formatter = new Formatter(Locale.UK);
        formatter.format("Дата та час покупки: %s%n", "26.10.2024 13:25:12");
        formatter.format("===========================================%n");
        formatter.format("%-3s %-15s %-15s %10s%n", "№", "Товар", "Категорія", "Ціна");
        formatter.format("===========================================%n");

        formatter.format("%-3d %-15s %-15s %10.2f ₴%n", 1, "Джинси", "Жіночий одяг", 1500.78);
        formatter.format("%-3d %-15s %-15s %10.2f ₴%n", 2, "Спідниця", "Жіночий одяг", 1000.56);
        formatter.format("%-3d %-15s %-15s %10.2f ₴%n", 3, "Краватка", "Чоловічий одяг", 500.78);
        formatter.format("%-3d %-15s %-15s %10.2f ₴%n", 4, "Сорочка", "Чоловічий одяг", 750.00);
        formatter.format("%-3d %-15s %-15s %10.2f ₴%n", 5, "Сукня", "Жіночий одяг", 2000.45);
        formatter.format("%-3d %-15s %-15s %10.2f ₴%n", 6, "Шкарпетки", "Чоловічий одяг", 50.30);
        formatter.format("%-3d %-15s %-15s %10.2f ₴%n", 7, "Шапка", "Чоловічий одяг", 300.60);
        formatter.format("%-3d %-15s %-15s %10.2f ₴%n", 8, "Шарф", "Чоловічий одяг", 120.00);
        formatter.format("%-3d %-15s %-15s %10.2f ₴%n", 9, "Блуза", "Жіночий одяг", 1800.90);
        formatter.format("%-3d %-15s %-15s %10.2f ₴%n", 10, "Куртка", "Чоловічий одяг", 3500.75);

        formatter.format("===========================================%n");
        formatter.format("Разом: %39.2f ₴%n", 1500.78 + 1000.56 + 500.78 + 750.00 + 2000.45 + 50.30 + 300.60 + 120.00 + 1800.90 + 3500.75);

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.print(formatter.toString());
        }
        formatter.close();
    }

    private static void readReceiptFromFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
