import java.util.*;

public class Hangman {
    public static void main(String[] args) {

        String[] words = { "patrick", "code", "hangman"};

        int randInt = new Random().nextInt(words.length);
        String word = words[randInt];
        Set<Character> guessed = new HashSet<>();

        int wrong = 0;

        final int MAX_WRONG = 6;
        
        Scanner scanner = new Scanner(System.in);

        while (wrong < MAX_WRONG) {

            System.out.println("Word: " + maskWord(word, guessed));
            System.out.print("Guess a letter: ");

            char guess = scanner.nextLine().toLowerCase().charAt(0);

            if (word.indexOf(guess) == -1) 
            {
                wrong++;
            }
            else {
                guessed.add(guess);
            }

            if (allGuessed(word, guessed)) {
                System.out.println("You won! Word is " + word);
                return;
            }
        }
        
        System.out.println("Out of tries! The word was: " + word);
        scanner.close();
    }

    private static String maskWord(String word, Set<Character> guessed) {

        StringBuilder masked = new StringBuilder();

        for (char c : word.toCharArray()) {
            
            if (guessed.contains(c)){
                masked.append(c);
            }

            else {
                masked.append("_");
            }
        }
        return masked.toString();
    }

    private static boolean allGuessed(String word, Set<Character> guessed) {

        for (char c : word.toCharArray()) {
            if (!guessed.contains(c)) {
                return false;
            }
        }
        return true;
    }
}
