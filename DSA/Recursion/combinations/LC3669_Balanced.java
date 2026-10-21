import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC3669_Balanced {
    public static void main(String[] args) {
        int n = 44;
        int k = 3;
        List<Integer> list = new ArrayList<>();

        // Generate divisors
        for (int i = 1; i <= n / i; i++) {
            if (n % i == 0) {
                list.add(i);

                if (i != n / i) {
                    list.add(n / i);
                }
            }
        }

        Collections.sort(list);

        List<Integer> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        int[] minDiff = { Integer.MAX_VALUE };

        combinationSum(list, result, current, 0, n, k, minDiff);

        System.out.println(result);
    }

    static void combinationSum(
            List<Integer> list,
            List<Integer> result,
            List<Integer> current,
            int start,
            int n,
            int k,
            int[] minDiff) {

        if (current.size() == k) {
            if (n == 1) {
                int diff = current.get(k - 1) - current.get(0);

                if (diff < minDiff[0]) {
                    minDiff[0] = diff;
                    result.clear();
                    result.addAll(current);
                }
            }
            return;
        }

        for (int i = start; i < list.size(); i++) {
            int factor = list.get(i);
            // Factors are sorted, so this branch cannot improve
            // the best difference if its minimum is already too large.
            if (!current.isEmpty() && factor - current.get(0) >= minDiff[0]) {
                break;
            }
            if (n % factor == 0) {
                current.add(factor);
                combinationSum(list, result, current, i, n / factor, k, minDiff);
                current.remove(current.size() - 1);
            }
        }
    }
}
