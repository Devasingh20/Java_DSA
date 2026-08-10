import java.util.Scanner;

public class IPClassFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter IP Address: ");
        String ip = sc.next();

        int first = 0;
        int i = 0;

        // Extract first octet
        while (i < ip.length() && ip.charAt(i) != '.') {
            first = first * 10 + (ip.charAt(i) - '0');
            i++;
        }

        // Determine class
        if (first >= 1 && first <= 126) {
            System.out.println("IP Class: A");
        } else if (first >= 128 && first <= 191) {
            System.out.println("IP Class: B");
        } else if (first >= 192 && first <= 223) {
            System.out.println("IP Class: C");
        } else if (first >= 224 && first <= 239) {
            System.out.println("IP Class: D");
        } else {
            System.out.println("IP Class: E");
        }

        sc.close();
    }
}

