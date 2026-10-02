import java.util.*;

public class LC78 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        List<List<Integer>> ans = subSets(arr);
        System.out.println(ans);
    }

    static List<List<Integer>> subSets(int[] arrr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int num : arrr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }
}
