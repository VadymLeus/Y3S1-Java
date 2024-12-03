package TASK_06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;
import java.io.FileInputStream;

public class Main {
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

    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            ProductDAO productDAO = new ProductDAO(connection);

            // 1. Creating a new product
            Product newProduct = new Product("DAO Product", "Description of DAO Product", 50.00, "Category DAO");
            productDAO.create(newProduct);
            System.out.println("Add product: " + newProduct);

            // 2. Reading the product
            Product fetchedProduct = productDAO.read(newProduct.getId());
            System.out.println("Read product: " + fetchedProduct);

            // 3. Updating the product
            fetchedProduct.setPrice(55.00);
            fetchedProduct.setCategory("Updated Category");
            productDAO.update(fetchedProduct);
            System.out.println("Updated product: " + fetchedProduct);

            // 4. Reading all products
            List<Product> products = productDAO.readAll();
            System.out.println("All product:");
            for (Product product : products) {
                System.out.println(product);
            }

            // 5. Deleting a product
            productDAO.delete(fetchedProduct.getId());
            System.out.println("Product with ID " + fetchedProduct.getId() + " was deleted.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
