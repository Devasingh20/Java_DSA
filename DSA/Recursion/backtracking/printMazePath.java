
import java.util.ArrayList;

public class printMazePath {
    public static void main(String[] args) {
        path("", 3, 3);
        System.out.println(pathAsList("", 3, 3));
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

}
