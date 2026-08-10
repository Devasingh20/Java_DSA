
//package Functions.pack1;
//without return type
import java.util.*;

public class sum {
    public static void main(String[] args) {
        sum1();
    }

    static void sum1() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter first number :");
            int num1 = sc.nextInt();
            System.out.println("Enter 2nd number :");
            int num2 = sc.nextInt();
            int add = num1 + num2;
            System.out.println("Sum is :");
            System.out.println(add);
        }

    }
}
