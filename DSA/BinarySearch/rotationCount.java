
//https://www.geeksforgeeks.org/dsa/find-rotation-count-rotated-sorted-array/public class rotationCount {
    public static void main(String[] args) {
        int[] nums = { 15, 18, 2, 3, 6, 12 };
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(start);

    }
}
