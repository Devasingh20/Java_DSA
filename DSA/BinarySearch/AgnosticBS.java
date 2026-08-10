// package DSA.BinarySearch;

public class AgnosticBS {
    public static void main(String[] args) {
        int[] nums = { 18, 12, 4, 2, 0, -1, -4, -12, -18 };
        int target = -12;
        int ans = agnosticBS(nums, target);
        System.out.println(ans);
    }

    static int agnosticBS(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        boolean isAsc = nums[start] < nums[end]; // check if the array is sorted in ascending or descending order short
                                                 // form of if else statement
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return mid;
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
        return -1;
    }
}
