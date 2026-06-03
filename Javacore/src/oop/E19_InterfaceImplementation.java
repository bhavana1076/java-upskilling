/**
 * Exercise 19: Interface Implementation
 * Objective: Use interfaces in Java.
 */
public class E19_InterfaceImplementation {
    
    // Interface
    interface Playable {
        void play();
    }
    
    // Guitar class implementing Playable
    static class Guitar implements Playable {
        @Override
        public void play() {
            System.out.println("Playing guitar: Strumming strings... Ding-ding-ding!");
        }
    }
    
    // Piano class implementing Playable
    static class Piano implements Playable {
        @Override
        public void play() {
            System.out.println("Playing piano: Pressing keys... Ding-dong-ding!");
        }
    }
    
    // Flute class implementing Playable
    static class Flute implements Playable {
        @Override
        public void play() {
            System.out.println("Playing flute: Blowing air... Piu-piu-piu!");
        }
    }
    
    public static void main(String[] args) {
        // Create instances
        Playable guitar = new Guitar();
        Playable piano = new Piano();
        Playable flute = new Flute();
        
        // Call play method
        guitar.play();
        piano.play();
        flute.play();
    }
}
