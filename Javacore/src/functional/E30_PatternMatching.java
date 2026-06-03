/**
 * Exercise 30: Pattern Matching for switch (Java 21)
 * Objective: Simplify conditional logic with pattern matching in switch expressions.
 */
public class E30_PatternMatching {
    
    public static void processObject(Object obj) {
        String result = switch (obj) {
            case Integer i -> "Integer: " + i + " (doubled: " + (i * 2) + ")";
            case String s -> "String: '" + s + "' (length: " + s.length() + ")";
            case Double d -> "Double: " + d + " (squared: " + (d * d) + ")";
            case Boolean b -> "Boolean: " + b;
            case null -> "Object is null";
            default -> "Unknown type: " + obj.getClass().getSimpleName();
        };
        System.out.println(result);
    }
    
    public static void main(String[] args) {
        System.out.println("Pattern Matching Examples:");
        System.out.println();
        
        processObject(42);
        processObject("Hello, World!");
        processObject(3.14);
        processObject(true);
        processObject(null);
        processObject(new Object());
    }
}
