package DSA.Linked_List;

public class LC_876 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Solution 1: Count approach
    static ListNode middleNode1(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        int mid = count / 2;
        temp = head;
        while (mid > 0) {
            temp = temp.next;
            mid--;
        }
        return temp;
    }

    // Solution 2: Slow and Fast pointers
    static ListNode middleNode2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Display linked list
    static void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);
        head.next.next.next.next.next = new ListNode(60);

        System.out.print("Original List: ");
        display(head);

        ListNode result1 = middleNode1(head);
        ListNode result2 = middleNode2(head);

        System.out.println("Solution 1 Middle: " + result1.val);
        System.out.println("Solution 2 Middle: " + result2.val);
    }
}
