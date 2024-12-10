package Task_04_05.logic;

import java.util.Formatter;
import java.util.List;

public class FormatterTask {
    public static void printReceipt(List<Product> products) {
        Formatter formatter = new Formatter();
        formatter.format("Дата та час покупки: %s%n", "28.03.2019 13:25:12");
        formatter.format("===========================================%n");
        formatter.format("№ %-15s %-15s %s%n", "Товар", "Категорія", "Ціна");
        formatter.format("===========================================%n");

        double total = 0;
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            formatter.format("%d. %-15s %-15s %.2f ₴%n",
                    i + 1, product.getName(), product.getCategory(), product.getPrice());
            total += product.getPrice();
        }

        formatter.format("===========================================%n");
        formatter.format("Разом: %.2f ₴%n", total);

        System.out.println(formatter);
        formatter.close();
    }
}
