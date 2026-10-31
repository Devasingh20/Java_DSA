package DSA.Linked_List;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
public class LC_83 {

    // Linked List Node
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // Your LeetCode Solution
    static class Solution {

        public ListNode deleteDuplicates(ListNode head) {

            if (head == null) {
                return head;
            }

            ListNode node = head;

            while (node.next != null) {

                if (node.val == node.next.val) {
                    node.next = node.next.next;
                } else {
                    node = node.next;
                }
            }

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

        // Creating Linked List: 1 -> 1 -> 1 -> 2 -> 2 -> 4 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(4);

        System.out.println("Original Linked List:");
        printList(head);

        Solution obj = new Solution();

        head = obj.deleteDuplicates(head);

        System.out.println("After Removing Duplicates:");
        printList(head);
    }
}
