//https://leetcode.com/problems/first-missing-positive/
public class LC41 {
    public static void main(String[] args) {
        // int[] nums = { 3, 4, -1, 1 };
        int[] nums = { 7, 8, 9, 11, 12 };
        int n = nums.length;
        int ans = firstMissing(nums, n);
        System.out.println(ans);
    }

    static int firstMissing(int[] nums, int n) {
        int i = 0;
        while (i < n) {
            int correctIndex = nums[i] - 1;
            if (nums[i] > 0 && nums[i] < n && nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }
        for (int index = 0; index < n; index++) {
            if (nums[index] != index + 1) {
                return index + 1;
            }
        }
        return n + 1;
    }
}
