public class LC209 {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        int target = 7;
        int n = nums.length;
        int left = 0;
        int window = 0;
        int minlength = Integer.MAX_VALUE;
        for (int right = 0; right < n; right++) {
            window += nums[right];

            while (window >= target) {
                minlength = Math.min(minlength, right - left + 1);
                window -= nums[left];
                left++;
            }
        }
        System.out.println(minlength == Integer.MAX_VALUE ? 0 : minlength);
    }
}
