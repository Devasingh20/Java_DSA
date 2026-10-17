import java.util.Arrays;

public class LC31_nextPermutation {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        int pivot = -1;// Pivot is initialized to -1, meaning no pivot has been found.
        // The pivot is the first index from the right where
        // nums[i] < nums[i + 1].
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }
        // If pivot != -1, a pivot has been found.
        // Find the first element greater than the pivot
        // by scanning from right to left, then swap them.
        if (pivot != -1) {
            for (int i = nums.length - 1; i > pivot; i--) {
                if (nums[i] > nums[pivot]) {
                    int temp = nums[i];
                    nums[i] = nums[pivot];
                    nums[pivot] = temp;
                    break;
                }
            }
        }
        // If the pivot was not found, the array is in descending
        // order and is already the greatest permutation.
        // Reverse the entire array to obtain the smallest permutation.
        //
        // Otherwise, reverse only the suffix after the pivot
        // to obtain the smallest possible suffix.
        int left = pivot == -1 ? 0 : pivot + 1;
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(nums));
    }
}
