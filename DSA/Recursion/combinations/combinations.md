# Combinations Using Backtracking

## 1. What is a Combination?

A **combination** means selecting elements where **order does not matter**.

For example, from:

```text
[1, 2, 3]
```

select 2 elements:

```text
[1, 2]
[1, 3]
[2, 3]
```
# Combination

## Meaning

Combination = Selection only + Order does NOT matter

## Formula

$$
\boxed{{}^nC_r = \frac{n!}{r!(n-r)!}}
$$

## Example

From 5 people, select 3:

$$
{}^5C_3 = \frac{5!}{3!(5-3)!}
$$

$$
= \frac{5!}{3!2!}
$$

$$
= \frac{120}{6 \times 2}
$$

$$
= 10
$$

So there are **10 combinations**.

---

## Combination vs Permutation

### Combination

$$
[1,2] = [2,1]
$$

Order does **not** matter.


---


`[1,2]` and `[2,1]` represent the same combination.

### Combination vs Permutation

```text
Combination:
[1,2] = [2,1]

Permutation:
[1,2] != [2,1]
```
 # Main Difference

|          | Permutation             | Combination               |
|----------|-------------------------|----------------------------|
| Meaning  | Arrangement             | Selection                  |
| Order    | **Matters**             | **Doesn't matter**         |
| Formula  | \(\frac{n!}{(n-r)!}\)  | \(\frac{n!}{r!(n-r)!}\)   |
| Notation | \(nP_r\)                | \(nC_r\)                   |
| Example  | ABC ≠ BAC               | ABC = BAC                  |


The main idea is:

> **In combinations, we do not go backward to previously considered elements.**

---

# 2. Example

Suppose:

```text
nums = [1, 2, 3, 4]
k = 2
```

We need to generate:

```text
[1,2]
[1,3]
[1,4]
[2,3]
[2,4]
[3,4]
```

We do **not** generate:

```text
[2,1]
[3,1]
[3,2]
[4,1]
...
```

because order does not matter.

---

# 3. The Key Idea: `start`

The most important concept in combination backtracking is `start`.

`start` tells the recursive function:

> **"From which index am I allowed to choose the next element?"**

Suppose we choose:

```text
1
```

Now we only consider:

```text
2, 3, 4
```

We don't consider `1` again.

If we choose:

```text
2
```

then the next choices can only be:

```text
3, 4
```

Therefore:

```text
1 → 2 → 3 → 4
```

We always move forward.

---

# 4. Why `i + 1`?

The recursive call is:

```java
backtrack(i + 1);
```

Suppose:

```text
nums = [1, 2, 3, 4]
```

and we choose:

```text
nums[i] = 1
```

The index of `1` is:

```text
i = 0
```

Therefore:

```text
i + 1 = 1
```

The next recursive call starts from index `1`, which contains `2`.

So:

```text
Choose 1
   ↓
start = 1
   ↓
Can choose 2, 3, 4
```

If we choose `2`:

```text
Choose 2
   ↓
start = 2
   ↓
Can choose 3, 4
```

Thus:

> **`i + 1` prevents reusing the current element and prevents going backward.**

---

# 5. Standard Combination Backtracking Code

```java
void combine(int[] nums, int k, int start,
             List<Integer> current,
             List<List<Integer>> result) {

    // Base case
    if (current.size() == k) {
        result.add(new ArrayList<>(current));
        return;
    }

    // Try every possible next choice
    for (int i = start; i < nums.length; i++) {

        // Choose
        current.add(nums[i]);

        // Explore
        combine(nums, k, i + 1, current, result);

        // Undo
        current.remove(current.size() - 1);
    }
}
```

Initial call:

```java
combine(nums, 2, 0, new ArrayList<>(), result);
```

---

# 6. The Three Steps of Backtracking

The most important part of the code is:

```java
current.add(nums[i]);

combine(nums, k, i + 1, current, result);

current.remove(current.size() - 1);
```

This represents:

```text
Choose
  ↓
Explore
  ↓
Undo
```

### Choose

```java
current.add(nums[i]);
```

Add the current element to the combination.

### Explore

```java
combine(nums, k, i + 1, current, result);
```

Recursively explore all combinations that can be created after this choice.

### Undo

```java
current.remove(current.size() - 1);
```

Remove the chosen element so that the next choice can be tried.

This **undo step is the backtracking part**.

---

# 7. Combination Tree

For:

```text
nums = [1, 2, 3, 4]
k = 2
```

the tree is:

```text
                         []
              /          |          |          \
             1           2           3           4
          /  |  \      /  \          |
         2   3   4    3    4         4
         |   |   |    |    |         |
        12  13  14   23   24        34
```

Therefore:

```text
[1,2]
[1,3]
[1,4]
[2,3]
[2,4]
[3,4]
```

There is no `[2,1]` because after choosing `2`, we only look at elements after `2`.

---

# 8. How One Branch Works

Initially:

```text
current = []
start = 0
```

Choose `1`:

```text
current = [1]
```

Recursive call:

```text
backtrack(start = 1)
```

Now the possible next choices are:

```text
2
3
4
```

### Choose 2

```text
current = [1,2]
```

Now:

```text
current.size() == k
```

So:

```java
result.add(new ArrayList<>(current));
return;
```

After returning:

```text
current = [1,2]
```

Undo:

```java
current.remove(current.size() - 1);
```

Now:

```text
current = [1]
```

The loop continues and tries `3`.

```text
[1,3]
```

Then undo:

```text
[1]
```

Then tries `4`:

```text
[1,4]
```

Then undo:

```text
[1]
```

After all choices starting with `1` are finished, `1` itself is removed:

```text
[1]
 ↓
[]
```

Now the algorithm can start with `2`.

---

# 9. Complete Recursive Flow

For:

```text
nums = [1,2,3,4]
k = 2
```

the important flow is:

```text
C(start=0, current=[])
│
│ i = 0 → choose arr[0] = 1
│
└── C(start=1, current=[1])
    │
    │ i = 1 → choose arr[1] = 2
    │
    └── C(start=2, current=[1,2])
        │
        │ current.size() == k
        │
        │ result.add([1,2])
        │
        └── RETURN
            ↑
            │
            │ Back to C(start=1, current=[1])
            │
            │ remove(2)
            │ current = [1]
            │
            │ i = 2 → choose arr[2] = 3
            │
            └── C(start=3, current=[1,3])
                │
                │ current.size() == k
                │
                │ result.add([1,3])
                │
                └── RETURN
                    ↑
                    │
                    │ Back to C(start=1, current=[1])
                    │
                    │ remove(3)
                    │ current = [1]
                    │
                    │ i = 3 → choose arr[3] = 4
                    │
                    └── C(start=4, current=[1,4])
                        │
                        │ current.size() == k
                        │
                        │ result.add([1,4])
                        │
                        └── RETURN
                            ↑
                            │
                            │ Back to C(start=1, current=[1])
                            │
                            │ remove(4)
                            │ current = [1]
                            │
                            │ for loop finished
                            │
                            └── RETURN
                                ↑
                                │
                                │ Back to C(start=0, current=[])
                                │
                                │ remove(1)
                                │ current = []
                                │
                                │ i = 1 → choose arr[1] = 2
                                │
                                └── C(start=2, current=[2])
                                    │
                                    │ i = 2 → choose arr[2] = 3
                                    │
                                    └── C(start=3, current=[2,3])
                                        │
                                        │ current.size() == k
                                        │
                                        │ result.add([2,3])
                                        │
                                        └── RETURN
                                            ↑
                                            │
                                            │ Back to C(start=2, current=[2])
                                            │
                                            │ remove(3)
                                            │ current = [2]
                                            │
                                            │ i = 3 → choose arr[3] = 4
                                            │
                                            └── C(start=4, current=[2,4])
                                                │
                                                │ current.size() == k
                                                │
                                                │ result.add([2,4])
                                                │
                                                └── RETURN
                                                    ↑
                                                    │
                                                    │ Back to C(start=2, current=[2])
                                                    │
                                                    │ remove(4)
                                                    │ current = [2]
                                                    │
                                                    │ for loop finished
                                                    │
                                                    └── RETURN
                                                        ↑
                                                        │
                                                        │ Back to C(start=0, current=[])
                                                        │
                                                        │ remove(2)
                                                        │ current = []
                                                        │
                                                        │ i = 2 → choose arr[2] = 3
                                                        │
                                                        └── C(start=3, current=[3])
                                                            │
                                                            │ i = 3 → choose arr[3] = 4
                                                            │
                                                            └── C(start=4, current=[3,4])
                                                                │
                                                                │ current.size() == k
                                                                │
                                                                │ result.add([3,4])
                                                                │
                                                                └── RETURN
                                                                    ↑
                                                                    │
                                                                    │ Back to C(start=3, current=[3])
                                                                    │
                                                                    │ remove(4)
                                                                    │ current = [3]
                                                                    │
                                                                    │ for loop finished
                                                                    │
                                                                    └── RETURN
                                                                        ↑
                                                                        │
                                                                        │ Back to C(start=0, current=[])
                                                                        │
                                                                        │ remove(3)
                                                                        │ current = []
                                                                        │
                                                                        │ i = 3 → choose arr[3] = 4
                                                                        │
                                                                        └── C(start=4, current=[4])
                                                                            │
                                                                            │ for:
                                                                            │ i = 4
                                                                            │
                                                                            │ 4 < arr.length(4) → FALSE
                                                                            │
                                                                            │ Loop doesn't execute
                                                                            │
                                                                            └── RETURN
                                                                                ↑
                                                                                │
                                                                                │ Back to C(start=0, current=[])
                                                                                │
                                                                                │ remove(4)
                                                                                │ current = []
                                                                                │
                                                                                │ for loop finished
                                                                                │
                                                                                └── RETURN
```

---

# 10. `current` and `result`

### `current`

```java
List<Integer> current
```

Stores the **combination currently being built**.

Example:

```text
[]
[1]
[1,2]
```

After backtracking:

```text
[1,2]
 ↓ remove 2
[1]
```

---

### `result`

```java
List<List<Integer>> result
```

Stores all completed combinations:

```text
[
    [1,2],
    [1,3],
    [1,4],
    [2,3],
    [2,4],
    [3,4]
]
```

---

# 11. Why `new ArrayList<>(current)`?

Use:

```java
result.add(new ArrayList<>(current));
```

instead of:

```java
result.add(current);
```

because `current` is continuously modified during backtracking.

For example:

```text
current = [1,2]
```

Store a **copy**:

```text
result = [[1,2]]
```

Then:

```text
current.remove(2)
```

gives:

```text
current = [1]
```

The stored `[1,2]` must remain unchanged.

Therefore:

```java
new ArrayList<>(current)
```

creates an independent copy.

---

# 12. Combination vs Permutation

### Combination

Order does not matter:

```text
[1,2] = [2,1]
```

Use:

```java
backtrack(i + 1);
```

Think:

```text
Move forward
```

---

### Permutation

Order matters:

```text
[1,2] != [2,1]
```

Typically use:

```java
boolean[] used;
```

Think:

```text
Any unused element can be chosen
```

---

# 13. Four Things to Remember

When solving a combination backtracking problem, identify:

### 1. `current`

What have I selected so far?

```java
List<Integer> current
```

### 2. `start`

Where can my next choice begin?

```java
int start
```

### 3. `i + 1`

After selecting index `i`, start from the next index.

```java
backtrack(i + 1);
```

### 4. Undo

Restore the state after the recursive call.

```java
current.remove(current.size() - 1);
```

---

# 14. The Pattern to Remember

```text
                Choose
                   ↓
             current.add()
                   ↓
               Explore
                   ↓
          backtrack(i + 1)
                   ↓
                Return
                   ↓
                 Undo
                   ↓
            current.remove()
                   ↓
            Try next choice
```

The fundamental combination-backtracking pattern is:

```java
for (int i = start; i < n; i++) {

    current.add(nums[i]);       // Choose

    backtrack(i + 1);           // Explore

    current.remove(
        current.size() - 1
    );                          // Undo
}
```

> **Combination = choose elements from left to right, use `i + 1` to move forward, and undo the choice after the recursive call.**