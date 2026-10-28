package DSA.Linked_List;

public class Main {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedList {
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

            Node node = new Node(data);
            node.next = previous.next;
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
            Node previous = head;
            while (previous.next != tail) {
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

            Node previous = head;
            for (int i = 0; i < index - 1; i++) {
                previous = previous.next;
            }
            Node target = previous.next;
            previous.next = target.next;

            if (target == tail) {
                tail = previous;
            }
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
        LinkedList list = new LinkedList();
        
        list.addFirst(20);
        list.addFirst(10);
        list.addLast(40);
        list.add(2, 30);

        list.display();
        // 10 -> 20 -> 30 -> 40 -> null

        System.out.println(list.sizeOf()); // 4
        System.out.println(list.indexOf(30)); // 2

        list.removeFirst();
        list.removeLast();
        list.remove(1);

        list.display();
        // 20 -> null
    }
}
