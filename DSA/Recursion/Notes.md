Recursive call tree of Merge Sort, I am using the word "tree" to visualize the function-call relationships.
input [8,3,5,4,7,6,1,2]; or you can take any input, it is just a example for understanding
initiaaly low = 0, high = 7
tree is :
mergeSort(0,7)
│
├── mergeSort(0,3)
│   │
│   ├── mergeSort(0,1)
│   │   │
│   │   ├── mergeSort(0,0) → return to mergeSort(0,1)
│   │   │
│   │   ├── mergeSort(1,1) → return to mergeSort(0,1)
│   │   │
│   │   └── merge(0,0,1)
│   │       └── return to mergeSort(0,1)
│   │
│   ├── mergeSort(2,3)
│   │   │
│   │   ├── mergeSort(2,2) → return to mergeSort(2,3)
│   │   │
│   │   ├── mergeSort(3,3) → return to mergeSort(2,3)
│   │   │
│   │   └── merge(2,2,3)
│   │       └── return to mergeSort(2,3)
│   │
│   └── merge(0,1,3)
│       └── return to mergeSort(0,3)
│
│       mergeSort(0,3) finishes
│       └── return to mergeSort(0,7)
│
├── mergeSort(4,7)
│   │
│   ├── mergeSort(4,5)
│   │   │
│   │   ├── mergeSort(4,4) → return to mergeSort(4,5)
│   │   │
│   │   ├── mergeSort(5,5) → return to mergeSort(4,5)
│   │   │
│   │   └── merge(4,4,5)
│   │       └── return to mergeSort(4,5)
│   │
│   ├── mergeSort(6,7)
│   │   │
│   │   ├── mergeSort(6,6) → return to mergeSort(6,7)
│   │   │
│   │   ├── mergeSort(7,7) → return to mergeSort(6,7)
│   │   │
│   │   └── merge(6,6,7)
│   │       └── return to mergeSort(6,7)
│   │
│   └── merge(4,5,7)
│       └── return to mergeSort(4,7)
│
│       mergeSort(4,7) finishes
│       └── return to mergeSort(0,7)
│
└── merge(0,3,7)
    └── return to mergeSort(0,7)

mergeSort(0,7) finishes
└── return to main()




Recursive call tree of Quick Sort
input [5,3,8,4,2,7,1,6] or you can take any input, it is just a example for understanding
initiaaly low = 0, high = 7
quickSort(0,7)
│
├── partition(0,7)
│      pivot = 6
│      pivotIndex = 5
│
├── quickSort(0,4)
│   │
│   ├── partition(0,4)
│   │      pivot = 1
│   │      pivotIndex = 0
│   │
│   ├── quickSort(0,-1)
│   │      → return to quickSort(0,4)
│   │
│   └── quickSort(1,4)
│       │
│       ├── partition(1,4)
│       │      pivot = 5
│       │      pivotIndex = 4
│       │
│       ├── quickSort(1,3)
│       │   │
│       │   ├── partition(1,3)
│       │   │      pivot = 2
│       │   │      pivotIndex = 1
│       │   │
│       │   ├── quickSort(1,0)
│       │   │      → return to quickSort(1,3)
│       │   │
│       │   └── quickSort(2,3)
│       │       │
│       │       ├── partition(2,3)
│       │       │      pivot = 3
│       │       │      pivotIndex = 2
│       │       │
│       │       ├── quickSort(2,1)
│       │       │      → return to quickSort(2,3)
│       │       │
│       │       └── quickSort(3,3)
│       │              → return to quickSort(2,3)
│       │
│       │       quickSort(2,3) finishes
│       │       → return to quickSort(1,3)
│       │
│       │   quickSort(1,3) finishes
│       │   → return to quickSort(1,4)
│       │
│       └── quickSort(5,4)
│              → return to quickSort(1,4)
│
│       quickSort(1,4) finishes
│       → return to quickSort(0,4)
│
│   quickSort(0,4) finishes
│   → return to quickSort(0,7)
│
└── quickSort(6,7)
    │
    ├── partition(6,7)
    │      pivot = 7
    │      pivotIndex = 6
    │
    ├── quickSort(6,5)
    │      → return to quickSort(6,7)
    │
    └── quickSort(7,7)
           → return to quickSort(6,7)

    quickSort(6,7) finishes
    → return to quickSort(0,7)


quickSort(0,7) finishes
→ return to main()


-------------------------------------------
important notes for leet code question 493
-------------------------------------------
1. Main idea

The important observation is:

Use Merge Sort to divide the array and make each half sorted. Then use the sorted halves to count reverse pairs efficiently before merging them.

The overall structure is:

Merge Sort
    │
    ├── Sort left half
    │
    ├── Sort right half
    │
    ├── Count reverse pairs between the halves
    │
    └── Merge the two sorted halves

Your code follows exactly this pattern:

mergeSortInPlace(arr, low, mid);
mergeSortInPlace(arr, mid + 1, high);

reversePairs(arr, low, mid, mid + 1);

mergeInPlace(arr, low, mid, high);

2. Why do we count before merging?
After these two calls:

mergeSortInPlace(arr, low, mid);
mergeSortInPlace(arr, mid + 1, high);

we know:

Left half       Right half
sorted          sorted

For example:

[2, 4] | [1, 3, 5]
  ↑          ↑
sorted      sorted

Now we can efficiently count:

arr[i] > 2L * arr[j]

using the fact that both halves are sorted.

After counting, we merge them:

[2,4] + [1,3,5]
       ↓
[1,2,3,4,5]

The sorted result is important because the parent Merge Sort call depends on both halves being sorted.


3. What reversePairs() actually does
Your method:

static void reversePairs(int[] arr, int low, int mid, int high) {

    int j = mid + 1;

    for (int i = low; i <= mid; i++) {

        while (j <= high && arr[i] > 2L * arr[j]) {
            j++;
        }

        count += j - (mid + 1);
    }
}

Think of the two halves as:

Left half                 Right half

low ... mid              mid+1 ... high
   ↑                         ↑
   i                         j

i moves through the left half.

j moves through the right half.


4. Why j does not reset
This is one of the most important things to remember.

Suppose:

Left  = [5, 6, 10]
Right = [1, 2, 4]

For 5:

5 > 2×1  ✓
5 > 2×2  ✓
5 > 2×4  ✗

So j stops at 4.

Now move to 6.

Because the left half is sorted:

5 < 6

If:

5 > 2×4

was already false, then there is no reason to move j backward and check 1 or 2 again.

Therefore:

j only moves forward and never moves backward.

This is what makes the counting step linear.


-----------------------------------------------------------------------
subset generation with duplicate handling (SubsetWithDuplicates .java question)
-----------------------------------------------------------------------
why the below code is inefficient

static List<List<Integer>> subSetWithDuplicates(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int num : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                if (!outer.contains(internal)) {
                    outer.add(internal);
                }
            }
        }
        return outer;
    }

 Why This Code Is Inefficient
The main problem is this line:
if (!outer.contains(internal))
1. contains() searches the entire outer list
outer is an ArrayList.
When you write:
outer.contains(internal)
Java may have to check:
outer[0]
outer[1]
outer[2]
outer[3]
...

until it finds a matching subset.
So contains() is O(S) where S is the current number of subsets.
For example:

outer = [[], [1], [2], [1,2], [3], [1,3], ...]

To check whether [1,2] exists, Java may compare it against many existing lists.

         2. List.equals() also costs time
There is another hidden cost.
contains() doesn't simply compare references. For each candidate, it essentially uses:
internal.equals(existingList)
Two lists are compared element by element.
If a subset contains k elements, comparison can take:
O(k)
So the operation is roughly:
contains()
    ↓
search many subsets
    ↓
compare lists
    ↓
compare their elements


3. You generate duplicate subsets first

Suppose:

arr = [1, 2, 2]

When processing the second 2, your algorithm still generates candidate subsets.
Then it asks:

if (!outer.contains(internal))

to remove duplicates.
So the algorithm's strategy is:

Generate candidate
       ↓
Check whether duplicate
       ↓
Discard if duplicate

This is wasteful.
The better approach is:

Know which subsets should be extended
       ↓
Generate only valid new subsets

That's why the start/end technique is more efficient.

4. The inefficient part in one picture

Your approach:

             Generate subset
                    ↓
             [1, 2, 2]
                    ↓
             outer.contains()
                    ↓
          Search existing subsets
             /            \
          found          not found
            ↓                ↓
         discard            add

The optimized approach:

Duplicate detected
       ↓
Use start = end + 1
       ↓
Only extend subsets created
by the previous occurrence
       ↓
No contains() required
Complexity

Let n be the number of input elements.
For distinct elements, there can be up to:

2^n

subsets.
Your code repeatedly performs contains() over the growing outer list, and each list comparison can itself examine multiple elements.
Therefore, the algorithm has substantial extra overhead compared with the standard duplicate-handling technique.
The important interview point is:

The main inefficiency is that outer.contains(internal) repeatedly searches and compares the existing subsets, while the start/end technique avoids generating duplicate candidates in the first place.


-----------------------------------------------------------------
LeetCode 315 – Count of Smaller Numbers After Self
-----------------------------------------------------------------
# LC 315 – Count of Smaller Numbers After Self

## Question

Given an integer array `arr`, for each element `arr[i]`, count how many elements to its right are smaller than it.

### Example

```text
arr = [3, 4, 2, 5, 1]

Answer = [2, 2, 1, 1, 0]
```

Explanation:

```text
3 → [4, 2, 5, 1] → smaller: 2, 1 → 2
4 → [2, 5, 1]    → smaller: 2, 1 → 2
2 → [5, 1]       → smaller: 1    → 1
5 → [1]           → smaller: 1    → 1
1 → []            → 0
```

---

# Answer

The key idea is to use:

> **Merge Sort + `index[]` array**

Normal Merge Sort sorts the values, but here we need to preserve the **original position of every element**, because the answer must be stored according to the original index.

---

# 1. Why do we use `index[]` instead of sorting `arr[]`?

Initially:

```text
arr   = [3, 4, 2, 5, 1]
index = [0, 1, 2, 3, 4]
```

Each index represents:

```text
index 0 → arr[0] = 3
index 1 → arr[1] = 4
index 2 → arr[2] = 2
index 3 → arr[3] = 5
index 4 → arr[4] = 1
```

We **do not modify `arr[]`**.

Instead, we rearrange `index[]` according to the values in `arr`.

Eventually:

```text
index = [4, 2, 0, 1, 3]
```

represents:

```text
arr[4] = 1
arr[2] = 2
arr[0] = 3
arr[1] = 4
arr[3] = 5
```

So `index[]` is effectively sorted according to the values of `arr`.

### Why is this necessary?

If we directly sort:

```text
arr = [3, 4, 2, 5, 1]
```

into:

```text
[1, 2, 3, 4, 5]
```

we lose information about where each element originally came from.

But we need:

```text
answer[0] → answer for 3
answer[1] → answer for 4
answer[2] → answer for 2
answer[3] → answer for 5
answer[4] → answer for 1
```

Therefore:

> **We sort the indexes, not the original array, so that values can be rearranged for counting while their original positions remain known.**

---

# 2. What does `index[]` do?

Think of `index[]` as a **label attached to every number**.

Initially:

```text
3(0)   4(1)   2(2)   5(3)   1(4)
```

The number is the value.

The number inside parentheses is its original index.

During Merge Sort, the values are logically sorted:

```text
1(4)   2(2)   3(0)   4(1)   5(3)
```

But the original indexes remain attached:

```text
1 → index 4
2 → index 2
3 → index 0
4 → index 1
5 → index 3
```

This allows us to update the correct position in `list`.

---

# 3. What is `list`?

Initially:

```java
List<Integer> list = new ArrayList<>();
```

and:

```text
list = [0, 0, 0, 0, 0]
```

The position of `list` corresponds to the **original index**.

```text
list[0] → answer for arr[0] = 3
list[1] → answer for arr[1] = 4
list[2] → answer for arr[2] = 2
list[3] → answer for arr[3] = 5
list[4] → answer for arr[4] = 1
```

So if we discover that `3` has one smaller element:

```java
list.set(0, list.get(0) + 1);
```

We update using its **original index**.

---

# 4. Why do we use Merge Sort?

The important property is:

> **During merging, both halves are already sorted.**

For example:

```text
LEFT  = [2, 5]
RIGHT = [1, 6]
```

Compare:

```text
2 vs 1
```

Since:

```text
1 < 2
```

`1` is smaller than `2`.

So we take `1` from the right half and increment:

```java
j++;
```

Now:

```text
j = 1
```

When we later select `2`, `j = 1` tells us:

> One element from the right half has already been placed before `2`.

Because the right half is sorted, that element is smaller than `2`.

Therefore:

```java
list.set(
    left[i],
    list.get(left[i]) + j
);
```

adds `1` to the count of `2`.

---

# 5. What does `i` represent?

```java
int i = 0;
```

`i` represents the **current position in the `left[]` array**.

For example:

```text
left = [2, 5]
        ↑
        i
```

If:

```text
i = 0
```

we are currently processing:

```text
left[0]
```

When we select the left element, we do:

```java
i++;
```

because we have finished processing that left element.

Therefore:

> **`i` tells us which element of the left half we are currently processing.**

---

# 6. What does `j` represent?

```java
int j = 0;
```

`j` represents:

> **How many elements from the right half have already been placed into the merged array.**

Example:

```text
LEFT  = [2, 5]
RIGHT = [1, 6]
```

Initially:

```text
i = 0
j = 0
```

Compare:

```text
2 vs 1
```

Since:

```text
1 < 2
```

we take `1` from the right:

```java
j++;
```

Now:

```text
j = 1
```

This means:

```text
1 right-side element has already been placed
```

Then:

```text
2 vs 6
```

Since:

```text
2 < 6
```

we take `2`.

At this moment:

```text
j = 1
```

Therefore:

> **1 element from the right half is smaller than `2`.**

So:

```java
list.set(left[i], list.get(left[i]) + j);
```

adds `1` to the count of `2`.

---

# 7. Why exactly does `j` give the count?

This is the most important concept.

Suppose:

```text
LEFT  = [2, 5]
RIGHT = [1, 6]
```

After processing `1`:

```text
RIGHT = [1, 6]
          ↑
       already taken
```

Therefore:

```text
j = 1
```

When we process `2`:

```text
2 > 1
```

Therefore `1` is smaller than `2`.

When we process `5`:

```text
5 > 1
```

Therefore `1` is also smaller than `5`.

Since the right half is sorted:

> **All `j` elements already removed from the right half are smaller than the current left element.**

Therefore:

```text
number of smaller right elements = j
```

---

# 8. Why do we increment `j` when the right element is smaller?

The merge condition is:

```java
if (arr[left[i]] <= arr[right[j]]) {

    // Left element is smaller or equal
    ...

} else {

    // Right element is smaller
    index[k++] = right[j];
    j++;
}
```

Suppose:

```text
left  = 5
right = 2
```

Since:

```text
2 < 5
```

we take `2` first.

Then:

```java
j++;
```

Now:

```text
j = 1
```

This records:

> **1 smaller right-side element has passed the left elements.**

Later, when `5` is selected:

```text
count[5] += j
```

---

# 9. Why do we add `j` only when selecting a left element?

We are calculating:

> **How many elements from the right half are smaller than this left element?**

Suppose:

```text
LEFT  = [2, 5]
RIGHT = [1, 6]
```

When `1` is selected:

```text
j = 1
```

But we don't immediately update `2` or `5`.

We wait until a left element is selected.

When `2` is selected:

```text
count[2] += 1
```

When `5` is selected:

```text
count[5] += 1
```

So one smaller right element can contribute to multiple left elements.

---

# 10. Why can the same `j` be used for both `2` and `5`?

Because:

```text
RIGHT = [1, 6]
```

is sorted.

Once `1` has been removed:

```text
j = 1
```

we know:

```text
1 < 2
1 < 5
```

Therefore both `2` and `5` get:

```text
+1
```

This is the efficiency gained from sorting.

---

# 11. What does `k` represent?

```java
int k = low;
```

`k` is the position where we put the next element into the original `index[]`.

Therefore:

```text
i → position in left[]
j → position in right[]
k → position in index[]
```

For example:

```text
left  = [2, 5]
right = [1, 6]

i = 0
j = 0
k = low
```

When `1` is smaller:

```java
index[k++] = right[j];
```

When `2` is selected:

```java
index[k++] = left[i];
```

So `k` builds the sorted `index[]`.

---

# 12. Why are `left[]` and `right[]` required?

During merging, we modify `index[]`:

```java
index[k++] = left[i];
```

or:

```java
index[k++] = right[j];
```

Therefore, we first copy the two halves:

```java
System.arraycopy(index, low, left, 0, n1);
System.arraycopy(index, mid + 1, right, 0, n2);
```

This gives us safe copies from which we can read while rebuilding `index[]`.

The flow is:

```text
index[]
   ↓
 copy
   ↓
left[]     right[]
   \          /
    \        /
     \      /
      merge
        ↓
     index[]
```

---

# 13. Why does `index[]` change after every merge?

Initially:

```text
index = [0, 1, 2, 3, 4]
```

It represents:

```text
3  4  2  5  1
```

After smaller merges, the indexes become rearranged according to their values.

Eventually:

```text
index = [4, 2, 0, 1, 3]
```

which represents:

```text
arr[4] = 1
arr[2] = 2
arr[0] = 3
arr[1] = 4
arr[3] = 5
```

So:

```text
index  = [4, 2, 0, 1, 3]
values = [1, 2, 3, 4, 5]
```

Important:

> **The index values themselves remain the original indexes. Their positions inside `index[]` change.**

---

# 14. The Most Important Line

This is the heart of the solution:

```java
list.set(
    left[i],
    list.get(left[i]) + j
);
```

Break it down.

### `left[i]`

This tells us:

> **Which original element am I currently processing?**

For example:

```text
left[i] = 0
```

means:

```text
arr[0] = 3
```

### `j`

This tells us:

> **How many smaller elements from the right half have already passed this element?**

Therefore:

```java
list.get(left[i]) + j
```

means:

> **Previous count + newly discovered smaller right-side elements.**

---

# 15. Why do counts accumulate across different merges?

This is another important idea.

Take:

```text
arr = [3, 4, 2, 5, 1]
```

For `4`, the smaller elements on its right are:

```text
2, 1
```

But Merge Sort doesn't necessarily discover both at the same time.

It can discover:

```text
4 > 2
```

during one merge:

```text
[4] | [2]
```

giving:

```text
count[4] = 1
```

Then later:

```text
4 > 1
```

is discovered during a higher-level merge.

So:

```text
count[4] = 1 + 1
         = 2
```

That's why the code uses:

```java
list.get(left[i]) + j
```

rather than simply:

```java
list.set(left[i], j);
```

We need to **accumulate counts from different merge levels**.

---

# 16. Complete Mental Model

Think of the algorithm like this:

```text
                    arr
                     |
                     ↓
             Keep arr unchanged
                     |
                     ↓
                  index[]
                     |
              Merge Sort by
              arr[index[i]]
                     |
           +---------+---------+
           |                   |
           ↓                   ↓
        left[]              right[]
           |                   |
           +---------+---------+
                     |
                     ↓
                  compare
                     |
          Is right element smaller?
                 /          \
               YES           NO
                |             |
               j++        choose left
                |             |
                +------+------+
                       |
                       ↓
              when choosing left
                       |
                       ↓
                   count += j
                       |
                       ↓
               list[originalIndex]
```

---

# 17. Final Meaning of Each Variable

| Variable | Meaning |
|---|---|
| `arr[]` | Original values; never rearranged |
| `index[]` | Original indexes arranged according to `arr` values |
| `left[]` | Copy of left-half indexes |
| `right[]` | Copy of right-half indexes |
| `i` | Current position in `left[]` |
| `j` | Number of right-half elements already placed |
| `k` | Position where we write into `index[]` |
| `list` | Final count for every original index |
| `low` | Start of current merge range |
| `mid` | Boundary between left and right halves |
| `high` | End of current merge range |

---

# Key Idea to Remember

> **We use Merge Sort to arrange indexes according to their values. During merging, whenever a smaller element from the right half is placed, we increment `j`. When a left element is finally placed, `j` tells us how many smaller elements from the right half have already passed it. We add that count to the left element's original index in `list`.**

The three most important things to remember:

```text
index[] → remembers ORIGINAL POSITION
i       → current LEFT element
j       → number of smaller RIGHT elements already passed
```

### One-line summary

> **Sort the indexes by value, count smaller right-side elements during the merge, and store each count using the element's original index.**