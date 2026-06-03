/**
 * Exercise 11: Factorial Calculator
 * Objective: Use loops to perform repetitive calculations.
 */
import java.util.Scanner;

public class E11_FactorialCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a non-negative integer: ");
        int number = scanner.nextInt();
        
        if (number < 0) {
            System.out.println("Error: Factorial is not defined for negative numbers");
        } else {
            long factorial = calculateFactorial(number);
            System.out.println("Factorial of " + number + " is: " + factorial);
        }
        
        scanner.close();
    }
    
    public static long calculateFactorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
