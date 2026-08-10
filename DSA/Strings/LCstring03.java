// import java.util.*;

// public class LCstring03 {
//     public static void main(String[] args) {
//         {
//             try (Scanner sc = new Scanner(System.in)) {
//                 System.out.println("Enter a string :");
//                 String s = sc.nextLine();
//                 int left = 0;
//                 int maxLen = 0;
//                 HashSet<Character> set = new HashSet<>();
//                 for (int right = 0; right < s.length(); right++) {
//                     while (set.contains(s.charAt(right))) {
//                         set.remove(s.charAt(left));
//                         left++;
//                     }
//                     set.add(s.charAt(right));
//                     maxLen = Math.max(maxLen, right - left + 1);
//                 }
//                 System.out.println("The length of the longest substring without repeating characters is: " + maxLen);
//             }
//         }
//     }
// }

import java.util.HashSet;
import java.util.Scanner;

public class LCstring03 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter a string :");
            String s = sc.nextLine();
            int left = 0;
            int maxLen = 0;
            HashSet<Character> set = new HashSet<>();
            for (int right = 0; right < s.length(); right++) {
                if (set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(s.charAt(right));
                maxLen = Math.max(maxLen, right - left + 1);
            }
            System.out.println("The length of the longest substring without repeating characters is: " + maxLen);
        }
    }
}