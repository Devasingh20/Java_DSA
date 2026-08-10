import java.util.Arrays;

public class LC1365 {
    public static void main(String[] args) {
        // int[] nums = { 6, 5, 4, 8 };
        // int[] ans = new int[nums.length];
        // for (int i = 0; i < nums.length; i++) {
        // int count = 0;
        // for (int j = 0; j < nums.length; j++) {
        // if (nums[j] < nums[i]) {
        // count++;
        // }
        // }
        // ans[i] = count;
        // }
        // System.out.println(Arrays.toString(ans));

        // optimal solution with time complexity o(n)
        int[] nums = { 6, 5, 4, 8 };
        int n = nums.length;
        int[] ans = new int[n];
        int[] freq = new int[101];

        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }

        for (int i = 1; i < freq.length; i++) {
            freq[i] = freq[i] + freq[i - 1];
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                ans[i] = 0;
            } else {
                ans[i] = freq[nums[i] - 1];
            }
        }
        System.out.println(Arrays.toString(ans));
    }
}
