
// package DSA.Strings;
// public class LCstring28 {
//     public static void main(String[] args) {
//         String haystack = "sadbutsad";
//         String needle = "but";
//         int n = haystack.length();
//         int m = needle.length();
//         for (int i = 0; i <= n - m; i++) {
//             int j = 0;
//             while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
//                 j++;
//             }
//             if (j == m) {
//                 System.out.println("needle found at index: " + i);
//                 return;
//             }
//         }
//         System.out.println(-1);
//     }
// }


//two pointer and sliding window approach.
public class LCstring28 {
    public static void main(String[] args) {
        String haystack = "Deva singh";
        String needle = "singh";
        int n = haystack.length();
        int m = needle.length();
        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}