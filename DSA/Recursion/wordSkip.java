public class wordSkip {
    public static void main(String[] args) {
        skip("", "bachapplefagyauia");
        System.out.println(skipWithReturnType("bachapplefagyauia"));
    }

    static void skip(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        boolean starts = up.startsWith("apple");
        if (starts) {
            skip(p, up.substring(5));
        } else {
            skip(p + up.charAt(0), up.substring(1));
        }
    }

    static String skipWithReturnType(String up) {
        if (up.isEmpty()) {
            return "";
        }
        boolean starts = up.startsWith("apple");
        if (starts) {
            return skipWithReturnType(up.substring(5));
        } else {
            return up.charAt(0) + skipWithReturnType(up.substring(1));
        }
    }
}
