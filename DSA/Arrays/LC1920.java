public class LC1920 {
    public static void main(String[] args) {
        int[] arr = {0,2,1,5,3,4};
        int n = arr.length;
        for(int i = 0;i<n;i++){
            System.out.println(arr[arr[i]]);
        }
    }
}
