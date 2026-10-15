import java.util.ArrayList;
import java.util.List;

public class LC51 {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        List<List<String>> ans = new ArrayList<>();
        queens(board, 0, ans);
        System.out.println(ans);
    }

    static void queens(boolean[][] board, int row,
            List<List<String>> ans) {
        // Base case: all queens have been placed
        if (row == board.length) {
            ans.add(display(board));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                // Choose
                board[row][col] = true;
                // Explore the next row
                queens(board, row + 1, ans);
                // Backtrack: undo the choice
                board[row][col] = false;
            }
        }
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
        // Check vertically upward
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }
        // Check left diagonal upward
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }
        // Check right diagonal upward
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }

        return true;
    }

    static List<String> display(boolean[][] board) {
        List<String> result = new ArrayList<>();
        for (boolean[] arr : board) {
            StringBuilder row = new StringBuilder();
            for (boolean element : arr) {
                if (element) {
                    row.append('Q');
                } else {
                    row.append('.');
                }
            }
            result.add(row.toString());
        }
        return result;
    }
}
