/**
 * Exercise 20: Try-Catch Example
 * Objective: Handle exceptions gracefully.
 */
import java.util.Scanner;

public class E20_TryCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter first integer: ");
            int num1 = scanner.nextInt();
            
            System.out.print("Enter second integer: ");
            int num2 = scanner.nextInt();
            
            int result = num1 / num2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter integers.");
        } finally {
            System.out.println("Program completed.");
            scanner.close();
        }
    }
}
