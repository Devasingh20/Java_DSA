//https://www.geeksforgeeks.org/dsa/find-position-element-sorted-array-infinite-numbers/
// the array is actually infinite we just take a finite array as an example.
// the instruction is we don't allow to use arr.length method.
public class InfiniteArray {
    public static void main(String[] args) {
        int[] nums = { 2, 8, 10, 11, 12, 15, 18, 29, 30, 56, 60, 65 };
        int target = 12;
        int start = 0;
        int end = 1;
        int ans = findRange(nums, target, start, end);
        System.out.println(ans);
    }

    static int findRange(int[] nums, int target, int start, int end) {
        while (target > nums[end]) {
            int newStart = end + 1;
            end = end + (end - start + 1) * 2;
            start = newStart;
        }
        return search(nums, target, start, end);
    }

    static int search(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
