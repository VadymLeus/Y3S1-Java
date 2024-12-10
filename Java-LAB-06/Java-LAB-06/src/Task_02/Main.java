package Task_02;

public class Main {
    public static void main(String[] args) {
        boolean isValid = LoginValidator.checkCredentials("123", "password_123", "password_123");
        System.out.println("Credentials valid: " + isValid);
    }
}