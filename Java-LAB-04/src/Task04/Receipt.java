package Task04;
import java.util.Formatter;
import java.util.Locale;

public class Receipt {

    public static void main(String[] args) {
        Formatter formatter = new Formatter(Locale.UK);
        String date = "28.03.2019 13:25:12";

        formatter.format("Дата та час покупки: %s%n", date);
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

        System.out.println(formatter.toString());

        formatter.close();
    }
}