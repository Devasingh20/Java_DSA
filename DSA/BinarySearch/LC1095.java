//https://leetcode.com/problems/find-in-mountain-array/description/
public class LC1095 {
    public static void main(String[] args) {
        int[] nums = { 1, 5, 2 };
        int target = 0;
        int peak = peakIndexInMountainArray(nums);
        int firstTry = orderAgnosticBS(nums, target, 0, peak);
        // try to search in first half
        if (firstTry != -1) {
            System.out.println(firstTry);
        } // try to search in second half
        else {
            System.out.println(orderAgnosticBS(nums, target, peak + 1, nums.length - 1));
        }
    }

    static int peakIndexInMountainArray(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    static int orderAgnosticBS(int[] nums, int target, int start, int end) {
        boolean isAsc = nums[start] < nums[end];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isAsc) {
                if (target < nums[mid]) {
                    end = mid - 1;
                } else if (target > nums[mid]) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            } else {
                if (target > nums[mid]) {
                    end = mid - 1;
                } else if (target < nums[mid]) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }
}
