import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
        // ===== NON-IN-PLACE VERSION =====

        int[] arr1 = { 5, 4, 3, 2, 1 };
        arr1 = mergeSort(arr1);
        System.out.println("Non-In-Place: " + Arrays.toString(arr1));

        // ===== IN-PLACE VERSION =====

        int[] arr2 = { 5, 4, 3, 2, 1 };

        mergeSortInPlace(arr2, 0, arr2.length - 1);

        System.out.println("In-Place: " + Arrays.toString(arr2));

    }

    // ==================================================
    // NON-IN-PLACE MERGE SORT
    // ==================================================

    static int[] mergeSort(int[] arr1) {
        if (arr1.length == 1) {
            return arr1;
        }
        int mid = arr1.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr1, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr1, mid, arr1.length));
        return merge(left, right);
    }

    static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < first.length && j < second.length) {
            if (first[i] <= second[j]) {
                mix[k++] = first[i++];
            } else {
                mix[k++] = second[j++];
            }
        }
        while (i < first.length) {
            mix[k++] = first[i++];
        }
        while (j < second.length) {
            mix[k++] = second[j++];
        }
        return mix;
    }

    // ==================================================
    // IN-PLACE STYLE MERGE SORT
    // ==================================================
    static void mergeSortInPlace(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSortInPlace(arr, low, mid);
        mergeSortInPlace(arr, mid + 1, high);
        mergeInPlace(arr, low, mid, high);
    }

    static void mergeInPlace(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= high) {
            temp[k++] = arr[j++];
        }
        System.arraycopy(temp, 0, arr, low, temp.length);
    }
}

// Merge Sort Implementations

// 1. Non-In-Place / Separate-Array Approach:
// The array is recursively divided by creating separate left and right
// subarrays. These sorted subarrays are then merged into a new array. It is
// simple to understand but involves additional array creation.

// 2. Index-Based Approach:
// The original array is maintained throughout recursion, and low, mid, and high
// indices are used to represent different portions of the array. The sorted
// portions are merged and copied back into the original array. This avoids
// creating separate subarrays during recursion and is generally the preferred
// implementation to learn for DSA.

// Both approaches have O(n log n) time complexity and O(n) auxiliary space in
// the standard implementation because merging requires temporary storage.

// One thing to remember
// Non-In-Place:
// new arrays → sort → new merged array

// Index-Based:
// same array → sort ranges → temporary merge array → copy back
