public class sumOfDigits {
    public static void main(String[] args) {
        long n = 123456789987654321L;
        long ans = digitSum(n);
        System.out.println(ans);
    }
    static long digitSum(long n){
        if(n==0){
            return 0;
        }
        return n%10 + digitSum(n/10);
    }
}
