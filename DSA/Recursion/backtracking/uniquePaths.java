import java.util.Arrays;

public class uniquePaths {
    public static void main(String[] args) {
        int[][] grid = {
                { 1, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 2, -1 }
        };
        int[][] path = new int[grid.length][grid[0].length];
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
        int count = allPath("", path, grid, startRow, startCol, 1, totalCells);
        System.out.println(count);
    }

    static int allPath(String p, int[][] path, int[][] grid, int row, int column, int steps,
            int totalCells) {
        if (grid[row][column] == -1) {
            return 0;
        }
        if (grid[row][column] == 2) {
            if (steps == totalCells) {
                path[row][column] = steps;
                for (int[] arr : path) {
                    System.out.println(Arrays.toString(arr));
                }
                System.out.println(p);
                System.out.println();
                return 1;
            } else {
                return 0;
            }

        }
        int count = 0;
        int original = grid[row][column];
        grid[row][column] = -1;
        path[row][column] = steps;
        if (row < grid.length - 1) {
            count += allPath(p + 'D', path, grid, row + 1, column, steps + 1, totalCells);
        }
        if (column < grid[0].length - 1) {
            count += allPath(p + 'R', path, grid, row, column + 1, steps + 1, totalCells);
        }
        if (row > 0) {
            count += allPath(p + 'U', path, grid, row - 1, column, steps + 1, totalCells);
        }
        if (column > 0) {
            count += allPath(p + 'L', path, grid, row, column - 1, steps + 1, totalCells);
        }
        grid[row][column] = original;
        path[row][column] = 0;
        return count;
    }
}
// acc. to this also explain why we use int original instead of boolean mazeIn
// the provided code snippet, we are dealing with a grid that contains different
// types of cells: empty cells (represented by 0), starting cell (represented by
// 1), ending cell (represented by 2), and obstacle cells (represented by -1).
// The goal is to find all unique paths from the starting cell to the ending
// cell while avoiding obstacles.
// In the provided code snippet, we use an `int original` variable instead of a
// boolean `maze` because the grid contains multiple types of cells, not just
// passable and impassable cells. Specifically, the grid can have:
// 1. Empty cells (0) - These are passable cells where the path can continue.
// 2. Starting cell (1) - This is the starting point of the path.
// 3. Ending cell (2) - This is the destination point of the path.
// 4. Obstacle cells (-1) - These are impassable cells that the path cannot go
// through.
// When we traverse the grid, we need to temporarily mark cells as visited to
// avoid revisiting them during the current path exploration. In this case, we
// set the cell to -1 (indicating it is now an obstacle) to mark it as visited.
// However, since the grid contains different types of cells, we need to
// remember the original value of the cell before marking it as visited. This is
// where `int original` comes into play.
// The `int original` variable stores the original value of the cell (which
// could be 0, 1, or 2) before we mark it as -1. After we finish exploring all
// possible paths from that cell, we restore the cell's original value using
// `grid[row][column] = original;`. This ensures that the grid remains unchanged
// for other paths that may pass through this cell later in the recursion.
