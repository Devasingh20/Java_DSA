package DSA.Linked_List;

public class LC_234 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find middle
        ListNode mid = middleNode(head);

        // Step 2: Reverse second half
        ListNode secondHead = reverseList(mid);

        // Step 3: Compare both halves
        ListNode firstHead = head;

        while (secondHead != null) {

            if (firstHead.val != secondHead.val) {
                return false;
            }

            firstHead = firstHead.next;
            secondHead = secondHead.next;
        }

        return true;
    }

    // Find middle using slow and fast pointers
    static ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Reverse linked list iteratively
    static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Display linked list
    static void printList(ListNode head) {

        ListNode current = head;

        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        // Creating linked list: 1 -> 2 -> 2 -> 1 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println("Original Linked List:");
        printList(head);

        boolean result = isPalindrome(head);

        System.out.println("Is Palindrome: " + result);
    }
}
