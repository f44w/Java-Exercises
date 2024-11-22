package Practical5;
import java.util.Arrays;
import java.util.Random;

public class QuickSort{
    // Main quicksort method (single argument)
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // Overloaded quicksort method with start and end indices
    private static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int partitionIndex = randomisedPartition(array, start, end);//int partitionIndex = partition(array, start, end);
            quickSort(array, start, partitionIndex - 1);  // Sort left partition
            quickSort(array, partitionIndex + 1, end); // Sort right partition
        }
    }

    // Partition method
    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int pivotIdx = start;
        for (int i = start; i<= end-1; i ++){
            if (array[i] <=  pivot){
                swap(array, i, pivotIdx);
                pivotIdx ++;
            }
        }
        swap(array,pivotIdx, end);
        return pivotIdx;
    }

    public static int selectARandomNumIn(int start, int end) {
        Random random = new Random();
        return random.nextInt(end - start + 1) + start;
    }

    private static int randomisedPartition(int[] array, int start, int end) {
        int randomPivotIdx = selectARandomNumIn( start, end);
        swap(array, randomPivotIdx, end);
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
        quickSort(array);

        // Display array after sorting
        System.out.println("Array after sorting:");
        System.out.println(Arrays.toString(array));
    }
}
