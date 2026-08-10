import java.util.Arrays;

public class suffix_max {
    public static void main(String[] args) {
        int[] nums = { 3, 1, 4, 2, 5 };
        int n = nums.length;
        int[] suffix = new int[n];
        suffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], nums[i]);
        }
        System.out.println(Arrays.toString(suffix));
    }
}


// class Solution {

//     public int trap(int[] height) {

//         int left = 0;
//         int right = height.length - 1;

//         int leftMax = 0;
//         int rightMax = 0;

//         int totalWater = 0;

//         while (left < right) {

//             if (height[left] < height[right]) {

//                 leftMax = Math.max(leftMax, height[left]);
//                 totalWater += leftMax - height[left];
//                 left++;

//             } else {

//                 rightMax = Math.max(rightMax, height[right]);
//                 totalWater += rightMax - height[right];
//                 right--;

//             }
//         }

//         return totalWater;
//     }
// }