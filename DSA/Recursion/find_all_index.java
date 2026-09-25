import java.util.ArrayList;

public class find_all_index {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 8, 5, 7, 1, 9, 1, 1 };
        findAllIndex(arr, 1, 0);
        System.out.println(list);
    }

    static ArrayList<Integer> list = new ArrayList<>();

    static void findAllIndex(int[] arr, int target, int index) {
        if (index == arr.length) {
            return;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        findAllIndex(arr, target, index + 1);
    }
}
