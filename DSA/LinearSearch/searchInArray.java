// package DSA.LinearSearch;

public class searchInArray {
    public static void main(String[] args) {
        int[] nums = { 10, 24, 58, -49, 0, 12, 45, 78 };
        int target = 12;
        int ans = linearsearch(nums, target);
        System.out.println("Target found at index: " + ans);
    }

    static int linearsearch(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == target) {
                return index;
            }
        }
        return -1;
    }
}

