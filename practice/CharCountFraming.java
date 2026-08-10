import java.util.*;

public class CharCountFraming {

    // Sender side: add count
    public static String charCountEncode(String data) {
        int count = data.length();
        return count + "|" + data;
    }

    // Receiver side: extract data
    public static String charCountDecode(String data) {
        int pos = data.indexOf('|');
        int count = Integer.parseInt(data.substring(0, pos));
        return data.substring(pos + 1, pos + 1 + count);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a string to send: ");
            String input = sc.nextLine();
            String encoded = charCountEncode(input);
            System.out.println("Encoded frame: " + encoded);

            String decoded = charCountDecode(encoded);
            System.out.println("Decoded string: " + decoded);
        }
    }
}