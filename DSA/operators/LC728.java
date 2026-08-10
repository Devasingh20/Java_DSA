// package DSA.operators;

import java.util.ArrayList;
import java.util.List;

public class LC728 {
    public static void main(String[] args) {
        int left = 47;
        int right = 85;
        List<Integer> ans = new ArrayList<>();
        for (int num = left; num <= right; num++) {
            int temp = num;
            boolean valid = false;
            while (temp > 0) {
                int digit = temp % 10;
                if (digit == 0) {
                    valid = false;
                    break;
                } else if (num % digit != 0) {
                    valid = false;
                    break;
                } else {
                    temp = temp / 10;
                }
                valid = true;
            }
            if (valid) {
                ans.add(num);
            }

        }
        System.out.println(ans);
    }
}
