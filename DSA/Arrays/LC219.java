import java.util.*;

public class LC219 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        int n = nums.length;
        int k = 3;
        Set<Integer> window = new HashSet<>();
        boolean ans = duplicate(nums, n, k, window);
        System.out.println(ans);
    }

    static boolean duplicate(int[] nums, int n, int k, Set<Integer> window) {
        for (int i = 0; i < n; i++) {
            if (i > k) {
                window.remove(nums[i - k - 1]);
            }
            if (!window.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
