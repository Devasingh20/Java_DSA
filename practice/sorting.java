// import java.util.*;

// public class sorting {
//     public static void printArray(int arr[]) {
//         System.out.println("The sorted array is :");
//         for (int i = 0; i < arr.length; i++) {
//             System.out.print(arr[i] + " ");
//         }
//     }

//     public static void main(String[] args) {
//         {
//             try (Scanner sc = new Scanner(System.in)) {
//                 System.out.println("Enter the size of array :");
//                 int n = sc.nextInt();
//                 int[] arr = new int[n];
//                 System.out.println("Enter the elements of array :");
//                 for (int i = 0; i < n; i++) {
//                     arr[i] = sc.nextInt();
//                 }
//                 //Bubble sort
//                 //time complexity O(n^2)
//                 for (int i = 0; i < n - 1; i++) {
//                     for (int j = 0; j < n - i - 1; j++) {
//                         if (arr[j] > arr[j + 1]) {
//                             int temp = arr[j];
//                             arr[j] = arr[j + 1];
//                             arr[j + 1] = temp;
//                         }
//                     }
//                 }9999
//                 printArray(arr);
//             }
//         }
//     }
// }

// import java.util.*;

// public class sorting {
//     public static void printArray(int arr[]) {
//         System.out.println("The sorted array is :");
//         for (int i = 0; i < arr.length; i++) {
//             System.out.print(arr[i] + " ");
//         }
//     }

//     public static void main(String[] args) {
//         {
//             try (Scanner sc = new Scanner(System.in)) {
//                 System.out.println("Enter the size of array :");
//                 int n = sc.nextInt();
//                 int[] arr = new int[n];
//                 System.out.println("Enter the elements of array :");
//                 for (int i = 0; i < n; i++) {
//                     arr[i] = sc.nextInt();
//                 }
//                 // Selection sort
//                 // time complexity O(n^2)
//                 for (int i = 0; i < n - 1; i++) {
//                     int smallest = i;
//                     for (int j = i + 1; j < n; j++) {
//                         if (arr[smallest] > arr[j]) {
//                             smallest = j;
//                         }
//                     }
//                     int temp = arr[i];
//                     arr[i] = arr[smallest];
//                     arr[smallest] = temp;
//                 }
//                 printArray(arr);
//             }
//         }
//     }
// }

//using non-static method
// import java.util.*;
// public class sorting {
//       void printArray(int arr[]) {
//         System.out.println("The sorted array is :");
//         for (int i = 0; i < arr.length; i++) {
//             System.out.print(arr[i] + " ");
//         }
//     }

//     public static void main(String[] args) {
//         {
//             try (Scanner sc = new Scanner(System.in)) {
//                 System.out.println("Enter the size of array :");
//                 int n = sc.nextInt();
//                 int[] arr = new int[n];
//                 System.out.println("Enter the elements of array :");
//                 for (int i = 0; i < n; i++) {
//                     arr[i] = sc.nextInt();
//                 }
//                 // insertion sort
//                 for (int i = 1; i < n; i++) {
//                     int key = arr[i];
//                     int j = i - 1;
//                     while (j >= 0 && arr[j] > key) {
//                         arr[j + 1] = arr[j];
//                         j--;
//                     }
//                     arr[j + 1] = key;
//                 }
//                 sorting obj = new sorting();

//                 obj.printArray(arr);
//             }
//         }
//     }
// }

//using static method
import java.util.*;

public class sorting {
    static void printArray(int arr[]) {
        System.out.println("The sorted array is :");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        {
            try (Scanner sc = new Scanner(System.in)) {
                System.out.println("Enter the size of array :");
                int n = sc.nextInt();
                int[] arr = new int[n];
                System.out.println("Enter the elements of array :");
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
                // insertion sort
                for (int i = 1; i < n; i++) {
                    int key = arr[i];
                    int j = i - 1;
                    while (j >= 0 && arr[j] > key) {
                        arr[j + 1] = arr[j];
                        j--;
                    }
                    arr[j + 1] = key;
                }
                printArray(arr);
            }
        }
    }
}