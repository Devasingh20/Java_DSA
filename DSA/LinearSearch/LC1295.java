// package DSA.LinearSearch;
//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/

public class LC1295 {
    public static void main(String[] args) {
        int[] nums = {12,345,2,6,7896};
        int n = nums.length;
        int even = 0;
        for(int i = 0;i<n;i++){
            int count = 0;
            int temp = nums[i];
            while(temp!=0){
                temp = temp/10;
                count++;
            }
            if(count%2==0){
                even++;
            }
        }
        System.out.println("The number of integers with even number of digits is: " + even);
    }
}
