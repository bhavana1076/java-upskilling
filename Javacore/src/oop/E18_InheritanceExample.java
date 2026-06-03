/**
 * Exercise 18: Inheritance Example
 * Objective: Implement inheritance.
 */
public class E18_InheritanceExample {
    
    // Base class
    static class Animal {
        public void makeSound() {
            System.out.println("Some generic animal sound");
        }
    }
    
    // Subclass
    static class Dog extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Bark! Bark!");
        }
    }
    
    // Another subclass
    static class Cat extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Meow! Meow!");
        }
    }
    
    public static void main(String[] args) {
        // Create instances
        Animal genericAnimal = new Animal();
        Dog dog = new Dog();
        Cat cat = new Cat();
        
        System.out.println("Animal sound: ");
        genericAnimal.makeSound();
        
        System.out.println("Dog sound: ");
        dog.makeSound();
        
        System.out.println("Cat sound: ");
        cat.makeSound();
    }
}
