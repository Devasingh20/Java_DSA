//Use this method when question says ==> You must write an algorithm that runs in O(n) time and uses only constant auxiliary space, excluding the space needed to store the output

import java.util.ArrayList;
import java.util.List;

public class LC442 {
    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] > 0) {
                nums[index] = nums[index] * -1;
            } else {
                ans.add(Math.abs(nums[i]));
            }
        }
        System.out.println(ans);
    }
}

//Complexity
// Time O(n) Space O(n) Advantages ✅ Very easy to understand. ✅ Easy to code. ✅ No modification of input array. Disadvantages ==> Needs extra memory.
// public class LC442 {
//     public static void main(String[] args) {
//         int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
//         List<Integer> ans = new ArrayList<>();
//         int[] freq = new int[nums.length + 1];
//         for (int i = 0; i < nums.length; i++) {
//             freq[nums[i]]++;
//             if (freq[nums[i]] == 2) {
//                 ans.add(nums[i]);
//             }
//         }
//         System.out.println(ans);
//     }
// }