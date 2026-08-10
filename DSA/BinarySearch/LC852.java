//https://leetcode.com/problems/peak-index-in-a-mountain-array/submissions/2101934606/?envType=problem-list-v2&envId=array
public class LC852 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 5, 6, 8, 10, 12, 4, 3, 2 };
        int ans = binarySearch(nums);
        System.out.println(ans);
    }

    static int binarySearch(int[] nums) {
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
}
