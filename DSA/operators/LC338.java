public class LC338 {
    public static void main(String[] args) {
        int n = 5;
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            // int num = i;
            // int count = 0;
            // while (num > 0) {
            //     num = num & (num - 1);
            //     count++;
            // }
            ans[i] = Integer.bitCount(i);
        }
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]);
        }
    }
}
