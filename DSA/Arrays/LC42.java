//This code uses O(n) space complexity.
// public class LC42 {
//     public static void main(String[] args) {
//         int[] height = { 4, 2, 0, 3, 2, 5 };
//         int n = height.length;
//         int[] leftMax = new int[n];
//         int[] rightMax = new int[n];

//         leftMax[0] = height[0];
//         for (int i = 1; i < n; i++) {
//             leftMax[i] = Math.max(leftMax[i - 1], height[i]);
//         }

//         rightMax[n - 1] = height[n - 1];
//         for (int i = n - 2; i >= 0; i--) {
//             rightMax[i] = Math.max(rightMax[i + 1], height[i]);
//         }

//         int totalWater = 0;
//         for (int x = 0; x < n; x++) {
//             totalWater += Math.min(leftMax[x], rightMax[x]) - height[x];
//         }

//         System.out.println(totalWater);
//     }
// }

//this code uses O(1) space complexity.
public class LC42 {
    public static void main(String[] args) {
        int[] height = { 4, 2, 0, 3, 2, 5 };
        int n = height.length;
        int leftMax = 0;
        int rightMax = 0;
        int totalWater = 0;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                totalWater += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                totalWater += rightMax - height[right];
                right--;
            }
        }

        System.out.println(totalWater);
    }
}