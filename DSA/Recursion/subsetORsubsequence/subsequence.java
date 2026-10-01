// package subsetORsubsequence;

import java.util.ArrayList;

public class subsequence {

    public static void main(String[] args) {
        // Generate subsequences of a String
        subSeq("", "abc");
        // Generate subsequences of an array
        subSeq1("", new int[] { 1, 2, 3 }, 0);
        // generate subsequences of a string using arraylist without passing the list as
        // a parameter
        System.out.println(subseq2("", "abc"));
        // Generate subsequences using three choices:
        // include character, exclude character, or include its ASCII value
        System.out.println(subseqAscii("", "abc"));
    }

    // For String
    static void subSeq(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        // Include current character
        subSeq(p + up.charAt(0), up.substring(1));

        // Exclude current character
        subSeq(p, up.substring(1));
    }

    // For array
    static void subSeq1(String p, int[] arr, int index) {
        if (index == arr.length) {
            System.out.println(p);
            return;
        }
        // Include current element
        subSeq1(p + arr[index], arr, index + 1);

        // Exclude current element
        subSeq1(p, arr, index + 1);
    }

    static ArrayList<String> subseq2(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subseq2(p + ch, up.substring(1));
        ArrayList<String> right = subseq2(p, up.substring(1));
        left.addAll(right);
        return left;
    }

    // Generate subsequences with three choices for each character:
    // 1. Include the character
    // 2. Exclude the character
    // 3. Include the ASCII value of the character
    static ArrayList<String> subseqAscii(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> first = subseqAscii(p + ch, up.substring(1));
        ArrayList<String> second = subseqAscii(p, up.substring(1));
        ArrayList<String> third = subseqAscii(p + (ch + 0), up.substring(1));
        first.addAll(second);
        first.addAll(third);
        return first;
    }
}