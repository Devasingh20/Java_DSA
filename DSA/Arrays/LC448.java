
// here the time complexity is O(n) and the space complexity isO(n) this is not optimal solution because it uses extra space.
// import java.util.*;

// public class LC448 {
//     public static void main(String[] args) {
//         int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
//         HashSet<Integer> set = new HashSet<>();
//         for (int num : nums) {
//             set.add(num);
//         }

//         List<Integer> ans = new ArrayList<>();
//         for (int i = 1; i <= nums.length; i++) {
//             if (!set.contains(i)) {
//                 ans.add(i);
//             }
//         }
//         System.out.println(ans);
//     }
// }

//we use index marking method (optimal solution).
import java.util.ArrayList;
import java.util.List;

public class LC448 {
    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] > 0) {
                nums[index] = nums[index] * -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }
        System.out.println(ans);
    }
}