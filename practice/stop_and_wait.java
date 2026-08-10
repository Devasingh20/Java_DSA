import java.util.Scanner;

public class stop_and_wait {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of frames: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Sending Frame " + i);
            System.out.print("Did receiver receive frame " + i + "? (yes/no): ");
            String ack = sc.next();

            if (ack.equalsIgnoreCase("yes")) {
                System.out.println("ACK received for Frame " + i);
            } else {
                System.out.println("Resending Frame " + i);
                i--; // resend same frame
            }
        }

        System.out.println("All frames sent successfully!");
    }
}
