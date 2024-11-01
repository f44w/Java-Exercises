package Practical4;
import java.util.Arrays;
import java.util.Random;

/*
We recursively call the quicksort algorithm on the same array. We do not put it into different arrays. After we have
completed a call, we have our pivot value in the correct position. We then leave it alone and deal with the values
greater than it and less than it. We continue doing this until we have all the values in our array in the correct
positions. These values are ALL STILL IN THE SAME ARRAY.
 */

public class QuickSort {
    // Main quicksort method (single argument)
    public static void quicksort(int[] array) {
        // Initial calling of the whole array
        quicksort(array, 0, array.length - 1);
    }


    // Overloaded quicksort method with start and end indices
    private static void quicksort(int[] array, int start, int end) {
        // Quicksort for sub-arrays, hence int start and end
        // Checking for base case if sub-array has 0 or 1 element, meaning it's sorted:
        if (start < end) {
            // Randomising each time we call function - creates better average time complexity:
            int pivotIndex = randomisedPartition(array, start, end);
            quicksort(array, start, pivotIndex - 1); // Left side of Pivot value
            quicksort(array, pivotIndex + 1, end); // Right side of Pivot value
        }
    }

    // Partition method
    // Sorts subarrays around a pivot value
    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int pivotIndex  = start; // Tracks where pivot will eventually be stored
        for (int i = start; i < end; i++) {
            if (array[i] < pivot) {
                // if less than pivot, swap pivotIndex and value
                swap(array, pivotIndex, i);
                // Move pivotIndex on one;
                pivotIndex++;
            }
        }
        // At end, swap pivot value (in end) into PivotIndex location:
        swap(array, pivotIndex, end);
        // Returns the location of our pivot value in our new sorted array
        return pivotIndex;
    }

    // For use in Task iii. Comment this out initially while completing Task ii.
    public static int selectARandomNumIn(int start, int end) {
        Random random = new Random();
        return random.nextInt(end - start + 1) + start;
    }

    
    // For use in Task iii. Comment this out initially while completing Task ii.
    // Helper function. Allows us to make it pivotIndex random if we want it without
    // affecting the parition method itself
    private static int randomisedPartition(int[] array, int start, int end) {
        // Set pivot index to a random value:
        int randomPivotIndex = selectARandomNumIn(start, end);
        // Swap random pivot with end for partition algorithm (as pivot value is expected at the end of array):
        /*
        We choose a random index value (and thus the value at that location) from our array (or subarray) and then move that
        index to the end of the array (or subarray) in order to stay consistent for our partition method. This means that we
        then choose our arr[end] element to be our pivot which has now been randomised due to the below method call.
         */
        swap(array, randomPivotIndex, end);
       // Returns pivotIndex:
        return partition(array, start, end);
    }


    // Helper method: Swap elements in the array
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
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

        // Sort the array using quicksort
        quicksort(array);

        // Display array after sorting
        System.out.println("Array after sorting:");
        System.out.println(Arrays.toString(array));
    }
}