import java.util.Scanner;

public class max_min_element_in_array {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the size of array :");
            int size = sc.nextInt();
            int[] arr = new int[size];
            System.out.println("Enter the elements of array :");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println("The array is :");
            for (int nums : arr) {
                System.out.print(nums + " ");
            }

            // sorting the array
            for (int i = 0; i < size - 1; i++) {
                for (int j = 0; j < size - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }

            System.out.println();
            System.out.println("The sorted array is :");
            for (int nums : arr) {
                System.out.print(nums + " ");
            }
            System.out.println();
            System.out.println("Minimum element in array is : " + arr[0]);
            System.out.println("Maximum element in array is : " + arr[size - 1]);
        }
    }
}
