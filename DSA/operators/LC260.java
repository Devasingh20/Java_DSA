public class LC260 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 3, 2, 5 };
        int xor = 0;
        for (int num : nums) {
            xor = xor ^ num;
        }
        int mask = xor & -xor;
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                a = a ^ num;
            } else {
                b = b ^ num;
            }
        }
        System.out.println(a + " " + b);
    }
}
