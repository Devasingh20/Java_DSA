import java.util.Scanner;

public class LC231 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter a number :");
            int n = sc.nextInt();
            if ((n > 0) && (n & (n - 1)) == 0) {
                System.out.println("Yes, The number is a power of two");
            } else {
                System.out.println("The number is not a power of two");
            }
        }
    }
}


