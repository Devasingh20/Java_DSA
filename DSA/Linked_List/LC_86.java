
package DSA.Linked_List;

// LeetCode 86: Partition List
// https://leetcode.com/problems/partition-list/

public class LC_86 {

    // Linked List Node
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Solution
    static class Solution {

        public ListNode partition(ListNode head, int x) {

            ListNode dummy = new ListNode(-1);
            ListNode tail = dummy;

            ListNode pre = head;
            ListNode curr = head;

            // First traversal: Add nodes having value < x
            while (pre != null) {

                if (pre.val < x) {
                    tail.next = new ListNode(pre.val);
                    tail = tail.next;
                }

                pre = pre.next;
            }

            // Second traversal: Add nodes having value >= x
            while (curr != null) {

                if (curr.val >= x) {
                    tail.next = new ListNode(curr.val);
                    tail = tail.next;
                }

                curr = curr.next;
            }

            return dummy.next;
        }
    }

    // Print Linked List
    static void printList(ListNode head) {

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Main Method
    public static void main(String[] args) {

        // Creating Linked List:
        // 1 -> 4 -> 3 -> 2 -> 5 -> 2

        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        int x = 3;

        System.out.println("Original Linked List:");
        printList(head);

        Solution obj = new Solution();

        head = obj.partition(head, x);

        System.out.println("\nPartitioned Linked List:");
        printList(head);
    }
}
