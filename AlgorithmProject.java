/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.algorithmproject;

/**
 *
 * @author USER
 */
import static com.mycompany.algorithmproject.SortingAlgorithm.generateFewUnique;
import static com.mycompany.algorithmproject.SortingAlgorithm.generateRandom;
import static com.mycompany.algorithmproject.SortingAlgorithm.generateReverse;
import static com.mycompany.algorithmproject.SortingAlgorithm.generateSorted;
import static com.mycompany.algorithmproject.SortingAlgorithm.testAll;

public class AlgorithmProject {

    public static void main(String[] args) {
         int[] sizes = {1000, 10000, 50000, 100000};

        System.out.println("==== Sorting Algorithms Benchmark ====");

        for (int size : sizes) {
            System.out.println("\n--- Dataset Size: " + size + " ---");

            // 1) Random Data
            int[] randomData = generateRandom(size);

            // 2) Sorted Data
            int[] sortedData = generateSorted(size);

            // 3) Reverse Sorted
            int[] reverseData = generateReverse(size);

            // 4) Few Unique
            int[] fewUnique = generateFewUnique(size);

            testAll("Random", randomData);
            testAll("Sorted", sortedData);
            testAll("Reverse Sorted", reverseData);
            testAll("Few Unique", fewUnique);
        }
    }
    }
}
