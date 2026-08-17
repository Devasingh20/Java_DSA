// package DSA.maths_for_dsa;

public class primeNumber {
    public static void main(String[] args) {
        // int num = 1;
        // int num = 40;
        int num = 13;
        boolean ans = isPrime(num);
        System.out.println(ans);
    }

    static boolean isPrime(int num) {
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
