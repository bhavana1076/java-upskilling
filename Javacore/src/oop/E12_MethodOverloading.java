/**
 * Exercise 12: Method Overloading
 * Objective: Understand method overloading in Java.
 */
public class E12_MethodOverloading {
    
    // Method to add two integers
    public static int add(int a, int b) {
        return a + b;
    }
    
    // Method to add two doubles
    public static double add(double a, double b) {
        return a + b;
    }
    
    // Method to add three integers
    public static int add(int a, int b, int c) {
        return a + b + c;
    }
    
    public static void main(String[] args) {
        System.out.println("Method Overloading Examples:");
        System.out.println();
        
        // Call add(int, int)
        int result1 = add(10, 20);
        System.out.println("add(10, 20) = " + result1);
        
        // Call add(double, double)
        double result2 = add(10.5, 20.3);
        System.out.println("add(10.5, 20.3) = " + result2);
        
        // Call add(int, int, int)
        int result3 = add(5, 10, 15);
        System.out.println("add(5, 10, 15) = " + result3);
    }
}
