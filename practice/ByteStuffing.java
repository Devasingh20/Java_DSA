public class ByteStuffing {

    // Sender side: stuffing
    public static String stuffData(String data) {
        String DLE = "DLE";
        String STX = "STX";
        String ETX = "ETX";

        String result = DLE + STX; // start frame

        for (int i = 0; i < data.length(); i++) {
            // Check if substring "DLE" appears
            if (i + 2 < data.length() && data.substring(i, i + 3).equals(DLE)) {
                result += DLE; // extra DLE (stuffing)
            }
            result += data.charAt(i);
        }

        result += DLE + ETX; // end frame
        return result;
    }

    // Receiver side: destuffing
    public static String destuffData(String frame) {
        String DLE = "DLE";

        String data = frame.substring(6, frame.length() - 6);
        String result = "";

        for (int i = 0; i < data.length(); i++) {
            if (i + 5 < data.length() && data.substring(i, i + 6).equals("DLEDLE")) {
                result += DLE;
                i += 5; // skip both DLEs
            } else {
                result += data.charAt(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String data = "ABCDLEFG";

        String stuffed = stuffData(data);
        System.out.println("Stuffed Frame: " + stuffed);

        String destuffed = destuffData(stuffed);
        System.out.println("Original Data: " + destuffed);
    }
}