// import java.util.*;

// public class LengthOfLastWord {
//     public static void main(String[] args) {
//         {
//             try (Scanner sc = new Scanner(System.in)) {
//                 System.out.println("Enter the string :");
//                 String s = sc.nextLine();
//                 String result = "";
//                 int i = s.length() - 1;
//                 while (i >= 0) {
//                     while (i >= 0 && s.charAt(i) == ' ') {
//                         i--;
//                     }
//                     if (i < 0) {
//                         break;
//                     }
//                     int end = i;
//                     while (i >= 0 && s.charAt(i) != ' ') {
//                         i--;
//                     }
//                     int start = i + 1;
//                     for (int j = start; j <= end; j++) {
//                         result = result + s.charAt(j);
//                     }
//                     System.out.println("Length of last word is :" + result.length());
//                     return;
//                 }
//             }
//         }
//     }
// }

import java.util.Scanner;

public class LengthOfLastWord {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter a sentence :");
            String s = sc.nextLine();
            int i = s.length() - 1;
            String result = "";
            while (i >= 0) {
                while (i >= 0 && s.charAt(i) == ' ') {
                    i--;
                }
                if (i < 0) {
                    break;
                }
                int end = i;
                while (i >= 0 && s.charAt(i) != ' ') {
                    i--;
                }
                int start = i + 1;
                for (int j = start; j <= end; j++) {
                    result = result + s.charAt(j);
                }
                System.out.println("Length of last word is :" + result.length());
                return;
            }
        }
    }
}