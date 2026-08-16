// package DSA.maths_for_dsa;
//sqrt without using Math.sqrt method, but using Binary search.
public class squareRoot {
    public static void main(String[] args) {
        int num = 259;
        int p = 3;
        System.out.println(sqrt(num, p));

    }

    static double sqrt(int num, int p) {
        int start = 0;
        int end = num;
        double root = 0.0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((long) mid * mid <= num) {
                root = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        double incr = 0.1;
        for (int i = 0; i < p; i++) {
            while (root * root <= num) {
                root += incr;
            }
            root -= incr;
            incr /= 10;
        }
        return root;
    }
}
