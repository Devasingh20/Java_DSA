
//Java implementation using Hoare Partition;
import java.util.*;

public class QuickSort2 {
    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 4, 2, 7, 1, 6 };
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int s = low;
        int e = high;
        int mid = s + (e - s) / 2;
        int pivot = arr[mid];
        while (s <= e) {
            while (arr[s] < pivot) {
                s++;
            }
            while (arr[e] > pivot) {
                e--;
            }
            if (s <= e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
        quickSort(arr, low, e);
        quickSort(arr, s, high);
    }
}
// The Hoare Partition Scheme is an efficient algorithm used by QuickSort to
// divide an array around a designated pivot. It uses two pointers starting from
// opposite ends of the array that move inward until they find elements that are
// out of place and swap them.Compared to the Lomuto scheme, Hoare's method is
// typically faster because it performs fewer swaps on average and only requires
// a single traversal of the data.