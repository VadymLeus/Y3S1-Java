package DOP;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.io.FileInputStream;

public class DatabaseResetter {

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

    public static void resetDatabase() {
        String query = "DELETE FROM products";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            int rowsDeleted = preparedStatement.executeUpdate();
            System.out.println("Database cleaned. Rows deleted: " + rowsDeleted);

        } catch (Exception e) {
            System.out.println("Error when clearing the database: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
