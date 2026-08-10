// package Functions.pack1;

import java.util.*;

public class sum1 {
    public static void main(String[] args) {
        int add = sum2();
        System.out.print(add);
    }
    static int sum2() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter first number :");
            int num1 = sc.nextInt();
            System.out.println("Enter 2nd number :");
            int num2 = sc.nextInt();
            int add = num1 + num2;
            System.out.print("Sum is :");
            return add;
            // System.out.println("This will not execute"); //because execution ends when return hits
        }
    }
}