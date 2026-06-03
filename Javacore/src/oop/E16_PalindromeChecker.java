/**
 * Exercise 16: Palindrome Checker
 * Objective: Combine string manipulation and conditional logic.
 */
import java.util.Scanner;

public class E16_PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        
        // Remove non-alphanumeric characters and convert to lowercase
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        // Check if palindrome
        String reversed = new StringBuilder(cleaned).reverse().toString();
        
        if (cleaned.equals(reversed)) {
            System.out.println("'" + str + "' is a Palindrome!");
        } else {
            System.out.println("'" + str + "' is not a Palindrome!");
        }
        
        System.out.println("Cleaned: " + cleaned);
        System.out.println("Reversed: " + reversed);
        
        scanner.close();
    }
}
