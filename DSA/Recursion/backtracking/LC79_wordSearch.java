public class LC79_wordSearch {
    public static void main(String[] args) {
        char[][] board = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };

        String word = "ABCCED";
        System.out.println(exists(board, word));
    }

    static boolean exists(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (allPath(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static boolean allPath(char[][] board, int row, int col, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        if (board[row][col] == '#' || board[row][col] != word.charAt(index)) {
            return false;
        }
        char original = board[row][col];
        board[row][col] = '#';
        boolean found = allPath(board, row + 1, col, word, index + 1) ||
                allPath(board, row, col + 1, word, index + 1) ||
                allPath(board, row - 1, col, word, index + 1) ||
                allPath(board, row, col - 1, word, index + 1);
        board[row][col] = original;
        return found;
    }
}
