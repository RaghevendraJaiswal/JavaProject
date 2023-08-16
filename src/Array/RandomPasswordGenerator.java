package Array;

import java.security.SecureRandom;
import java.util.Scanner;

public class RandomPasswordGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Random Password Generator");
        System.out.print("Enter the length of the password: ");
        int passwordLength = scanner.nextInt();

        System.out.print("Include uppercase letters? (Y/N): ");
        boolean includeUpperCase = scanner.next().equalsIgnoreCase("Y");

        System.out.print("Include lowercase letters? (Y/N): ");
        boolean includeLowerCase = scanner.next().equalsIgnoreCase("Y");

        System.out.print("Include digits? (Y/N): ");
        boolean includeDigits = scanner.next().equalsIgnoreCase("Y");

        System.out.print("Include special characters? (Y/N): ");
        boolean includeSpecialChars = scanner.next().equalsIgnoreCase("Y");

        try {
            String generatedPassword = generateRandomPassword(passwordLength, includeUpperCase, includeLowerCase, includeDigits, includeSpecialChars);
            System.out.println("Generated Password: " + generatedPassword);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

    public static String generateRandomPassword(int length, boolean upperCase, boolean lowerCase, boolean digits, boolean specialChars) {
        String upperCaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseChars = "abcdefghijklmnopqrstuvwxyz";
        String digitChars = "0123456789";
        String specialCharsStr = "!@#$%^&*()_+{}[]<>?";

        String allowedChars = "";
        StringBuilder password = new StringBuilder();

        if (upperCase) {
            allowedChars += upperCaseChars;
        }

        if (lowerCase) {
            allowedChars += lowerCaseChars;
        }

        if (digits) {
            allowedChars += digitChars;
        }

        if (specialChars) {
            allowedChars += specialCharsStr;
        }

        SecureRandom random = new SecureRandom();

        if (allowedChars.isEmpty()) {
            throw new IllegalArgumentException("At least one character type should be included in the password.");
        }

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allowedChars.length());
            password.append(allowedChars.charAt(randomIndex));
        }

        return password.toString();
    }
}
