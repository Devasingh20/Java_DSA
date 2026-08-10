import java.util.Arrays;

public class permutation {

    // Function to generate permutations
    public static void permute(int[] arr, int index) {

        // Base case: one complete permutation formed
        if (index == arr.length) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        // Try fixing each element at the current index
        for (int i = index; i < arr.length; i++) {

            // Swap current index with i
            swap(arr, index, i);

            // Recurse for next index
            permute(arr, index + 1);

            // Backtrack (restore original array)
            swap(arr, index, i);
        }
    }

    // Swap utility
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        permute(arr, 0);
    }
}
