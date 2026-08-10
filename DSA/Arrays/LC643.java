public class LC643 {
    public static void main(String[] args) {
        int[] nums = { 1, 12, -5, -6, 50, 3 };
        int n = nums.length;
        int k = 4;
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        double maxSum = windowSum;
        for (int i = k; i < n; i++) {
            windowSum -= nums[i - k];
            windowSum += nums[i];
            maxSum = Math.max(maxSum, windowSum);
        }
        System.out.println(maxSum / 4);
    }
}
