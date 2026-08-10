public class LC191 {
    public static void main(String[] args) {
        int num = 6;
        int count = 0;
        while (num > 0) {
            num = num & (num - 1);
            count++;
        }
        System.out.println("The number of 1 bit is " + count);
    }
}