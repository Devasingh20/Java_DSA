//https://leetcode.com/problems/combination-sum/description/

import java.util.*;

public class LC36 {
    public static void main(String[] args) {
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        combinationSum(candidates, result, current, 0, target);
        System.out.println(result);
    }

    static void combinationSum(int[] candidates, List<List<Integer>> result, List<Integer> current, int start,
            int target) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            combinationSum(candidates, result, current, i, target - candidates[i]);
            current.remove(current.size() - 1);
        }
    }
}
