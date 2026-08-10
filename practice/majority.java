//this code works only for few inputs it is not worked for -ve inputs and large numbers like 1000 1000 1000 etc. so this approach is wrong.

public class majority {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 3 };
        // int n = nums.length;
        int[] freq = new int[256];
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int num : nums) {
            freq[num]++;
        }

        for (int i = 0; i < 256; i++) {
            if (freq[i] > max) {
                max = freq[i];
                index = i;
            }
        }
        System.out.println(max);
        System.out.println("majority element is : " + index);
    }
}
