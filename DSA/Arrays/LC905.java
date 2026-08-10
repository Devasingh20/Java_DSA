import java.util.Arrays;

public class LC905 {
    public static void main(String[] args) {
        int[] nums = { 3, 1, 2, 4 };
        if (nums.length == 0)
            throw new IllegalArgumentException("Array is empty");
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                // ans[left] = nums[i];
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                left++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
