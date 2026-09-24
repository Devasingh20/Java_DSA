public class concepts {
    public static void main(String[] args) {
        Concept(6);
    }

    static int Concept(int n) {
        if (n == 0) {
            return 0;
        }
        System.out.println(n);
        return Concept(n--);
        // Post-decrement passes the original value of n to the recursive call,
        // so n is not actually decreased before the call. This causes infinite
        // recursion.
    }
}
