import java.util.ArrayList;

//https://leetcode.com/problems/the-kth-factor-of-n/
public class Kth_Factor {
    public static void main(String[] args) {
        int n = 12;
        // int k = 3;
        int k = 6;
        System.out.println(kthFactor(n, k));
    }

    static int kthFactor(int n, int k) {
        ArrayList<Integer> small = new ArrayList<>();
        ArrayList<Integer> large = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                small.add(i);
                if (i != n / i) {
                    large.add(n/i);
                }
            }
        }
        if (k <= small.size()) {
            return small.get(k - 1);
        }
        k = k - small.size();
        if (k <= large.size()) {
            return large.get(large.size() - k);
        }
        return -1;
    }
}
