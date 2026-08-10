public class LC414 {
    public static void main(String[] args) {
        int[] nums = { -2147483648, 2147483647, 2, -2147483647 };
        int n = nums.length;
        long largest = Long.MIN_VALUE;
        long slargest = Long.MIN_VALUE;
        long tlargest = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] > largest) {
                tlargest = slargest;
                slargest = largest;
                largest = nums[i];
            } else if (nums[i] > slargest && nums[i] != largest) {
                tlargest = slargest;
                slargest = nums[i];
            } else if (nums[i] > tlargest && nums[i] != largest && nums[i] != slargest) {
                tlargest = nums[i];
            }
        }
        System.out.println(
                "The third largest number is : " + (tlargest == Long.MIN_VALUE ? (int) largest : (int) tlargest));
        System.out.println("---------------");
        System.out.println(Long.MIN_VALUE);
    }
}
