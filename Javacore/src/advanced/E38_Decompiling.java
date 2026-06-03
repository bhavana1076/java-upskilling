/**
 * Exercise 38: Decompile a Class File
 * Objective: Reverse engineer compiled Java bytecode.
 * 
 * Tools mentioned:
 * - JD-GUI: http://jd.benow.ca/
 * - CFR: https://www.benf.org/other/cfr/
 * - Procyon: https://github.com/mstrobel/procyon
 * - Fernflower: https://github.com/JetBrains/intellij-community/tree/master/plugins/java/tools/java-decompilers/fernflower
 */
public class E38_Decompiling {
    
    private String message;
    private int counter;
    
    public E38_Decompiling(String message) {
        this.message = message;
        this.counter = 0;
    }
    
    public void incrementCounter() {
        counter++;
    }
    
    public void displayMessage() {
        System.out.println(message + " - Counter: " + counter);
    }
    
    public boolean isCounterGreaterThan(int value) {
        return counter > value;
    }
    
    public static void main(String[] args) {
        E38_Decompiling demo = new E38_Decompiling("Hello Decompiler");
        
        for (int i = 0; i < 5; i++) {
            demo.incrementCounter();
            demo.displayMessage();
        }
        
        if (demo.isCounterGreaterThan(3)) {
            System.out.println("Counter exceeded 3!");
        }
    }
}

/**
 * How to decompile:
 * 
 * 1. Compile:
 *    javac E38_Decompiling.java
 * 
 * 2. Using CFR (download cfr.jar from https://www.benf.org/other/cfr/):
 *    java -jar cfr.jar E38_Decompiling.class
 * 
 * 3. Using JD-GUI:
 *    - Open the GUI application
 *    - File > Open -> Select E38_Decompiling.class
 *    - The decompiled source will be displayed
 * 
 * 4. The decompiled output will show the original source code
 *    reconstructed from the bytecode.
 * 
 * NOTE: Decompilation is useful for:
 * - Learning how Java works internally
 * - Analyzing third-party libraries
 * - Debugging obfuscated code
 * - Reverse engineering (ethical use only)
 */
