package DSA.Linked_List;

public class LinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    static class linkedList {
        private Node head;
        private Node tail;
        private int size;

        public void addFirst(int data) {
            Node node = new Node(data);

            node.next = head;
            head = node;

            if (tail == null) {
                tail = head;
            }
            size++;
        }

        public void addLast(int data) {
            Node node = new Node(data);

            if (head == null) {
                tail = node;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            size++;
        }

        public void add(int index, int data) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException();
            }
            if (index == 0) {
                addFirst(data);
            }
            if (index == size) {
                addLast(data);
            }

            Node previous = head;
            for (int i = 0; i < index - 1; i++) {
                previous = previous.next;
            }

            Node node = new Node(data, previous.next);
            // node.next = previous.next;
            previous.next = node;
            size++;
        }

        public int removeFirst() {
            if (head == null) {
                throw new IllegalStateException("List is emoty");
            }
            int removed = head.data;
            head = head.next;

            if (head == null) {
                tail = null;
            }
            size--;
            return removed;
        }

        public int removeLast() {
            if (head == null) {
                throw new IllegalStateException("List is emoty");
            }
            if (head == tail) {
                return removeFirst();
            }
            // Node previous = head;
            // while (previous.next != tail) {
            // previous = previous.next;
            // }

            // We use size - 2 because we need to reach the second-last node.
            // Starting from head (index 0), the second-last node is at index size - 2.
            // For example, if size = 4, we need 2 moves to reach node at index 2.
            // Once previous reaches the second-last node, we can disconnect the last node
            // using previous.next = null and update tail = previous.
            Node previous = head;
            for (int i = 0; i < size - 2; i++) {
                previous = previous.next;
            }
            int removed = tail.data;
            previous.next = null;
            tail = previous;
            size--;

            return removed;
        }

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

            Node previous = head;

            for (int i = 0; i < index - 1; i++) {
                previous = previous.next;
            }

            Node target = previous.next;
            previous.next = target.next;

            size--;
            return target.data;
        }

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

        public int sizeOf() {
            return size;
        }

        public boolean ioEmpty() {
            return head == null;
        }

        public void display() {
            Node current = head;

            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
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
        // 10 -> 20 -> 30 -> 40 -> null

        System.out.println("Delete : " + list.remove(3));
        list.display();

        System.out.println(list.sizeOf()); // 3
        System.out.println(list.indexOf(30)); // 2

        System.out.println("Delete : " + list.removeFirst());
        list.display();

        System.out.println("Delete : " + list.removeLast());
        list.display();

        System.out.println("Delete : " + list.remove(0));
        list.display();
        //  null
    }
}
