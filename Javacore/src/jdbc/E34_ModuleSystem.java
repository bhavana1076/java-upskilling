/**
 * Exercise 34: Create and Use Java Modules
 * Objective: Understand Java's module system.
 * 
 * This is a simplified example showing module concept.
 * For a full multi-module setup, see project structure in separate folders.
 */
public class E34_ModuleSystem {
    
    // Simulating module: com.utils
    static class UtilityClass {
        public static String greet(String name) {
            return "Hello, " + name + "!";
        }
        
        public static int add(int a, int b) {
            return a + b;
        }
        
        public static String reverseString(String str) {
            return new StringBuilder(str).reverse().toString();
        }
    }
    
    // Simulating module: com.greetings
    static class GreetingsApp {
        public static void main(String[] args) {
            System.out.println("=== Module System Example ===\n");
            
            // Using utility methods
            System.out.println(UtilityClass.greet("Alice"));
            System.out.println(UtilityClass.greet("Bob"));
            
            System.out.println("\nAddition: " + UtilityClass.add(10, 20));
            System.out.println("Reversed: " + UtilityClass.reverseString("Hello"));
        }
    }
    
    public static void main(String[] args) {
        GreetingsApp.main(args);
    }
}

/**
 * NOTE: For a proper multi-module setup, create the following structure:
 * 
 * project/
 * ├── com.utils/
 * │   ├── src/
 * │   │   ├── module-info.java
 * │   │   └── com/utils/UtilityClass.java
 * │
 * ├── com.greetings/
 * │   ├── src/
 * │   │   ├── module-info.java
 * │   │   └── com/greetings/GreetingsApp.java
 * 
 * Compile:
 * javac -d mods/com.utils com.utils/src/module-info.java com.utils/src/com/utils/*.java
 * javac -d mods/com.greetings --module-path mods com.greetings/src/module-info.java com.greetings/src/com/greetings/*.java
 * 
 * Run:
 * java --module-path mods -m com.greetings/com.greetings.GreetingsApp
 */
