
// package combinations;
import java.util.*;

public class combination {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        int k = 2;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        combinations(arr, result, current, 0, k);
        System.out.println(result);
    }

    static void combinations(int[] arr, List<List<Integer>> result, List<Integer> current, int start, int k) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            current.add(arr[i]);
            combinations(arr, result, current, i + 1, k);
            current.remove(current.size() - 1);
        }
    }
}
