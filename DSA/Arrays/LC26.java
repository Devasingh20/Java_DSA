import java.util.*;

public class LC26 {
    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int n = nums.length;
        int slow = 0;
        for (int fast = 1; fast < n; fast++) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        System.out.println(slow + 1);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, slow + 1)));
    }
}
