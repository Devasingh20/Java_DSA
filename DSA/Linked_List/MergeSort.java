package DSA.Linked_List;

public class MergeSort {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // Main function: Sort Linked List
    ListNode sortList(ListNode head) {

        // Base condition
        if (head == null || head.next == null) {
            return head;
        }

        // Find middle and divide the list
        ListNode mid = getmid(head);

        // Recursively sort left and right halves
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        // Merge both sorted halves
        return merge(left, right);
    }

    // Merge two sorted linked lists
    static ListNode merge(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }

            tail = tail.next;
        }

        // Attach remaining nodes
        tail.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }

    // Find middle and split the linked list
    static ListNode getmid(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;

        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Disconnect left and right halves
        if (pre != null) {
            pre.next = null;
        }

        return slow;
    }

    // Display linked list
    static void display(ListNode head) {

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val);

            if (temp.next != null) {
                System.out.print(" -> ");
            }

            temp = temp.next;
        }

        System.out.println(" -> null");
    }

    // Main method
    public static void main(String[] args) {

        MergeSort obj = new MergeSort();

        // Input: 10 -> 5 -> 3 -> 8 -> 2
        ListNode head = new ListNode(10);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(2);

        System.out.println("Original Linked List:");
        display(head);

        // Sort linked list
        head = obj.sortList(head);

        System.out.println("Sorted Linked List:");
        display(head);
    }
}
