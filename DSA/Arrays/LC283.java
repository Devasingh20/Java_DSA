import java.util.Arrays;

public class LC283 {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 3, 12 };
        int n = nums.length;
        int left = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[left] = nums[i];
                left++;
            }
        }
        for (int i = left; i < n; i++) {
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }
}