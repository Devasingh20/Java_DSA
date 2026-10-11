// package DSA.Recursion.backtracking;

public class mazePath {
    public static void main(String[] args) {
        System.out.println(count(3, 3));
    }

    static int count(int row, int column) {
        if (row == 1 || column == 1) {
            return 1;
        }
        int left = count(row - 1, column);
        int right = count(row, column - 1);
        return left + right;
    }
}
