// package DSA.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccessListOfLists {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(10, 20, 30));
        result.add(Arrays.asList(40, 50, 60));
        System.out.println("List of Lists: " + result);
        // Accessing elements
        System.out.println(result.get(0));
        System.out.println(result.get(1));
        System.out.println(result.get(0).get(1));
        System.out.println(result.get(1).get(2));
    }
}
