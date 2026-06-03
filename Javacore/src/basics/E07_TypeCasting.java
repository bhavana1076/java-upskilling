/**
 * Exercise 7: Type Casting Example
 * Objective: Practice type casting between different data types.
 */
public class E07_TypeCasting {
    public static void main(String[] args) {
        // Double to Int (Explicit casting)
        double doubleValue = 9.99;
        int intFromDouble = (int) doubleValue;
        System.out.println("Double: " + doubleValue);
        System.out.println("Casted to Int: " + intFromDouble);
        
        System.out.println();
        
        // Int to Double (Implicit casting)
        int intValue = 42;
        double doubleFromInt = intValue;
        System.out.println("Int: " + intValue);
        System.out.println("Casted to Double: " + doubleFromInt);
        
        System.out.println();
        
        // Float to Int
        float floatValue = 15.75f;
        int intFromFloat = (int) floatValue;
        System.out.println("Float: " + floatValue);
        System.out.println("Casted to Int: " + intFromFloat);
        
        System.out.println();
        
        // String to Integer
        String stringValue = "100";
        int intFromString = Integer.parseInt(stringValue);
        System.out.println("String: " + stringValue);
        System.out.println("Parsed to Int: " + intFromString);
    }
}
