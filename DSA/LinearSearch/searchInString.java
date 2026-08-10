// package DSA.LinearSearch;

public class searchInString {
    public static void main(String[] args) {
        String name = "Deva singh";
        char target = 's';
        int ans = linearSearch(name, target);
        System.out.println("Target found at index: " + ans);
    }

    static int linearSearch(String name, char target) {
        if (name.length() == 0) {
            return -1;
        }
        for (int index = 0; index < name.length(); index++) {
            if (name.charAt(index) == target) {
                return index;
            }
        }
        return -1;
    }
}
