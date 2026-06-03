/**
 * Exercise 27: Lambda Expressions
 * Objective: Use functional programming features.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class E27_LambdaExpressions {
    public static void main(String[] args) {
        // Create a list of strings
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Date");
        fruits.add("Elderberry");
        
        System.out.println("Original list:");
        fruits.forEach(fruit -> System.out.println("- " + fruit));
        
        // Sort using lambda expression
        Collections.sort(fruits, (a, b) -> a.compareTo(b));
        
        System.out.println("\nSorted list (ascending):");
        fruits.forEach(fruit -> System.out.println("- " + fruit));
        
        // Sort in reverse order
        Collections.sort(fruits, (a, b) -> b.compareTo(a));
        
        System.out.println("\nSorted list (descending):");
        fruits.forEach(fruit -> System.out.println("- " + fruit));
    }
}
