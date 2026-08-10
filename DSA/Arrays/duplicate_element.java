// import java.util.*;

// public class array {
//     public static void main(String[] args) {
//         try (Scanner sc = new Scanner(System.in)) {
//             System.out.println("Enter the size of array :");
//             int size = sc.nextInt();
//             int[] arr = new int[size];
//             System.out.println("Enter the elements of array :");
//             for (int i = 0; i < size; i++) {
//                 arr[i] = sc.nextInt();
//             }

//             for (int i = 0; i < size; i++) {
//                 for (int j = i + 1; j < size; j++) {
//                     if (arr[i] == arr[j]) {
//                         System.out.println("Duplicate element found : " + arr[i]);
//                     }
//                 }
//             }

//         }
//     }
// }

//using sorting
// import java.util.*;

// public class array {
//     public static void main(String[] args) {
//         try (Scanner sc = new Scanner(System.in)) {
//             System.out.println("Enter the size of array :");
//             int size = sc.nextInt();
//             int[] arr = new int[size];
//             System.out.println("Enter the elements of array :");
//             for (int i = 0; i < size; i++) {
//                 arr[i] = sc.nextInt();
//             }

//             Arrays.sort(arr);
//             for (int i = 0; i < size-1; i++) {
//                 if (arr[i] == arr[i + 1]) {
//                     System.out.println("Duplicate element found : " + arr[i]);
//                 }
//             }

//         }
//     }
// }

//using hashset
import java.util.*;

public class duplicate_element {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the size of array :");
            int size = sc.nextInt();
            int[] arr = new int[size];
            System.out.println("Enter the elements of array :");
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }

            HashSet<Integer> set = new HashSet<>();
            for(int i = 0; i<size; i++){
                if(set.contains(arr[i])){
                    System.out.println("Duplicate element found : " + arr[i]);
                    return;
                }
                else{
                    set.add(arr[i]);
                }
            }
            System.out.println("No duplicate element is found!");
        }
    }
}
