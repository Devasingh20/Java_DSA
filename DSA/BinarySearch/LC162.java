//https://leetcode.com/problems/find-peak-element/
public class LC162 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 5, 6, 8, 10, 12, 4, 3, 2 };
        int ans = binarySearch(nums);
        System.out.println(ans);
    }

    static int binarySearch(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                // you are in dec part of array
                // this may be the ans, but look at left
                // this is why end != mid - 1
                end = mid;
            } else {
                // you are in asc part of array
                start = mid + 1; // because we know that mid+1 element > mid element
            }
        }
        // in the end, start == end and pointing to the largest number because of the 2
        // checks above
        // start and end are always trying to find max element in the above 2 checks
        // hence, when they are pointing to just one element, that is the max one
        // because that is what the checks say
        // more elaboration: at every point of time for start and end, they have the
        // best possible answer till that time
        // and if we are saying that only one item is remaining, hence cuz of above line
        // that is the best possible ans
        // or return end as both are =
        return start;
    }
}

