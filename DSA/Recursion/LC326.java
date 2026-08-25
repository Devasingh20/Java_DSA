public class LC326 {
    public static void main(String[] args) {
        int n = 729;
        System.out.println(isPowerOfTwo(n));
    }

    static boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        }
        if (n <= 0) {
            return false;
        }
        // int m = n / 3;
        // if (m + m == n) {
        // isPowerOfTwo(n / 3);
        // }
        // essentially we are checking->can i divide this number the base exactly.that
        // is why we can also use % operator as below.
        if (n % 3 == 0) {
            return isPowerOfTwo(n / 3);
        }
        return false;
    }
}
