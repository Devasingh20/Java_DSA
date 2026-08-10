// package DSA.LinearSearch;

public class searchInRange {
    public static void main(String[] args) {
        int[] arr = { 10, 24, 58, -49, 0, 12, 45, 78 };
        int target = 78;
        int start = 1;
        int end = 6;
        int ans = linearSearch(arr, target, start, end);
        if (ans == -1) {
            System.out.println("Target not found in the given range.");
        } else {
            System.out.println("Target found at index: " + ans);
        }
    }

    static int linearSearch(int[] arr, int target, int start, int end) {
        if (arr.length == 0) {
            return -1;
        }
        for (int i = start; i <= end; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
