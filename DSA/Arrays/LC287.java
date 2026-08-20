//https://leetcode.com/problems/find-the-duplicate-number/description/
public class LC287 {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 4, 2, 2 };
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            } else {
                ans = Math.abs(nums[i]);
            }
        }
        System.out.println(ans);
    }
}
