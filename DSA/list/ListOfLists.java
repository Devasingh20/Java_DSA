
// package DSA.list;
import java.util.*;

public class ListOfLists {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        result.add(list1);
        result.add(list2);
        System.out.println("List of Lists: " + result);
    }
}
