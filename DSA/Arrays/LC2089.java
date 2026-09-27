
//https://leetcode.com/problems/find-target-indices-after-sorting-array/
import java.util.*;

public class LC2089 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 5, 2, 3 };
        int target = 2;
        List<Integer> list = new ArrayList<>();
        System.out.println(targetIndices(arr, target, list));
    }

    static List<Integer> targetIndices(int[] arr, int targer, List<Integer> list) {
        int count = 0;
        int leastCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < targer) {
                leastCount++;
            }
            if (arr[i] == targer) {
                count++;
            }
        }
        while (count-- > 0) {
            list.add(leastCount++);
        }
        return list;
    }
}

// Why sorting is not required in LC 2089
// The problem asks for the indices that the target would have after the array
// is sorted, not for the sorted array itself.
// The important property is:
// After sorting, every element smaller than the target must appear before the
// target, and every element equal to the target occupies consecutive positions.
// Therefore, we only need two pieces of information:

// Count elements smaller than the target
// This tells us the first index where the target will appear.

// Count elements equal to the target
// This tells us how many consecutive positions the target will occupy.

// For example:
// Array: [1, 2, 5, 2, 3]
// Target: 2
// There is:
// 1 element < 2
// 2 elements = 2
// Therefore, after sorting:
// [1, 2, 2, 3, 5]
// ↑ ↑
// 1 2
// So the target indices are:
// [1, 2]