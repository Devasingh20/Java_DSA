import java.util.*;

public class IPDetails {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter IP Address: ");
        String ip = sc.next();

        String[] parts = ip.split("\\.");

        if (parts.length != 4) {
            System.out.println("Invalid IP format");
            return;
        }

        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[1]);
        int c = Integer.parseInt(parts[2]);
        int d = Integer.parseInt(parts[3]);

        if (a >= 1 && a <= 126) {
            System.out.println("Net ID: " + a);
            System.out.println("Host ID: " + b + "." + c + "." + d);
            System.out.println("Range: " + a + ".0.0.0 to " + a + ".255.255.255");
        } 
        else if (a >= 128 && a <= 191) {
            System.out.println("Net ID: " + a + "." + b);
            System.out.println("Host ID: " + c + "." + d);
            System.out.println("Range: " + a + "." + b + ".0.0 to " + a + "." + b + ".255.255");
        } 
        else if (a >= 192 && a <= 223) {
            System.out.println("Net ID: " + a + "." + b + "." + c);
            System.out.println("Host ID: " + d);
            System.out.println("Range: " + a + "." + b + "." + c + ".0 to " + a + "." + b + "." + c + ".255");
        } 
        else {
            System.out.println("Invalid or unsupported class");
        }

        sc.close();
    }
}