/**
 * Exercise 21: Custom Exception
 * Objective: Create and use custom exceptions.
 */
import java.util.Scanner;

public class E21_CustomException {
    
    // Custom exception class
    static class InvalidAgeException extends Exception {
        public InvalidAgeException(String message) {
            super(message);
        }
    }
    
    // Method that throws custom exception
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or older. You are " + age + " years old.");
        }
        System.out.println("Age " + age + " is valid.");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        
        try {
            validateAge(age);
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        scanner.close();
    }
}
