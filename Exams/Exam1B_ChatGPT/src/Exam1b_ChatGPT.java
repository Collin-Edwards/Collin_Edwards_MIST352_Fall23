import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Exam1b_ChatGPT {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display a creative welcome message
        System.out.println("Welcome to the Creative Input Processor!");
        System.out.println("======================================");

        // Ask user for text input
        System.out.println("Please enter some text:");
        String userInput = scanner.nextLine();

        // Printout the length of the provided input
        System.out.println("The length of your input is: " + userInput.length());

        // Ask user for a character to find in the input
        System.out.println("Please enter a character to find in your input:");
        char characterToFind = scanner.next().charAt(0);

        // Find and printout the location of the first occurrence of that character
        int firstOccurrence = userInput.indexOf(characterToFind);
        if (firstOccurrence != -1) {
            System.out.println("The first occurrence of '" + characterToFind + "' is at index: " + firstOccurrence);
        }

        // Bonus: Handle multiple occurrences of the character
        List<Integer> occurrences = new ArrayList<>();
        for (int i = firstOccurrence; i != -1; i = userInput.indexOf(characterToFind, i + 1)) {
            occurrences.add(i);
        }

        if (occurrences.size() > 1) {
            System.out.println("Bonus: The character '" + characterToFind + "' also occurs at the following indices: " + occurrences.subList(1, occurrences.size()));
        }

        // Close the scanner
        scanner.close();
    }
}
