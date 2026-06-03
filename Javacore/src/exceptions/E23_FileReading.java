/**
 * Exercise 23: File Reading
 * Objective: Read data from a file.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class E23_FileReading {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
            String line;
            System.out.println("Contents of output.txt:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
