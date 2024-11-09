import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int [] arr = new int[10];
        Random rand = new Random();
        for(int i=0; i<arr.length;i++){
            arr[i] = rand.nextInt(1000);
        }

        /*
        System.out.println("The Array before Bubble sort: ");

        System.out.println(Arrays.toString(arr));

        BubbleSort BS = new BubbleSort();
        BS.bubbleSort(arr);

        System.out.println("The Array after Bubble sort: ");
        System.out.println(Arrays.toString(arr));


        System.out.println("The array before merge sort: ");
        System.out.println(Arrays.toString(arr));

        MergeSort MS = new MergeSort();
        MS.mergeSort(arr);

        System.out.println("The array after merge sort: ");
        System.out.println(Arrays.toString(arr));
        */

        System.out.println("The array before selection sort: ");
        System.out.println(Arrays.toString(arr));

        SelectionSort SS = new SelectionSort();
        SS.selectionSort(arr);

        System.out.println("The array after selection sort: ");
        System.out.println(Arrays.toString(arr));
    }
}