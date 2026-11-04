package DSA.Linked_List;

public class LC_206 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode pres = head;
        ListNode next = pres.next;

        // ListNode oldHead = head;

        while (pres != null) {

            pres.next = prev;

            prev = pres;
            pres = next;

            if (next != null) {
                next = next.next;
            }
        }

        head = prev;
        // ListNode tail = oldHead;

        return head;
    }

    static void printList(ListNode head) {

        ListNode current = head;

        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        // Creating linked list: 10 -> 20 -> 30 -> 40 -> null
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);

        System.out.println("Original Linked List:");
        printList(head);

        head = reverseList(head);

        System.out.println("After Reversing:");
        printList(head);
    }
}
