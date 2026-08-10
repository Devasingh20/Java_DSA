public class LC918 {
    public static void main(String[] args) {
        int[] nums = { 1, -2, 3, -2 };
        int totalSum = 0;

        int currentMax = 0;
        int maxSum = Integer.MIN_VALUE;

        int currentMin = 0;
        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];

            currentMax += nums[i];
            maxSum = Math.max(maxSum, currentMax);
            if (currentMax < 0) {
                currentMax = 0;
            }

            currentMin += nums[i];
            minSum = Math.min(minSum, currentMin);
            if (currentMin > 0) {
                currentMin = 0;
            }
        }
        if (maxSum > 0) {
            System.out.println("The maximum circular subarray sum is: " + Math.max(maxSum, totalSum - minSum));
        } else {
            System.out.println("The maximum circular subarray sum is: " + maxSum);
        }
    }
}
