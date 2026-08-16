// package DSA.maths_for_dsa;

public class primeNumber {
    public static void main(String[] args) {
        int num = 12;
        boolean ans = isPrime(num);
        System.out.println(ans);
    }

    static boolean isPrime(int num) {
        int c = 2;
        while (c * c <= num) {
            if (num <= 1) {
                return false;
            }

            if (num % c == 0) {
                return false;
            }
            c++;
        }
        return true;
    }
}
