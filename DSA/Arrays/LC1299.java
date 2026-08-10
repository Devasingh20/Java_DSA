import java.util.Arrays;

public class LC1299 {
    public static void main(String[] args) {
        int[] arr = { 17, 18, 5, 4, 6, 1 };
        int n = arr.length;
        int[] ans = new int[n];
        int max = Integer.MIN_VALUE;
        // for (int i = 0; i < n; i++) {
        // for (int j = i + 1; j < n; j++) {
        // if (arr[j] > max) {
        // max = arr[j];
        // }
        // }
        // ans[i] = max;
        // max = Integer.MIN_VALUE;
        // }
        // ans[n - 1] = -1;
        // System.out.println(Arrays.toString(ans));

        // solution with o(n) complexity
        for (int i = arr.length - 1; i >= 0; i--) {
            ans[i] = max;
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        ans[n - 1] = -1;
        System.out.println(Arrays.toString(ans));
    }
}
