import java.util.*;

public class merging_of_arrays {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the size of arrayA :");
            int sizeA = sc.nextInt();
            int[] A = new int[sizeA];
            System.out.println("Enter the elements of arrayA :");
            for (int i = 0; i < sizeA; i++) {
                A[i] = sc.nextInt();
            }

            System.out.println("Enter the size of arrayB :");
            int sizeB = sc.nextInt();
            int[] B = new int[sizeB];
            System.out.println("Enter the elements of arrayB :");
            for (int i = 0; i < sizeB; i++) {
                B[i] = sc.nextInt();
            }

            int[] mergedArray = new int[sizeA + sizeB];
            System.arraycopy(A, 0, mergedArray, 0, sizeA);
            System.arraycopy(B, 0, mergedArray, sizeA, sizeB);

            System.out.println("The merged array is :");
            for (int nums : mergedArray) {
                System.out.print(nums + " ");
            }
            // for (int i = 0; i < mergedArray.length; i++) {
            // System.out.print(mergedArray[i] + " ");
            // }
        }
    }
}