
// package DSA.maths_for_dsa;
import java.util.Arrays;

public class sieveEratosthenes {
    public static void main(String[] args) {
        int n = 1000;
        sieve(n);
    }

    static void sieve(int n) {
        boolean[] isprime = new boolean[n + 1];
        Arrays.fill(isprime, true);
        isprime[0] = false;
        isprime[1] = false;
        int c = 2;
        while (c * c <= n) {
            if (isprime[c]) {
                for (int i = c * c; i <= n; i += c) {
                    isprime[i] = false;
                }
            }
            c++;
        }
        // print primes
        for (int i = 2; i <= n; i++) {
            if (isprime[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
