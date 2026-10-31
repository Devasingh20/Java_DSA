package DSA.Linked_List;

public class LC_141_142 {
      static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }


    // LC 141: Floyd's algorithm
    static boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    // LC 142: Floyd's algorithm
    static ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        // Create linked list
        ListNode head = new ListNode(10);
        ListNode second = new ListNode(20);
        ListNode third = new ListNode(30);
        ListNode fourth = new ListNode(40);
        ListNode fifth = new ListNode(50);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        // Create cycle: 50 -> 30
        fifth.next = third;

        // LC 141
        System.out.println("LC 141 - Cycle Detection");

        System.out.println(
            "Floyd: " + hasCycle(head)
        );

        // LC 142
        System.out.println("\nLC 142 - Cycle Starting Node");

        ListNode result2 = detectCycle(head);

        System.out.println(
            "Floyd: " +
            (result2 != null ? result2.val : "No Cycle")
        );
    }
}
