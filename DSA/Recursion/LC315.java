
//https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/
import java.util.*;

public class LC315 {
    public static void main(String[] args) {
        // int[] arr = { 5, 2, 6, 1 };
        int[] arr = { 3, 4, 2, 5, 1 };
        int[] index = new int[arr.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            index[i] = i;
            list.add(0);
        }
        countSmaller(index, 0, arr.length - 1, arr, list);
        System.out.println(list);
    }

    static void countSmaller(int[] index, int low, int high, int[] arr, List<Integer> list) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        countSmaller(index, low, mid, arr, list);
        countSmaller(index, mid + 1, high, arr, list);
        merge(index, low, mid, high, arr, list);
    }

    static void merge(int[] index, int low, int mid, int high, int[] arr, List<Integer> list) {
        // size of left and right subarrays
        int n1 = mid - low + 1;
        int n2 = high - mid;
        // create left and right subarrays
        int[] left = new int[n1];
        int[] right = new int[n2];
        // copy data to left and right subarrays from index array
        System.arraycopy(index, low, left, 0, n1);
        System.arraycopy(index, mid + 1, right, 0, n2);
        // merge the left and right subarrays
        int i = 0;
        int j = 0;
        int k = low;
        while (i < n1 && j < n2) {
            if (arr[left[i]] <= arr[right[j]]) {
                index[k++] = left[i];
                list.set(left[i], list.get(left[i]) + j);
                i++;
            } else {
                index[k++] = right[j];
                j++;
            }
        }
        while (i < n1) {
            index[k++] = left[i];
            list.set(left[i], list.get(left[i]) + j);
            i++;
        }
        while (j < n2) {
            index[k++] = right[j];
            j++;
        }
    }
}
