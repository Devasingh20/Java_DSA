import java.util.*;

public class two_sum {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the size of array : ");
            int size = sc.nextInt();
            int[] arr = new int[size];
            System.out.println("Enter the elements of array : ");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println("Enter the target value ;");
            int target = sc.nextInt();
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] + arr[j] == target) {
                        System.out.println("Pair found at index " + i + " and " + j);
                    }
                }
            }
        }
    }
}