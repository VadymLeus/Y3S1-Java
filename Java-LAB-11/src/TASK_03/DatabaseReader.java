package TASK_03;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.io.FileInputStream;

public class DatabaseReader {

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

    public static void displayProducts() {
        String query = "SELECT * FROM products";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            System.out.println("Grocery List::");
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
            System.out.println("Error in data output: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
