package TASK_04;
public class Main {
    public static void main(String[] args) {
        ProductManager.addProducts();
        ProductManager.displayProductsByCategory("Clothing");
        ProductManager.deleteAllProducts();
    }
}
