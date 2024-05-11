package com.example;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PaidGroup {
  //  This method calculates the minimum cost to hire k workers.
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length; // Total number of workers.
        Worker[] workers = new Worker[n]; // Array to store workers' data.
        
        // Creating Worker objects for each worker with their quality and wage.
        for (int i = 0; i < n; ++i)
            workers[i] = new Worker(quality[i], wage[i]);
        
        // Sorting workers based on their wage-to-quality ratio.
        Arrays.sort(workers);

        double ans = Double.MAX_VALUE; // Variable to store the minimum cost.
        int sumq = 0; // Sum of qualities of selected workers.
        PriorityQueue<Integer> pool = new PriorityQueue<>(); // Max-heap to store qualities.
        
        // Loop through each worker.
        for (Worker worker : workers) {
            pool.offer(-worker.quality); // Add worker's quality to the max-heap.
            sumq += worker.quality; // Add worker's quality to the sum.
            
            // If we have more than k workers, remove the one with the highest quality.
            if (pool.size() > k) sumq += pool.poll();
            
            // If we have exactly k workers, calculate the cost and update the answer.
            if (pool.size() == k) ans = Math.min(ans, sumq * worker.ratio());
        }
        return ans; // Return the minimum cost.
    }

    // Worker class to store quality and wage, and to compare workers.
    class Worker implements Comparable<Worker> {
        int quality, wage;

        Worker(int q, int w) {
            quality = q; // Worker's quality.
            wage = w; // Worker's minimum wage expectation.
        }

        // Method to get the wage-to-quality ratio.
        public double ratio() {
            return (double) wage / quality;
        }

        // Method to compare workers based on their ratio.
        public int compareTo(Worker other) {
            return Double.compare(ratio(), other.ratio());
        }
    }

    // Main method to run the program with user inputs.
    public static void main(String[] args) {
        // Example user inputs.
        int[] quality = {10, 20, 5};
        int[] wage = {70, 50, 30};
        int k = 2;

        // Creating an instance of PaidGroup.
        PaidGroup pg = new PaidGroup();
        
        // Calling the method to calculate the minimum cost and printing the result.
        double result = pg.mincostToHireWorkers(quality, wage, k);
        System.out.printf("The minimum cost to hire %d workers is: %.5f\n", k, result);
    }
}
