package DSA.Linked_List;

public class BubbleSort {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // get reference by index
    ListNode getReference(ListNode head, int index) {
        ListNode temp = head;
        for (int i = 0; i < index; i++) {
            if (temp != null) {
                temp = temp.next;
            } else {
                return null; // Index out of bounds
            }
        }
        return temp;
    }

    // Main function: Sort Linked List
    ListNode BS(ListNode head, ListNode tail, int row, int col) {
        // Base condition
        if (row == 0) {
            return head;
        }
        if (row > col) {
            ListNode first = getReference(head, col);
            ListNode second = getReference(head, col + 1);
            if (first.val > second.val) {
                if (first == head) {
                    first.next = second.next;
                    second.next = first;
                    head = second;
                } else if (second == tail) {
                    ListNode pre = getReference(head, col - 1);
                    pre.next = second;
                    tail = first;
                    tail.next = null;
                    second.next = tail;
                } else {
                    ListNode pre = getReference(head, col - 1);
                    pre.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            head = BS(head, tail, row, col + 1);
        } else {
            head = BS(head, tail, row - 1, 0);
        }
        return head;
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

        BubbleSort obj = new BubbleSort();

        // Input: 10 -> 5 -> 3 -> 8 -> 2
        int size = 0;
        ListNode head = new ListNode(10);
        size++;
        head.next = new ListNode(5);
        size++;
        head.next.next = new ListNode(3);
        size++;
        head.next.next.next = new ListNode(8);
        size++;
        head.next.next.next.next = new ListNode(2);
        size++;

        ListNode tail = head.next.next.next.next;
        System.out.println("Original Linked List:");
        display(head);

        // Sort linked list
        head = obj.BS(head, tail, size - 1, 0);

        System.out.println("Sorted Linked List:");
        display(head);
    }
}
