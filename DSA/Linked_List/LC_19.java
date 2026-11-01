
package DSA.Linked_List;

// LeetCode 19: Remove Nth Node From End of List
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

public class LC_19 {

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

        public ListNode removeNthFromEnd(ListNode head, int n) {

            ListNode pre = head;
            int count = 0;

            // Step 1: Count total nodes
            while (pre != null) {
                count++;
                pre = pre.next;
            }

            // Step 2: Calculate steps to previous node
            int steps = count - n - 1;

            // Step 3: Handle deletion of head
            if (steps < 0) {
                return head.next;
            }

            // Step 4: Reset pointer
            pre = head;

            // Step 5: Reach the previous node
            while (steps > 0) {
                steps--;
                pre = pre.next;
            }

            // Step 6: Remove the target node
            pre.next = pre.next.next;

            return head;
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
        // 1 -> 2 -> 3 -> 4 -> 5

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2;

        System.out.println("Original Linked List:");
        printList(head);

        Solution obj = new Solution();

        head = obj.removeNthFromEnd(head, n);

        System.out.println("\nAfter Removing " + n + "nd Node From End:");
        printList(head);
    }
}
