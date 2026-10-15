public class kNights {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(nights(board, 0, 0, 4));
    }

    static int nights(boolean[][] board, int row, int col, int knight) {
        if (knight == 0) {
            display(board);
            System.out.println();
            return 1;
        }
        // check whether the row is out of boubd
        if (row == board.length) {
            return 0;
        }
        // check whether the column is out of bound then try next row
        if (col == board.length) {
            return nights(board, row + 1, 0, knight);
        }
        int count = 0;
        if (isSafe(board, row, col)) {
            board[row][col] = true;
            count += nights(board, row, col + 1, knight - 1);
            board[row][col] = false;
        }
        count += nights(board, row, col + 1, knight);
        return count;
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
        if (isValid(board, row - 2, col + 1)) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }
        if (isValid(board, row - 2, col - 1)) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }
        if (isValid(board, row - 1, col + 2)) {
            if (board[row - 1][col + 2]) {
                return false;
            }
        }
        if (isValid(board, row - 1, col - 2)) {
            if (board[row - 1][col - 2]) {
                return false;
            }
        }
        return true;
    }

    static boolean isValid(boolean[][] board, int row, int col) {
        // if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
        // return true;
        // }
        // return false;
        return row >= 0 && row < board.length && col >= 0 && col < board.length;
    }

    static void display(boolean[][] board) {
        for (boolean[] arr : board) {
            for (boolean element : arr) {
                if (element) {
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
