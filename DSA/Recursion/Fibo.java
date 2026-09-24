public class Fibo {
    public static void main(String[] args) {
        System.out.println(fibo(50));
    }

    static long fibo(long n) {
        if (n < 2) {
            return n;
        }
       //return fibo(n - 1) + fibo(n - 2);
       return (long) ((1/Math.sqrt(5))*(Math.pow((1 + Math.sqrt(5)) / 2,n)));
    }
}
    
//series
// public class Fibo {
//     public static void main(String[] args) {
//         fibo(6);
//     }

//     static void fibo(int n) {
//         int a = 0;
//         int b = 1;
//         System.out.print(a + " " + b + " ");
//         for (int i = 2; i < n; i++) {
//             int c = a + b;
//             System.out.print(c + " ");
//             a = b;
//             b = c;
//         }
//     }
// }
