//https://leetcode.com/problems/ugly-number/
public class LC263 {
    public static void main(String[] args) {
        // int n = 14;
        int n = 6;
        if (n <= 0) {
            System.out.println(false);
        }
        while (n % 2 == 0) {
            n = n / 2;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        while (n % 5 == 0) {
            n = n / 5;
        }
        System.out.println(n == 1);
    }
}
