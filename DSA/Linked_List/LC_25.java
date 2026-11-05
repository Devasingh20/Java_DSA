package DSA.Linked_List;

public class LC_25 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    static ListNode reverseKGroup(ListNode head, int k) {

        if (k <= 1 || head == null) {
            return head;
        }

        ListNode prev = null;
        ListNode pres = head;

        while (pres != null) {

            ListNode leftprev = prev;
            ListNode newEnd = pres;

            // Check whether k nodes are available
            ListNode temp = pres;
            int count = 0;

            while (temp != null && count < k) {
                temp = temp.next;
                count++;
            }

            // Leave the incomplete group unchanged
            if (count < k) {
                break;
            }

            // Reverse k nodes
            ListNode next = pres.next;

            for (int i = 0; pres != null && i < k; i++) {

                pres.next = prev;
                prev = pres;
                pres = next;

                if (next != null) {
                    next = next.next;
                }
            }

            // Reconnect the reversed group
            if (leftprev != null) {
                leftprev.next = prev;
            } else {
                head = prev;
            }

            newEnd.next = pres;

            // Move prev to the tail of the reversed group
            prev = newEnd;
        }

        return head;
    }

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

        head = reverseKGroup(head, k);

        System.out.println("After Reversing in Groups of " + k + ":");
        display(head);
    }
}
