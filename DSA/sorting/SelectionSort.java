import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        // int[] arr = { 5, 2, 8, 1, 3 };
        int[] arr = { -10, 5, -12, 7, 10 };
        int n = arr.length;
        selectionSort(arr, n);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            // find the min item in the entire array and swap it with correct index
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
