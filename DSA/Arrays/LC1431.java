import java.util.Arrays;

public class LC1431 {
    public static void main(String[] args) {
        int[] nums = { 4, 2, 1, 1, 2 };
        boolean[] ans = new boolean[nums.length];
        int e = 1;
        // for (int i = 0; i < nums.length; i++) {
        // int a = nums[i] + e;
        // for (int j = 0; j < nums.length; j++) {
        // if (a < nums[j]) {
        // ans[i] = 0;
        // break;
        // } else {
        // ans[i] = 1;
        // }
        // }
        // }
        // System.out.println(Arrays.toString(ans));
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        System.out.println(max);

        for (int i = 0; i < nums.length; i++) {
            // if (nums[i] + e >= max) {
            // ans[i] = true;
            // } else {
            // ans[i] = false;
            // } //we can use a better version

            ans[i] = nums[i] + e >= max;
        }
        System.out.println(Arrays.toString(ans));
    }
}
