// import java.util.*;

// public class prefixSum {
//     public static int[] buildPrefixSum(int[] arr) {
//         int[] prefix = new int[arr.length];
//         prefix[0] = arr[0];
//         for (int i = 1; i < arr.length; i++) {
//             prefix[i] = prefix[i - 1] + arr[i];
//         }
//         return prefix;
//     }

//     static int rangeSum(int[] prefix, int l, int r) {
//         if (l == 0) {
//             return prefix[r];
//         } else {
//             return prefix[r] - prefix[l - 1];
//         }
//     }

//     public static void main(String[] args) {
//         {
//             int[] arr = { 2, 4, 6, 8, 10 };
//             int[] prefix = buildPrefixSum(arr);
//             System.out.println(Arrays.toString(prefix));
//             System.out.println(rangeSum(prefix, 1, 3));
//         }
//     }
// }

import java.util.*;

public class prefixSum {

    public static int[] buildPrefix(int[] arr) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        return prefix;
    }

    static int rangeSum(int[] prefix, int l, int r) {
        if (l == 0) {
            return prefix[r];
        } else {
            return prefix[r] - prefix[l - 1];
        }
    }

    public static void main(String[] args) {
        {
            try (Scanner sc = new Scanner(System.in)) {
                System.out.println("Enter the size of array :");
                int size = sc.nextInt();
                int[] arr = new int[size];
                System.out.println("Enter the elements of array :");
                for (int i = 0; i < size; i++) {
                    arr[i] = sc.nextInt();
                }
                System.out.println("Prefix sum is :");
                int[] prefix = buildPrefix(arr);
                System.out.println(Arrays.toString(prefix));
                System.out.println(rangeSum(prefix, 1, 3));
            }

        }
    }
}