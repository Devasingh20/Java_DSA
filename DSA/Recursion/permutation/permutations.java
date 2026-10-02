
// package DSA.Recursion.permutation;
import java.util.*;

public class permutations {
    public static void main(String[] args) {
        per("", "abc");
        // using array list but without passing the list as a parameter
        ArrayList<String> ans = per1("", "abc");
        System.out.println(ans);
    }

    static void per(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            per(f + ch + s, up.substring(1));
        }
    }

    static ArrayList<String> per1(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            ans.addAll(per1(f + ch + s, up.substring(1)));
        }
        return ans;
    }
}
