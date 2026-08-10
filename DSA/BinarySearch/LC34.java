
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
//for time complexity O(logn)
import java.util.Arrays;

public class LC34 {
    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        int[] ans = { -1, -1 };
        // int[] ans = new int[2];
        int start = searchRange(nums, target, true);
        int end = searchRange(nums, target, false);
        ans[0] = start;
        ans[1] = end;
        System.out.println(Arrays.toString(ans));
    }

    static int searchRange(int[] nums, int target, boolean findFirstIndex) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                ans = mid;
                if (findFirstIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}

// for time complexity O(n)
// class Solution {
// public int[] searchRange(int[] nums, int target) {

// int start = 0;
// int end = nums.length - 1;

// int[] ans = {-1, -1};

// boolean starting = false;
// boolean ending = false;

// while (start <= end) {

// // Find first occurrence
// if (!starting) {

// if (nums[start] == target) {
// ans[0] = start;
// starting = true;
// } else {
// start++;
// }
// }

// // Find last occurrence
// if (!ending) {

// if (nums[end] == target) {
// ans[1] = end;
// ending = true;
// } else {
// end--;
// }
// }

// // Both found
// if (starting && ending) {
// return ans;
// }
// }

// return ans;
// }
// }