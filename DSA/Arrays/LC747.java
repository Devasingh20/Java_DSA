// You are given an integer array nums where the largest integer is unique.
// Determine whether the largest element in the array is at least twice as much
// as every other number in the array. If it is, return the index of the largest
// element, or return -1 otherwise.

public class LC747 {
    public static void main(String[] args) {
        int[] arr = { 3, 6, 1, 0 };
        int n = arr.length;
        long largest = Long.MIN_VALUE;
        long second = Long.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                second = largest;
                largest = arr[i];
                index = i;
            } else if (arr[i] > second && arr[i] != largest) {
                second = arr[i];
            }
        }
        if (largest >= 2 * second) {
            System.out.println(index);
        } else {
            System.out.println("not found!");
        }
    }
}
