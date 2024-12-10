package TASK_05;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Properties;
import java.io.FileInputStream;

public class TransactionHandler {

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

    public static void handleTransactions() {
        try (Connection connection = getConnection()) {
            connection.setAutoCommit(false); // Disable autocommit to keep them out of the way

            String insertQuery1 = "INSERT INTO products (name, description, price, category) VALUES (?, ?, ?, ?)";
            String insertQuery2 = "INSERT INTO products (name, description, price, category VALUES (?, ?, ?, ?)"; // Syntax error

            Savepoint savepoint = null;

            try (PreparedStatement statement1 = connection.prepareStatement(insertQuery1);
                 PreparedStatement statement2 = connection.prepareStatement(insertQuery2)) {

                // Adding the first item
                statement1.setString(1, "Transaction Product 1");
                statement1.setString(2, "Description of Transaction Product 1");
                statement1.setDouble(3, 20.00);
                statement1.setString(4, "Category A");
                statement1.executeUpdate();

                System.out.println("First item added successfully");
                savepoint = connection.setSavepoint("AfterFirstProduct"); // Creating a savepoint

                // Trying to add a second product with an error
                statement2.setString(1, "Transaction Product 2");
                statement2.setString(2, "Description of Transaction Product 2");
                statement2.setDouble(3, 25.00);
                statement2.setString(4, "Category B");
                statement2.executeUpdate();

                // If both products are added successfully (NO)
                connection.commit();
                System.out.println("Transaction completed successfully.");

            } catch (Exception e) {
                System.out.println("Error when adding a second product: " + e.getMessage());
                if (savepoint != null) {
                    connection.rollback(savepoint); // Back to savepoint
                    System.out.println("Rollback to save point: only the first item is saved.");
                } else {
                    connection.rollback(); // Full back
                    System.out.println("Full back: not a single item added.");
                }
            }

            // Output data from the products table
            displayProducts(connection);

        } catch (Exception e) {
            System.out.println("Error when working with transactions: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void displayProducts(Connection connection) {
        String query = "SELECT * FROM products";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            System.out.println("A list of items after a transaction:");
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
        }
    }
}
