public class LC2596 {
    public static void main(String[] args) {
        int[][] grid = {
                { 0, 11, 16, 5, 20 },
                { 17, 4, 19, 10, 15 },
                { 12, 1, 8, 21, 6 },
                { 3, 18, 23, 14, 9 },
                { 24, 13, 2, 7, 22 }
        };
        if (grid[0][0] != 0) {
            System.out.println(false);
        }
        System.out.println(knightTour(grid, 0, 0, 0));
    }

    static boolean knightTour(int[][] grid, int num, int row, int col) {
        int n = grid.length;
        if (row < 0 || col < 0 || row >= n || col >= n) {
            return false;
        }
        if (grid[row][col] != num)
            return false;
        if (num == n * n - 1)
            return true;
        // if (knightTour(grid, num + 1, row - 2, col + 1))
        // return true;
        // if (knightTour(grid, num + 1, row - 2, col - 1))
        // return true;
        // if (knightTour(grid, num + 1, row - 1, col + 2))
        // return true;
        // if (knightTour(grid, num + 1, row - 1, col - 2))
        // return true;
        // if (knightTour(grid, num + 1, row + 2, col + 1))
        // return true;
        // if (knightTour(grid, num + 1, row + 2, col - 1))
        // return true;
        // if (knightTour(grid, num + 1, row + 1, col + 2))
        // return true;
        // if (knightTour(grid, num + 1, row + 1, col - 2))
        // return true;
        // return false;
        return knightTour(grid, num + 1, row - 2, col + 1)
                || knightTour(grid, num + 1, row - 2, col - 1)
                || knightTour(grid, num + 1, row - 1, col + 2)
                || knightTour(grid, num + 1, row - 1, col - 2)
                || knightTour(grid, num + 1, row + 2, col + 1)
                || knightTour(grid, num + 1, row + 2, col - 1)
                || knightTour(grid, num + 1, row + 1, col + 2)
                || knightTour(grid, num + 1, row + 1, col - 2);
    }
}
