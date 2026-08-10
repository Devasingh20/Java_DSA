import java.util.*;

public class chocolate {
    public static void main(String[] args) {
        {
            try (Scanner sc = new Scanner(System.in)) {
                System.out.println("Enter the size of array :");
                int size = sc.nextInt();
                int[] arr = new int[size];
                System.out.println("Enter the elements of array :");
                for (int i = 0; i < size; i++) {
                    arr[i] = sc.nextInt();
                }

                Arrays.sort(arr);
                System.out.println("Sorted array is :");
                for(int i = 0; i<size;i++){
                    System.out.println(arr[i]);
                }
                System.out.println("Enter the number of students :");
                int m = sc.nextInt();
                int st = 0;
                int mindiff = Integer.MAX_VALUE;
                for (int i = 0; i <= size - m; i++) {
                    int diff = arr[i + m - 1] - arr[i];
                    if (diff < mindiff) {
                        mindiff = diff;
                        st = i;
                    }
                }
                System.out.println("The minimum difference is : " + mindiff);
                System.out.println("The selected packets are :");
                for (int i = st; i < st + m; i++) {
                    System.out.print(arr[i] + " ");
                }
            }
        }
    }
}
