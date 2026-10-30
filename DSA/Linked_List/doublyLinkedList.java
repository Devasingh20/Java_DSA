package DSA.Linked_List;

public class doublyLinkedList {

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    static class linkedList {
        private Node head;
        private Node tail;
        private int size;

        // Insert at the beginning
        public void addFirst(int data) {
            Node node = new Node(data);

            if (head == null) {
                head = tail = node;
            } else {
                node.next = head;
                head.prev = node;
                head = node;
            }

            size++;
        }

        // Insert at the end
        public void addLast(int data) {
            Node node = new Node(data);

            if (tail == null) {
                head = tail = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }

            size++;
        }

        // Insert at a specific index
        public void add(int index, int data) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException();
            }

            if (index == 0) {
                addFirst(data);
                return;
            }

            if (index == size) {
                addLast(data);
                return;
            }

            Node previous = head;

            for (int i = 0; i < index - 1; i++) {
                previous = previous.next;
            }

            Node node = new Node(data);
            Node nextNode = previous.next;

            node.prev = previous;
            node.next = nextNode;

            previous.next = node;
            nextNode.prev = node;

            size++;
        }

        // Delete the first node
        public int removeFirst() {
            if (head == null) {
                throw new IllegalStateException("List is empty");
            }

            int removed = head.data;

            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }

            size--;
            return removed;
        }

        // Delete the last node
        public int removeLast() {
            if (tail == null) {
                throw new IllegalStateException("List is empty");
            }

            int removed = tail.data;

            if (head == tail) {
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }

            size--;
            return removed;
        }

        // Delete a node at a specific index
        public int remove(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }

            if (index == 0) {
                return removeFirst();
            }

            if (index == size - 1) {
                return removeLast();
            }

            Node target = head;

            for (int i = 0; i < index; i++) {
                target = target.next;
            }

            Node previous = target.prev;
            Node nextNode = target.next;

            previous.next = nextNode;
            nextNode.prev = previous;

            size--;
            return target.data;
        }

        // Find the index of a value
        public int indexOf(int target) {
            Node current = head;
            int index = 0;

            while (current != null) {
                if (current.data == target) {
                    return index;
                }

                current = current.next;
                index++;
            }

            return -1;
        }

        // Return the size
        public int sizeOf() {
            return size;
        }

        // Check whether the list is empty
        public boolean ioEmpty() {
            return head == null;
        }

        // Display from head to tail
        public void display() {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }

            Node current = head;

            while (current != null) {
                System.out.print(current.data + " <-> ");
                current = current.next;
            }

            System.out.println("null");
        }

        // Display from tail to head
        public void displayBackward() {
            if (tail == null) {
                System.out.println("List is empty");
                return;
            }

            Node current = tail;

            while (current != null) {
                System.out.print(current.data + " <-> ");
                current = current.prev;
            }

            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        linkedList list = new linkedList();

        list.addFirst(20);
        list.display();

        list.addFirst(10);
        list.display();

        list.addLast(40);
        list.display();

        list.add(2, 30);
        list.display();
        // 10 <-> 20 <-> 30 <-> 40 <-> null

        System.out.println("Forward traversal:");
        list.display();

        System.out.println("Backward traversal:");
        list.displayBackward();
        // 40 <-> 30 <-> 20 <-> 10 <-> null

        System.out.println("Delete: " + list.remove(3));
        list.display();
        // 10 <-> 20 <-> 30 <-> null

        System.out.println("Size: " + list.sizeOf()); // 3
        System.out.println("Index of 30: " + list.indexOf(30)); // 2

        System.out.println("Delete first: " + list.removeFirst());
        list.display();
        // 20 <-> 30 <-> null

        System.out.println("Delete last: " + list.removeLast());
        list.display();
        // 20 <-> null

        System.out.println("Delete: " + list.remove(0));
        list.display();
        // List is empty

        System.out.println("Is empty: " + list.ioEmpty()); // true
    }
}
