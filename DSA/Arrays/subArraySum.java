// import java.util.Scanner;

// public class subArraySum {
//     public static void main(String[] args) {
//         {
//             try (Scanner sc = new Scanner(System.in)) {
//                 System.out.println("Enter the size of array :");
//                 int n = sc.nextInt();
//                 int[] arr = new int[n];
//                 System.out.println("Enter the elements of array :");
//                 for (int i = 0; i < n; i++) {
//                     arr[i] = sc.nextInt();
//                 }

//                 System.out.println("Enter the size of subarray :");
//                 int m = sc.nextInt();

//                 int[] prefix = new int[n];
//                 prefix[0] = arr[0];
//                 for (int i = 1; i < n; i++) {
//                     prefix[i] = prefix[i - 1] + arr[i];
//                 }

//                 int maxSum = Integer.MIN_VALUE;
//                 for (int i = m - 1; i < n; i++) {
//                     int currSum;
//                     if (i == m - 1) {
//                         currSum = prefix[i];
//                     } else {
//                         currSum = prefix[i] - prefix[i - m];
//                     }
//                     maxSum = Math.max(currSum, maxSum);
//                 }
//                 System.out.println("The maximum subarray sum is: " + maxSum);
//             }
//         }
//     }
// }

//this method takes O(n) space complexity.
// import java.util.*;

// public class subArraySum {
//     public static void main(String[] args) {
//         try (Scanner sc = new Scanner(System.in)) {
//             System.out.println("Enter the size of array :");
//             int size = sc.nextInt();
//             int[] arr = new int[size];
//             System.out.println("Enter the elements of array :");
//             for (int i = 0; i < size; i++) {
//                 arr[i] = sc.nextInt();
//             }

//             System.out.println("Enter the size of subArray :");
//             int m = sc.nextInt();

//             int[] prefix = new int[arr.length];
//             prefix[0] = arr[0];
//             for (int i = 1; i < arr.length; i++) {
//                 prefix[i] = prefix[i - 1] + arr[i];
//             }
//             int maxSum = Integer.MIN_VALUE;
//             for (int i = 0; i <= size - m; i++) {
//                 int currSum;
//                 if (i == 0) {
//                     currSum = prefix[i + m - 1];
//                 } else {
//                     currSum = prefix[i + m - 1] - prefix[i - 1];
//                 }
//                 maxSum = Math.max(currSum, maxSum);
//             }
//             System.out.println("The maximum subarray sum is :" + maxSum);
//         }
//     }
// }

//below solution takes O(1) space complexity.
public class subArraySum {
    public static void main(String[] args) {
        int[] nums = { 2, 1, 5, 1, 3, 2 };
        int k = 3;
        int n = nums.length;
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int maxSum = windowSum;
        for (int i = k; i < n; i++) {
            windowSum = windowSum - nums[i - k] + nums[i];
            maxSum = Math.max(windowSum, maxSum);
        }
        System.out.println(maxSum);
    }
}
