//https://leetcode.com/problems/permutations-ii/

import java.util.*;

public class LC47 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, 2 };
        Arrays.sort(arr);
        List<Integer> p = new ArrayList<>();
        List<Integer> up = new ArrayList<>();
        for (int num : arr) {
            up.add(num);
        }
        List<List<Integer>> result = new ArrayList<>();
        permuteUnique(p, up, result);
        System.out.println(result);
    }

    static void permuteUnique(List<Integer> p, List<Integer> up, List<List<Integer>> result) {
        if (up.isEmpty()) {
            result.add(new ArrayList<>(p));
            return;
        }
        for (int i = 0; i < up.size(); i++) {
            if (i > 0 && up.get(i).equals(up.get(i - 1))) {
                continue;
            }
            int num = up.get(i);
            p.add(num);
            up.remove(i);
            // explore
            permuteUnique(p, up, result);
            // backtrack
            up.add(i, num);
            p.remove(p.size() - 1);
        }
    }
}
