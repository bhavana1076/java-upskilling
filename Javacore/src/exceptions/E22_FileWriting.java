/**
 * Exercise 22: File Writing
 * Objective: Write data to a file.
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class E22_FileWriting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter text to write to file: ");
        String text = scanner.nextLine();
        
        try {
            FileWriter writer = new FileWriter("output.txt");
            writer.write(text);
            writer.close();
            System.out.println("Data successfully written to output.txt");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        scanner.close();
    }
}
