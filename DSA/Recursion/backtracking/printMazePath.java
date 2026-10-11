public class printMazePath {
    public static void main(String[] args) {
        path("", 3, 3);
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

}
