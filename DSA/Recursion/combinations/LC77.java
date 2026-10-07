
//https://leetcode.com/problems/combinations/description/
import java.util.*;

public class LC77 {

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        combinations(result, current, 1, k, n);
        System.out.println(result);
    }

    static void combinations(List<List<Integer>> result, List<Integer> current, int start, int k, int n) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        int need = k - current.size();
        for (int i = start; i <= n - need + 1; i++) {
            current.add(i);
            combinations(result, current, i + 1, k, n);
            current.remove(current.size() - 1);
        }
    }
}
