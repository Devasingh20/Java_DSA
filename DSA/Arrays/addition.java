import java.util.*;

public class addition {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the number of rows : ");
            int rows = sc.nextInt();
            System.out.println("Enter the number of columns : ");
            int cols = sc.nextInt();
            int[][] matrixA = new int[rows][cols];
            int[][] matrixB = new int[rows][cols];
            int[][] sumMatrix = new int[rows][cols];

            System.out.println("Enter the elements of matrix A : ");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrixA[i][j] = sc.nextInt();
                }
            }

            System.out.println("Enter the elements of matrix B : ");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrixB[i][j] = sc.nextInt();
                }
            }

            // matrix addition
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    sumMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
                }
            }

            System.out.println("The sum of matrix A and B is : ");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(sumMatrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
