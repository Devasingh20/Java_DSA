//bruteForce approach. O(n) time complexity.
// public class factors {
//     public static void main(String[] args) {
//         int num = 20;
//         factors1(num);
//     }

//     static void factors1(int num) {
//         for (int i = 1; i <= num; i++) {
//             if (num % i == 0) {
//                 System.out.print(i + " ");
//             }
//         }
//     }
// }

//O(sqrt(n)) time complexity.
public class factors {
    public static void main(String[] args) {
        int num = 20;
        factors1(num);
    }

    static void factors1(int num) {
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                System.out.print(i + " " + num / i + " ");
            }
        }
    }
}