import java.util.*;

public class find_class {
    public static void main(String[] args) {
        {
            try (Scanner sc = new Scanner(System.in)) {
                System.out.println("Enter the IP address :");
                String ip = sc.nextLine();
                String[] parts = ip.split("\\.");
                int firstOctet = Integer.parseInt(parts[0]);
                if (firstOctet >= 1 && firstOctet <= 126) {
                    System.out.println("Class A");
                } else if (firstOctet >= 128 && firstOctet <= 191) {
                    System.out.println("Class B");
                } else if (firstOctet >= 192 && firstOctet <= 223) {
                    System.out.println("Class C");
                } else if (firstOctet >= 224 && firstOctet <= 239) {
                    System.out.println("Class D");
                } else if (firstOctet >= 240 && firstOctet <= 255) {
                    System.out.println("Class E");
                } else {
                    System.out.println("Invalid IP address");
                }
            }
        }
    }
}

// import java.util.*;

// public class find_class {
// public static void main(String[] args) {
// {
// try (Scanner sc = new Scanner(System.in)) {
// System.out.println("Enter a string :");
// String s = sc.nextLine();
// int start = 0;
// int end = s.length() - 1;
// while (start < end) {
// if (s.charAt(start) != s.charAt(end)) {
// System.out.println("Not a palindrome");
// return;
// }
// start++;
// end--;
// }
// System.out.println("It is a palindrome");

// }
// }
// }
// }