import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = { 3, 1, 5, 4, 2 };
        int n = arr.length;
        cyclicSort(arr, n);
        System.out.println(Arrays.toString(arr));
    }

    static void cyclicSort(int[] arr, int n) {
        int i = 0;
        while (i < n) {
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            } else {
                i++;
            }
        }
    }
}
