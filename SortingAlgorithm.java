package com.mycompany.algorithmproject;
import java.util.Random;
public class SortingAlgorithm {
    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // merge sort
    public static void mergeSort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;

            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);

            merge(A, p, q, r);
        }
    }

    private static void merge(int[] A, int p, int q, int r) {

        int n1 = q - p + 1;
        int n2 = r - q;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = A[p + i];
        }

        for (int j = 0; j < n2; ++j) {
            R[j] = A[q + 1 + j];
        }

        int i = 0, j = 0;
        int k = p;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            A[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            A[k] = R[j];
            j++;
            k++;
        }
    }

    // heap sort 
    class HeapSort {

        void sort(int[] arr) {
            int n = arr.length;
            for (int i = n / 2 - 1; i >= 0; i--) {
                heapify(arr, n, i);
            }
            for (int i = n - 1; i > 0; i--) {
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
                heapify(arr, i, 0);
            }
        }

        void heapify(int[] arr, int n, int i) {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < n && arr[left] > arr[largest]) {
                largest = left;
            }
            if (right < n && arr[right] > arr[largest]) {
                largest = right;
            }
            if (largest != i) {
                int temp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = temp;
                heapify(arr, n, largest);

            }
        }
    }

    //quick sort
    static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        // random pivot
        randomizedPivot(arr, low, high);
        int pivot = arr[high];

        int lt = low;     // أقل من pivot
        int gt = high;    // أكبر من pivot
        int i = low;

        while (i <= gt) {
            if (arr[i] < pivot) {
                swap(arr, lt, i);
                lt++;
                i++;
            } else if (arr[i] > pivot) {
                swap(arr, i, gt);
                gt--;
            } else {
                i++;
            }
        }

        // recursive calls
        quickSort(arr, low, lt - 1);
        quickSort(arr, gt + 1, high);
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Randomized QuickSort
    static void randomizedPivot(int[] arr, int low, int high) {
        Random rand = new Random();
        int pivotIndex = rand.nextInt(high - low + 1) + low;

        int temp = arr[pivotIndex];
        arr[pivotIndex] = arr[high];
        arr[high] = temp;
    }

    //////////////////////////////////
    static int[] generateRandom(int n) {
        Random r = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = r.nextInt(1_000_000) + 1;
        }
        return arr;
    }

    static int[] generateSorted(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    static int[] generateReverse(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
        }
        return arr;
    }

    static int[] generateFewUnique(int n) {
        Random r = new Random();
        int[] arr = new int[n];
        int[] values = {1, 2, 3, 4, 5};
        for (int i = 0; i < n; i++) {
            arr[i] = values[r.nextInt(5)];
        }
        return arr;
    }

    static void testAll(String type, int[] original) {

        System.out.println("\n[" + type + " Data]");

        int[] arr1 = original.clone();
        long t1 = System.currentTimeMillis();
        insertionSort(arr1);
        long t2 = System.currentTimeMillis();
        System.out.println("Insertion Sort: " + (t2 - t1) + " ms");

        int[] arr2 = original.clone();
        t1 = System.currentTimeMillis();
        mergeSort(arr2, 0, arr2.length - 1);
        t2 = System.currentTimeMillis();
        System.out.println("Merge Sort: " + (t2 - t1) + " ms");

        int[] arr3 = original.clone();
        t1 = System.currentTimeMillis();
        new SortingAlgorithm().new HeapSort().sort(arr3);
        t2 = System.currentTimeMillis();
        System.out.println("Heap Sort: " + (t2 - t1) + " ms");

        int[] arr4 = original.clone();
        t1 = System.currentTimeMillis();
        quickSort(arr4, 0, arr4.length - 1);
        t2 = System.currentTimeMillis();
        System.out.println("Quick Sort: " + (t2 - t1) + " ms");
    
        int[] arr5 = original.clone();
        t1 = System.currentTimeMillis();
        quickSort(arr5, 0, arr5.length - 1);
        t2 = System.currentTimeMillis();
        System.out.println("Randomized QuickSort: " + (t2 - t1) + " ms");
    } 
}




