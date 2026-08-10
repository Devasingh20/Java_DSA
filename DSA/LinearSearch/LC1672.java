//https://leetcode.com/problems/richest-customer-wealth/description/
public class LC1672 {
    public static void main(String[] args) {
        int[][] nums = {
                { 2, 8, 7 },
                { 7, 1, 3 },
                { 1, 9, 5 }
        };
        int max = 0;
        for (int row = 0; row < nums.length; row++) {
            int rowsum = 0;
            for (int col = 0; col < nums[row].length; col++) {
                rowsum += nums[row][col];
            }
            max = Math.max(rowsum, max);
        }
        System.out.println("The maximum wealth is: " + max);
    }
}
