/**
 * Exercise 28: Stream API
 * Objective: Process collections using streams.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class E28_StreamAPI {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);
        
        System.out.println("Original list:");
        System.out.println(numbers);
        
        // Filter even numbers using Stream API
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(n -> n % 2 == 0)
                                           .collect(Collectors.toList());
        
        System.out.println("\nEven numbers:");
        System.out.println(evenNumbers);
        
        // Filter odd numbers
        List<Integer> oddNumbers = numbers.stream()
                                          .filter(n -> n % 2 != 0)
                                          .collect(Collectors.toList());
        
        System.out.println("\nOdd numbers:");
        System.out.println(oddNumbers);
        
        // Square each even number
        List<Integer> squaredEvens = numbers.stream()
                                            .filter(n -> n % 2 == 0)
                                            .map(n -> n * n)
                                            .collect(Collectors.toList());
        
        System.out.println("\nSquared even numbers:");
        System.out.println(squaredEvens);
        
        // Sum of all numbers
        int sum = numbers.stream()
                        .reduce(0, Integer::sum);
        
        System.out.println("\nSum of all numbers: " + sum);
        
        // Average
        double average = numbers.stream()
                               .mapToDouble(Integer::doubleValue)
                               .average()
                               .orElse(0.0);
        
        System.out.println("Average: " + average);
    }
}
