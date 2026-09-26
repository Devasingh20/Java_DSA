// package DSA.list;

import java.util.*;

public class RecursiveListOfLists {
    static void find(
            int[] arr,
            int target,
            int index,
            List<List<Integer>> result) {
        // Base case
        if (index == arr.length) {
            return;
        }
        // Found target
        if (arr[index] == target) {
            result.add(List.of(index, arr[index]));
        }
        // Recursive call
        find(arr, target, index + 1, result);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, 4, 1, 5 };
        int target = 1;
        List<List<Integer>> result = new ArrayList<>();
        find(arr, target, 0, result);
        System.out.println(result);
    }
}

// Why do we pass List<List<Integer>> as an argument in recursion?
// We pass List<List<Integer>> as an argument so that all recursive calls share
// the same result list and accumulate their results in one common collection;
// creating it inside the recursive method would create a new list for every
// invocation.

// Remember, in Java, when you pass an object (like a List) to a method, you're
// passing a reference to that object. This means that any changes made to the
// object inside the method will affect the original object outside the
// method,so every recursive call receives a copy of the reference pointing to
// the same result object.