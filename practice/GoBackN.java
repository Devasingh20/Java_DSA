import java.util.Scanner;

public class GoBackN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total number of frames: ");
        int total = sc.nextInt();

        System.out.print("Enter window size: ");
        int window = sc.nextInt();

        int i = 1;

        while (i <= total) {
            System.out.println("\nSending frames:");
            for (int j = 0; j < window && (i + j) <= total; j++) {
                System.out.println("Frame " + (i + j) + " sent");
            }

            System.out.print("Enter last successfully received frame: ");
            int ack = sc.nextInt();

            if (ack < i) {
                System.out.println("Error! Resending from Frame " + i);
            } else {
                i = ack + 1;
            }
        }

        System.out.println("All frames transmitted successfully!");
    }
}