//Java implementation using Lomuto Partition;

import java.util.Arrays;

public class QuickSort1 {
    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 4, 2, 7, 1, 6 };
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}

// Lomuto Partition Scheme is a popular algorithm used in QuickSort to
// reorganize an array around a designated pivot element. It traditionally
// selects the last element of the array as the pivot. During a single
// traversal, it rearranges the array so that all elements smaller than the
// pivot are placed to its left, and all elements greater than or equal to the
// pivot are placed to its right.