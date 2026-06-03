/**
 * Exercise 8: Operator Precedence
 * Objective: Explore how Java evaluates expressions.
 */
public class E08_OperatorPrecedence {
    public static void main(String[] args) {
        System.out.println("Order of Operations (PEMDAS): Parentheses, Exponents, Multiplication/Division, Addition/Subtraction");
        System.out.println();
        
        // Example 1: 10 + 5 * 2
        int result1 = 10 + 5 * 2;
        System.out.println("Expression: 10 + 5 * 2");
        System.out.println("Evaluation: 10 + (5 * 2) = 10 + 10 = " + result1);
        System.out.println();
        
        // Example 2: (10 + 5) * 2
        int result2 = (10 + 5) * 2;
        System.out.println("Expression: (10 + 5) * 2");
        System.out.println("Evaluation: (15) * 2 = " + result2);
        System.out.println();
        
        // Example 3: 20 - 5 + 3
        int result3 = 20 - 5 + 3;
        System.out.println("Expression: 20 - 5 + 3");
        System.out.println("Evaluation: (20 - 5) + 3 = 15 + 3 = " + result3);
        System.out.println();
        
        // Example 4: 20 / 4 * 2
        int result4 = 20 / 4 * 2;
        System.out.println("Expression: 20 / 4 * 2");
        System.out.println("Evaluation: (20 / 4) * 2 = 5 * 2 = " + result4);
        System.out.println();
        
        // Example 5: 2 + 3 * 4 - 5
        int result5 = 2 + 3 * 4 - 5;
        System.out.println("Expression: 2 + 3 * 4 - 5");
        System.out.println("Evaluation: 2 + (3 * 4) - 5 = 2 + 12 - 5 = " + result5);
    }
}
