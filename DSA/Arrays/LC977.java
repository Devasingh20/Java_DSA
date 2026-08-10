import java.util.Arrays;

public class LC977 {
    public static void main(String[] args) {

        // int[] nums = { -4, -3, 1, 2, 5 };
        // int[] ans = new int[nums.length];
        // for (int i = 0; i < nums.length; i++) {
        // ans[i] = nums[i] * nums[i];
        // }
        // Arrays.sort(ans);
        // System.out.println(Arrays.toString(ans));

        int[] nums = { -4, -3, 1, 2, 5 };
        int n = nums.length;
        int[] ans = new int[n];
        int left = 0;
        int right = n - 1;
        int index = n - 1;
        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                ans[index] = nums[left] * nums[left];
                left++;
                index--;
            } else {
                ans[index] = nums[right] * nums[right];
                right--;
                index--;
            }
        }
        System.out.println(Arrays.toString(ans));
    }
}
