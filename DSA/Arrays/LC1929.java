import java.util.Arrays;

public class LC1929 {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 2, 1 };
        int n = nums.length;
        int[] ans = new int[n << 1];
        for (int i = 0; i < (n << 1); i++) {
            ans[i] = nums[i % n];
        }
        System.out.println(Arrays.toString(ans));
    }
}
