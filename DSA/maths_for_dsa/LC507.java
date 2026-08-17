//https://leetcode.com/problems/perfect-number/
public class LC507 {
    public static void main(String[] args) {
        int num = 28;
        // int num = 7;
        boolean ans = checkPerfectNumber(num);
        System.out.println(ans);
    }

    static boolean checkPerfectNumber(int num) {
        int perfect = 1;
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                perfect += i;
                if (i != num / i) {
                    perfect += num / i;
                }
            }
        }
        return perfect == num;
    }
}
