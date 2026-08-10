
// public class strings {
//     public static void main(String[] args) {
//         {
//             try (Scanner sc = new Scanner(System.in)) {
//                 System.out.println("Enter the character :");
//                 String s = sc.nextLine();
//                 char ch = s.charAt(0);
//                 int ASCII = ch;
//                 System.out.println("The ascii value of " +  ch  + " is :" + ASCII);
//             }
//         }
//     }
// }

// import java.util.*;

// public class strings {
// public static void main(String[] args) {
// {
// try (Scanner sc = new Scanner(System.in)) {
// System.out.println("Enter your name :");
// String name = sc.nextLine();
// name = name.concat(" singh");
// System.out.println("Hello, " + name + "!");
// String s1 = "apple";
// String s2 = "banana";
// System.out.println(s1.compareTo(s2));
// }
// }
// }
// }

// import java.util.*;

// public class strings {
// public static void main(String[] args) {
// {
// try (Scanner sc = new Scanner(System.in)) {
// System.out.println("Enter your first name :");
// String firstName = sc.nextLine();
// System.out.println("Enter your last name :");
// String lastName = sc.nextLine();
// String fullName = firstName + " " + lastName;
// System.out.println("Hello, " + fullName + "!");
// System.out.println(fullName.length());
// }
// }
// }
// }

// use equals()
// import java.util.*;

// public class strings {
// public static void main(String[] args) {
// {
// try (Scanner sc = new Scanner(System.in)) {
// System.out.println("Enter your name :");
// String name1 = sc.nextLine();
// System.out.println("Enter your name again :");
// String name2 = sc.nextLine();
// if (name1.equals(name2)) {
// System.out.println("Names are equal");
// } else {
// System.out.println("Names are not equal");
// }
// }
// }
// }
// }

// use comparesto()
// public class strings {
// public static void main(String[] args) {
// {
// String s1 = "apple";
// String s2 = "banana";
// System.out.println(s1.compareTo(s2));
// }
// }
// }

// use charat()

// import java.util.Scanner;

// public class strings{
//     public static void main(String[] args) {
//         try(Scanner sc = new Scanner(System.in)){
//             System.out.println("Enter a string :");
//             String s = sc.nextLine();
//             for(int i = 0; i<s.length(); i++){
//                 System.out.println("Character at " + i + " is " + s.charAt(i));
//             }
//         }
//     }
// }

// use substring()
// public class strings{
//     public static void main(String[] args) {
//         {
//             String sentence = "Hello, Welcome to the world of java programming.";
//             System.out.println("Substring from index 7 to end :"+ sentence.substring(7));
//             System.out.println("Substring from index 7 to 13 :"+ sentence.substring(7,14));
//         }
//     }
// }

// use tostring()
// public class strings {
//     public static void main(String[] args) {
//         int num = 12345;
//         String str = Integer.toString(num);
//         System.out.println("The string representation of the number is: " + str);
//     }
// }

// use tolowercase() and touppercase()
// import java.util.*;

// public class strings {
// public static void main(String[] args) {
// {
// try (Scanner sc = new Scanner(System.in)) {
// System.out.println("Enter your name in lowercase :");
// String upperCase = sc.nextLine();
// System.out.println("Uppercase: " + upperCase.toUpperCase());
// System.out.println("Enter your name in upperCase : ");
// String lowerCase = sc.nextLine();
// System.out.println("Lowercase: " + lowerCase.toLowerCase());
// }
// }
// }
// }

// use trim()
// import java.util.*;
// public class strings{
//     public static void main(String[] args) {
//         {
//             try(Scanner sc = new Scanner(System.in)){
//                 System.out.println("Enter a string with leading and trailing space :");
//                 String input = sc.nextLine();
//                 System.out.println("string with leading and trailing space is :"+ input);
//                 String trimmedInput = input.trim();
//                 System.out.println("The trimmed input is :"+ trimmedInput);
//             }
//         }
//     }
// }

// use replace()
// import java.util.*;

// public class strings {
//     public static void main(String[] args) {
//         {
//             try (Scanner sc = new Scanner(System.in)) {
//                 System.out.println("Enter the input string :");
//                 String input = sc.nextLine();
//                 System.out.println("Enter the character for replacement :");
//                 char oldChar = sc.nextLine().charAt(0);
//                 System.out.println("Enter new character :");
//                 char newChar = sc.nextLine().charAt(0);
//                 String replacedString = input.replace(oldChar, newChar);
//                 System.out.println("The new string is : " + replacedString);
//             }
//         }
//     }
// }

//frequency of word
// import java.util.*;
// public class strings {
//     public static void main(String[] args) {
//         {
//             try (Scanner sc = new Scanner(System.in)) {
//                 System.out.println("Enter input string :");
//                 String input = sc.nextLine();
//                 int n = input.length();
//                 int i = 0;
//                 int count = 0;
//                 System.out.println("Enter the string for count :");
//                 String key = sc.nextLine();
//                 while (i < n) {
//                     while (i < n && input.charAt(i) == ' ') {
//                         i++;
//                     }
//                     if (i >= n) {
//                         break;
//                     }
//                     int start = i;
//                     while (i < n && input.charAt(i) != ' ') {
//                         i++;
//                     }
//                     int end = i - 1;
//                     String word = input.substring(start, end + 1);
//                     if (word.equalsIgnoreCase(key)) {
//                         count++;
//                     }
//                 }
//                 System.out.println("The frequency of word\"" + key + "\" = " + count);
//             }
//         }
//     }
// }

// use split() frequency of word
// import java.util.*;

// public class strings {
//     public static void main(String[] args) {
//         {
//             try (Scanner sc = new Scanner(System.in)) {
//                 System.out.println("Enter a sentence :");
//                 String sentence = sc.nextLine();
//                 String[] words = sentence.split(" ");
//                 System.out.println("Enter the string for count :");
//                 String key = sc.nextLine();
//                 System.out.println("The words in the sentence are:");
//                 int count = 0;
//                 for (String word : words) {
//                     System.out.println(word);
//                     if (word.equalsIgnoreCase(key)) {
//                         count++;
//                     }
//                 }
//                 System.out.println("The frequency of word \"" + key + "\" = " + count);
//             }
//         }
//     }
// }
// import java.util.*;
// public class strings {
//     public static void main(String[] args) {
//         String[] word1 = { "leetcode", "is", "amazing", "as", "is" };
//         String[] word2 = { "amazing", "leetcode", "is" };
//         HashSet<String> set = new HashSet<>();
//         for (String word : word1) {
//         set.add(word);
//         }
//         // int count = 0;
//         // for (String word : word2) {
//         // if (set.contains(word)) {
//         // count++;
//         // }
//         // }
//         // System.out.println("The number of common words in both arrays is: " + count);

//         for (String w1 : set) {
//             for (String w2 : word2) {
//                 if (w1.equals(w2)) {
//                     System.out.println(w1);
//                 }
//             }
//         }
//     }
// }

// use concat()
// import java.util.*;

// public class strings {
// public static void main(String[] args) {
// {
// try (Scanner sc = new Scanner(System.in)) {
// System.out.println("Enter your first name :");
// String firstName = sc.nextLine();
// System.out.println("Enter your last name :");
// String lastName = sc.nextLine();
// String fullName = firstName.concat(" ").concat(lastName);
// System.out.println("Hello, " + fullName + "!");
// }
// }
// }
// }

// detection for double and triple spaces
// import java.util.*;

// public class strings {
// public static void main(String[] args) {
// {
// try (Scanner sc = new Scanner(System.in)) {
// System.out.println("Enter a string :");
// String input = sc.nextLine();
// System.out.println("double space is found at index: " + input.indexOf(" "));
// System.out.println("triple space is found at index: " + input.indexOf(" "));
// System.out.println("index of De is : " + input.indexOf("De"));
// }
// }
// }
// }

// public class strings {
// public static void main(String[] args) {

// System.out.println("1. New Line:");
// System.out.println("Hello\nWorld");

// System.out.println("\n2. Tab:");
// System.out.println("Name\tAge");
// System.out.println("Deva\t21");

// System.out.println("\n3. Double Quote:");
// System.out.println("He said, \"Java is easy\"");

// System.out.println("\n4. Single Quote:");
// System.out.println("It\'s Java");

// System.out.println("\n5. Backslash:");
// System.out.println("C:\\Users\\Deva");

// System.out.println("\n6. Backspace:");
// System.out.println("ABC\bD"); // removes C before printing D

// System.out.println("\n7. Carriage Return:");
// System.out.println("Hello\rJava");

// }
// }

// length of string without using length() method
// import java.util.*;

// public class strings {
// public static void main(String[] args) {
// {
// // String str = "Dear sir,\n\tI am Deva Singh.\n\tThank you.";
// // System.out.println(str);
// try (Scanner sc = new Scanner(System.in)) {
// System.out.println("Enter a string :");
// String str = sc.nextLine();
// char[] arr = str.toCharArray();
// int count = 0;
// for (int i = 0; i < arr.length; i++) {
// count++;
// }
// System.out.println("Length of string is : " + count);
// }

// }
// }
// }

// count number of words in a string
// import java.util.Scanner;

// public class strings {
//     public static void main(String[] args) {
//         {
//             try (Scanner sc = new Scanner(System.in)) {
//                 System.out.println("Enter a string :");
//                 String s = sc.nextLine();
//                 String[] arr = s.trim().split("\\s+");
//                 System.out.println("Number of words in the string : " + arr.length);
//             }
//         }
//     }
// }

// count number of words in a string without using split() and trim()
// import java.util.*;

// public class strings {
//     public static void main(String[] args) {
//         try (Scanner sc = new Scanner(System.in)) {
//             System.out.println("Enter a string :");
//             String s = sc.nextLine();
//             int count = 0;
//             boolean inWord = false;
//             for (int i = 0; i < s.length(); i++) {
//                 char ch = s.charAt(i);
//                 if (ch != ' ' && !inWord) {
//                     count++;
//                     inWord = true;
//                 } else if (ch == ' ') {
//                     inWord = false;

//                 }
//             }
//             System.out.println("Number of words in the string : " + count);
//         }
//     }
// }
// import java.util.*;

// public class strings {
//     public static void main(String[] args) {
//         try (Scanner sc = new Scanner(System.in)) {
//             System.out.println("Enter a string : ");
//             String s = sc.nextLine();
//             int count = 0;
//             boolean inWords = false;
//             for (int i = 0; i < s.length(); i++) {
//                 char ch = s.charAt(i);
//                 if (ch != ' ' && !inWords) {
//                     count++;
//                     inWords = true;
//                 } else if (ch == ' ') {
//                     inWords = false;
//                 }
//             }
//             System.out.println("Number of words in the string : " + count);
//         }
//     }
// }

// check palindrome
// import java.util.*;

// public class strings {
//     public static void main(String[] args) {
//         try (Scanner sc = new Scanner(System.in)) {
//             System.out.println("Enter a string :");
//             String s = sc.nextLine();
//             s = s.toLowerCase();
//             int start = 0;
//             int end = s.length() - 1;
//             while (start < end) {
//                 if (s.charAt(end) != s.charAt(start)) {
//                     System.out.println("String is not a palindrom!");
//                     return;
//                 }
//                 start++;
//                 end--;
//             }
//             System.out.println("Yes the string is a palindrom!");
//         }
//     }
// }
// count vowels and consonants
// import java.util.*;

// public class strings {
// public static void main(String[] args) {
// {
// try (Scanner sc = new Scanner(System.in)) {
// System.out.println("Enter a string :");
// String s = sc.nextLine();
// s = s.toLowerCase();
// int vowels = 0;
// int consonants = 0;
// for (int i = 0; i < s.length(); i++) {
// char ch = s.charAt(i);
// if (ch >= 'a' && ch <= 'z') {
// if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
// vowels++;
// } else {
// consonants++;
// }

// }
// }
// System.out.println("Number of vowels: " + vowels);
// System.out.println("Number of consonants: " + consonants);
// }
// }
// }
// }

// count frequency of each character
// import java.util.*;

// public class strings {
//     public static void main(String[] args) {
//         {
//             try (Scanner sc = new Scanner(System.in)) {
//                 System.out.println("Enter a string :");
//                 String s = sc.nextLine();
//                 int[] freq = new int[256];
//                 for (int i = 0; i < s.length(); i++) {
//                     char ch = s.charAt(i);
//                     freq[ch]++;
//                 }
//                 System.out.println("Character frequency:");
//                 for (int i = 0; i < 256; i++) {
//                     if (freq[i] > 0) {
//                         System.out.println((char) i + ": " + freq[i]);
//                     }
//                 }
//             }
//         }
//     }
// }

// first non-repeating character
// import java.util.*;

// public class strings {
// public static void main(String[] args) {
// {
// try (Scanner sc = new Scanner(System.in)) {
// System.out.println("Enter a string :");
// String s = sc.nextLine();
// int[] freq = new int[256];

// for (int i = 0; i < s.length(); i++) {
// char ch = s.charAt(i);
// freq[ch]++;
// }

// for (int i = 0; i < s.length(); i++) {
// char ch = s.charAt(i);
// if (freq[ch] == 1) {
// System.out.println("First non-repeating character is found at index : " + i);
// break;
// }
// }
// System.out.println(-1);
// }
// }
// }
// }

// check anagram
// import java.util.Scanner;

// public class strings {
//     public static void main(String[] args) {
//         try (Scanner sc = new Scanner(System.in)) {
//             System.out.println("Enter first string :");
//             String s1 = sc.nextLine();
//             s1 = s1.toLowerCase();
//             s1 = s1.trim();
//             System.out.println("Enter second string :");
//             String s2 = sc.nextLine();
//             s2 = s2.toLowerCase();
//             s2 = s2.trim();
//             int[] freq = new int[256];
//             if (s1.length() != s2.length()) {
//                 System.out.println("Strings is not an anagram");
//             }
//             for (int i = 0; i < s1.length(); i++) {
//                 char ch = s1.charAt(i);
//                 freq[ch]++;
//             }

//             for (int i = 0; i < s2.length(); i++) {
//                 char ch = s2.charAt(i);
//                 freq[ch]--;
//             }

//             for (int i = 0; i < 256; i++) {
//                 if (freq[i] != 0) {
//                     System.out.println("Strings is not an anagram!");
//                     return;
//                 }
//             }
//             System.out.println("Yes! Strings is an anagram.");
//         }
//     }
// }

// reversed sentence
// import java.util.*;
// public class strings {
// public static void main(String[] args) {
// {
// try (Scanner sc = new Scanner(System.in)) {
// System.out.println("Enter a sentence :");
// String sentence = sc.nextLine();
// String[] words = sentence.split(" ");
// System.out.println("The words in the sentence are:");
// for(int i = words.length-1; i>=0; i--){
// System.out.print(" " + words[i]);
// }
// }
// }
// }
// }

// reversed sentence without using split.
// import java.util.*;

// public class strings {
// public static void main(String[] args) {
// {
// try (Scanner sc = new Scanner(System.in)) {
// System.out.println("Enter a string :");
// String s = sc.nextLine();
// String result = "";
// int i = s.length() - 1;
// while (i >= 0) {
// while (i >= 0 && s.charAt(i) == ' ') {
// i--;
// }
// if (i < 0) {
// break;
// }
// int end = i;
// while (i >= 0 && s.charAt(i) != ' ') {
// i--;
// }
// int start = i + 1;
// for (int j = start; j <= end; j++) {
// result = result + s.charAt(j);
// }
// result = result + " ";
// }
// System.out.println("Reversed sentence is :");
// System.out.println(result);
// }
// }
// }
// }

// import java.util.Scanner;

// public class strings {
// public static void main(String[] args) {

// Scanner sc = new Scanner(System.in);
// System.out.println("Enter a sentence:");
// String s = sc.nextLine();
// int n = s.length();
// int i = 0;
// int maxLen = 0;
// int maxStart = 0;
// while (i < n) {
// // Skip spaces
// while (i < n && s.charAt(i) == ' ') {
// i++;
// }
// if (i >= n)
// break;
// int start = i;
// // Move until space (end of word)
// while (i < n && s.charAt(i) != ' ') {
// i++;
// }
// int end = i - 1;
// int len = end - start + 1;
// if (len > maxLen) {
// maxLen = len;
// maxStart = start;
// }
// }
// // Print longest word
// System.out.print("Longest word is: ");
// for (int j = maxStart; j < maxStart + maxLen; j++) {
// System.out.print(s.charAt(j));
// }
// System.out.println("\nLength: " + maxLen);
// }
// }

// find longest word in a string
// import java.util.*;

// public class strings {
// public static void main(String[] args) {
// {
// try (Scanner sc = new Scanner(System.in)) {
// System.out.println("Enter a strings :");
// String s = sc.nextLine();
// int n = s.length();
// int i = 0;
// int maxLen = 0;
// int maxStr = 0;
// while (i < n) {
// while (i < n && s.charAt(i) == ' ') {
// i++;
// }
// if (i >= n) {
// break;
// }
// int start = i;
// while (i < n && s.charAt(i) != ' ') {
// i++;
// }
// int end = i - 1;
// int len = end - start + 1;
// if (len > maxLen) {
// maxLen = len;
// maxStr = start;
// }
// }
// System.out.print("Longest word is: ");
// for (int j = maxStr; j < maxStr + maxLen; j++) {
// System.out.print(s.charAt(j));
// }
// System.out.println("\nLenght is " + maxLen);
// }
// }
// }
// }
// import java.util.*;

// public class strings {
//     public static void main(String[] args) {
//         try (Scanner sc = new Scanner(System.in)) {
//             System.out.println("Enter a sentence :");
//             String s = sc.nextLine();
//             int n = s.length();
//             int i = 0;
//             int maxLen = 0;
//             int maxStr = 0;
//             while (i < n) {
//                 while (i < n && s.charAt(i) == ' ') {
//                     i++;
//                 }

//                 if (i >= n) {
//                     break;
//                 }

//                 int start = i;
//                 while (i < n && s.charAt(i) != ' ') {
//                     i++;
//                 }

//                 int end = i - 1;
//                 int len = end - start + 1;
//                 if (len > maxLen) {
//                     maxLen = len;
//                     maxStr = start;
//                 }
//             }
//             System.out.println("The word with maximum length is :");
//             for (int j = maxStr; j < maxLen + maxStr; j++) {
//                 System.out.print(s.charAt(j));
//             }
//             System.out.println("\nLenght is " + maxLen);
//         }
//     }
// }

// reverse vowels of a string
// import java.util.*;

// public class strings {
// public static void main(String[] args) {

// try (Scanner sc = new Scanner(System.in)) {
// System.out.println("Enter a string:");
// String s = sc.nextLine();
// char[] arr = s.toCharArray();
// int left = 0;
// int right = arr.length - 1;
// // two pointer logic
// while (left < right) {

// while (left < right && !isVowel(arr[left])) {
// left++;
// }

// while (left < right && !isVowel(arr[right])) {
// right--;
// }

// if (left < right) {
// char temp = arr[left];
// arr[left] = arr[right];
// arr[right] = temp;

// left++;
// right--;99
// }
// }
// System.out.println("After reversing vowels: " + new String(arr));
// }
// }

// public static boolean isVowel(char c) {

// return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
// c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
// }
// }



//258
// public class strings {
//     public static void main(String[] args) {
//         int num = 14329756;
//         int sum;
//         while (num >= 10) {
//             sum = 0;
//             while (num > 0) {
//                 sum = sum + num % 10;
//                 num = num / 10;
//             }
//             num = sum;
//         }
//         System.out.println(num);
//     }
// }


//412
// import java.util.Scanner;

// public class strings {
//     public static void main(String[] args) {
//         try (Scanner sc = new Scanner(System.in)) {
//             System.out.println("Enter a number :");
//             int n = sc.nextInt();
//             String[] arr = new String[n];
//             for (int i = 0; i < n; i++) {
//                 if ((i + 1) % 3 == 0 && (i + 1) % 5 == 0) {
//                     arr[i] = "fizzBuzz";
//                 } else if ((i + 1) % 3 == 0) {
//                     arr[i] = "fizz";
//                 } else if ((i + 1) % 5 == 0) {
//                     arr[i] = "buzz";
//                 } else {
//                     arr[i] = String.valueOf(i + 1);
//                 }
//             }
//             for (int i = 0; i < n; i++) {
//                 System.out.println(arr[i]);
//             }
//         }
//     }
// }



//728
import java.util.ArrayList;
import java.util.List;

public class strings {
    public static void main(String[] args) {
        int left = 47;
        int right = 85;
        List<Integer> ans = new ArrayList<>();
        for (int num = left; num <= right; num++) {
            int temp = num;
            boolean valid = false;
            while (temp > 0) {
                int digit = temp % 10;
                if (digit == 0) {
                    valid = false;
                    break;
                } else if (num % digit != 0) {
                    valid = false;
                    break;
                } else {
                    temp = temp / 10;
                }
                valid = true;
            }
            if (valid) {
                ans.add(num);
            }

        }
        System.out.println(ans);
    }
}