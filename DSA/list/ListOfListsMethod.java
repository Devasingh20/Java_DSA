
// package DSA.list;
import java.util.*;

public class ListOfListsMethod {
    public static void main(String[] args) {
        List<List<Integer>> result = createLists();
        System.out.println(result);
    }

    static List<List<Integer>> createLists() {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        list1.add(10);
        list1.add(20);

        List<Integer> list2 = new ArrayList<>();
        list2.add(30);
        list2.add(40);

        result.add(list1);
        result.add(list2);

        return result;
    }
}
