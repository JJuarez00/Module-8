
package module8.two;

/*
Note to me: Page 32 is where Parallel Programming gets brought up.

Chapter 32:  Exercise 32.15

(Parallel sum) Implement the following method using Fork/Join to find the sum of 
a list.

public static double parallelSum(double[] list)

Write a test program that finds the sum in a list of 9,000,000 double values



*/

import java.util.concurrent.ForkJoinPool;

public class ThirtyTwoPointFifteen {

    // Note to me: look at page 36
    public static double parallelSum(double[] list) {
        SumTask task = new SumTask(list, 0, list.length);
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(task);
    }

    public static void main(String[] args) {
        
        int size = 9000000;
        double[] list = new double[size];
        
        
        for (int i = 0; i < size; i++) {
            list[i] = Math.random();
        }
        
        long startTime = System.currentTimeMillis();
        double sum = parallelSum(list);
        long endTime = System.currentTimeMillis();

        System.out.println("Parallel Sum: " + sum);
        System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");
        
        // Ignore this just wanted to make it look with all stats but also since you showed this in the zoom class
        System.out.println(Runtime.getRuntime().availableProcessors() + " Processors Available");
    }
}

