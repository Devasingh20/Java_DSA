public class LC219 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        int n = nums.length;
        int k = 3;
        boolean duplicate = false;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (nums[left] == nums[right] && Math.abs(left - right) <= k) {
                duplicate = true;
                break;
            } else {
                duplicate = false;
                left++;
            }
        }

        System.out.println(duplicate);
    }
}
