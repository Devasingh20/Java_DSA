public class LC169 {
    public static void main(String[] args) {
        int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
        int ans = 0;
        int count = 0;
        for (int num : nums) {

            if (count == 0) {
                ans = num;
            }

            if (num == ans) {
                count++;
            } else {
                count--;
            }
        }
        int freq = 0;
        for (int num : nums) {
            if (ans == num) {
                freq++;
            }
        }
        if (freq > nums.length / 2) {
            System.out.println("majority element is :" + ans);
        } else {
            System.out.println("not found!");
        }
    }
}
