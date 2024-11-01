package Practical4;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
    // Main quicksort method (single argument)
    public static void insertionsort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }


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
        insertionsort(array);

        // Display array after sorting
        System.out.println("Array after sorting:");
        System.out.println(Arrays.toString(array));
    }
}