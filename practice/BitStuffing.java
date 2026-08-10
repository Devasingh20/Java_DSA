public class BitStuffing {

    // Stuffing function
    public static String bitStuffing(String data) {
        String result = "";
        int count = 0;

        for (int i = 0; i < data.length(); i++) {
            char bit = data.charAt(i);
            result += bit;

            if (bit == '1') {
                count++;
                if (count == 5) {
                    result += '0'; // stuff 0
                    count = 0;
                }
            } else {
                count = 0;
            }
        }
        return result;
    }

    // Destuffing function
    public static String bitDestuffing(String data) {
        String result = "";
        int count = 0;

        for (int i = 0; i < data.length(); i++) {
            char bit = data.charAt(i);
            result += bit;

            if (bit == '1') {
                count++;
                if (count == 5) {
                    i++; // skip stuffed 0
                    count = 0;
                }
            } else {
                count = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String data = "01111110111110";

        System.out.println("Original Data: " + data);

        String stuffed = bitStuffing(data);
        System.out.println("Stuffed Data: " + stuffed);

        String destuffed = bitDestuffing(stuffed);
        System.out.println("Destuffed Data: " + destuffed);
    }
}