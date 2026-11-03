package DSA.Linked_List;

public class LC_202 {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(isHappy(n));
    }

    static boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (slow != fast);
        return slow == 1;
    }

    static int findSquare(int n) {
        int ans = 0;
        while (n > 0) {
            int rem = n % 10;
            ans += rem * rem;
            n = n / 10;
        }
        return ans;
    }
}
