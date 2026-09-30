//https://leetcode.com/problems/koko-eating-bananas/description/
public class LC875 {
    public static void main(String[] args) {
        int[] arr = { 805306368, 805306368, 805306368 };
        int h = 1000000000;
        System.out.println(minEatingSpeed(arr, h));
    }

    static int minEatingSpeed(int[] arr, int h) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int start = 1;
        int end = max;
        int ans = max;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long steps = 0;
            for (int i = 0; i < arr.length; i++) {
                steps += (arr[i] + mid - 1) / mid;
            }
            if (steps <= h) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
