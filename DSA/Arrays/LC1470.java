import java.util.Arrays;
public class LC1470 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 4, 3, 2, 1 };
        int n = 4;
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[2 * i] = nums[i];
            ans[2 * i + 1] = nums[i + n];
        }
        System.out.println(Arrays.toString(ans));
    }
}
