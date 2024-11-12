import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int low = 1;
        int high = 100;
        boolean guessedCorrectly = false;

        System.out.println("Pick a number between 1 and 100");

        while (!guessedCorrectly && low <= high) {
            int guess = low + (high - low) / 2;
            System.out.println("Is it " + guess + "? [high/low/correct]");
            String response = scanner.nextLine().toLowerCase();

            if (response.equals("high")) {
                high = guess - 1;
            } 
            else if (response.equals("low")) {
                low = guess + 1;
            } 
            else if (response.equals("correct")) {
                guessedCorrectly = true;
            } 
            else {
                System.out.println("Invalid. Can be only high, low, or correct");
            }
        }

        System.out.println("Guessed your number!");
        scanner.close();
    }
}