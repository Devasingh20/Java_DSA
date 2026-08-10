public class LC1343 {
    public static void main(String[] args) {
        int[] nums = { 11, 13, 17, 23, 29, 31, 7, 5, 2, 3 };
        int n = nums.length;
        int k = 3;
        int threshold = 5;
        double windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int count = 0;
        for (int i = k; i < n; i++) {
            if (windowSum / k >= threshold) {
                count++;
            }
            windowSum -= nums[i - k];
            windowSum += nums[i];
        }
        if (windowSum / k >= threshold) {
            count++;
        }
        System.out.println(count);
    }
}
