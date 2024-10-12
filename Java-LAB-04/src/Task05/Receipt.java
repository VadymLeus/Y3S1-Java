package Task05;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Receipt {

    public static void main(String[] args) {
        Locale uaLocale = new Locale("uk", "UA");
        Locale enLocale = new Locale("en", "US");
        Locale frLocale = new Locale("fr", "FR");

        generateReceipt(uaLocale);
        generateReceipt(enLocale);
        generateReceipt(frLocale);
    }

    public static void generateReceipt(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("data", locale);

        String productName = bundle.getString("product_name");
        String priceLabel = bundle.getString("price");
        String currency = bundle.getString("currency");
        String totalLabel = bundle.getString("total");

        double[] prices = {150.00, 250.50, 50.75};
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
        double total = 0;
        System.out.println("Receipt (" + locale.getDisplayLanguage(Locale.ENGLISH) + "):");
        for (int i = 0; i < prices.length; i++) {
            total += prices[i];
            System.out.println(productName + " " + (i + 1) + ": " + priceLabel + " " + currencyFormat.format(prices[i]));
        }
        System.out.println(totalLabel + ": " + currencyFormat.format(total));
        System.out.println();
    }
}
