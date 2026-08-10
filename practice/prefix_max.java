import java.util.Arrays;

public class prefix_max {
    public static void main(String[] args) {
        int[] nums = { 3, 1, 4, 2, 5 };
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], nums[i]);
        }
        System.out.println(Arrays.toString(prefix));
    }
}
