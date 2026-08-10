import java.util.*;

public class LCstring345 {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter a string:");
            String s = sc.nextLine();
            char[] arr = s.toCharArray();
            int left = 0;
            int right = arr.length - 1;
            // two pointer logic
            while (left < right) {

                while (left < right && !isVowel(arr[left])) {
                    left++;
                }

                while (left < right && !isVowel(arr[right])) {
                    right--;
                }

                if (left < right) {
                    char temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;

                    left++;
                    right--;
                }
            }
            System.out.println("After reversing vowels: " + new String(arr));
        }
    }

    public static boolean isVowel(char c) {

        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
