/**
 * Exercise 13: Recursive Fibonacci
 * Objective: Implement recursion.
 */
import java.util.Scanner;

public class E13_RecursiveFibonacci {
    
    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a positive integer n: ");
        int n = scanner.nextInt();
        
        if (n < 0) {
            System.out.println("Error: Please enter a positive integer");
        } else {
            long result = fibonacci(n);
            System.out.println("The " + n + "th Fibonacci number is: " + result);
        }
        
        scanner.close();
    }
}
