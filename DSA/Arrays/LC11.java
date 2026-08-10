
public class LC11 {
    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        // int[] height = { 1, 1 };
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int area;
        int maxArea = 0;
        while (left < right) {
            area = Math.min(height[left], height[right]) * (right - left);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            maxArea = Math.max(area, maxArea);
        }
        System.out.println(maxArea);
    }
}
