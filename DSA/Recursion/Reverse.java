public class Reverse {
    public static void main(String[] args) {
        int n = 123456789;
        reverse(n);
        System.out.println(rev);
    }

    static int rev = 0;

    static void reverse(int n) {
        if (n == 0) {
            return;
        }
        int digit = n % 10;
        rev = rev * 10 + digit;
        reverse(n / 10);
    }

}
