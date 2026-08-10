// package DSA.operators;

import java.util.Scanner;

public class LC412 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter a number :");
            int n = sc.nextInt();
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                if ((i + 1) % 3 == 0 && (i + 1) % 5 == 0) {
                    arr[i] = "fizzBuzz";
                } else if ((i + 1) % 3 == 0) {
                    arr[i] = "fizz";
                } else if ((i + 1) % 5 == 0) {
                    arr[i] = "buzz";
                } else {
                    arr[i] = String.valueOf(i + 1);
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.println(arr[i]);
            }
        }
    }

}
