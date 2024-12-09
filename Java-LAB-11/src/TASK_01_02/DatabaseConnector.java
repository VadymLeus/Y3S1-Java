package TASK_01_02;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DatabaseConnector {
    private Connection connection;

    public void connect() {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        String url = bundle.getString("db.url");
        String username = bundle.getString("db.user");
        String password = bundle.getString("db.password");

        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful.");
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
