package DSA.Linked_List;

public class LC_143 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    static void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }
        
        ListNode mid = getMid(head);

        // Reverse the second half
        ListNode hs = reverse(mid.next);
        mid.next = null;

        ListNode hf = head;

        // Rearrange the two halves
        while (hf != null && hs != null) {

            ListNode temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }
    }

    static ListNode getMid(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    static ListNode reverse(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode pres = head;
        ListNode next = pres.next;

        while (pres != null) {

            pres.next = prev;
            prev = pres;
            pres = next;

            if (next != null) {
                next = next.next;
            }
        }

        return prev;
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

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        display(head);

        reorderList(head);

        System.out.println("Reordered List:");
        display(head);
    }
}
