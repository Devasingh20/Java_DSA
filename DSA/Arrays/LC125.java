public class LC125 {
    public static void main(String[] args) {
        String s = "race a car";
        // String s = "A man, a plan, a canal: Panama"
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                System.out.println("not a palindrom!");
                return;
            }

            left++;
            right--;
        }
        System.out.println("is a palindrom.");
    }
}
