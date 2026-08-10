public class LC476 {
    public static void main(String[] args) {
        int num = 13;
        int ans = 0;
        int temp = num;
        for (int i = 0; temp > 0; i++) {
            if ((num & (1 << i)) >>> i == 0) {
                ans = ans | (1 << i);
            }
            temp = temp >> 1;
        }
        System.out.println(ans);
    }
}
