import java.util.Arrays;

public class printAllMazePaths {
    public static void main(String[] args) {
        boolean[][] maze = {
                { true, true, true },
                { true, true, true },
                { true, true, true }
        };
        int[][] path = new int[maze.length][maze[0].length];
        allPath("", maze, path, 0, 0, 1);
    }

    static void allPath(String p, boolean[][] maze, int[][] path, int row, int column, int steps) {
        if (row == maze.length - 1 && column == maze[0].length - 1) {
            path[row][column] = steps;
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if (!maze[row][column]) {
            return;
        }
        maze[row][column] = false;
        path[row][column] = steps;
        if (row < maze.length - 1) {
            allPath(p + 'D', maze, path, row + 1, column, steps + 1);
        }
        if (column < maze[0].length - 1) {
            allPath(p + 'R', maze, path, row, column + 1, steps + 1);
        }
        if (row > 0) {
            allPath(p + 'U', maze, path, row - 1, column, steps + 1);
        }
        if (column > 0) {
            allPath(p + 'L', maze, path, row, column - 1, steps + 1);
        }
        maze[row][column] = true;
        path[row][column] = 0;
    }
}
