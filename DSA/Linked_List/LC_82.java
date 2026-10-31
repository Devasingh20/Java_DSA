
package DSA.Linked_List;

// LeetCode 82: Remove Duplicates from Sorted List II
// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

public class LC_82 {

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

        public ListNode deleteDuplicates(ListNode head) {

            // Dummy node
            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            ListNode prev = dummy;
            ListNode curr = head;

            while (curr != null) {

                // Check whether current value is duplicated
                if (curr.next != null &&
                        curr.val == curr.next.val) {

                    // Skip all nodes having the same value
                    while (curr.next != null &&
                            curr.val == curr.next.val) {

                        curr = curr.next;
                    }

                    // Remove the entire duplicate group
                    prev.next = curr.next;

                } else {

                    // Current value is unique
                    prev = prev.next;
                }

                // Move current pointer forward
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
        // 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        System.out.println("Original Linked List:");
        printList(head);

        Solution obj = new Solution();

        head = obj.deleteDuplicates(head);

        System.out.println("\nAfter Removing All Duplicates:");
        printList(head);
    }
}
