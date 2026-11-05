package DSA.Linked_List;

public class LC_61 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    static ListNode rotateRight(ListNode head, int k) {

        if (k <= 0 || head == null || head.next == null) {
            return head;
        }

        // Calculate length and find the tail
        ListNode tail = head;
        int length = 1;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Avoid unnecessary rotations
        k = k % length;

        if (k == 0) {
            return head;
        }

        // Make the list circular
        tail.next = head;

        // Find the new tail
        int rotations = length - k;

        ListNode newTail = head;

        for (int i = 1; i < rotations; i++) {
            newTail = newTail.next;
        }

        // Find the new head and break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    // Display linked list
    static void display(ListNode head) {

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("END");
    }

    public static void main(String[] args) {

        // Creating linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        System.out.println("Original Linked List:");
        display(head);

        head = rotateRight(head, k);

        System.out.println("After Rotating Right by " + k + " positions:");
        display(head);
    }
}
