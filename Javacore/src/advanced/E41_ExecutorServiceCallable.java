/**
 * Exercise 41: Executor Service and Callable
 * Objective: Use concurrency utilities.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class E41_ExecutorServiceCallable {
    
    // Callable task that returns a result
    static class CalculationTask implements Callable<Integer> {
        private int taskNumber;
        private int value;
        
        public CalculationTask(int taskNumber, int value) {
            this.taskNumber = taskNumber;
            this.value = value;
        }
        
        @Override
        public Integer call() throws Exception {
            System.out.println("Task " + taskNumber + " started");
            Thread.sleep(1000); // Simulate work
            int result = value * value;
            System.out.println("Task " + taskNumber + " completed with result: " + result);
            return result;
        }
    }
    
    public static void main(String[] args) {
        // Create a thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<Integer>> futureList = new ArrayList<>();
        
        System.out.println("=== Executor Service with Callable ===\n");
        
        // Submit multiple callable tasks
        System.out.println("Submitting tasks...");
        for (int i = 1; i <= 5; i++) {
            Callable<Integer> task = new CalculationTask(i, i * 10);
            Future<Integer> future = executor.submit(task);
            futureList.add(future);
        }
        
        System.out.println("\nTasks submitted. Waiting for results...\n");
        
        // Collect results
        int totalSum = 0;
        for (int i = 0; i < futureList.size(); i++) {
            try {
                Future<Integer> future = futureList.get(i);
                Integer result = future.get(5, TimeUnit.SECONDS); // Wait up to 5 seconds
                System.out.println("Retrieved result for task " + (i + 1) + ": " + result);
                totalSum += result;
            } catch (TimeoutException e) {
                System.out.println("Task " + (i + 1) + " timed out!");
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        System.out.println("\nTotal sum: " + totalSum);
        
        // Shutdown the executor
        executor.shutdown();
        System.out.println("Executor shutdown complete.");
    }
}

/**
 * Key Concepts:
 * 
 * 1. Callable<V>: Similar to Runnable but returns a result of type V
 * 2. Future<V>: Represents the result of an asynchronous computation
 * 3. ExecutorService: Manages thread pool execution
 * 
 * Methods:
 * - submit(Callable): Submit a task and return Future
 * - get(): Block until result is available
 * - get(long timeout, TimeUnit unit): Get result with timeout
 * - isDone(): Check if task is complete
 * - cancel(boolean): Cancel task execution
 * 
 * Pool types:
 * - newFixedThreadPool(int nThreads): Fixed size thread pool
 * - newCachedThreadPool(): Dynamic thread pool
 * - newSingleThreadExecutor(): Single thread executor
 * - newScheduledThreadPool(int nThreads): For scheduling tasks
 */
