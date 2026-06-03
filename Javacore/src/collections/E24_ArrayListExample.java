/**
 * Exercise 24: ArrayList Example
 * Objective: Use dynamic arrays.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class E24_ArrayListExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        
        System.out.println("Enter student names (type 'quit' to stop):");
        
        while (true) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            
            if (name.equalsIgnoreCase("quit")) {
                break;
            }
            
            names.add(name);
        }
        
        System.out.println("\nStudent Names:");
        for (int i = 0; i < names.size(); i++) {
            System.out.println((i + 1) + ". " + names.get(i));
        }
        
        System.out.println("\nTotal students: " + names.size());
        
        scanner.close();
    }
}
