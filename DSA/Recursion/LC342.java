//https://leetcode.com/problems/power-of-four/
public class LC342 {
    public static void main(String[] args) {
        int n = 16;
        System.out.println(isPowerOfFour(n));
    }

    static boolean isPowerOfFour(int n) {
        if (n == 1) {
            return true;
        }
        if (n <= 0) {
            return false;
        }
        // int m = n / 4;
        // if (m + m == n) {
        // isPowerOfTwo(n / 4);
        // }
        // essentially we are checking->can i divide this number the base exactly.that
        // is why we can also use % operator as below.
        if (n % 4 == 0) {
            return isPowerOfFour(n / 4);
        }
        return false;
    }
}
