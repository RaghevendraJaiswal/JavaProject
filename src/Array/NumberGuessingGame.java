package Array;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        int attempts = 0;
        int guess;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100.");

        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess > randomNumber) {
                System.out.println("Try a lower number.");
            } else if (guess < randomNumber) {
                System.out.println("Try a higher number.");
            } else {
                System.out.println("Congratulations! You guessed the correct number: " + randomNumber);
                System.out.println("Number of attempts: " + attempts);
            }
        } while (guess != randomNumber);

        scanner.close();
    }
}
