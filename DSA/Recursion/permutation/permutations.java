
// package DSA.Recursion.permutation;
import java.util.*;

public class permutations {
    public static void main(String[] args) {
        per("", "abc");
        // using array list but without passing the list as a parameter
        ArrayList<String> ans = per1("", "abc");
        System.out.println(ans);
        // permutation count
        System.out.println(perCount("", "abcde"));
        // return a list of permutations : lists inside a list
        System.out.println(permutationsList("", "abc"));
        // return a list of integer not string like : List<List<Integer>> instead of
        // List<List<String>>
        System.out.println(permute(new ArrayList<>(), new int[] { 1, 2, 3 }, 0));
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

    static int perCount(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        char ch = up.charAt(0);
        int count = 0;
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            count += perCount(f + ch + s, up.substring(1));
        }
        return count;
    }

    static ArrayList<ArrayList<String>> permutationsList(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            ArrayList<ArrayList<String>> result = new ArrayList<>();
            result.add(list);
            return result;
        }
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            ans.addAll(permutationsList(f + ch + s, up.substring(1)));
        }
        return ans;
    }

    static List<List<Integer>> permute(List<Integer> p, int[] arr, int index) {
        if (index == arr.length) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>(p));
            return result;
        }
        int num = arr[index];
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <= p.size(); i++) {
            List<Integer> f = new ArrayList<>(p.subList(0, i));
            List<Integer> s = new ArrayList<>(p.subList(i, p.size()));
            f.add(num);
            f.addAll(s);
            ans.addAll(permute(f, arr, index + 1));
        }
        return ans;
    }
}
