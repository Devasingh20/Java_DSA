import java.util.*;

public class subarrays {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the size of array :");
            int size = sc.nextInt();
            int[] arr = new int[size];
            System.out.println("Enter the elements of array :");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println("The subarrays are :");
            for (int st = 0; st < size; st++) {
                for (int end = st; end < size; end++) {
                    for (int k = st; k <= end; k++) {
                        System.out.print(arr[k]);
                    }
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
    }
}