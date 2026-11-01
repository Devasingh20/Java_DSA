
package DSA.Linked_List;

public class LC_203 {

    // Node class
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        // ListNode(int val, ListNode next) {
        //     this.val = val;
        //     this.next = next;
        // }
    }

    // Solution class
    static class Solution {

        public ListNode removeElements(ListNode head, int val) {

            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            ListNode pre = dummy;
            ListNode curr = head;

            while (curr != null) {

                if (curr.val == val) {
                    pre.next = curr.next;
                    curr = curr.next;

                } else {
                    pre = pre.next;
                    curr = curr.next;
                }
            }

            return dummy.next;
        }
    }

    // Display linked list
    static void printList(ListNode head) {

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) {

        // Creating linked list: 1 -> 2 -> 6 -> 3 -> 6 -> 4 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(4);

        int val = 6;

        System.out.println("Original Linked List:");
        printList(head);

        Solution solution = new Solution();

        head = solution.removeElements(head, val);

        System.out.println("After Removing " + val + ":");
        printList(head);
    }
}
