//https://leetcode.com/problems/binary-search/submissions/2118771039/
public class binarySearchLC704 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 55, 66, 78 };
        int target = 55;
        System.out.println(BS(arr, target, 0, arr.length - 1));
    }

    static int BS(int[] arr, int target, int s, int e) {
        if (s > e) {
            return -1;
        }
        int mid = s + (e - s) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (target < arr[mid]) {
            return BS(arr, target, s, mid - 1);
        }
        return BS(arr, target, mid + 1, e);
    }
}
