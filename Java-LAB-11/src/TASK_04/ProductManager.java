package TASK_04;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.io.FileInputStream;
public class ProductManager {

    // Method for obtaining a compound
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

    // Add products
    public static void addProducts() {
        String query = "INSERT INTO products (name, description, price, category) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // 5 new product
            preparedStatement.setString(1, "Product 11");
            preparedStatement.setString(2, "Description of Product 11");
            preparedStatement.setDouble(3, 15.99);
            preparedStatement.setString(4, "Clothing");
            preparedStatement.addBatch();

            preparedStatement.setString(1, "Product 12");
            preparedStatement.setString(2, "Description of Product 12");
            preparedStatement.setDouble(3, 19.99);
            preparedStatement.setString(4, "Clothing");
            preparedStatement.addBatch();

            preparedStatement.setString(1, "Product 13");
            preparedStatement.setString(2, "Description of Product 13");
            preparedStatement.setDouble(3, 25.49);
            preparedStatement.setString(4, "Books");
            preparedStatement.addBatch();

            preparedStatement.setString(1, "Product 14");
            preparedStatement.setString(2, "Description of Product 14");
            preparedStatement.setDouble(3, 9.99);
            preparedStatement.setString(4, "Books");
            preparedStatement.addBatch();

            preparedStatement.setString(1, "Product 15");
            preparedStatement.setString(2, "Description of Product 15");
            preparedStatement.setDouble(3, 29.99);
            preparedStatement.setString(4, "Electronics");
            preparedStatement.addBatch();

            preparedStatement.executeBatch();

            System.out.println("Goods successfully added.");

        } catch (Exception e) {
            System.out.println("Error when adding products: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Get products by category
    public static void displayProductsByCategory(String category) {
        String query = "SELECT * FROM products WHERE category = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, category);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                System.out.println("Products in category \"" + category + "\":");
                System.out.println("----------------------------------------------------");
                System.out.printf("%-5s %-20s %-30s %-10s %-15s%n", "ID", "Name", "Description", "Price", "Category");
                System.out.println("----------------------------------------------------");

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    double price = resultSet.getDouble("price");
                    String prodCategory = resultSet.getString("category");

                    System.out.printf("%-5d %-20s %-30s %-10.2f %-15s%n", id, name, description, price, prodCategory);
                }
            }

        } catch (Exception e) {
            System.out.println("Error when receiving goods:  " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Delete all records from the table
    public static void deleteAllProducts() {
        String query = "DELETE FROM products";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            int rowsDeleted = preparedStatement.executeUpdate();
            System.out.println("Delete all records from the table " + rowsDeleted);

        } catch (Exception e) {
            System.out.println("Error when deleting products: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
