public class BubbleSort {

/*
Loop through array comparing neighbouring elements
If element to right is bigger, swap element with left
Compare each element in the array until done first iteration
Start again from second index
Repeat until only one element left
 */

    public static void bubbleSort(int arr[]){
        int i,j,temp;
        boolean swapped;
        for(i=0; i<arr.length-1; i++){
            swapped = false;
            for(j=0; j<arr.length-i-1; j++){
                //Comparing neighbouring elements:
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                // If we've made no swaps (ie array is in order):
                break;
            }
        }
    }
}