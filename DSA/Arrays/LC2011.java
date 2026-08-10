public class LC2011 {
    public static void main(String[] args) {
        String[] operations = { "--X", "X++", "X++" };
        int x = 0;
        for (String op : operations) {
            if (op.equals("X++") || op.equals("++X")) {
                x++;
            } else {
                x--;
            }
        }
        System.out.println("Final value of X: " + x);
    }
}
