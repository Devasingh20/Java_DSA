
import java.util.ArrayList;

public class printMazePath {
    public static void main(String[] args) {
        path("", 3, 3);
        System.out.println(pathAsList("", 3, 3));
        // include diagonal moves
        System.out.println(pathDiagonal("", 3, 3));
        // with obstacle: 1 means obstacle
        int[][] maze = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 0 }
        };
        pathRestriction("", maze, 0, 0);
    }

    static void path(String p, int row, int column) {
        if (row == 1 && column == 1) {
            System.out.println(p);
            return;
        }
        if (row > 1) {
            path(p + 'D', row - 1, column);
        }
        if (column > 1) {
            path(p + 'R', row, column - 1);
        }
    }

    static ArrayList<String> pathAsList(String p, int row, int column) {
        if (row == 1 && column == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        if (row > 1) {
            ans.addAll(pathAsList(p + 'D', row - 1, column));
        }
        if (column > 1) {
            ans.addAll(pathAsList(p + 'R', row, column - 1));
        }
        return ans;
    }

    // include diagonal moves
    // D -> diagonal, H -> horizontal(right), V -> vertical(down)
    static ArrayList<String> pathDiagonal(String p, int row, int column) {
        if (row == 1 && column == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        if (row > 1) {
            ans.addAll(pathDiagonal(p + 'V', row - 1, column));
        }
        if (column > 1) {
            ans.addAll(pathDiagonal(p + 'H', row, column - 1));
        }
        if (row > 1 && column > 1) {
            ans.addAll(pathDiagonal(p + 'D', row - 1, column - 1));
        }
        return ans;
    }

    // with obstacle
    static void pathRestriction(String p, int[][] maze, int row, int column) {
        if (row == maze.length - 1 && column == maze[0].length - 1) {
            System.out.println(p);
            return;
        }
        if (maze[row][column] == 1) {
            return;
        }
        if (row < maze.length - 1) {
            pathRestriction(p + 'V', maze, row + 1, column);
        }
        if (column < maze[0].length - 1) {
            pathRestriction(p + 'H', maze, row, column + 1);
        }
    }

}
