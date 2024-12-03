package DOP;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.io.FileInputStream;

public class DatabaseRestorer {

    private static Connection getConnection() throws Exception {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/db.properties")) {
            props.load(fis);
        }
        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");

        return DriverManager.getConnection(url, user, password);
    }

    public static void restoreData() {
        String query = "INSERT INTO products (name, description, price, category) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Initial data
            preparedStatement.setString(1, "Product 1");
            preparedStatement.setString(2, "Description of Product 1");
            preparedStatement.setDouble(3, 10.99);
            preparedStatement.setString(4, "Electronics");
            preparedStatement.addBatch();

            preparedStatement.setString(1, "Product 2");
            preparedStatement.setString(2, "Description of Product 2");
            preparedStatement.setDouble(3, 12.99);
            preparedStatement.setString(4, "Electronics");
            preparedStatement.addBatch();

            preparedStatement.setString(1, "Product 3");
            preparedStatement.setString(2, "Description of Product 3");
            preparedStatement.setDouble(3, 5.49);
            preparedStatement.setString(4, "Furniture");
            preparedStatement.addBatch();

            preparedStatement.setString(1, "Product 4");
            preparedStatement.setString(2, "Description of Product 4");
            preparedStatement.setDouble(3, 8.75);
            preparedStatement.setString(4, "Furniture");
            preparedStatement.addBatch();

            preparedStatement.setString(1, "Product 5");
            preparedStatement.setString(2, "Description of Product 5");
            preparedStatement.setDouble(3, 3.99);
            preparedStatement.setString(4, "Clothing");
            preparedStatement.addBatch();

            preparedStatement.setString(1, "Product 6");
            preparedStatement.setString(2, "Description of Product 6");
            preparedStatement.setDouble(3, 7.49);
            preparedStatement.setString(4, "Clothing");
            preparedStatement.addBatch();

            preparedStatement.setString(1, "Product 7");
            preparedStatement.setString(2, "Description of Product 7");
            preparedStatement.setDouble(3, 11.25);
            preparedStatement.setString(4, "Books");
            preparedStatement.addBatch();

            preparedStatement.setString(1, "Product 8");
            preparedStatement.setString(2, "Description of Product 8");
            preparedStatement.setDouble(3, 6.89);
            preparedStatement.setString(4, "Books");
            preparedStatement.addBatch();

            preparedStatement.setString(1, "Product 9");
            preparedStatement.setString(2, "Description of Product 9");
            preparedStatement.setDouble(3, 4.99);
            preparedStatement.setString(4, "Electronics");
            preparedStatement.addBatch();

            preparedStatement.setString(1, "Product 10");
            preparedStatement.setString(2, "Description of Product 10");
            preparedStatement.setDouble(3, 9.99);
            preparedStatement.setString(4, "Furniture");
            preparedStatement.addBatch();

            preparedStatement.executeBatch();
            System.out.println("Данные успешно восстановлены!");

            // Output the added data
            displayRestoredData();

        } catch (Exception e) {
            System.out.println("Ошибка при восстановлении данных: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method for outputting data after recovery
    private static void displayRestoredData() {
        String query = "SELECT * FROM products";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            System.out.println("Recovered data in the table products:");
            System.out.println("-------------------------------------------------------------");
            System.out.printf("%-5s %-20s %-30s %-10s %-15s%n", "ID", "Name", "Description", "Price", "Category");
            System.out.println("-------------------------------------------------------------");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                String category = resultSet.getString("category");

                System.out.printf("%-5d %-20s %-30s %-10.2f %-15s%n", id, name, description, price, category);
            }

        } catch (Exception e) {
            System.out.println("Error when outputting recovered data: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
