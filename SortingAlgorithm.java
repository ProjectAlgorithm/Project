package com.mycompany.algorithmproject;
import java.util.Random;
public class SortingAlgorithm {
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
    class HeapSort{
        void sort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 -1; i >= 0; i--)
            heapify(arr, n, i);
        for (int i = n -1; i > 0; i--) {
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
        if (left < n && arr[left] > arr[largest])
            largest = left;
        if (right < n && arr[right] > arr[largest])
            largest = right;
        if (largest != i) {
            int temp = arr[i]; arr[i] = arr[largest]; 
            arr[largest] = temp;
        heapify(arr, n, largest);
        
       }       
    }
 }
    

    
     
}

