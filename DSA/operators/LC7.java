// package DSA.operators;

public class LC7 {
    public static void main(String[] args) {
        int num = 214748364;
        int reverse = 0;
        while (num != 0) {
            int digit = num % 10;
            if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && digit > 7)) {
                System.out.println("Reverse is not possible");
            }
            if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && digit < -8)) {
                System.out.println("Reverse is not possible");
            }
            reverse = reverse * 10 + digit;
            num = num / 10;
        }
        System.out.println(reverse);
    }
}
