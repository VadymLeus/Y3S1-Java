package Task_04_05.logic;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizationTask {
    public static void printLocalizedReceipt(List<Product> products, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("Task_04_05.resources.data", locale);
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

        System.out.println(bundle.getString("dateTime"));
        System.out.println("===========================================");
        System.out.printf("%-3s %-15s %-15s %s%n",
                bundle.getString("no"), bundle.getString("product"), bundle.getString("category"), bundle.getString("price"));
        System.out.println("===========================================");

        double total = 0;
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.printf("%-3d %-15s %-15s %s%n",
                    i + 1, product.getName(), product.getCategory(), currencyFormatter.format(product.getPrice()));
            total += product.getPrice();
        }

        System.out.println("===========================================");
        System.out.printf("%s: %s%n", bundle.getString("total"), currencyFormatter.format(total));
    }
}
