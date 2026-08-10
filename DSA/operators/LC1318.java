public class LC1318 {
    public static void main(String[] args) {
        int a = 2;
        int b = 6;
        int c = 5;
        int flips = 0;
        for (int i = 0; i < 32; i++) {
            int bitA = (a & (1 << i)) >>> i;
            int bitB = (b & (1 << i)) >>> i;
            int bitC = (c & (1 << i)) >>> i;
            if (bitC == 0) {
                flips += bitA + bitB;
            }
            if (bitC == 1) {
                flips += (bitA == 0 && bitB == 0) ? 1 : 0;
            }
        }
        System.out.println(flips);
    }
}
