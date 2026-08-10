
public class LC136 {
    public static void main(String[] args) {
        int[] nums = { 4, 1, 2, 1, 2 };
        int ans = 0;
        for (int num : nums) {
            ans = ans ^ num;
        }
        System.out.println(ans);
    }
}