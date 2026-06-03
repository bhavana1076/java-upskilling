/**
 * Exercise 3: Even or Odd Checker
 * Objective: Utilize conditional statements.
 */
import java.util.Scanner;

public class E03_EvenOddChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        
        if (number % 2 == 0) {
            System.out.println(number + " is Even");
        } else {
            System.out.println(number + " is Odd");
        }
        
        scanner.close();
    }
}
