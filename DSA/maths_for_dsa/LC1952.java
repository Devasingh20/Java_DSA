//https://leetcode.com/problems/three-divisors/
public class LC1952 {
    public static void main(String[] args) {
        // int n = 14;
        int n = 121;
        int num = (int) Math.sqrt(n);
        System.out.println((long) num * num == n ? isprime(num) : false);
    }

    static boolean isprime(int num) {
        int c = 2;
        if (num <= 1) {
            return false;
        }
        while (c * c <= num) {
            if (num % c == 0) {
                return false;
            }
            c++;
        }
        return true;
    }
}
