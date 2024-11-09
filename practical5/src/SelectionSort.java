public class SelectionSort {

/*
Algorithm moves through array assuming smallest element is first/one we are looking at.
If element is found that is smaller, swap them. Consider first element to be
solved -> start from next element -> repeat
 */

    public void selectionSort(int arr[]){
        //Selected the smallest elements
        for(int i=0;i<arr.length-1;i++){

            //Find min element:
            int minIndex = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }

            //Swap elements so that min element is in correct final position
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
