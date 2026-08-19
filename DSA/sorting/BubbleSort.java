// package DSA.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 5, 4, 2 };
        int n = arr.length;
        bubbleSort(arr, n);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr, int n) {
        boolean swapped;
        // run the steps n-1 times
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            // After each pass, the largest element in the unsorted portion
            // moves to its correct position at the end.
            for (int j = 0; j < n - i - 1; j++) {
                // swap the item if it is greater than the next item
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no swaps occurred during a complete pass,
            // the array is already sorted, and stop the program.
            if (!swapped) {
                break;
            }
        }
    }
}
