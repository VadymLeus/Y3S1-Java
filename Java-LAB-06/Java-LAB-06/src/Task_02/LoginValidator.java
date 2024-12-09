package Task_02;
public class LoginValidator {
    public static boolean checkCredentials(String login, String password, String confirmPassword) {
        try {
            if (!login.matches("^[a-zA-Z0-9_]+$") || login.length() >= 20) {
                throw new WrongLoginException("Login must contain only Latin letters, digits, and underscores, and be less than 20 characters long.");
            }

            if (!password.matches("^[a-zA-Z0-9_]+$") || password.length() >= 20) {
                throw new WrongPasswordException("Password must contain only Latin letters, digits, and underscores, and be less than 20 characters long.");
            }

            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Password and confirmPassword do not match.");
            }

            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}
