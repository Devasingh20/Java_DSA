public class LC36_ValidSudoku {
    public static void main(String[] args) {
        int[][] board = {
                { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
                { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 }
        };
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != 0) {
                    if (!isSafe(board, row, col, board[row][col])) {
                        System.out.println("Invalid sudoku");
                    }
                }
            }
        }

        System.out.println("valid sudoku");
    }

    static boolean isSafe(int[][] board, int row, int col, int num) {

        // Check row
        for (int i = 0; i < board.length; i++) {
            if (i != col && board[row][i] == num) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < board.length; i++) {
            if (i != row && board[i][col] == num) {
                return false;
            }
        }

        // Check 3x3 box
        int sqrt = 3;
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for (int r = rowStart; r < rowStart + sqrt; r++) {
            for (int c = colStart; c < colStart + sqrt; c++) {
                if ((r != row || c != col) && board[r][c] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
