/**
 * Exercise 15: String Reversal
 * Objective: Manipulate strings.
 */
import java.util.Scanner;

public class E15_StringReversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        
        // Method 1: Using StringBuilder
        String reversed1 = new StringBuilder(str).reverse().toString();
        System.out.println("Reversed (StringBuilder): " + reversed1);
        
        // Method 2: Using a loop
        String reversed2 = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed2 += str.charAt(i);
        }
        System.out.println("Reversed (Loop): " + reversed2);
        
        scanner.close();
    }
}
