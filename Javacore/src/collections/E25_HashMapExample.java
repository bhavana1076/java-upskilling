/**
 * Exercise 25: HashMap Example
 * Objective: Use key-value pairs.
 */
import java.util.HashMap;
import java.util.Scanner;

public class E25_HashMapExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> studentMap = new HashMap<>();
        
        System.out.println("Add student entries (type 'quit' to stop):");
        
        while (true) {
            System.out.print("Enter student ID (or 'quit'): ");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("quit")) {
                break;
            }
            
            try {
                int id = Integer.parseInt(input);
                System.out.print("Enter student name: ");
                String name = scanner.nextLine();
                studentMap.put(id, name);
                System.out.println("Entry added!\n");
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID. Please enter a number.\n");
            }
        }
        
        System.out.println("\nStudent Directory:");
        for (Integer id : studentMap.keySet()) {
            System.out.println("ID: " + id + " -> Name: " + studentMap.get(id));
        }
        
        System.out.print("\nEnter ID to search: ");
        try {
            int searchId = Integer.parseInt(scanner.nextLine());
            if (studentMap.containsKey(searchId)) {
                System.out.println("Found: " + studentMap.get(searchId));
            } else {
                System.out.println("ID not found!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input!");
        }
        
        scanner.close();
    }
}
