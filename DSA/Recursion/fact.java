public class fact {
   public static void main(String[] args) {
    int ans = fact(6);
    System.out.println(ans);
   }
   static int fact(int n){
    if(n<=1){
        return n;
    }
    return n*fact(n-1);
   }
}
