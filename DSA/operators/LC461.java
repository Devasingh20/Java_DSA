public class LC461 {
    public static void main(String[] args) {
        int x = 7;
        int y = 16;
        System.out.println("Hamming distance is : " + Integer.bitCount(x ^ y));
        // manually
        int count = 0;
        int xor = x ^ y;
        while (xor != 0) {
            // int digit = xor % 2;
            // if (digit == 1) {
            // count++;
            // }
            // xor = xor / 2;
            xor = xor & (xor - 1);
            count++;
        }
        System.out.println(count);

        // for finding the highest set bit position
        int num = 22;
        int position = -1;

        while (num > 0) {
            position++;
            num >>= 1;
        }

        System.out.println(position);
    }
}
