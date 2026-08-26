///https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
public class LC1342 {
    public static void main(String[] args) {
        int count = 0;
        // int num = 14;
        int num = 123;
        if (num == 0) {
            System.out.println(0);
        }
        System.out.println(steps(num, count));
    }

    static int steps(int num, int count) {
        if (num == 0) {
            return count;
        }
        if (num % 2 == 0) {
            return steps(num / 2, count + 1);
        }
        return steps(num - 1, count + 1);

    }
}
