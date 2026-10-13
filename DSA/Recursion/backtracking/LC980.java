public class LC980 {
    public static void main(String[] args) {
        int[][] grid = {
                { 1, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 2, -1 }
        };
        int totalCells = 0;
        int startRow = 0;
        int startCol = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] != -1) {
                    totalCells++;
                }
                if (grid[r][c] == 1) {
                    startRow = r;
                    startCol = c;
                }
            }
        }
        int count = allPath(grid, startRow, startCol, 1, totalCells);
        System.out.println(count);
    }

    static int allPath(int[][] grid, int row, int column, int steps,
            int totalCells) {
        if (grid[row][column] == -1) {
            return 0;
        }
        if (grid[row][column] == 2) {
            if (steps == totalCells) {
                return 1;
            } else {
                return 0;
            }

        }
        int original = grid[row][column];
        grid[row][column] = -1;
        int count = 0;
        if (row < grid.length - 1) {
            count += allPath(grid, row + 1, column, steps + 1, totalCells);
        }
        if (column < grid[0].length - 1) {
            count += allPath(grid, row, column + 1, steps + 1, totalCells);
        }
        if (row > 0) {
            count += allPath(grid, row - 1, column, steps + 1, totalCells);
        }
        if (column > 0) {
            count += allPath(grid, row, column - 1, steps + 1, totalCells);
        }
        grid[row][column] = original;
        return count;
    }
}
