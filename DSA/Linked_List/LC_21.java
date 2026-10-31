package DSA.Linked_List;

public class LC_21 {
    // Node class
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // Solution class
    static class Solution {

        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

            ListNode f = list1;
            ListNode s = list2;

            ListNode dummy = new ListNode(-1);
            ListNode tail = dummy;

            while (f != null && s != null) {

                if (f.val < s.val) {
                    tail.next = new ListNode(f.val);
                    f = f.next;
                } else {
                    tail.next = new ListNode(s.val);
                    s = s.next;
                }

                tail = tail.next;
            }

            while (f != null) {
                tail.next = new ListNode(f.val);
                tail = tail.next;
                f = f.next;
            }

            while (s != null) {
                tail.next = new ListNode(s.val);
                tail = tail.next;
                s = s.next;
            }

            return dummy.next;
        }
    }

    // Display Linked List
    static void display(ListNode head) {

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) {

        // First sorted linked list: 1 -> 3 -> 5
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        // Second sorted linked list: 2 -> 4 -> 6
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        System.out.println("First Linked List:");
        display(list1);

        System.out.println("Second Linked List:");
        display(list2);

        // Calling mergeTwoLists()
        Solution obj = new Solution();

        ListNode result = obj.mergeTwoLists(list1, list2);

        System.out.println("Merged Linked List:");
        display(result);
    }
}
