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

//             int maxSum = Integer.MIN_VALUE;
//             for (int st = 0; st < size; st++) {
//                 int currSum = 0;
//                 for (int end = st; end < size; end++) {
//                     currSum += arr[end];
//                     maxSum = Math.max(maxSum, currSum);
//                 }
//             }
//             System.out.println("The maximum subarray sum is : " + maxSum);
//         }
//     }
// }

// by kadane's algorithm
// import java.util.*;

// public class max_of_subArray {
//     public static void main(String[] args) {
//         try (Scanner sc = new Scanner(System.in)) {
//             System.out.println("Enter the size of array :");
//             int size = sc.nextInt();
//             int[] arr = new int[size];
//             System.out.println("Enter the elements of array :");
//             for (int i = 0; i < size; i++) {
//                 arr[i] = sc.nextInt();
//             }

//             int maxSum = Integer.MIN_VALUE;
//             int currSum = 0;
//             for (int st = 0; st < size; st++) {
//                 currSum += arr[st];
//                 maxSum = Math.max(maxSum, currSum);
//                 if (currSum < 0) {
//                     currSum = 0;
//                 }
//             }
//             System.out.println("The maximum subarray sum is : " + maxSum);
//         }
//     }
// }

import java.util.*;

public class max_of_subArray {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter size of array :");
            int size = sc.nextInt();
            int[] arr = new int[size];
            System.out.println("Enter the elements of array :");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            int maxSum = Integer.MIN_VALUE;
            int currSum = 0;
            for (int st = 0; st < size; st++) {
                currSum += arr[st];
                maxSum = Math.max(currSum, maxSum);
                if (currSum < 0) {
                    currSum = 0;
                }
            }
            System.out.println("The maximum subarray sum is : " + maxSum);
        }
    }
}