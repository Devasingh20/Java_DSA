public class LC1009 {
    public static void main(String[] args) {
        int num = 10;
        int ans = 0;
        int temp = num;
        for (int i = 0; temp > 0; i++) {
            int bit = (num & (1 << i)) >>> i;
            if (bit == 0) {
                ans = ans | (1 << i);
            }
            temp = temp >> 1;
        }
        if (num == 0) {
            ans = 1;
        }
        System.out.println(ans);
        System.out.println(Integer.toBinaryString(ans));
    }
}
