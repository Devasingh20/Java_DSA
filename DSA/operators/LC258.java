// package DSA.operators;

public class LC258 {
    public static void main(String[] args) {
        int num = 14329756;
        int sum;
        while (num >= 10) {
            sum = 0;
            while (num > 0) {
                sum = sum + num % 10;
                num = num / 10;
            }
            num = sum;
        }
        System.out.println(num);
    }
}
