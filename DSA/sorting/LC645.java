//https://leetcode.com/problems/set-mismatch/

import java.util.Arrays;

public class LC645 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 4 };
        int n = nums.length;
        int[] result = setMismatch(nums, n);
        System.out.println(Arrays.toString(result));
    }

    static int[] setMismatch(int[] nums, int n) {
        int i = 0;
        while (i < n) {
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }
        for (int index = 0; index < n; index++) {
            if (nums[index] != index + 1) {
                return new int[] { nums[index], index + 1 };
            }
        }
        return new int[] { -1, -1 };
    }
}
