package Practical5;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
    // Main quicksort method (single argument)
    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i <  n ; i++) {
            int key = array[i]; //record
            int j = i - 1;
            while (j >= 0 && array[j] > key) { //find the position
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key; //insert the “key” at the correct position
        }
    }


    // Main method to create and sort an array
    public static void main(String[] args) {
        int[] array = new int[20];
        Random rand = new Random();

        // Fill the array with random values
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(1000); // Random integers between 0 and 999
        }

        // Display array before sorting
        System.out.println("Array before sorting:");
        System.out.println(Arrays.toString(array));

        // Sort the array using quicksort
        insertionSort(array);

        // Display array after sorting
        System.out.println("Array after sorting:");
        System.out.println(Arrays.toString(array));
    }
}
