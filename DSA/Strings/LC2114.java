public class LC2114 {
    public static void main(String[] args) {
        String[] sentences = { "alice and bob love leetcode", "i think so too", "this is great thanks very much" };
        int max = 0;
        for (String s : sentences) {
            int word = 1;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ') {
                    word++;
                }
            }
            max = Math.max(max, word);
        }
        System.out.println("Max words in a sentence: " + max);
    }
}
