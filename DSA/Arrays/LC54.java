public class LC54 {
    public static void main(String[] args) {
        int[][] nums = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int top = 0;
        int bottom = nums.length - 1;

        int left = 0;
        int right = nums[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int col = left; col <= right; col++) {
                System.out.print(nums[top][col] + " ");
            }
            top++;
            for (int row = top; row <= bottom; row++) {
                System.out.print(nums[row][right] + " ");
            }
            right--;
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    System.out.print(nums[bottom][col] + " ");
                }
                bottom--;
            }
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    System.out.print(nums[row][left] + " ");
                }
                left++;
            }
        }
    }
}