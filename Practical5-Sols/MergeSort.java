package Practical5;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    // Main merge sort method (single argument)
    public static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    // Overloaded merge sort method with start and end indices
    private static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2; // Find the middle index

            // Recursively sort both halves
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);

            // Merge the sorted halves
            merge(array, start, mid, end);
        }
    }

    // Merge two sorted subarrays within the same array
    private static void merge(int[] array, int start, int mid, int end) {
        // Create a temporary array to hold the merged result
        int[] temp = new int[end - start + 1];

        // Indexes for left, right, and merged array
        int leftIndex = start;     // Start of the left subarray
        int rightIndex = mid + 1;  // Start of the right subarray
        int tempIndex = 0;         // Index for temp array

        // Merge the two halves into the temp array
        while (leftIndex <= mid && rightIndex <= end) {
            if (array[leftIndex] <= array[rightIndex]) {
                temp[tempIndex++] = array[leftIndex++];
            } else {
                temp[tempIndex++] = array[rightIndex++];
            }
        }

        // Copy remaining elements from the left subarray, if any
        while (leftIndex <= mid) {
            temp[tempIndex++] = array[leftIndex++];
        }

        // Copy remaining elements from the right subarray, if any
        while (rightIndex <= end) {
            temp[tempIndex++] = array[rightIndex++];
        }

        // Copy merged elements back into the original array
        for (int i = 0; i < temp.length; i++) {
            array[start + i] = temp[i];
        }
    }

    // Main method to create and sort an array
    public static void main(String[] args) {
        int[] array = new int[200];
        Random rand = new Random();

        // Fill the array with random values
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(1000); // Random integers between 0 and 999
        }

        // Display array before sorting
        System.out.println("Array before sorting:");
        System.out.println(Arrays.toString(array));

        // Sort the array using merge sort
        mergeSort(array);

        // Display array after sorting
        System.out.println("Array after sorting:");
        System.out.println(Arrays.toString(array));
    }
}
