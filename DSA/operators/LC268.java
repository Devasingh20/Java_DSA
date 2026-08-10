public class LC268 {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 3 };
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = ans ^ i;
            ans = ans ^ nums[i];
        }
        ans = ans ^ n;
        System.out.println(ans);
    }
}
