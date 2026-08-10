public class secondSmallest {
    public static void main(String[] args) {
        int[] arr = { 4, -1, 7, -2147483648, 5 };
        int n = arr.length;
        long smallest = Long.MAX_VALUE;
        long second = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] < smallest) {
                second = smallest;
                smallest = arr[i];
            } else if (arr[i] < second && arr[i] != smallest) {
                second = arr[i];
            }
        }
        System.out.println("Second smallest number is :" + (second == Long.MAX_VALUE ? -1 : (int) second));
    }
}

// You are given an integer array nums where the largest integer is unique.
// Determine whether the largest element in the array is at least twice as much
// as every other number in the array. If it is, return the index of the largest
// element, or return -1 otherwise.

// public class secondSmallest {
// public static void main(String[] args) {
// int[] arr = {0,0,0};
// int n = arr.length;
// long largest = Long.MIN_VALUE;
// long second = Long.MAX_VALUE;
// int index = -1;
// for (int i = 0; i < n; i++) {
// if (arr[i] > largest) {
// second = largest;
// largest = arr[i];
// index = i;
// } else if (arr[i] > second && arr[i] != largest) {
// second = arr[i];
// }
// }
// if (largest >= 2 * second) {
// System.out.println(index);
// } else {
// System.out.println("not found!");
// }
// }
// }
