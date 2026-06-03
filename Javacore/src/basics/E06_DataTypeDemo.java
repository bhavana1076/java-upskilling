/**
 * Exercise 6: Data Type Demonstration
 * Objective: Understand Java's primitive data types.
 */
public class E06_DataTypeDemo {
    public static void main(String[] args) {
        int intValue = 42;
        float floatValue = 3.14f;
        double doubleValue = 2.71828;
        char charValue = 'A';
        boolean boolValue = true;
        
        System.out.println("int: " + intValue);
        System.out.println("float: " + floatValue);
        System.out.println("double: " + doubleValue);
        System.out.println("char: " + charValue);
        System.out.println("boolean: " + boolValue);
        
        System.out.println("\nData Type Sizes:");
        System.out.println("int size: " + Integer.BYTES + " bytes");
        System.out.println("float size: " + Float.BYTES + " bytes");
        System.out.println("double size: " + Double.BYTES + " bytes");
        System.out.println("char size: " + Character.BYTES + " bytes");
    }
}
