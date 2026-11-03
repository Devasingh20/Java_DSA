# Linked List in Java — Complete Guide

A linked list is a linear data structure in which elements, called nodes, are connected using references. Each node stores data and a reference to another node (or to the previous node as well, depending on the type of linked list).

Unlike an array, a linked list does not require its elements to occupy consecutive memory locations.

In Java, linked lists are important for understanding Data Structures and Algorithms (DSA), references, classes, objects, recursion, and time complexity.

We will learn linked lists from the fundamentals to implementation, operations, Java's built-in `LinkedList` class, and interview-level concepts.

## 1. What is a linked list?

Imagine that you want to store these integers:

`10, 20, 30, 40`
<p align="center">
  <img src="images/linkedlist.png" alt="linked list" width="900">
</p>
Each node contains two things:

1. Data — the value stored in the node.
2. Next reference — a reference to the next node.

The first node is called the head, and the last node is called the tail when the list maintains a tail reference.

### Why is it called a linked list?

Because nodes are linked together through references.

The connection is logical rather than requiring the nodes to sit next to each other in memory.

## 2. What is a node in Java?

A node is an object representing one element of a linked list.

For example, a node can be represented using a Java class:

```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
```

Let's understand every line.

### `class Node`

```java
class Node {
}
```

This defines a class named `Node`. It acts as a blueprint for creating node objects.

### `int data`

```java
int data;
```

This instance variable stores the actual integer value of a node.

For example, a node may store `10`.

### `Node next`

```java
Node next;
```

This is the most important part.

- `Node` is the type of the variable.
- `next` is the variable name.
- It stores a reference to another `Node` object.

Notice that `next` is not an `int`. It refers to an object of type `Node`.

This is possible because Java allows a class to contain a reference to an object of its own class. This is called a self-referential class structure.

### Constructor

```java
Node(int data) {
    this.data = data;
    this.next = null;
}
```

When we create a node using:

```java
Node first = new Node(10);
```

Java creates a `Node` object whose `data` is `10` and whose `next` is `null`.

Here:

- `new Node(10)` creates an object.
- `first` stores a reference to that object.
- `this.data` refers to the current object's instance variable.
- `this.next = null` initializes its next reference to `null`.

Because `next` is a reference variable, its default value would already be `null`. We explicitly initialize it here to make the constructor's intention clear.

## 3. How do nodes connect to each other?

Let's create three node objects.

```java
Node first = new Node(10);
Node second = new Node(20);
Node third = new Node(30);
```

Initially, the nodes are independent. Each node's `next` reference is `null`.

Now connect them:

```java
first.next = second;
second.next = third;
```
<p align="center">
  <img src="images/image2.png" alt="linked list" width="900">
</p>
The statements work as follows:

```java
first.next = second;
```

This makes the first node's `next` reference point to the second node.

```java
second.next = third;
```

This makes the second node's `next` reference point to the third node.

**Important:** We are not copying the entire second node into the first node. We are assigning a reference to the second node object.

This is the same reference concept you encounter when working with objects and classes in Java OOP.

### What does `first.next.data` mean?

Consider:

```java
System.out.println(first.data);            // 10
System.out.println(first.next.data);       // 20
System.out.println(first.next.next.data);  // 30
```

Read the expressions from left to right:

- `first.data` — access the data in the first node.
- `first.next.data` — follow the first node's `next` reference, then access that node's data.
- `first.next.next.data` — follow two `next` references, then access the data.

If a reference is `null`, attempting to access a field through it causes a `NullPointerException`.

## 4. Complete linked list implementation in Java

Let's build our own singly linked list rather than using Java's built-in `LinkedList` class. This helps you understand how linked lists actually work.

The following program supports:

- Insertion at the beginning
- Insertion at the end
- Insertion at a particular index
- Deletion from the beginning
- Deletion from the end
- Deletion at a particular index
- Searching for an element
- Getting the size
- Displaying the list

```java
public class Main {

    // Represents one node in the linked list
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // The linked list itself
    static class LinkedList {
        private Node head;
        private Node tail;
        private int size;

        // Insert at the beginning
        public void addFirst(int data) {
            Node node = new Node(data);

            node.next = head;
            head = node;

            if (tail == null) {
                tail = node;
            }

            size++;
        }

        // Insert at the end
        public void addLast(int data) {
            Node node = new Node(data);

            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }

            size++;
        }

        // Insert at a specified index
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

        // Delete from the beginning
        public int removeFirst() {
            if (head == null) {
                throw new IllegalStateException("List is empty");
            }

            int removed = head.data;
            head = head.next;
            size--;

            if (head == null) {
                tail = null;
            }

            return removed;
        }

        // Delete from the end
        public int removeLast() {
            if (head == null) {
                throw new IllegalStateException("List is empty");
            }

            if (head == tail) {
                return removeFirst();
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

        // Delete at a specified index
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

        // Search for a value; return its index or -1
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

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return head == null;
        }

        // Print every node
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

        System.out.println(list.size());       // 4
        System.out.println(list.indexOf(30));  // 2

        list.removeFirst();
        list.removeLast();
        list.remove(1);

        list.display();
        // 20 -> null
    }
}
```

### How the program works

The implementation uses three fields:

```java
private Node head;
private Node tail;
private int size;
```

- `head` references the first node.
- `tail` references the last node.
- `size` records how many nodes exist.

Initially, both `head` and `tail` are `null`, and `size` is `0`.

The `private` modifier prevents other classes from directly changing these fields. This protects the linked list's internal structure.

The `static` nested classes allow us to use `Node` and `LinkedList` from the static `main` method without first creating a `Main` object.

### A. Inserting at the beginning

```java
public void addFirst(int data) {
    Node node = new Node(data);

    node.next = head;
    head = node;

    if (tail == null) {
        tail = node;
    }

    size++;
}
```

Suppose the list is:

`20 -> 30 -> null`

We insert `10`.

<p align="center">
  <img src="images/image3.png" alt="linked list" width="900">
</p>

The key statements are:

```java
node.next = head;
head = node;
```

Why this order? First, preserve the connection to the old list. Then update the head. If you update `head` first, you can lose your easy reference to the old first node before connecting the new node to it.

If the list was empty, the new node becomes both `head` and `tail`.

**Time complexity:** \(O(1)\).

### B. Inserting at the end

```java
tail.next = node;
tail = node;
```

When the list is not empty, `tail` already identifies the last node. Therefore, we can connect the new node directly and update `tail`, without traversing the entire list.

If the list is empty, the new node becomes both `head` and `tail`.

**Time complexity:** \(O(1)\) when a tail reference is maintained.

### C. Inserting at an index

Suppose the list is:

`10 -> 20 -> 40 -> null`

We want to insert `30` at index `2`.

The important statements are:

```java
node.next = previous.next;
previous.next = node;
```

Before insertion, the `next` reference of node `20` points to node `40`.

First, make the new node point to `40`. Then make node `20` point to the new node.

The result is:

`10 -> 20 -> 30 -> 40 -> null`

The order matters because you need to preserve the reference to the rest of the list.

Finding the previous node takes up to \(O(n)\) time, although the pointer changes themselves take \(O(1)\).

### D. Deleting the first node

```java
head = head.next;
```

If the list is:

`10 -> 20 -> 30 -> null`

then `head = head.next` makes `head` reference node `20`.

Node `10` is no longer reachable through the list, so it can eventually be reclaimed by Java's garbage collector if no other references to it remain.

If the list becomes empty, `tail` must also be set to `null`.

**Time complexity:** \(O(1)\).

### E. Deleting the last node

This operation is more interesting.

For the list:

`10 -> 20 -> 30 -> null`

we need to find the node immediately before the tail. In a singly linked list, we cannot move backward from node `30`, because each node only points forward.

We therefore traverse from the head until:

```java
previous.next == tail
```
Then we perform:
```java
previous.next = null;
tail = previous;
```
The new tail is node `20`.
**Time complexity:** \(O(n)\), even though we maintain a tail reference. This is because the singly linked list does not maintain backward references.

### F. Traversing the list

```java
Node current = head;
while (current != null) {
    System.out.println(current.data);
    current = current.next;
}
```
Traversal means visiting nodes one by one.
The variable `current` moves from one node to the next. The loop ends when `current` becomes `null`.
**Important:** Moving `current` does not change `head`. They are separate reference variables.

## 5. How is a linked list stored in memory?
Consider these declarations:
```java
Node first = new Node(10);
Node second = new Node(20);
first.next = second;
```
Conceptually, Java references connect the objects like this:
<p align="center">
  <img src="images/image4.png" alt="linked list" width="900">
</p>

This is a conceptual diagram, not a literal memory layout. The JVM manages object allocation and reference representation.

Three important observations:

1. A reference variable stores a way to access an object, not the entire object itself.
2. Nodes need not occupy consecutive memory addresses.
3. A linked list is connected through references, so the nodes do not need array-style contiguous storage.

Java does not expose ordinary object memory addresses directly through its reference variables.

## 6. Linked List vs Array

| Feature | Array | Linked list |
|---|---|---|
| Access by index | \(O(1)\) | \(O(n)\) |
| Search by value | \(O(n)\) | \(O(n)\) |
| Insert at beginning | \(O(n)\) for shifting | \(O(1)\) |
| Delete at beginning | \(O(n)\) for shifting | \(O(1)\) |
| Insert at end | Usually \(O(1)\) amortized for a dynamic array | \(O(1)\) with a tail reference |
| Delete at end | \(O(1)\) for a typical dynamic array | \(O(n)\) for a singly linked list |
| Extra memory | Usually lower per element | Extra reference fields per node |
| Cache locality | Generally good | Generally poorer |
| Random access | Supported efficiently | Requires traversal |

The array comparison assumes an ordinary dynamic array such as Java's `ArrayList` for insertion and deletion. A fixed-size array cannot grow automatically.

### Why is array access \(O(1)\)?

Consider:

```java id="x0hkwv"
int[] arr = {10, 20, 30, 40};
System.out.println(arr[3]);
```

Java can access the fourth element directly using its index.

### Why is linked list access \(O(n)\)?

To access the fourth element of a singly linked list, you must follow the references from the head:

`head -> node 1 -> node 2 -> node 3 -> node 4`

You cannot directly jump to the fourth node by index.

### Is a linked list always faster for insertion and deletion?

No. This is a common interview misconception.

A linked list has \(O(1)\) insertion or deletion when you already have the appropriate node reference. If you must search for that node first, the complete operation can take \(O(n)\).

Arrays and `ArrayList` also benefit from better cache locality, which can make them faster in real-world workloads despite shifting elements.


# Linked List Patterns: Dummy Node, Head, and Tail

This is a very important pattern in Linked List problems, especially on LeetCode.

When a question says return the head and provides only `ListNode head` (without `tail`), you generally need to manipulate the linked list using references.

There are three common patterns.

## 1. When You Need to Create a New Linked List: Dummy Node

Use this when you are building a result linked list.

```java
ListNode dummy = new ListNode(-1);
ListNode tail = dummy;

// Add a new node
tail.next = new ListNode(10);
tail = tail.next;

// Add another node
tail.next = new ListNode(20);
tail = tail.next;

return dummy.next;
```

**Visual representation:**

```text
dummy
  |
  v
 -1 → 10 → 20 → null
```

Return `dummy.next`, not `dummy`.

**Why dummy?**

It eliminates the special condition for inserting the first node.

**Examples:**

- [LC 21 – Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)
- [LC 86 – Partition List](https://leetcode.com/problems/partition-list/)

## 2. When Modifying the Existing Linked List: Use Head

If you only need to modify existing nodes, you generally don't need a dummy node.

**Example: Remove Duplicates (LC 83)**

```java
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
```

Here:

- `head` maintains the starting reference.
- `node` traverses the linked list.
- You return `head` because the first node is still valid.

## 3. When the Head Itself Might Change: Use Dummy

Suppose you want to delete the first node.

**Original:**

```text
10 → 20 → 30 → null
```

**After deleting 10:**

```text
20 → 30 → null
```

If you use only `head`, you must update it:

```java
head = head.next;
return head;
```

Alternatively, use a dummy node:

```java
ListNode dummy = new ListNode(-1);
dummy.next = head;

ListNode prev = dummy;

prev.next = prev.next.next;

return dummy.next;
```

**Examples:**

- [LC 203 – Remove Linked List Elements](https://leetcode.com/problems/remove-linked-list-elements/)
- [LC 19 – Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)

## 4. Your Quick Decision-Making Guide

| Situation | Pattern |
|---|---|
| Creating a new result list | Dummy + Tail |
| Modifying existing nodes | Head + Traversal pointer |
| First node might be deleted | Dummy node |
| Reversing a linked list | Previous + Current + Next |
| Merging two sorted lists | Dummy + Tail |

## Important Concept

Even if LeetCode doesn't provide `tail`, you can create your own:

```java
ListNode dummy = new ListNode(-1);
ListNode tail = dummy;
```

`tail` is simply a reference that you maintain yourself. It does not have to be a member variable of a Linked List class.



# Cycle Detection in a Linked List (Floyd's Cycle Detection Algorithm)

Cycle detection is one of the most important patterns in Linked List problems, especially in DSA interviews and LeetCode.

Let's understand it from the basics, using Java, with diagrams, dry runs, and code.

## 1. First, What Is a Cycle in a Linked List?

Normally, a singly linked list looks like this:

![alt text](images/image5.png))

Each node points to the next node, and the last node points to `null`.

But sometimes, the last node points back to an already existing node instead of pointing to `null`.

This creates a cycle (loop).

![Linked list cycle detection](https://images.openai.com/static-rsc-4/95nK6smlwfoiF6ppo3O1poz0T28V2NtR_wOwviw__1mC0fJTQN-NiaXguh-McHmy1Ng3p3OQc1KXAv90a9aJ0zyb1rH0M1kuvwrRQpfvrS0NmNGLhA3PPK6eC38o6QSalTXnFHk1fhtfbQahUQ6Ik4h8RJoOB6Dlyf06IrGAkH8?purpose=inline)

[Source: TutorialHorizon – Linked List Cycle Detection](https://tutorialhorizon.com/algorithms/linked-list-cycle-detection-tortoise-and-hare-algorithm/)

For example:

```text
10 → 20 → 30 → 40 → 50
      ↑              |
      |______________|
```

Here:

- Node 10 points to 20.
- Node 20 points to 30.
- Node 30 points to 40.
- Node 40 points to 50.
- Node 50 points back to 20.

Notice: There is no `null` at the end.

Therefore, if we traverse this linked list normally, we will never reach `null`. The traversal will continue infinitely.

This is called a cycle.

## 2. How Do We Detect a Cycle?

There are two common approaches.

| Approach | Time Complexity | Space Complexity |
|---|---|---|
| HashSet | O(n) | O(n) |
| Floyd's Algorithm | O(n) | O(1) |

We'll focus on Floyd's Cycle Detection Algorithm because it is the optimal approach.

## 3. Floyd's Cycle Detection Algorithm (Slow and Fast Pointers)

The main idea is very simple.

We use two pointers:

1. **Slow pointer:** Moves one node at a time.
2. **Fast pointer:** Moves two nodes at a time.

```java
slow = slow.next;
fast = fast.next.next;
```

Now, there are two possibilities.

**Case 1: No cycle exists**

Eventually, the fast pointer reaches `null` (or its next node is `null`).

**Case 2: A cycle exists**

The fast pointer will eventually meet the slow pointer.

**Why?**

Imagine two people running on a circular track:

- Person A runs 1 step at a time.
- Person B runs 2 steps at a time.

Eventually, the faster person catches the slower person.

The same principle works in a circular linked list.

## 4. Dry Run with an Example

Consider this linked list:

```text
10 → 20 → 30 → 40 → 50
      ↑              |
      |______________|
```

Initially:

```java
slow = head;
fast = head;
```

**Initial position:**

- Slow = 10
- Fast = 10

**Movement:**

| Step | Slow | Fast |
|---|---:|---:|
| 0 | 10 | 10 |
| 1 | 20 | 30 |
| 2 | 30 | 50 |
| 3 | 40 | 30 |
| 4 | 50 | 50 |

<badge color="success">Cycle detected at node 50</badge>

Both pointers meet at node 50.

The important observation is:

```java
slow == fast
```

When both pointers reference the same node, a cycle exists.

**Important:** We compare node references, not node values.

## 5. Java Implementation (LeetCode 141)

Linked List Cycle asks us to determine whether a linked list contains a cycle.

```java
public class Solution {

    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
```

### Let's Understand Every Important Line

**1. Initialize both pointers**

```java
ListNode slow = head;
ListNode fast = head;
```

Both pointers initially point to the first node.

**2. The while condition**

```java
while (fast != null && fast.next != null)
```

Why do we need two conditions?

- `fast != null`: Ensures fast itself exists.
- `fast.next != null`: Ensures fast can move two steps ahead.

Without these checks, we might get a `NullPointerException`.

**3. Move the pointers**

```java
slow = slow.next;
fast = fast.next.next;
```

Slow moves one step, and fast moves two steps.

**4. Check whether they meet**

```java
if (slow == fast) {
    return true;
}
```

If both references point to the same node, the cycle exists.

**5. Return false**

```java
return false;
```

If fast reaches `null`, no cycle exists.

## 6. Why Does the Fast Pointer Always Catch the Slow Pointer?

This is an important interview question.

Suppose both pointers enter a cycle.

- Slow moves 1 step.
- Fast moves 2 steps.

Therefore, the relative distance between them decreases by one node on every iteration (considering the circular distance).

Eventually, the distance becomes zero, meaning both pointers meet.

That's why Floyd's algorithm works.

## 7. Complexity Analysis

| Complexity | Value | Reason |
|---|---|---|
| Time | O(n) | Pointers traverse the linked list |
| Space | O(1) | Only two pointers are used |

This is better than the HashSet approach in terms of auxiliary space.



# Cycle Detection in a Linked List (Floyd's Cycle Detection Algorithm)

Cycle detection is one of the most important patterns in Linked List problems, especially in DSA interviews and LeetCode.

Let's understand it from the basics, using Java, with diagrams, dry runs, and code.

## 1. First, What Is a Cycle in a Linked List?

Normally, a singly linked list looks like this:

![alt text](images/image5.png))

Each node points to the next node, and the last node points to `null`.

But sometimes, the last node points back to an already existing node instead of pointing to `null`.

This creates a cycle (loop).

![Linked list cycle detection](https://images.openai.com/static-rsc-4/95nK6smlwfoiF6ppo3O1poz0T28V2NtR_wOwviw__1mC0fJTQN-NiaXguh-McHmy1Ng3p3OQc1KXAv90a9aJ0zyb1rH0M1kuvwrRQpfvrS0NmNGLhA3PPK6eC38o6QSalTXnFHk1fhtfbQahUQ6Ik4h8RJoOB6Dlyf06IrGAkH8?purpose=inline)

[Source: TutorialHorizon – Linked List Cycle Detection](https://tutorialhorizon.com/algorithms/linked-list-cycle-detection-tortoise-and-hare-algorithm/)

For example:

```text
10 → 20 → 30 → 40 → 50
      ↑              |
      |______________|
```

Here:

- Node 10 points to 20.
- Node 20 points to 30.
- Node 30 points to 40.
- Node 40 points to 50.
- Node 50 points back to 20.

Notice: There is no `null` at the end.

Therefore, if we traverse this linked list normally, we will never reach `null`. The traversal will continue infinitely.

This is called a cycle.

## 2. How Do We Detect a Cycle?

There are two common approaches.

| Approach | Time Complexity | Space Complexity |
|---|---|---|
| HashSet | O(n) | O(n) |
| Floyd's Algorithm | O(n) | O(1) |

We'll focus on Floyd's Cycle Detection Algorithm because it is the optimal approach.

## 3. Floyd's Cycle Detection Algorithm (Slow and Fast Pointers)

The main idea is very simple.

We use two pointers:

1. **Slow pointer:** Moves one node at a time.
2. **Fast pointer:** Moves two nodes at a time.

```java
slow = slow.next;
fast = fast.next.next;
```

Now, there are two possibilities.

**Case 1: No cycle exists**

Eventually, the fast pointer reaches `null` (or its next node is `null`).

**Case 2: A cycle exists**

The fast pointer will eventually meet the slow pointer.

**Why?**

Imagine two people running on a circular track:

- Person A runs 1 step at a time.
- Person B runs 2 steps at a time.

Eventually, the faster person catches the slower person.

The same principle works in a circular linked list.

## 4. Dry Run with an Example

Consider this linked list:

```text
10 → 20 → 30 → 40 → 50
      ↑              |
      |______________|
```

Initially:

```java
slow = head;
fast = head;
```

**Initial position:**

- Slow = 10
- Fast = 10

**Movement:**

| Step | Slow | Fast |
|---|---:|---:|
| 0 | 10 | 10 |
| 1 | 20 | 30 |
| 2 | 30 | 50 |
| 3 | 40 | 30 |
| 4 | 50 | 50 |

<badge color="success">Cycle detected at node 50</badge>

Both pointers meet at node 50.

The important observation is:

```java
slow == fast
```

When both pointers reference the same node, a cycle exists.

**Important:** We compare node references, not node values.

## 5. Java Implementation (LeetCode 141)

Linked List Cycle asks us to determine whether a linked list contains a cycle.

```java
public class Solution {

    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
```

### Let's Understand Every Important Line

**1. Initialize both pointers**

```java
ListNode slow = head;
ListNode fast = head;
```

Both pointers initially point to the first node.

**2. The while condition**

```java
while (fast != null && fast.next != null)
```

Why do we need two conditions?

- `fast != null`: Ensures fast itself exists.
- `fast.next != null`: Ensures fast can move two steps ahead.

Without these checks, we might get a `NullPointerException`.

**3. Move the pointers**

```java
slow = slow.next;
fast = fast.next.next;
```

Slow moves one step, and fast moves two steps.

**4. Check whether they meet**

```java
if (slow == fast) {
    return true;
}
```

If both references point to the same node, the cycle exists.

**5. Return false**

```java
return false;
```

If fast reaches `null`, no cycle exists.

## 6. Why Does the Fast Pointer Always Catch the Slow Pointer?

This is an important interview question.

Suppose both pointers enter a cycle.

- Slow moves 1 step.
- Fast moves 2 steps.

Therefore, the relative distance between them decreases by one node on every iteration (considering the circular distance).

Eventually, the distance becomes zero, meaning both pointers meet.

That's why Floyd's algorithm works.

## 7. Complexity Analysis

| Complexity | Value | Reason |
|---|---|---|
| Time | O(n) | Pointers traverse the linked list |
| Space | O(1) | Only two pointers are used |

This is better than the HashSet approach in terms of auxiliary space.




# Linked List Cycle II (LeetCode 142) – Find the Starting Node of a Cycle

In LeetCode 142, we don't just detect whether a cycle exists; we have to find the exact node where the cycle begins.

This requires one additional step after detecting the cycle using Floyd's algorithm.

## 1. Understand the Example

Consider this linked list:

```text
10 → 20 → 30 → 40 → 50
      ↑              |
      |______________|
```

Here:

- Head = 10
- Cycle starts at node 20.
- Both slow and fast eventually meet at node 50.

Our objective is to return node 20, not node 50.

## 2. The Additional Step

Once slow and fast meet:

1. Move the `slow` pointer back to `head`.
2. Keep the `fast` pointer at the meeting point.
3. Now move BOTH pointers one step at a time.
4. The node where they meet again is the starting node of the cycle.

![LeetCode 142 – Linked List Cycle II](https://images.openai.com/static-rsc-4/JFPGU7YW2kFaG0lIe8o_-bUpqCYWwSJLFjE8ooRq7jFQ-DaxvmQ3eJ0ThXCAcedgh1ykO_OoASNbhK9InMi20-SIzJeki-9hWrKZKAfozVADbd_tYAO2X2YT6YcF1x96ucUG0hGvBXkbeCDJs-zhf4xOTDoWbMgAThpxJpQ4YNo?purpose=inline)

[Source: Nick Li – LeetCode 142](https://nicklee1006.github.io/Leetcode-142-Linked-List-Cycle-II/)

**The logic:**

```java
slow = head;

while (slow != fast) {
    slow = slow.next;
    fast = fast.next;
}

return slow;
```

## 3. Complete Java Code (LeetCode 142)

```java
public class Solution {

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            // Step 2: Find the meeting point
            if (slow == fast) {

                // Step 3: Reset slow to head
                slow = head;

                // Step 4: Move both one step at a time
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                // Step 5: Return cycle starting node
                return slow;
            }
        }

        return null;
    }
}
```

## 4. Why Does This Work Mathematically?

Let's understand the mathematical reasoning.

Suppose:

- `L` = Distance from head to cycle starting node.
- `C` = Distance from cycle starting node to meeting point.
- `K` = Length of the entire cycle.

When slow and fast meet:

- Slow travels: \(L+C\)
- Fast travels: \(2(L+C)\)

Since fast travels twice the distance:

\[
2(L+C)-(L+C)=L+C
\]

The difference is a multiple of the cycle length:

\[
L+C=nK
\]

Therefore:

\[
L=nK-C
\]

This means that if one pointer starts from the head and another starts from the meeting point, moving both one step at a time makes them meet at the cycle entrance.

## 5. Important Difference Between LC 141 and LC 142

| Feature | LC 141 | LC 142 |
|---|---|---|
| Detect cycle | Yes | Yes |
| Find cycle starting node | No | Yes |
| Floyd's algorithm | Yes | Yes |
| Additional pointer movement | No | Yes |
| Return type | `boolean` | `ListNode` |



# LeetCode 82 – Remove Duplicates from Sorted List II

## Recommended Approach: Dummy Node + Two Pointers

The easiest way to solve LC 82 is to use a dummy node.

**Consider:**

```text
1 → 2 → 3 → 3 → 4 → 4 → 5
```

**Expected output:**

```text
1 → 2 → 5 → null
```

**Why?**

- 1 appears once → Keep.
- 2 appears once → Keep.
- 3 appears twice → Remove both.
- 4 appears twice → Remove both.
- 5 appears once → Keep.

## 3. Java Solution (LeetCode 82)

```java
class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {

            // Check whether current value is duplicated
            if (curr.next != null && curr.val == curr.next.val) {

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

            curr = curr.next;
        }

        return dummy.next;
    }
}
```

## Pointer Responsibilities

### `prev` (Previous Pointer)

Points to the last node that we know is unique and should remain in the final linked list.

### `curr` (Current Pointer)

Checks the current node and identifies whether its value is duplicated.


# LeetCode 82 – Remove Duplicates from Sorted List II: Complete Dry Run

Let's dry-run your LeetCode 82 – Remove Duplicates from Sorted List II code with the input:

```text
1 → 2 → 3 → 3 → 4 → 4 → 5 → null
```

**Expected output:**

```text
1 → 2 → 5 → null
```

We'll track three pointers/variables:

- `dummy`: A node before the head.
- `prev`: Points to the last node confirmed to be unique.
- `curr`: Used to traverse the linked list.

# 1. Initial Setup

Execute:

```java
ListNode dummy = new ListNode(-1);
dummy.next = head;

ListNode prev = dummy;
ListNode curr = head;
```

Our initial structure:

```text
dummy → 1 → 2 → 3 → 3 → 4 → 4 → 5 → null
  ↑      ↑
 prev   curr
```

| Variable | Points to |
|---|---|
| `dummy` | -1 |
| `prev` | -1 |
| `curr` | 1 |

# 2. Complete Dry Run

## Iteration 1: curr = 1

Current structure:

```text
dummy → 1 → 2 → 3 → 3 → 4 → 4 → 5
  ↑      ↑
 prev   curr
```

Check:

```java
if (curr.next != null && curr.val == curr.next.val)
```

Substitute values:

```java
if (1 == 2)  // false
```

Since 1 is unique, execute:

```java
prev = prev.next;
```

Now:

```text
dummy → 1 → 2 → 3 → 3 → 4 → 4 → 5
         ↑   ↑
        prev curr
```

Updated pointers:

- `prev = 1`
- `curr = 1` (temporarily, before the final statement)

Then execute:

```java
curr = curr.next;
```

Now `curr = 2`.

**Node 1 retained.**

## Iteration 2: curr = 2

Current structure:

```text
dummy → 1 → 2 → 3 → 3 → 4 → 4 → 5
         ↑   ↑
        prev curr
```

Check:

```java
if (2 == 3) // false
```

Node 2 is unique.

Execute:

```java
prev = prev.next;
```

Now:

```text
dummy → 1 → 2 → 3 → 3 → 4 → 4 → 5
             ↑   ↑
            prev curr
```

Then:

```java
curr = curr.next;
```

Now `curr = 3`.

**Node 2 retained.**

## Iteration 3: curr = 3

Current structure:

```text
dummy → 1 → 2 → 3 → 3 → 4 → 4 → 5
             ↑   ↑
            prev curr
```

Check:

```java
if (3 == 3) // true
```

We found a duplicate!

Now execute the inner while loop:

```java
while (curr.next != null &&
       curr.val == curr.next.val) {

    curr = curr.next;
}
```

Let's understand this carefully.

**First inner iteration:**

```java
3 == 3 // true
```

Move:

```java
curr = curr.next;
```

Now `curr` points to the second 3.

```text
dummy → 1 → 2 → 3 → 3 → 4 → 4 → 5
             ↑       ↑
            prev    curr
```

Check the inner condition again:

```java
3 == 4 // false
```

The inner loop terminates.

Now `curr` points to the last node containing 3.

**Duplicate group identified: 3, 3**

## Iteration 3 Continued: Remove the Duplicate Group

Execute:

```java
prev.next = curr.next;
```

Let's understand the references:

Before:

```text
dummy → 1 → 2 → 3 → 3 → 4 → 4 → 5
             ↑       ↑
            prev    curr
```

Here:

- `prev` points to node 2.
- `curr` points to the second node 3.
- `curr.next` points to node 4.

We execute:

```java
prev.next = curr.next;
```

This means:

```java
node2.next = node4;
```

After:

```text
dummy → 1 → 2 ─────────→ 4 → 4 → 5
             ↑           ↑
            prev        curr
```

Both nodes containing 3 are now disconnected from the linked list.

**Important:** Notice that `prev` did not move. It remains at node 2 because we haven't confirmed that the next value (4) is unique yet.

Finally:

```java
curr = curr.next;
```

Now `curr` moves from the second 3 to node 4.

**Both nodes containing 3 removed.**

## Iteration 4: curr = 4

Current structure:

```text
dummy → 1 → 2 → 4 → 4 → 5
             ↑   ↑
            prev curr
```

Check:

```java
if (4 == 4) // true
```

Another duplicate group!

Execute the inner while loop:

```java
while (curr.next != null &&
       curr.val == curr.next.val) {

    curr = curr.next;
}
```

**First check:**

```java
4 == 4 // true
```

Move `curr` to the second 4.

```text
dummy → 1 → 2 → 4 → 4 → 5
             ↑       ↑
            prev    curr
```

Check again:

```java
4 == 5 // false
```

The inner loop stops.

Now execute:

```java
prev.next = curr.next;
```

This means:

```java
node2.next = node5;
```

After removing both 4s:

```text
dummy → 1 → 2 ─────────→ 5
             ↑           ↑
            prev        curr
```

Finally:

```java
curr = curr.next;
```

Now `curr = 5`.

**Both nodes containing 4 removed.**

## Iteration 5: curr = 5

Current structure:

```text
dummy → 1 → 2 → 5
             ↑   ↑
            prev curr
```

Check:

```java
if (5 == null) // Cannot compare this way
```

Actually, the condition evaluates as follows:

```java
curr.next != null
```

Since `curr.next == null`, the condition is false.

Node 5 is unique.

Execute:

```java
prev = prev.next;
```

Now:

```text
dummy → 1 → 2 → 5
                 ↑
                prev
                curr (temporarily)
```

Finally:

```java
curr = curr.next;
```

Now `curr = null`.

The outer while loop terminates.

# 3. Complete Iteration Summary

| Iteration | curr value | Duplicate? | Operation |
|---|---:|---|---|
| 1 | 1 | No | Move prev |
| 2 | 2 | No | Move prev |
| 3 | 3 | Yes | Remove both 3s |
| 4 | 4 | Yes | Remove both 4s |
| 5 | 5 | No | Move prev |

**Final output:**

```text
1 → 2 → 5 → null
```

**Original nodes:** 7

**Removed nodes:** 4

**Remaining nodes:** 3

# 4. The Most Important Concept: Why Don't We Move `prev` When Duplicates Are Found?

This is the key to understanding LC 82.

Consider:

```text
1 → 2 → 3 → 3 → 4
```

When we find duplicate 3s:

```java
prev.next = curr.next;
```

We connect node 2 directly to node 4.

Why don't we move `prev` to node 4?

Because we haven't checked whether 4 is also duplicated!

If 4 is duplicated, we must remove it too.

Therefore:

- If the current value is unique, move `prev`.
- If the current value is duplicated, keep `prev` where it is.
- Always move `curr` forward after processing the current group.

This is the fundamental pointer-management idea behind this solution.




# LeetCode 19 – Remove Nth Node From End of List (Two-Pass Approach)

Yes! Absolutely. Your approach is 100% correct, and it is one of the standard ways to solve LeetCode 19.

You can solve this problem using:

- One pointer (`pre`)
- One counter (`count`)
- Two traversals
- Reference manipulation (`next.next`)

Let's understand it.

# 1. Your Approach

Suppose the input is:

```text
1 → 2 → 3 → 4 → 5 → null
```

And:

```java
n = 2;
```

We need to remove the 2nd node from the end.

**Expected output:**

```text
1 → 2 → 3 → 5 → null
```

### Step 1: Count the Total Nodes

```java
int count = 0;
ListNode pre = head;

while (pre != null) {
    count++;
    pre = pre.next;
}
```

After traversal:

```java
count = 5;
```

### Step 2: Calculate the Position

```java
int index = count - n;
```

Therefore:

```text
index = 5 - 2
      = 3
```

Here, `index = 3` means we need to reach the node immediately before the node we want to delete (using zero-based indexing).

Our positions are:

| Index | Node |
|---|---|
| 0 | 1 |
| 1 | 2 |
| 2 | 3 |
| 3 | 4 |
| 4 | 5 |

So we need to reach node 3 (index 2), not node 4.

**Correction to the calculation:** The previous node's index is `count - n - 1`, which is `2`.

### Step 3: Traverse to the Previous Node

Reset the pointer:

```java
pre = head;
```

Move it `count - n - 1` times:

```java
int steps = count - n - 1;

while (steps > 0) {
    pre = pre.next;
    steps--;
}
```

Now:

```text
1 → 2 → 3 → 4 → 5
          ↑
         pre
```

### Step 4: Remove the Node

Execute:

```java
pre.next = pre.next.next;
```

This changes the connection:

**Before:**

```text
3 → 4 → 5
```

**After:**

```text
3 ─────→ 5
```

**Final result:**

```text
1 → 2 → 3 → 5 → null
```

# 2. Complete Java Solution (VS Code)

```java
package DSA.Linked_List;

// LeetCode 19: Remove Nth Node From End of List
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

public class LC_19 {

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

        public ListNode removeNthFromEnd(ListNode head, int n) {

            int count = 0;
            ListNode pre = head;

            // Step 1: Count total nodes
            while (pre != null) {
                count++;
                pre = pre.next;
            }

            // Step 2: Calculate steps to previous node
            int steps = count - n - 1;

            // Special case: Remove the head
            if (steps < 0) {
                return head.next;
            }

            // Step 3: Reset pointer
            pre = head;

            // Step 4: Reach the previous node
            while (steps > 0) {
                pre = pre.next;
                steps--;
            }

            // Step 5: Remove the target node
            pre.next = pre.next.next;

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

        // Creating Linked List:
        // 1 -> 2 -> 3 -> 4 -> 5

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2;

        System.out.println("Original Linked List:");
        printList(head);

        Solution obj = new Solution();

        head = obj.removeNthFromEnd(head, n);

        System.out.println("\nAfter Removing " + n + "nd Node From End:");
        printList(head);
    }
}
```

**Expected output:**

```text
Original Linked List:
1 -> 2 -> 3 -> 4 -> 5 -> null

After Removing 2nd Node From End:
1 -> 2 -> 3 -> 5 -> null
```

# 3. Important Edge Case: Removing the Head

Consider:

```text
1 → 2 → 3 → 4 → 5
```

If:

```java
n = 5;
```

We need to remove node 1.

**Calculation:**

\[
steps = count-n-1
\]

\[
steps = 5-5-1=-1
\]

Since `steps < 0`, we remove the head:

```java
return head.next;
```

**Result:**

```text
2 → 3 → 4 → 5 → null
```

This is why we need the special case.

# 4. Complexity Analysis

| Complexity | Value |
|---|---|
| Time | O(n) |
| Space | O(1) |

Your approach uses two traversals, but it still has O(n) time complexity.

# 5. One More Approach You Should Learn

There is also a **One-Pass Slow and Fast Pointer** approach.

Instead of counting all nodes:

1. Move `fast` ahead by `n` nodes.
2. Start `slow` at `head` (using a dummy node).
3. Move both pointers one step at a time.
4. When `fast` reaches `null`, `slow.next` is the node to remove.
5. Remove it using `slow.next = slow.next.next`.

This avoids the separate counting traversal.



# LeetCode 1472 – Design Browser History

**Difficulty:** Medium  
**Data Structure:** Doubly Linked List

**Official problem:** [Design Browser History – LeetCode 1472](https://leetcode.com/problems/design-browser-history/)

Let's understand this problem from the basics, then implement it using a Doubly Linked List in Java.

## 1. Understand the Problem

Imagine you're using a web browser such as Chrome.

You open these websites in order:

1. google.com
2. youtube.com
3. facebook.com
4. instagram.com

Now, suppose you press the Back button twice.

You move:

```text
instagram.com → facebook.com → youtube.com
```

Your current webpage is now `youtube.com`.

If you press Forward once, you return to `facebook.com`.

This is exactly what we need to implement.

## 2. Understand the Three Operations

LeetCode gives you four methods:

```java
public BrowserHistory(String homepage)

public void visit(String url)

public String back(int steps)

public String forward(int steps)
```

Let's understand each one.

### Operation 1: Constructor

```java
public BrowserHistory(String homepage)
```

It initializes the browser with the homepage.

For example:

```java
BrowserHistory obj = new BrowserHistory("google.com");
```

Initially:

```text
google.com
    ↑
  current
```

### Operation 2: Visit

```java
public void visit(String url)
```

It visits a new webpage.

Suppose you have:

```text
google.com ⇄ youtube.com ⇄ facebook.com
```

Currently, you're on `youtube.com`.

Now execute:

```java
obj.visit("instagram.com");
```

The new history becomes:

```text
google.com ⇄ youtube.com ⇄ instagram.com
```

Notice something important:

`facebook.com` is removed from the forward history.

**This is a very important rule:**

Whenever you visit a new website, all forward history is deleted.

### Operation 3: Back

```java
public String back(int steps)
```

Moves backward by at most the specified number of steps.

For example:

```text
google.com ⇄ youtube.com ⇄ facebook.com ⇄ instagram.com
```

Currently at `instagram.com`.

```java
obj.back(2);
```

Result:

```text
google.com ⇄ youtube.com ⇄ facebook.com ⇄ instagram.com
                         ↑
                       current
```

Returns `"facebook.com"`.

### Operation 4: Forward

```java
public String forward(int steps)
```

Moves forward by at most the specified number of steps.

For example, if you're currently at `facebook.com`:

```java
obj.forward(1);
```

You move to `instagram.com` and return `"instagram.com"`.

## 3. Why Use a Doubly Linked List?

A browser needs to move in two directions:

- Backward using `prev`.
- Forward using `next`.

A DLL is perfect for this.

Let's create a Node class:

```java
static class Node {
    String url;
    Node prev;
    Node next;

    Node(String url) {
        this.url = url;
    }
}
```

Each node stores:

- `url`: Webpage address.
- `prev`: Previous webpage.
- `next`: Next webpage.

### Which Pointers Do We Need?

For this problem, we can solve everything using just one pointer: `curr`.

```java
Node curr;
```

It represents the webpage currently open in the browser.

We don't actually need `head`, `tail`, or `size`.

Why? Because all operations start from the current webpage, and we only need to move backward or forward from there.

## 4. Implement Each Method Step by Step

### A. Constructor

```java
public BrowserHistory(String homepage) {
    curr = new Node(homepage);
}
```

Suppose:

```java
BrowserHistory obj = new BrowserHistory("google.com");
```

A new node is created:

```text
google.com
    ↑
   curr
```

Both `prev` and `next` are initially `null`.

### B. Visit a New Webpage

```java
public void visit(String url) {
    Node node = new Node(url);

    curr.next = node;
    node.prev = curr;

    curr = node;
}
```

Let's understand this carefully.

Initially:

```text
google.com ⇄ youtube.com ⇄ facebook.com
               ↑
              curr
```

Now execute:

```java
visit("instagram.com");
```

**Step 1: Create a new node.**

```java
Node node = new Node(url);
```

**Step 2: Connect the current node to the new node.**

```java
curr.next = node;
```

**Step 3: Connect the new node back to the current node.**

```java
node.prev = curr;
```

**Step 4: Move `curr` to the newly visited webpage.**

```java
curr = node;
```

Result:

```text
google.com ⇄ youtube.com ⇄ instagram.com
                                ↑
                               curr
```

Notice that `facebook.com` is no longer reachable.

Why?

Because this statement:

```java
curr.next = node;
```

overwrites the old forward connection from `youtube.com` to `facebook.com`.

This automatically discards the forward history from our linked-list structure.

### C. Back Operation

```java
public String back(int steps) {
    while (steps > 0 && curr.prev != null) {
        curr = curr.prev;
        steps--;
    }

    return curr.url;
}
```

Let's say:

```text
google.com ⇄ youtube.com ⇄ facebook.com ⇄ instagram.com
                                             ↑
                                            curr
```

Execute:

```java
back(2);
```

**Dry run:**

| Step | Operation | Current webpage |
|---|---|---|
| Initial | — | instagram.com |
| 1 | `curr = curr.prev` | facebook.com |
| 2 | `curr = curr.prev` | youtube.com |

Returns:

```text
youtube.com
```

Why do we use this condition?

```java
steps > 0 && curr.prev != null
```

Because:

- `steps > 0` ensures we still have backward movements remaining.
- `curr.prev != null` ensures we don't move before the homepage.

### D. Forward Operation

```java
public String forward(int steps) {
    while (steps > 0 && curr.next != null) {
        curr = curr.next;
        steps--;
    }

    return curr.url;
}
```

Suppose:

```text
google.com ⇄ youtube.com ⇄ facebook.com ⇄ instagram.com
               ↑
              curr
```

Execute:

```java
forward(2);
```

**Dry run:**

| Step | Operation | Current webpage |
|---|---|---|
| Initial | — | youtube.com |
| 1 | `curr = curr.next` | facebook.com |
| 2 | `curr = curr.next` | instagram.com |

Returns:

```text
instagram.com
```

We use `curr.next != null` to ensure we never move beyond the latest visited webpage.

## 5. Complete LeetCode Solution

Now combine all four methods.

```java
class BrowserHistory {

    static class Node {
        String url;
        Node prev;
        Node next;

        Node(String url) {
            this.url = url;
        }
    }

    Node curr;

    // Constructor
    public BrowserHistory(String homepage) {
        curr = new Node(homepage);
    }

    // Visit a new webpage
    public void visit(String url) {
        Node node = new Node(url);

        curr.next = node;
        node.prev = curr;

        curr = node;
    }

    // Move backward
    public String back(int steps) {
        while (steps > 0 && curr.prev != null) {
            curr = curr.prev;
            steps--;
        }

        return curr.url;
    }

    // Move forward
    public String forward(int steps) {
        while (steps > 0 && curr.next != null) {
            curr = curr.next;
            steps--;
        }

        return curr.url;
    }
}
```

## 6. Complete Dry Run

Consider these operations from the problem:

```java
BrowserHistory browserHistory =
    new BrowserHistory("leetcode.com");

browserHistory.visit("google.com");
browserHistory.visit("facebook.com");
browserHistory.visit("youtube.com");

browserHistory.back(1);

browserHistory.back(1);

browserHistory.forward(1);

browserHistory.visit("linkedin.com");

browserHistory.forward(2);

browserHistory.back(2);

browserHistory.back(7);
```

Let's execute them one by one.

| Operation | Returned value | Current webpage |
|---|---|---|
| Constructor | — | leetcode.com |
| `visit(google.com)` | — | google.com |
| `visit(facebook.com)` | — | facebook.com |
| `visit(youtube.com)` | — | youtube.com |
| `back(1)` | facebook.com | facebook.com |
| `back(1)` | google.com | google.com |
| `forward(1)` | facebook.com | facebook.com |
| `visit(linkedin.com)` | — | linkedin.com |
| `forward(2)` | linkedin.com | linkedin.com |
| `back(2)` | google.com | google.com |
| `back(7)` | leetcode.com | leetcode.com |

Pay special attention to this operation:

```java
browserHistory.visit("linkedin.com");
```

At that point, the current webpage is `facebook.com`, and the forward history contains `youtube.com`.

After visiting LinkedIn:

```text
leetcode.com ⇄ google.com ⇄ facebook.com ⇄ linkedin.com
                              ↑
                            current
```

`youtube.com` is discarded!

That's the most important concept in this problem.

## 7. Time and Space Complexity

Let `k` be the number of steps requested and `n` the number of stored webpage nodes.

| Method | Time Complexity |
|---|---|
| Constructor | O(1) |
| `visit()` | O(1) |
| `back(k)` | O(min(k, available backward nodes)) |
| `forward(k)` | O(min(k, available forward nodes)) |

**Space complexity:** O(n), where n is the number of webpages retained in the history.




# LeetCode 148 – Sort List (Merge Sort on a Linked List)

Let's understand the complete Merge Sort on a Linked List using your original Slow-Fast Pointer (`middleNode2`) approach.

We'll use your preferred `getMid()` implementation, where:

- `slow` moves one step.
- `fast` moves two steps.
- `prev` keeps track of the node before `slow`.
- `prev.next = null` separates the two halves.

**Our example:**

```text
10 → 5 → 3 → 8 → 2
```

**Expected output:**

```text
2 → 3 → 5 → 8 → 10
```

## 1. Complete Java Code

```java
public class MergeSort {

    public ListNode sortList(ListNode head) {

        // Base condition
        if (head == null || head.next == null) {
            return head;
        }

        // Find middle and split the list
        ListNode mid = getMid(head);

        // Recursively sort left half
        ListNode left = sortList(head);

        // Recursively sort right half
        ListNode right = sortList(mid);

        // Merge both sorted halves
        return merge(left, right);
    }

    // Merge two sorted linked lists
    ListNode merge(ListNode list1, ListNode list2) {

        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }

        tail.next = (list1 != null) ? list1 : list2;

        return dummyHead.next;
    }

    // Your slow-fast pointer approach
    ListNode getMid(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {

            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        return slow;
    }
}
```

## 2. First Understand getMid()

This method finds the middle and splits the linked list into two independent lists.

```java
ListNode getMid(ListNode head) {

    ListNode slow = head;
    ListNode fast = head;
    ListNode prev = null;

    while (fast != null && fast.next != null) {

        prev = slow;
        slow = slow.next;
        fast = fast.next.next;
    }

    prev.next = null;

    return slow;
}
```

Let's dry-run it.

**Initial linked list:**

```text
10 → 5 → 3 → 8 → 2
```

**Initial state:**

- slow = 10
- fast = 10
- prev = null

**After iteration 1:**

```text
10 → 5 → 3 → 8 → 2
```

- prev = 10
- slow = 5
- fast = 3

**After iteration 2:**

```text
10 → 5 → 3 → 8 → 2
```

- prev = 5
- slow = 3
- fast = 2

**Loop stops**

`fast.next == null`, so we exit.

Then:

```java
prev.next = null;
```

**Two independent lists:**

```text
10 → 5

3 → 8 → 2
```

The method returns node 3 as the head of the second list.

Notice something important:

- `head` still points to node 10.
- `mid` (the returned `slow`) points to node 3.
- The connection between 5 and 3 has been broken.

So now we have two independent lists.

## 3. Understand sortList() – Recursive Division

This is the most important part of Merge Sort.

```java
public ListNode sortList(ListNode head) {

    if (head == null || head.next == null) {
        return head;
    }

    ListNode mid = getMid(head);

    ListNode left = sortList(head);
    ListNode right = sortList(mid);

    return merge(left, right);
}
```

Let's execute it step by step.

### Step 1: First Function Call

Initially:

```java
sortList(10 → 5 → 3 → 8 → 2)
```

The base condition is false.

We call:

```java
ListNode mid = getMid(head);
```

Our modified `getMid()` divides the list:

```text
Left:  10 → 5

Right: 3 → 8 → 2
```

Now:

```java
ListNode left = sortList(head);
```

Since `head` still points to node 10, the next recursive call is:

```java
sortList(10 → 5)
```

### Step 2: Sort the Left Half

Inside `sortList(10 → 5)`:

The base condition is false because there are two nodes.

We call `getMid()` again.

Using slow and fast:

| Variable | Initial | After one iteration |
|---|---|---|
| slow | 10 | 5 |
| fast | 10 | null |
| prev | null | 10 |

Now:

```java
prev.next = null;
```

The list becomes:

```text
10       5
```

Here:

```java
ListNode left = sortList(head);
```

Calls:

```java
sortList(10);
```

The base condition is true, so node 10 is returned.

Then:

```java
ListNode right = sortList(mid);
```

Calls:

```java
sortList(5);
```

Again, the base condition is true, so node 5 is returned.

Now we have:

```text
left = 10;
right = 5;
```

Finally:

```java
return merge(left, right);
```

Result:

```text
5 → 10
```

**Left half sorted.**

### Step 3: Sort the Right Half

Remember, we originally called:

```java
sortList(10 → 5 → 3 → 8 → 2);
```

Its left recursive call has now finished.

Java moves to:

```java
ListNode right = sortList(mid);
```

Here `mid` points to node 3.

So we call:

```java
sortList(3 → 8 → 2)
```

Now `getMid()` divides it:

```text
Left:  3

Right: 8 → 2
```

The left recursive call:

```java
sortList(3);
```

Returns node 3 because of the base condition.

Next:

```java
sortList(8 → 2);
```

This list is divided again:

```text
Left:  8

Right: 2
```

Both calls reach the base condition and return their respective nodes.

Now:

```java
return merge(8, 2);
```

Produces:

```text
2 → 8
```

Finally, the previous recursive call merges:

```text
left  = 3

right = 2 → 8
```

Result:

```text
2 → 3 → 8
```

**Right half sorted.**

## 4. Complete Recursion Tree

Now you can see how the entire list gets divided and merged.

### Division Phase

```text
          10 → 5 → 3 → 8 → 2
                    |
             ---------------
             |             |
           10 → 5        3 → 8 → 2
             |             |
          --------       --------
          |      |       |      |
          10     5       3     8 → 2
                                |
                              -----
                              |   |
                              8   2
```

### Merging Phase

```text
          5 → 10
          Merge 10 and 5

          2 → 8
          Merge 8 and 2

          2 → 3 → 8
          Merge node 3 with 2 → 8

          2 → 3 → 5 → 8 → 10
          Final sorted list
```

## 5. How merge() Works

Now let's understand why the merging works.

Suppose we have two already sorted lists:

```text
list1: 5 → 10

list2: 2 → 3 → 8
```

Your method:

```java
ListNode merge(ListNode list1, ListNode list2) {

    ListNode dummyHead = new ListNode();
    ListNode tail = dummyHead;

    while (list1 != null && list2 != null) {

        if (list1.val < list2.val) {

            tail.next = list1;
            list1 = list1.next;
            tail = tail.next;

        } else {

            tail.next = list2;
            list2 = list2.next;
            tail = tail.next;
        }
    }

    tail.next = (list1 != null) ? list1 : list2;

    return dummyHead.next;
}
```

**Let's dry-run:**

| Comparison | Selected node | Result |
|---|---|---|
| 5 vs 2 | 2 | 2 |
| 5 vs 3 | 3 | 2 → 3 |
| 5 vs 8 | 5 | 2 → 3 → 5 |
| 10 vs 8 | 8 | 2 → 3 → 5 → 8 |
| 10 vs null | 10 | 2 → 3 → 5 → 8 → 10 |

Notice:

```java
tail.next = list1;
list1 = list1.next;
tail = tail.next;
```

We are reusing the existing nodes, not creating new nodes.

Also, when one list becomes empty, we attach the remaining nodes of the other list directly.

## 6. Complexity Analysis

| Complexity | Value |
|---|---|
| Time | O(n log n) |
| Recursion stack | O(log n) |
| Extra space for merging | O(1) |

The list gets divided into approximately `log n` levels, and each level requires O(n) merging work.




# Understanding Recursion in Merge Sort – How `return` Works and Why Each Call Has Its Own `mid`

Node 10 is returned to its caller first, and then it gets stored in `left`.

Let's understand exactly what happens.

### Step 1: Parent Function Calls sortList(10)

Suppose we are currently executing:

```java
ListNode left = sortList(head);
```

Here, `head` points to node 10.

Java makes another function call:

```java
sortList(10);
```

### Step 2: Base Condition Executes

Inside this new function call:

```java
if (head == null || head.next == null) {
    return head;
}
```

Since node 10 is the only node:

```java
return head;
```

This returns the reference to node 10 to the previous function call.

### Step 3: Value Gets Stored in left

Now Java resumes execution at the exact place where the function was called:

```java
ListNode left = sortList(head);
```

Since `sortList(head)` returned node 10, it becomes equivalent to:

```java
ListNode left = node10;
```

**Execution flow:**

```text
Parent call

sortList(10 → 5)

       |
       | Calls sortList(10)
       |
       v

Child call

sortList(10)

       |
       | return head
       |
       v

    Node 10

       |
       | Returns to parent
       v

left = Node 10
```

### Step 4: What Executes Next?

After `left` receives node 10, Java executes the next statement:

```java
ListNode right = sortList(mid);
```

So the right recursive call starts.

**Remember this rule:**

Whenever Java encounters:

```java
int result = someMethod();
```

It first executes `someMethod()` completely. When that method returns a value, Java assigns that value to `result`.

The same principle applies to your linked list:

```java
ListNode left = sortList(head);
```

The returned node reference is stored in `left` only after the recursive call finishes.

---

## So, the Returned 10 Goes to sortList(10) or sortList(10 → 5)?

The returned `10` goes to `sortList(10 → 5)`, not directly to the original `sortList(10 → 5 → 3 → 8 → 2)`.

Let's see the call hierarchy:

```text
sortList(10 → 5 → 3 → 8 → 2)
    |
    | calls sortList(10 → 5)
    |
    └── sortList(10 → 5)
            |
            | calls sortList(10)
            |
            └── sortList(10)
                    |
                    └── return 10
```

Now, where does `return 10` go?

It goes back to the function that called `sortList(10)`, which is:

```java
sortList(10 → 5)
```

There, this statement receives the returned node:

```java
ListNode left = sortList(head);
```

So now:

```java
left = 10;
```

**Remember:** A recursive function always returns to its immediate caller, not directly to the first function call.

This is exactly how the recursion stack works (LIFO).

---

## So at This Stage the mid Is 3, Then Why Does the Right Call Call with mid 5?

Excellent! You're mixing up the `mid` values belonging to two different recursive function calls. Each call has its own local `mid` variable.

Let's trace it carefully.

### 1. First Call: sortList(10 → 5 → 3 → 8 → 2)

We execute:

```java
ListNode mid = getMid(head);
```

Your `getMid()` divides the list:

```text
10 → 5       3 → 8 → 2
             ↑
            mid
```

So, in this function call:

```java
mid = 3;
```

Then:

```java
ListNode left = sortList(head);
```

This calls:

```java
sortList(10 → 5);
```

### 2. Second Call: sortList(10 → 5)

Now we are inside a completely new function call.

It executes its own:

```java
ListNode mid = getMid(head);
```

This time the list is:

```text
10       5
         ↑
        mid
```

So, in this function call:

```java
mid = 5;
```

Notice the difference:

| Function call | Its mid |
|---|---|
| `sortList(10 → 5 → 3 → 8 → 2)` | 3 |
| `sortList(10 → 5)` | 5 |

### 3. Now the Execution Continues

Inside `sortList(10 → 5)`:

```java
ListNode left = sortList(head);
```

Calls `sortList(10)`.

It returns node 10, which gets stored in `left`.

Then Java executes:

```java
ListNode right = sortList(mid);
```

But remember, this `mid` belongs to `sortList(10 → 5)`.

Therefore:

```java
sortList(5);
```

It does NOT call `sortList(3)`.

### 4. Visualize the Two Different mid Variables

**Function call 1**

`sortList(10 → 5 → 3 → 8 → 2)`

```text
mid = 3
```

Its own local mid variable.

Calls `sortList(10 → 5)`.

**Function call 2**

`sortList(10 → 5)`

```text
mid = 5
```

A separate local mid variable.

Calls `sortList(mid)`.

```text
sortList(5)
```

Base condition.

**The key concept:** Every recursive function call gets its own local variables (`head`, `mid`, `left`, `right`). They don't overwrite the variables of the previous function call.

This is why Java can remember `mid = 3` in the first call while simultaneously having `mid = 5` in the second call.
