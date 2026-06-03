/**
 * Exercise 17: Class and Object Creation
 * Objective: Understand classes and objects.
 */
public class E17_ClassAndObject {
    
    // Car class
    static class Car {
        private String make;
        private String model;
        private int year;
        
        // Constructor
        public Car(String make, String model, int year) {
            this.make = make;
            this.model = model;
            this.year = year;
        }
        
        // Method to display details
        public void displayDetails() {
            System.out.println("Car Details:");
            System.out.println("Make: " + make);
            System.out.println("Model: " + model);
            System.out.println("Year: " + year);
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        // Create Car objects
        Car car1 = new Car("Toyota", "Camry", 2022);
        Car car2 = new Car("Honda", "Civic", 2021);
        Car car3 = new Car("Ford", "Mustang", 2023);
        
        // Display details
        car1.displayDetails();
        car2.displayDetails();
        car3.displayDetails();
    }
}
