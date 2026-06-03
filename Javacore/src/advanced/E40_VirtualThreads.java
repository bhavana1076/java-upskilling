/**
 * Exercise 40: Virtual Threads (Java 21)
 * Objective: Use lightweight threads for scalable concurrency.
 */
public class E40_VirtualThreads {
    
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Virtual Threads Example ===\n");
        
        // Example 1: Create and start virtual threads
        System.out.println("Launching 10,000 virtual threads...");
        long startTime = System.currentTimeMillis();
        
        Thread[] threads = new Thread[10000];
        for (int i = 0; i < 10000; i++) {
            final int threadNumber = i + 1;
            threads[i] = Thread.startVirtualThread(() -> {
                try {
                    // Simulate some work
                    Thread.sleep(100);
                    if (threadNumber % 1000 == 0) {
                        System.out.println("Virtual Thread " + threadNumber + " completed");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        
        // Wait for all threads to complete
        for (Thread thread : threads) {
            thread.join();
        }
        
        long endTime = System.currentTimeMillis();
        System.out.println("All threads completed in " + (endTime - startTime) + " ms");
        
        System.out.println("\n=== Benefits of Virtual Threads ===");
        System.out.println("1. Lightweight - Can create millions of them");
        System.out.println("2. Easier to reason about - Imperative style");
        System.out.println("3. Better resource utilization");
        System.out.println("4. Automatic scheduling on platform threads");
    }
}

/**
 * Performance Comparison:
 * 
 * Traditional Threads (10 threads creating 1000 objects each):
 * - Memory: ~8 MB per thread
 * - Total for 10 threads: ~80 MB
 * - Time to create and start: ~1-2 seconds
 * 
 * Virtual Threads (10,000 virtual threads):
 * - Memory: ~1 KB per virtual thread
 * - Total for 10,000 threads: ~10 MB
 * - Time to create and start: ~100-200 ms
 * 
 * NOTE: Requires Java 21 or later.
 * To run: java --enable-preview E40_VirtualThreads.java
 * Or compile with: javac --release 21 E40_VirtualThreads.java
 */
