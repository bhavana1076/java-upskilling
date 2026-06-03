/**
 * Exercise 39: Reflection in Java
 * Objective: Use Java Reflection API.
 */
import java.lang.reflect.*;

public class E39_Reflection {
    
    // Sample class to reflect on
    static class Calculator {
        private int lastResult;
        
        public Calculator() {
            this.lastResult = 0;
        }
        
        public int add(int a, int b) {
            lastResult = a + b;
            return lastResult;
        }
        
        public int multiply(int a, int b) {
            lastResult = a * b;
            return lastResult;
        }
        
        public int getLastResult() {
            return lastResult;
        }
    }
    
    public static void main(String[] args) {
        try {
            // Load the class
            Class<?> clazz = Class.forName("E39_Reflection$Calculator");
            System.out.println("Class: " + clazz.getName());
            System.out.println();
            
            // Get constructors
            System.out.println("=== Constructors ===");
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }
            System.out.println();
            
            // Get methods
            System.out.println("=== Methods ===");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("Method: " + method.getName());
                System.out.println("Return Type: " + method.getReturnType());
                System.out.println("Parameters: " + method.getParameterCount());
                System.out.println();
            }
            
            // Invoke methods dynamically
            System.out.println("=== Dynamic Method Invocation ===");
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            Object instance = constructor.newInstance();
            
            Method addMethod = clazz.getDeclaredMethod("add", int.class, int.class);
            int result1 = (int) addMethod.invoke(instance, 10, 20);
            System.out.println("add(10, 20) = " + result1);
            
            Method multiplyMethod = clazz.getDeclaredMethod("multiply", int.class, int.class);
            int result2 = (int) multiplyMethod.invoke(instance, 5, 6);
            System.out.println("multiply(5, 6) = " + result2);
            
            Method getResultMethod = clazz.getDeclaredMethod("getLastResult");
            int result3 = (int) getResultMethod.invoke(instance);
            System.out.println("getLastResult() = " + result3);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
