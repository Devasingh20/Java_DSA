import java.util.*;

public class product {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the number of rows for matrix A : ");
            int r1 = sc.nextInt();
            System.out.println("Enter the number of columns for matrix A : ");
            int c1 = sc.nextInt();
            System.out.println("Enter the number of rows for matrix B : ");
            int r2 = sc.nextInt();
            System.out.println("Enter the number of columns for matrix B : ");
            int c2 = sc.nextInt();
            if (c1 != r2) {
                System.out.println("Matrix multiplication is not possible");
            }
            int[][] matrixA = new int[r1][c1];
            int[][] matrixB = new int[r2][c2];
            int[][] productMatrix = new int[r1][c2];
            System.out.println("Enter the elements of matrix A : ");
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c1; j++) {
                    matrixA[i][j] = sc.nextInt();
                }
            }

            System.out.println("Enter the elements of matrix B : ");
            for (int i = 0; i < r2; i++) {
                for (int j = 0; j < c2; j++) {
                    matrixB[i][j] = sc.nextInt();
                }
            }

            // matrix multiplication
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c2; j++) {
                    productMatrix[i][j] = 0;
                    for (int k = 0; k < c1; k++) {
                        productMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
                    }
                }
            }

            System.out.println("The product of matrix A and B is : ");
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c2; j++) {
                    System.out.print(productMatrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}