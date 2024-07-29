import java.util.Scanner;

public class PasswordStrengthChecker {

    // Minimum length requirement
    private static final int MIN_LENGTH = 8;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a password to assess its strength: ");
        String password = scanner.nextLine();

        String feedback = assessPasswordStrength(password);
        System.out.println(feedback);

        scanner.close();
    }

    private static String assessPasswordStrength(String password) {
        if (password.length() < MIN_LENGTH) {
            return "Password is too short. It must be at least " + MIN_LENGTH + " characters long.";
        }

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }

        if (hasUppercase && hasLowercase && hasDigit && hasSpecialChar) {
            return "Password is strong.";
        }

        StringBuilder feedback = new StringBuilder("Password is weak. Consider the following:");
        if (!hasUppercase) {
            feedback.append("\n- Include at least one uppercase letter.");
        }
        if (!hasLowercase) {
            feedback.append("\n- Include at least one lowercase letter.");
        }
        if (!hasDigit) {
            feedback.append("\n- Include at least one digit.");
        }
        if (!hasSpecialChar) {
            feedback.append("\n- Include at least one special character (e.g., !, @, #, $, etc.).");
        }

        return feedback.toString();
    }
}