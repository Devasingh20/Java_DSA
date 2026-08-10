//left rotation by 2 position.

import java.util.Arrays;

public class left_rotation1 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        int n = nums.length;
        int temp = nums[0];
        for (int i = 0; i < n - 1; i++) {
            nums[i] = nums[i + 1];
        }

        int temp1 = nums[0];
        for (int i = 0; i < n - 1; i++) {
            nums[i] = nums[i + 1];
        }
        nums[n - 2] = temp;
        nums[n - 1] = temp1;
        System.out.println(Arrays.toString(nums));
    }
}
