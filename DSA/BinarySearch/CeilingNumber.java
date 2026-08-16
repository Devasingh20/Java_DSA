public class CeilingNumber {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 5, 9, 14, 16, 17, 18, 19 };
        int target = 10;
        int ans = agnosticBS(nums, target);
        System.out.println(ans);
    }

    static int agnosticBS(int[] nums, int target) {
        // but what if the target is greater than the greatest number in the array
        if (target > nums[nums.length - 1]) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        boolean isAsc = nums[start] < nums[end]; // check if the array is sorted in ascending or descending order short
                                                 // form of if else statement
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return nums[mid];
            }
            if (isAsc) {
                if (target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target < nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return nums[start];
    }
}
