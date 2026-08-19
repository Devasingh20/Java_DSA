//https://leetcode.com/problems/ugly-number-ii/description/
public class LC264 {
    public static void main(String[] args) {
        int n = 9;
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        while (index < n) {
            int next2 = ugly[i2] * 2;
            int next3 = ugly[i3] * 3;
            int next5 = ugly[i5] * 5;
            int next = Math.min(Math.min(next2, next3), next5);
            ugly[index] = next;
            index++;
            if (next == next2) {
                i2++;
            }
            if (next == next3) {
                i3++;
            }
            if (next == next5) {
                i5++;
            }
        }
        System.out.println(ugly[n - 1]);
    }
}
