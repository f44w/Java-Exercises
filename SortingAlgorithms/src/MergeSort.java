public class MergeSort {

    // Initial mergeSort method - just takes array:
    public static void mergeSort(int [] array){
        mergeSort(array,0,array.length-1);
    }

    // Overloaded mergeSort method:
    private static void mergeSort(int[] array, int start, int end){
        // Base case - invalid for any size less than 2:
        if(start < end){
            int mid = (start + end) / 2; // Set our mid point
            mergeSort(array, start, mid); // Run merge sort on lower half
            mergeSort(array, mid + 1, end); // Run merge sort on upper half
            merge(array, start, mid, end); // Merge all together
        }
    }


    private static void merge(int[] array, int start, int mid, int end){
        // Create temp array and set up vals:
        int[] temp = new int[end - start + 1]; // Make a temp array
        int leftIndex = start; // Get our left index
        int rightIndex = mid + 1; // Get our right index
        int tempIndex = 0; // Set temp index

        // Merge two halves into the temp array:
        while(leftIndex<=mid && rightIndex<=end) {
            if (array[leftIndex] < array[rightIndex]) {
                temp[tempIndex++] = array[leftIndex++];
            } else {
                temp[tempIndex++] = array[rightIndex++];
            }
        }

        // If Arrays are not the same size, we copy the last of the larger one exploiting the fact that it
        // is already sorted within itself
        // Copy remainder of 1st subarray into the temp array:
        while(leftIndex<=mid){
            temp[tempIndex++] = array[leftIndex++];
        }

        // Copy remainder of 2nd subarray into the temp array:
        while(rightIndex<=end){
            temp[tempIndex++] = array[rightIndex++];
        }

        // Copy contents of temp array into our array - Sorted in array:
        for(int i=0; i<temp.length;i++){
            array[start + i] = temp[i];
        }
    }
}
