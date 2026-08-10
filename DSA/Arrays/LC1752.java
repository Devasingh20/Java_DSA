import java.util.Arrays;

public class LC1752 {
    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 1, 2 };
        int n = nums.length;
        int[] ans = new int[n];
        int index = 0;
        boolean isSorted = false;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                index = i + 1;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            ans[i] = nums[(i + index) % n];
        }

        for (int i = 0; i < n - 1; i++) {
            if (ans[i] > ans[i + 1]) {
                isSorted = false;
                break;
            } else {
                isSorted = true;
            }
        }
        System.out.println(index);
        System.out.println(Arrays.toString(ans));
        System.out.println("isSorted : " + isSorted);
    }
}
