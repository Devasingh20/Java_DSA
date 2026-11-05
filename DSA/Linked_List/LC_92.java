package DSA.Linked_List;

public class LC_92 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        // ListNode(int val, ListNode next) {
        // this.val = val;
        // this.next = next;
        // }
    }

    static ListNode reverseBetween(ListNode head, int left, int right) {

        if (left == right) {
            return head;
        }

        ListNode prev = null;
        ListNode pres = head;

        // Skip the first left - 1 elements
        for (int i = 0; pres != null && i < left - 1; i++) {
            prev = pres;
            pres = pres.next;
        }

        ListNode leftpre = prev;
        ListNode newEnd = pres;

        // Reverse the selected portion
        ListNode next = pres.next;

        for (int i = 0; pres != null && i < right - left + 1; i++) {

            pres.next = prev;

            prev = pres;
            pres = next;

            if (next != null) {
                next = next.next;
            }
        }

        // Connect the left portion
        if (leftpre != null) {
            leftpre.next = prev;
        } else {
            head = prev;
        }

        // Connect the right portion
        newEnd.next = pres;

        return head;
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

        // Creating linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int left = 2;
        int right = 4;

        System.out.println("Original Linked List:");
        printList(head);

        head = reverseBetween(head, left, right);

        System.out.println("After Reversing from position "
                + left + " to " + right + ":");

        printList(head);
    }
}
