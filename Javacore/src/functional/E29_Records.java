/**
 * Exercise 29: Records
 * Objective: Use the record keyword for immutable data structures (Java 16+).
 */
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class E29_Records {
    
    // Record to represent a Person
    record Person(String name, int age) {
        @Override
        public String toString() {
            return name + " (Age: " + age + ")";
        }
    }
    
    public static void main(String[] args) {
        // Create Person instances
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 25));
        people.add(new Person("Bob", 30));
        people.add(new Person("Charlie", 35));
        people.add(new Person("Diana", 22));
        people.add(new Person("Eve", 28));
        
        System.out.println("All people:");
        people.forEach(System.out::println);
        
        // Filter people aged 25 or older using Streams
        System.out.println("\nPeople aged 25 or older:");
        List<Person> adults = people.stream()
                                    .filter(p -> p.age() >= 25)
                                    .collect(Collectors.toList());
        adults.forEach(System.out::println);
        
        // Filter people under 30
        System.out.println("\nPeople under 30:");
        List<Person> youngPeople = people.stream()
                                         .filter(p -> p.age() < 30)
                                         .collect(Collectors.toList());
        youngPeople.forEach(System.out::println);
    }
}
