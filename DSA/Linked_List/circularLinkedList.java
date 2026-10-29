package DSA.Linked_List;

public class circularLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static class cll {
        private Node head;
        private Node tail;
        private int size;

        public void addFirst(int data) {
            Node node = new Node(data);
            if (head == null) {
                head = tail = node;
                node.next = head;
            } else {
                node.next = head;
                head = node;
                tail.next = head;
            }
            size++;
        }

        public void addLast(int data) {
            Node node = new Node(data);
            if (head == null) {
                head = tail = node;
                node.next = head;
            } else {
                tail.next = node;
                tail = node;
                tail.next = head;
            }
            size++;
        }

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
            node.next = previous.next;
            previous.next = node;
            size++;
        }

        public int removeFirst() {
            if (head == null) {
                throw new IllegalStateException("list is empty");
            }
            int removed = head.data;

            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }

            size--;
            return removed;
        }

        public int removeLast() {
            if (head == null) {
                throw new IllegalStateException("list is empty");
            }
            if (head == tail) {
                return removeFirst();
            }

            Node previous = head;
            for (int i = 0; i < size - 2; i++) {
                previous = previous.next;
            }

            int remove = tail.data;
            tail = previous;
            tail.next = head;
            size--;
            return remove;
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

        public boolean removeByValue(int val) {
            if (head == null) {
                throw new IllegalStateException("list is empty");
            }
            if (head.data == val) {
                removeFirst();
                return true;
            }

            Node previous = head;
            Node current = head.next;

            while (current != head) {
                if (current.data == val) {
                    previous.next = current.next;
                    if (current == tail) {
                        tail = previous;
                    }
                    size--;
                    return true;
                }
                previous = current;
                current = current.next;
            }
            return false;

        }

        public int indexOf(int target) {
            if (head == null) {
                return -1;
            }

            Node current = head;
            int index = 0;

            do {
                if (current.data == target) {
                    return index;
                }

                current = current.next;
                index++;
            } while (current != head);

            return -1;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return head == null;
        }

        // Display each node exactly once
        public void display() {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }

            Node current = head;

            do {
                System.out.print(current.data + " -> ");
                current = current.next;
            } while (current != head);

            System.out.println("(back to head)");
        }
    }

    public static void main(String[] args) {
        cll list = new cll();

        list.addFirst(20);
        list.display();

        list.addFirst(10);
        list.display();

        list.addLast(40);
        list.display();

        list.addLast(50);
        list.display();

        System.out.println("Delete : " + list.removeByValue(50));
        list.display();

        list.add(2, 30);
        list.display();
        // 10 -> 20 -> 30 -> 40 -> null

        System.out.println("Delete : " + list.remove(3));
        list.display();

        System.out.println(list.size()); // 3
        System.out.println(list.indexOf(30)); // 2

        System.out.println("Delete : " + list.removeFirst());
        list.display();

        System.out.println("Delete : " + list.removeLast());
        list.display();

        System.out.println("Delete : " + list.remove(0));
        list.display();
        // null
    }
}
