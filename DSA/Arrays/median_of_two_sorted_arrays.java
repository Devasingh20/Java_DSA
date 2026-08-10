import java.util.*;

public class median_of_two_sorted_arrays {
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

            // Arrays.sort(A);
            // Arrays.sort(B);

            int[] mergedArray = new int[sizeA + sizeB];
            int i = 0, j = 0, k = 0;
            while (i < sizeA && j < sizeB) {
                if (A[i] <= B[j]) {
                    mergedArray[k++] = A[i++];
                } else {
                    mergedArray[k++] = B[j++];
                }
            }
            while (i < sizeA) {
                mergedArray[k++] = A[i++];
            }
            while (j < sizeB) {
                mergedArray[k++] = B[j++];
            }
            System.out.println("The merged sorted array is :");
            for (int nums : mergedArray) {
                System.out.print(nums + " ");
            }

            System.out.println();

            System.out.println("Median of merged sorted array is :");
            int totalSize = mergedArray.length;
            // int totalSize = sizeA + sizeB;
            double median;
            if (totalSize % 2 == 1) {
                median = mergedArray[totalSize / 2];
                System.out.println(median);
            } else {
                median = (mergedArray[(totalSize / 2) - 1] + mergedArray[totalSize / 2]) / 2.0;
                System.out.println(median);
            }
            System.out.println(totalSize);
            System.out.println(totalSize / 2);
        }

    }
}

// import java.util.*;

// public class median_of_two_sorted_arrays {
// public static void main(String[] args) {
// {
// try (Scanner sc = new Scanner(System.in)) {
// System.out.println("Enter the size of arrA :");
// int sizeA = sc.nextInt();
// int[] arrA = new int[sizeA];
// System.out.println("Enter the elements of arrA :");
// for (int i = 0; i < sizeA; i++) {
// arrA[i] = sc.nextInt();
// }

// System.out.println("Enter the size of arrB :");
// int sizeB = sc.nextInt();
// int[] arrB = new int[sizeB];
// System.out.println("Enter the elements of arrB :");
// for (int i = 0; i < sizeB; i++) {
// arrB[i] = sc.nextInt();
// }

// int[] mergedArr = new int[sizeA + sizeB];
// int i = 0;
// int j = 0;
// int k = 0;
// while (i < sizeA && j < sizeB) {
// if (arrA[i] <= arrB[j]) {
// mergedArr[k++] = arrA[i++];
// } else {
// mergedArr[k++] = arrB[j++];
// }
// }

// while (i < sizeA) {
// mergedArr[k++] = arrA[i++];
// }
// while (j < sizeB) {
// mergedArr[k++] = arrB[j++];
// }

// System.out.println("The merged array is :");
// for (int nums : mergedArr) {
// System.out.print(nums + " ");
// }
// System.out.println();
// }
// }
// }
// }