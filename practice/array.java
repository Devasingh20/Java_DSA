
// arrays in java

// public class array {
//     public static void main(String[] args) {
//         int[] marks = new int[3];
//         marks[0] = 10;
//         marks[1] = 20;
//         marks[2] = 30;
//         for (int i = 0; i < marks.length; i++) {
//             System.out.println(" marks in subjects is : " + marks[i]);
//         }
//     }
// }

// sum and average of array
// import java.util.Scanner;

// public class array{
//     public static void main(String[] args) {
//         try(Scanner sc = new Scanner(System.in)){
//             System.out.println("Enter the size of array :");
//             int size = sc.nextInt();
//             int[] arr = new int[size];
//             for(int i = 0; i<size; i++){
//                 System.out.println("Enter the marks  of subject " + (i+1) + " : ");
//                 arr[i] = sc.nextInt();
//             }
//             int sum = 0;
//             for(int i= 0; i<size; i++){
//                 sum+=arr[i];
//             }
//             System.out.println("----Marks Report----");
//             System.out.println("Total marks is :" + sum );
//             int avg = sum / arr.length;
//             System.out.println("Average marks is " + avg);
//         }
//     }
// }

// import java.util.Scanner;
// public class array{
//     public static void main(String[] args) {
//         try(Scanner sc = new Scanner(System.in)){
//             System.out.println("Enter the size of array :");
//             int size = sc.nextInt();
//             int[] arr = new int[size];
//             System.out.println("Enter the numbers :");
//             for(int i= 0; i<size; i++){
//                 arr[i] = sc.nextInt();
//             }
//             int min = Integer.MAX_VALUE;
//             int max = Integer.MIN_VALUE;
//             for(int num : arr){
//                 if(num > max){
//                     max = num;
//                 }
//                 if(num < min){
//                     min = num;
//                 }
//             }
//              System.out.println("Minimum number is :" + min);
//              System.out.println("Maximum number is :" + max);
//         }
//     }
// }

// import java.util.*;

// public class array {
//     public static void main(String[] args) {
//         try (Scanner sc = new Scanner(System.in)) {
//             System.out.println("Enter the number of rows : ");
//             int rows = sc.nextInt();
//             System.out.println("Enter the numbers of columns : ");
//             int cols = sc.nextInt();
//             int[][] matrix = new int[rows][cols];
//             System.out.println("Enter the elements of the matrix : ");
//             for (int i = 0; i < rows; i++) {
//                 for (int j = 0; j < cols; j++) { 
//                     matrix[i][j] = sc.nextInt();
//                 }
//             }
//             System.out.println("The matrix is : ");
//             for (int i = 0; i < rows; i++) {
//                 for (int j = 0; j < cols; j++) {
//                     System.out.print(matrix[i][j] + " ");
//                 }
//                 System.out.println();
//             }

//         }
//     }
// }

// public class array {  
// public static int changeNum(int num) {
// num = 99;
// return num;
// }

// public static void main(String[] args) {
// int num = 10;
// System.out.println("Before changing num : " + num);
// num = changeNum(num);
// System.out.println("After changing num : " + num);
// }
// }

//matrix addition
// import java.util.*;

// public class array {
//     public static void main(String[] args) {
//         try (Scanner sc = new Scanner(System.in)) {
//             System.out.println("Enter the number of rows : ");
//             int rows = sc.nextInt();
//             System.out.println("Enter the number of columns : ");
//             int cols = sc.nextInt();
//             int[][] matrixA = new int[rows][cols];
//             int[][] matrixB = new int[rows][cols];
//             int[][] sumMatrix = new int[rows][cols];

//             System.out.println("Enter the elements of matrix A : ");
//             for (int i = 0; i < rows; i++) {
//                 for (int j = 0; j < cols; j++) {
//                     matrixA[i][j] = sc.nextInt();
//                 }
//             }

//             System.out.println("Enter the elements of matrix B : ");
//             for (int i = 0; i < rows; i++) {
//                 for (int j = 0; j < cols; j++) {
//                     matrixB[i][j] = sc.nextInt();
//                 }
//             }

//             // matrix addition
//             for (int i = 0; i < rows; i++) {
//                 for (int j = 0; j < cols; j++) {
//                     sumMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
//                 }
//             }

//             System.out.println("The sum of matrix A and B is : ");
//             for (int i = 0; i < rows; i++) {
//                 for (int j = 0; j < cols; j++) {
//                     System.out.print(sumMatrix[i][j] + " ");
//                 }
//                 System.out.println();
//             }
//         }
//     }
// }

//matrix multiplication
// import java.util.*;

// public class array {
//     public static void main(String[] args) {
//         try (Scanner sc = new Scanner(System.in)) {
//             System.out.println("Enter the number of rows for matrix A : ");
//             int r1 = sc.nextInt();
//             System.out.println("Enter the number of columns for matrix A : ");
//             int c1 = sc.nextInt();
//             System.out.println("Enter the number of rows for matrix B : ");
//             int r2 = sc.nextInt();
//             System.out.println("Enter the number of columns for matrix B : ");
//             int c2 = sc.nextInt();
//             if (c1 != r2) {
//                 System.out.println("Matrix multiplication is not possible");
//             }
//             int[][] matrixA = new int[r1][c1];
//             int[][] matrixB = new int[r2][c2];
//             int[][] productMatrix = new int[r1][c2];
//             System.out.println("Enter the elements of matrix A : ");
//             for (int i = 0; i < r1; i++) {
//                 for (int j = 0; j < c1; j++) {
//                     matrixA[i][j] = sc.nextInt();
//                 }
//             }

//             System.out.println("Enter the elements of matrix B : ");
//             for (int i = 0; i < r2; i++) {
//                 for (int j = 0; j < c2; j++) {
//                     matrixB[i][j] = sc.nextInt();
//                 }
//             }

//             // matrix multiplication
//             for (int i = 0; i < r1; i++) {
//                 for (int j = 0; j < c2; j++) {
//                     productMatrix[i][j] = 0;
//                     for (int k = 0; k < c1; k++) {
//                         productMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
//                     }
//                 }
//             }

//             System.out.println("The product of matrix A and B is : ");
//             for (int i = 0; i < r1; i++) {
//                 for (int j = 0; j < c2; j++) {
//                     System.out.print(productMatrix[i][j] + " ");
//                 }
//                 System.out.println();
//             }
//         }
//     }
// }

// import java.util.*;

// public class array {
//     public static void main(String[] args) {
//         try (Scanner sc = new Scanner(System.in)) {
//             System.out.println("Enter the size of array : ");
//             int size = sc.nextInt();
//             int[] arr = new int[size];
//             System.out.println("Enter the elements of array : ");
//             for (int i = 0; i < size; i++) {
//                 arr[i] = sc.nextInt();
//             }
//             System.out.println("Enter the target value ;");
//             int target = sc.nextInt();
//             for (int i = 0; i < arr.length; i++) {
//                 for (int j = i + 1; j < arr.length; j++) {
//                     if (arr[i] + arr[j] == target) {
//                         System.out.println("Pair found at index " + i + " and " + j);
//                     }
//                 }
//             }
//         }
//     }
// }

//merging of two arrays
// import java.util.*;

// public class array {
//     public static void main(String[] args) {
//         try (Scanner sc = new Scanner(System.in)) {
//             System.out.println("Enter the size of arrayA :");
//             int sizeA = sc.nextInt();
//             int[] A = new int[sizeA];
//             System.out.println("Enter the elements of arrayA :");
//             for (int i = 0; i < sizeA; i++) {
//                 A[i] = sc.nextInt();
//             }

//             System.out.println("Enter the size of arrayB :");
//             int sizeB = sc.nextInt();
//             int[] B = new int[sizeB];
//             System.out.println("Enter the elements of arrayB :");
//             for (int i = 0; i < sizeB; i++) {
//                 B[i] = sc.nextInt();
//             }

//             int[] mergedArray = new int[sizeA + sizeB];
//             for (int i = 0; i < sizeA; i++) {
//                 mergedArray[i] = A[i];
//             }

//             for (int i = 0; i < sizeB; i++) {
//                 mergedArray[sizeA + i] = B[i];
//             }

//             System.out.println("The merged array is :");
//             for (int nums : mergedArray) {
//                 System.out.print(nums + " ");
//             }
//             // for (int i = 0; i < mergedArray.length; i++) {
//             // System.out.print(mergedArray[i] + " ");
//             // }
//         }
//     }
// }

//merging of two sorted arrays and finding median
// import java.util.*;

// public class array {
//     public static void main(String[] args) {
//         try (Scanner sc = new Scanner(System.in)) {
//             System.out.println("Enter the size of arrayA :");
//             int sizeA = sc.nextInt();
//             int[] A = new int[sizeA];
//             System.out.println("Enter the elements of arrayA :");
//             for (int i = 0; i < sizeA; i++) {
//                 A[i] = sc.nextInt();
//             }

//             System.out.println("Enter the size of arrayB :");
//             int sizeB = sc.nextInt();
//             int[] B = new int[sizeB];
//             System.out.println("Enter the elements of arrayB :");
//             for (int i = 0; i < sizeB; i++) {
//                 B[i] = sc.nextInt();
//             }

//             // Arrays.sort(A);
//             // Arrays.sort(B);

//             int[] mergedArray = new int[sizeA + sizeB];
//             int i = 0, j = 0, k = 0;
//             while (i < sizeA && j < sizeB) {
//                 if (A[i] <= B[j]) {
//                     mergedArray[k++] = A[i++];
//                 } else {
//                     mergedArray[k++] = B[j++];
//                 }
//             }
//             while (i < sizeA) {
//                 mergedArray[k++] = A[i++];
//             }
//             while (j < sizeB) {
//                 mergedArray[k++] = B[j++];
//             }
//             System.out.println("The merged sorted array is :");
//             for (int nums : mergedArray) {
//                 System.out.print(nums + " ");
//             }

//             System.out.println();

//             System.out.println("Median of merged sorted array is :");
//             int totalSize = mergedArray.length;
//             // int totalSize = sizeA + sizeB;
//             double median;
//             if (totalSize % 2 == 1) {
//                 median = mergedArray[totalSize / 2];
//                 System.out.println(median);
//             } else {
//                 median = (mergedArray[(totalSize / 2) - 1] + mergedArray[totalSize / 2]) / 2.0;
//                 System.out.println(median);
//             }
//         }

//     }
// }

//maximum and minimum in array 

// import java.util.Scanner;

// public class array {
//     public static void main(String[] args) {
//         try (Scanner sc = new Scanner(System.in)) {
//             System.out.println("Enter the size of array :");
//             int size = sc.nextInt();
//             int[] arr = new int[size];
//             System.out.println("Enter the elements of array :");
//             for (int i = 0; i < size; i++) {
//                 arr[i] = sc.nextInt();
//             }

//             System.out.println("The array is :");
//             for (int nums : arr) {
//                 System.out.print(nums + " ");
//             }

//             // sorting the array
//             for (int i = 0; i < size - 1; i++) {
//                 for (int j = 0; j < size - 1 - i; j++) {
//                     if (arr[j] > arr[j + 1]) {
//                         int temp = arr[j];
//                         arr[j] = arr[j + 1];
//                         arr[j + 1] = temp;
//                     }
//                 }
//             }

//             System.out.println();
//             System.out.println("The sorted array is :");
//             for (int nums : arr) {
//                 System.out.print(nums + " ");
//             }
//             System.out.println();
//             System.out.println("Minimum element in array is : " + arr[0]);
//             System.out.println("Maximum element in array is : " + arr[size - 1]);
//         }
//     }
// }

//print subarrays of an array

// import java.util.*;

// public class array {
//     public static void main(String[] args) {
//         try (Scanner sc = new Scanner(System.in)) {
//             System.out.println("Enter the size of array :");
//             int size = sc.nextInt();
//             int[] arr = new int[size];
//             System.out.println("Enter the elements of array :");
//             for (int i = 0; i < size; i++) {
//                 arr[i] = sc.nextInt();
//             }

//             System.out.println("The subArray is :");
//             for (int st = 0; st < size; st++) {
//                 for (int end = st; end < size; end++) {
//                     for (int k = st; k <= end; k++) {
//                         System.out.print(arr[k] + " ");
//                     }
//                     System.out.print(" ");
//                 }
//                 System.out.println();
//             }
//         }
//     }
// }

// maximum of all subarrays of size
// import java.util.*;

// public class array {
// public static void main(String[] args) {
// try (Scanner sc = new Scanner(System.in)) {
// System.out.println("Enter the size of array :");
// int size = sc.nextInt();
// int[] arr = new int[size];
// System.out.println("Enter the elements of array :");
// for (int i = 0; i < size; i++) {
// arr[i] = sc.nextInt();
// }

// int maxSum = Integer.MIN_VALUE;
// for (int st = 0; st < size; st++) {
// int currSum = 0;
// for (int end = st; end < size; end++) {
// currSum += arr[end];
// maxSum = Math.max(maxSum, currSum);
// }
// }
// System.out.println("The maximum subarray sum is : " + maxSum);
// }
// }
// }

// by kadane's algorithm
// import java.util.*;

// public class array {
// public static void main(String[] args) {
// try (Scanner sc = new Scanner(System.in)) {
// System.out.println("Enter the size of array :");
// int size = sc.nextInt();
// int[] arr = new int[size];
// System.out.println("Enter the elements of array :");
// for (int i = 0; i < size; i++) {
// arr[i] = sc.nextInt();
// }

// int maxSum = Integer.MIN_VALUE;
// int currSum = 0;
// for (int st = 0; st < size; st++) {
// currSum += arr[st];
// maxSum = Math.max(maxSum, currSum);
// if (currSum < 0) {
// currSum = 0;
// }
// }
// System.out.println("The maximum subarray sum is : " + maxSum);
// }
// }
// }



// duplicate in array
// import java.util.*;

// public class array {
// public static void main(String[] args) {
// try (Scanner sc = new Scanner(System.in)) {
// System.out.println("Enter the size of array :");
// int size = sc.nextInt();
// int[] arr = new int[size];
// System.out.println("Enter the elements of array :");
// for (int i = 0; i < size; i++) {
// arr[i] = sc.nextInt();
// }

// for (int i = 0; i < size; i++) {
// for (int j = i + 1; j < size; j++) {
// if (arr[i] == arr[j]) {
// System.out.println("Duplicate element found : " + arr[i]);
// }
// }
// }

// }
// }
// }

// using sorting
// import java.util.*;

// public class array {
// public static void main(String[] args) {
// try (Scanner sc = new Scanner(System.in)) {
// System.out.println("Enter the size of array :");
// int size = sc.nextInt();
// int[] arr = new int[size];
// System.out.println("Enter the elements of array :");
// for (int i = 0; i < size; i++) {
// arr[i] = sc.nextInt();
// }

// Arrays.sort(arr);
// for (int i = 0; i < size-1; i++) {
// if (arr[i] == arr[i + 1]) {
// System.out.println("Duplicate element found : " + arr[i]);
// }
// }

// }
// }
// }

// using hashset
// import java.util.*;

// public class array {
// public static void main(String[] args) {
// try (Scanner sc = new Scanner(System.in)) {
// System.out.println("Enter the size of array :");
// int size = sc.nextInt();
// int[] arr = new int[size];
// System.out.println("Enter the elements of array :");
// for (int i = 0; i < size; i++) {
// arr[i] = sc.nextInt();
// }

// HashSet<Integer> set = new HashSet<>();
// for (int i = 0; i < size; i++) {
// if (set.contains(arr[i])) {
// System.out.println("Duplicate element found : " + arr[i]);
// // return;
// } else {
// set.add(arr[i]);
// }
// }
// // System.out.println("No duplicate elements found");
// }
// }
// }

// hashset use of iterator
// import java.util.*;

// public class array {
// public static void main(String[] args) {
// try (Scanner sc = new Scanner(System.in)) {
// System.out.println("Enter the size of array :");
// int size = sc.nextInt();
// int[] arr = new int[size];
// System.out.println("Enter the elements of array :");
// for (int i = 0; i < size; i++) {
// arr[i] = sc.nextInt();
// }

// HashSet<Integer> set = new HashSet<>();
// for (int i = 0; i < size; i++) {
// set.add(arr[i]);
// }

// System.out.println("The unique elements in the array are :");
// Iterator<Integer> it = set.iterator();
// while (it.hasNext()) {
// System.out.println(it.next() + " ");
// }
// }
// }
// }

// import java.util.*;

// public class array {
// public static void main(String[] args) {
// {
// try (Scanner sc = new Scanner(System.in)) {
// System.out.println("Enter the size of array :");
// int size = sc.nextInt();
// int[] arr = new int[size];
// System.out.println("Enter the elements of array :");
// for (int i = 0; i < size; i++) {
// arr[i] = sc.nextInt();
// }

// Arrays.sort(arr);
// System.out.println("Enter the number of students :");
// int m = sc.nextInt();
// int st = 0;
// int mindiff = Integer.MAX_VALUE;
// for (int i = 0; i + m - 1 < size; i++) {
// int diff = arr[i + m - 1] - arr[i];
// if (diff < mindiff) {
// mindiff = diff;
// st = i;
// }
// }
// System.out.println("The minimum difference is : " + mindiff);
// System.out.println("The selected packets are :");
// for (int i = st; i < st + m; i++) {
// System.out.print(arr[i] + " ");
// }
// }
// }
// }
// }

// array opetaions
// import java.util.*;

// public class array {
// public static void main(String[] args) {
// {
// try (Scanner sc = new Scanner(System.in)) {
// System.out.println("Enter the size of array :");
// int size = sc.nextInt();
// int[] arr = new int[size];
// System.out.println("Enter the elements of array :");
// for (int i = 0; i < size; i++) {
// arr[i] = sc.nextInt();
// }
// arr[0] = 99; // updating value at index 0
// System.out.println("elements of array is :");
// for (int i = 0; i < size; i++) {
// System.out.print(arr[i] + " ");
// }
// }
// }
// }
// }