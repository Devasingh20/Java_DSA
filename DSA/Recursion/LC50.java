//https://leetcode.com/problems/powx-n/
// public class LC50 {
//     public static void main(String[] args) {
//         double x = 2.1;
//         int n = -10;
//         double m = x;

//         System.out.println(pow(1, (long) n, m));
//     }

//     static double pow(double num, long n, double m) {

//         if (n == 0) {
//             return num;
//         }

//         if (n > 0) {
//             return pow(num * m, n - 1, m);
//         }

//         return pow(num * (1 / m), n + 1, m);
//     }
// }

// This recursive approach works for small values of n,
// but fails for very large values such as -200 million
// because it makes O(|n|) recursive calls and causes StackOverflowError
//that is why we need an efficient solution like below-----

public class LC50 {
    public static void main(String[] args) {
        double x = 2;
        int n = 10;
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        System.out.println(pow(x, N));
    }

    static double pow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double half = pow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        }
        return half * half * x;
    }
}