// package DSA.list;

import java.util.*;

public class ModifyListOfLists {

    public static void main(String[] args) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        list1.add(10);
        list1.add(20);

        result.add(list1);

        System.out.println(result);

        result.get(0).add(30);

        System.out.println(result);
    }
}
