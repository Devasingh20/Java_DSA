// import java.util.Arrays;

// public class varargs {
//     public static void main(String[] args) {
//         fun(2, 4, 6, 8, 10);
//     }

//     static void fun(int... num) {
//         System.out.println(Arrays.toString(num));
//     }
// }

// public class varargs {
//     static int sum(int... nums) {
//         int total = 0;
//         for (int n : nums) {
//             total += n;
//         }
//         return total;
//     }

//     public static void main(String[] args) {
//         System.out.println(sum());
//         System.out.println(sum(7, 5));
//         System.out.println(sum(8, 5, 6));
//         System.out.println(sum(1, 2, 3, 4, 4));
//     }}

// mixed parametres

//     public class varargs {
//         static void student(String name, int... marks) {
//             System.out.println(name);
//             for (int n : marks) {
//                 System.out.print(n + " ");
//             }
//         }

//         public static void main(String[] args) {
//             student("Deva", 95, 70, 65);
//         }
// }