public class count_zeros {
    public static void main(String[] args) {
        int ans = countZeros(304020000, 0);
        System.out.println(ans);
    }

    static int countZeros(int n, int count) {
        if (n == 0) {
            return count;
        }
        int rem = n % 10;
        if (rem == 0) {
           return countZeros(n / 10, count + 1);
        }
        return countZeros(n / 10, count);
    }
}
