public class LC896 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 3 };
        int n = nums.length;
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                increasing = false;
            }
            if (nums[i] < nums[i + 1]) {
                decreasing = false;
            }
        }
        System.out.println(increasing || decreasing);
    }
}
