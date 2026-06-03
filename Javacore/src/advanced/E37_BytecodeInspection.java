/**
 * Exercise 37: Using javap to Inspect Bytecode
 * Objective: Explore compiled .class files.
 */
public class E37_BytecodeInspection {
    
    // Sample class to inspect
    private String name;
    private int age;
    
    public E37_BytecodeInspection(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
    
    public int calculateBirthYear() {
        return 2024 - age;
    }
    
    public static void main(String[] args) {
        E37_BytecodeInspection person = new E37_BytecodeInspection("John", 25);
        person.displayInfo();
        System.out.println("Birth Year: " + person.calculateBirthYear());
    }
}

/**
 * To inspect the bytecode:
 * 
 * 1. Compile the class:
 *    javac E37_BytecodeInspection.java
 * 
 * 2. Inspect bytecode with javap:
 *    javap -c E37_BytecodeInspection
 * 
 * 3. For detailed bytecode information:
 *    javap -c -v E37_BytecodeInspection
 * 
 * 4. To inspect only a specific method:
 *    javap -c E37_BytecodeInspection | grep -A 20 "public int calculateBirthYear"
 * 
 * The output will show:
 * - Compiled method bytecode instructions
 * - Stack frame information
 * - Local variable information
 * - Exception handlers
 * - Method signatures
 */
