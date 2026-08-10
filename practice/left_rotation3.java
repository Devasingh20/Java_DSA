//Instead of rotating the whole array, you rotate only a part of it.The subarray is:
// Index : 2 3 4 5
// Value : 3 4 5 6
// We want to left rotate only this subarray by one position.

import java.util.Arrays;

public class left_rotation3 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        // int n = nums.length;
        int l = 2;
        int r = 5;
        int temp = nums[l];
        for (int i = l; i < r; i++) {
            nums[i] = nums[i + 1];
        }
        nums[r] = temp;
        System.out.println(Arrays.toString(nums));
    }
}