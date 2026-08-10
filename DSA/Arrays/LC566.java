
public class LC566 {
    public static void main(String[] args) {
        // int[][] mat = {
        //         { 1, 2 },
        //         { 3, 4 },
        //         { 5, 6 },
        //         { 7, 8 }
        // };
        // int r = 1;
        // int c = 8;
         int[][] mat = {
                { 1, 2 },
                { 3, 4 }
        };
        int r = 1;
        int c = 4;
        int m = mat.length;
        int n = mat[0].length;
        int[][] ans = new int[r][c];
        if (m * n != r * c) {
            System.out.println("Reshape not possible");
            return;
        }
        for (int i = 0; i < m * n; i++) {
            ans[i / c][i % c] = mat[i / n][i % n];
        }
        System.out.println("Reshaped Matrix:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
