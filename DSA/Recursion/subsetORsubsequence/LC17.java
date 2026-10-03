import java.util.ArrayList;
import java.util.List;

public class LC17 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("", "23"));
    }

    static List<String> letterCombinations(String p, String up) {
        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> ans = new ArrayList<>();
        int digit = up.charAt(0) - '0';
        // int start = (digit - 2) * 3;
        // int end = start + 3;
        int start = 0;
        int end = 0;
        if(digit != 7 && digit != 9 && digit != 8) {
            start = (digit - 2)*3;
            end = start + 3;
        } else if(digit == 7) {
            start = (digit - 2)*3;
            end = start + 4;
        } else if(digit == 8) {
            start = (digit - 2)*3 + 1;
            end = start + 3;
        } else if(digit == 9) {
            start = (digit - 2)*3 + 1;
            end = start + 4;
        }
        for (int i = start; i < end; i++) {
            char ch = (char) ('a' + i);
            List<String> list = letterCombinations(p + ch, up.substring(1));
            ans.addAll(list);
        }
        return ans;
    }
}
