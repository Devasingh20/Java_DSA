public class productsOfDigit {
    public static void main(String[] args) {
        int n = 959595;
        int ans = digitProduct(n);
        System.out.println(ans);
    }
    static int digitProduct(int n){
        if(n<10){
            return n;
        }
        return n%10 * digitProduct(n/10);
    }
}
