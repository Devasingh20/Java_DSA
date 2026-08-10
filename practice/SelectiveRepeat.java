import java.util.Scanner;

public class SelectiveRepeat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of frames: ");
        int n = sc.nextInt();

        boolean[] received = new boolean[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Was Frame " + (i + 1) + " received? (true/false): ");
            received[i] = sc.nextBoolean();
        }

        System.out.println("\nRetransmitting lost frames:");
        for (int i = 0; i < n; i++) {
            if (!received[i]) {
                System.out.println("Resending Frame " + (i + 1));
            }
        }

        System.out.println("Transmission complete!");
    }
}