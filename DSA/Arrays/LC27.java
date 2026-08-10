import java.util.Arrays;

public class LC27 {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
        int val = 2;
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        System.out.println(slow);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, slow )));
    }
}
