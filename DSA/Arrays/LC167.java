import java.util.Arrays;

public class LC167 {
    public static void main(String[] args) {
        // int[] nums = { 2, 7, 11, 15 };
        int[] nums = { 2, 3, 4 };
        //int target = 9;
        int target = 6;
        int n = nums.length;
        int[] ans = new int[2];
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                ans[0] = left + 1;
                ans[1] = right + 1;
                break;
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(Arrays.toString(ans));
    }
}
