import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18_4sum {
    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,-2,2};
        int target = 0;
         Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            for(int j = i+1;j<arr.length - 2;j++){
                if (j > i+1 && arr[j] == arr[j - 1]) {
                continue;
            }
                int left = j + 1;
            int right = arr.length - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right]+arr[j];
                if (sum == target) {
                    result.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
                    left++;
                    right--;
                    while (left < right && arr[left] == arr[left - 1]) {
                        left++;
                    }
                    while (left < right && arr[right] == arr[right + 1]) {
                        right--;
                    }
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
            }
        }
        System.out.println(result);
    }
}
