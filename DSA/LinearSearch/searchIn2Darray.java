// package DSA.LinearSearch;

public class searchIn2Darray {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9, 15 },
                { 10, 11, 12 }
        };
        int target = 12;
        int[] ans = search(arr, target);
        if (ans[0] == -1) {
            System.out.println("Target not found in the 2D array.");
        } else {
            System.out.println("Target found at row: " + ans[0] + ", column: " + ans[1]);
        }
    }

    static int[] search(int[][] arr, int target) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == target) {
                    return new int[] { row, col };
                }
            }
        }
        return new int[] { -1, -1 };
    }
}
