/**
 * Exercise 14: Array Sum and Average
 * Objective: Work with arrays and perform calculations.
 */
import java.util.Scanner;

public class E14_ArraySumAndAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        
        int[] array = new int[n];
        
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
        
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        
        double average = (double) sum / n;
        
        System.out.println("\nArray elements: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        
        scanner.close();
    }
}
