import java.util.Arrays;

public class LC189 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        int n = nums.length;
        if (n <= 1) {
            return;
        }
        int k = 3;
        k = k % n;
        // rotate array to the right by k-positions
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);

        // rotate array to the right by k-positions
        // reverse(nums, 0, k - 1);
        // reverse(nums, k, n - 1);
        // reverse(nums, 0, n - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return arr;
    }
}


// class Solution {
//     public int thirdMax(int[] nums) {
//        Long largest = null;
//        Long slargest = null;
//        Long tlargest = null;

//        for(int num : nums){
//         if((largest!=null && num == largest)||
//             (slargest!=null && num == slargest)||
//             (tlargest!=null && num == tlargest)){
//                 continue;
//             }

//             if(largest == null || num>largest){
//                 tlargest = slargest;
//                 slargest = largest;
//                 largest = (long) num;
//             }
//             else if(slargest == null || num>slargest){
//                 tlargest = slargest;
//                 slargest = (long) num;
//             }
//             else if(tlargest == null || num>tlargest){
//                 tlargest = (long) num;
//             }
//        }
//        return tlargest == null? largest.intValue():tlargest.intValue();
//     }
// }


// class Solution {
//     public int thirdMax(int[] nums) {
//         long largest = Long.MIN_VALUE;
//         long slargest = Long.MIN_VALUE;
//         long tlargest = Long.MIN_VALUE;
//         for(int i = 0;i<nums.length;i++){
//             if(nums[i]>largest){
//                 tlargest = slargest;
//                 slargest = largest;
//                 largest = nums[i];
//             }
//            else if(nums[i]>slargest && nums[i]!=largest){
//                 tlargest = slargest;
//                 slargest = nums[i];
//             }
//            else if(nums[i]>tlargest && nums[i]!=largest && nums[i]!=slargest){
//                 tlargest = nums[i];
//             }
//         }
//        return tlargest == Long.MIN_VALUE?(int) largest:(int) tlargest;
//     }
// }