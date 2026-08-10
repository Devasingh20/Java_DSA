
//left rotaion by one position.
import java.util.Arrays;

public class left_rotation {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        int n = nums.length;
        if (n <= 1) {
            return;
        }
        int temp = nums[0];
        for (int i = 0; i < n - 1; i++) {
            nums[i] = nums[i + 1];
        }
        nums[n - 1] = temp;
        System.out.println(Arrays.toString(nums));
    }
}
