
// package DSA.list;
import java.util.*;

public class PassListOfLists {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        addLists(result);
        System.out.println(result);
    }

    static void addLists(List<List<Integer>> result) {
        result.add(Arrays.asList(10, 20, 30));
        result.add(Arrays.asList(40, 50, 60));
    }
}
