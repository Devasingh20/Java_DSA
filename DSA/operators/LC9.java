// package DSA.operators;

public class LC9 {
    public static void main(String[] args) {
        int num = 123454321;
        if (num < 0) {
            System.out.println("Not a palindrom!");
        }
        int original = num;
        int reverse = 0;
        while (num > 0) {
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num = num / 10;
        }
        if (reverse == original) {
            System.out.println("Is a palindrom");
        } else {
            System.out.println("Not a palindrom!");
        }
    }
}
