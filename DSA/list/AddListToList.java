// package DSA.list;
import java.util.*;
public class AddListToList {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1, 2));
        result.add(Arrays.asList(3, 4));
        System.out.println("List of Lists: " + result);
    }
}
