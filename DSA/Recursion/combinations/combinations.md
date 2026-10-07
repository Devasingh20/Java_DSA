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
Main Difference

|          | Permutation | Combination |
|----------|-------------|-------------|
| Meaning  | Arrangement  | Selection   |
| Order    | **Matters** | **Doesn't matter** |
| Formula  | $$\frac{n!}{(n-r)!}$$ | $$\frac{n!}{r!(n-r)!}$$ |
| Notation | $$nP_r$$ | $$nC_r$$ |
| Example  | ABC ≠ BAC | ABC = BAC |


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
##

# Combination Sum — LeetCode 39

## 1. What is the Question?

You are given an array of **distinct positive integers** `candidates` and a target integer `target`.

Return **all unique combinations** of candidates where the chosen numbers add up to `target`.

The important rule is:

> **You can use the same number unlimited times.**

### Example

```text
candidates = [2,3,6,7]
target = 7

Valid combinations:
[2,2,3]
[7]

Because:
2 + 2 + 3 = 7

and:
7 = 7
```
## 2. Combination vs Combination Sum
```text
This is very important.
In the Combinations problem you just learned:
n = 4
k = 2

we choose exactly k elements:
[1,2]
[1,3]
[1,4]
[2,3]
[2,4]
[3,4]

Each element can be selected only once.
In Combination Sum:
candidates = [2,3,6,7]
target = 7

we don't know how many elements we need.
We keep selecting until:
sum == target

And we can reuse an element:
2 → 2 → 2 → ...

So:
[2,2,3]

is allowed.
```
## 3. The Biggest Difference
```text
Combination
combinations(..., i + 1, ...)

We move forward because an element cannot be reused.
Combination Sum
combinations(..., i, ...)

We do not move to i + 1 after choosing an element.
Why?
Because we are allowed to choose the same element again.
This is the most important idea in Combination Sum.
```
## 4. Backtracking Idea
```text
We use:
Choose
   ↓
Explore
   ↓
Undo

For example:
candidates = [2,3,6,7]
target = 7

Start:
current = []
sum = 0

Choose 2:
current = [2]
sum = 2

Because 2 can be reused, we can choose 2 again:
current = [2,2]
sum = 4

Again:
current = [2,2,2]
sum = 6

Again:
current = [2,2,2,2]
sum = 8

Now:
8 > 7
```
So this branch is invalid.
We backtrack.
## 5. The Three Important Cases
```text
At every recursive call, there are three possibilities.
Case 1 — Target reached
sum == target

We found a valid combination.
SAVE current

Case 2 — Sum becomes too large
sum > target

This branch can never work.
So:
RETURN

Case 3 — Sum is still smaller
sum < target
```
Continue choosing elements.
## 6. Code
A clean version is:
```java
class Solution {

    public List<List<Integer>> combinationSum(
            int[] candidates,
            int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        combinations(
                candidates,
                target,
                0,
                current,
                result
        );

        return result;
    }

    static void combinations(
            int[] candidates,
            int target,
            int start,
            List<Integer> current,
            List<List<Integer>> result) {

        // Target reached
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Target exceeded
        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // Choose
            current.add(candidates[i]);

            // Explore
            combinations(
                    candidates,
                    target - candidates[i],
                    i,
                    current,
                    result
            );

            // Undo
            current.remove(current.size() - 1);
        }
    }
}
```
## 7. Why Do We Pass i Instead of i + 1?
This is the heart of Combination Sum.
Look at:
```java
combinations(
    candidates,
    target - candidates[i],
    i,
    current,
    result
);
```
Notice:
i

not:
i + 1

Suppose:
candidates = [2,3,6,7]

We choose:
2

Now:
current = [2]

We want to be able to choose 2 again:
[2,2]

Therefore we call:
```java
combinations(..., i, ...)
```
instead of:
```java
combinations(..., i + 1, ...)
```
## 8. Compare With Your Previous Combination Code
Your previous code had:
```java
combinations(
    arr,
    result,
    current,
    i + 1,
    k
);
```
because:
Element can be used only once

For Combination Sum:
```java
combinations(
    candidates,
    target - candidates[i],
    i,
    current,
    result
);
```
because:
Element can be used unlimited times

Remember this:
Combination
       ↓
i + 1
       ↓
Don't reuse

Combination Sum
       ↓
i
       ↓
Can reuse

## 9. Recursive Tree
Let's understand:
candidates = [2,3,6,7]
target = 7
```text
At the beginning:
                        []
                     target = 7
                    /    |    |    \
                  2      3    6     7

Choose 2:
                         []
                          |
                       choose 2
                          ↓
                       [2]
                     target = 5

Because 2 can be reused:
                         [2]
                          |
                         2
                          ↓
                       [2,2]
                     target = 3

Again:
                       [2,2]
                          |
                         2
                          ↓
                     [2,2,2]
                    target = 1
```
Now no candidate can make the remaining target 1.
So this branch returns.
```text
Backtrack:
[2,2]

Now choose 3:
[2,2,3]
target = 0

Therefore:
💾 SAVE [2,2,3]

10. Another Valid Branch
From:
[]
target = 7

choose 7:
[7]
target = 0

Therefore:
💾 SAVE [7]

Final result:
[
    [2,2,3],
    [7]
]
```
## 11. Why Don't We Get [3,2,2]?
This is another very important concept.
Suppose we already generated:
```text
[2,2,3]

We don't want:
[2,3,2]
[3,2,2]

because these represent the same combination.
Combination means:
[2,2,3] = [2,3,2] = [3,2,2]
```
So we maintain the start index.
Once we move forward, we don't go backward.
For example:
2 → 3

is allowed.
But:
3 → 2

is not allowed.
That's how we avoid duplicate combinations.
## 12. The Core Difference
This is the part I want you to remember for DSA:
```text
Problem	Recursive Call	Meaning
Permutation	i / visited	Elements can appear in different orders
Combination	i + 1	Element used once
Combination Sum	i	Element can be reused
```

**For Combination Sum:**
combinations(..., i, ...)

means:
"I chose candidates[i], but I am allowed to choose it again."

# Complete Recursive Trace — Combination Sum

Let's trace **the exact code**.

**`candidates = [2,3,6,7]`**  
**`target = 7`**

### Symbols

- 🟢 **Choose**
- 🔵 **Recursive call**
- 💾 **Save**
- 🔴 **`target < 0` → return**
- ↩️ **Return from recursive call**
- ↩️ **Undo**
- `i` = current loop index
- `start` = index from where the current recursive call is allowed to choose
- `target` = remaining target at that level

---

# Complete Recursive Tree

```text
combinationSum([2,3,6,7], 7)
│
└── combinations(
        target = 7,
        start = 0,
        current = []
    )
    │
    ├── i = 0 → choose 2 🟢
    │
    │   current = [2]
    │   target  = 7 - 2 = 5
    │   start   = 0
    │
    │   🔵 Recursive call:
    │
    │   combinations(
    │       target = 5,
    │       start = 0,
    │       current = [2]
    │   )
    │
    │   ├── i = 0 → choose 2 🟢
    │   │
    │   │   current = [2,2]
    │   │   target  = 5 - 2 = 3
    │   │   start   = 0
    │   │
    │   │   🔵 Recursive call:
    │   │
    │   │   combinations(
    │   │       target = 3,
    │   │       start = 0,
    │   │       current = [2,2]
    │   │   )
    │   │
    │   │   ├── i = 0 → choose 2 🟢
    │   │   │
    │   │   │   current = [2,2,2]
    │   │   │   target  = 3 - 2 = 1
    │   │   │   start   = 0
    │   │   │
    │   │   │   🔵 Recursive call:
    │   │   │
    │   │   │   combinations(
    │   │   │       target = 1,
    │   │   │       start = 0,
    │   │   │       current = [2,2,2]
    │   │   │   )
    │   │   │
    │   │   │   ├── i = 0 → choose 2 🟢
    │   │   │   │
    │   │   │   │   current = [2,2,2,2]
    │   │   │   │   target  = 1 - 2 = -1
    │   │   │   │   start   = 0
    │   │   │   │
    │   │   │   │   🔵 Recursive call:
    │   │   │   │
    │   │   │   │   combinations(
    │   │   │   │       target = -1,
    │   │   │   │       start = 0,
    │   │   │   │       current = [2,2,2,2]
    │   │   │   │   )
    │   │   │   │
    │   │   │   │   target < 0
    │   │   │   │
    │   │   │   │   🔴 RETURN
    │   │   │   │
    │   │   │   │   ↩️ Return to:
    │   │   │   │   [2,2,2]
    │   │   │   │
    │   │   │   │   ↩️ Undo
    │   │   │   │   current = [2,2,2]
    │   │   │   │
    │   │   │   ├── i = 1 → choose 3 🟢
    │   │   │   │
    │   │   │   │   current = [2,2,2,3]
    │   │   │   │   target  = 1 - 3 = -2
    │   │   │   │   start   = 1
    │   │   │   │
    │   │   │   │   🔵 Recursive call:
    │   │   │   │
    │   │   │   │   combinations(
    │   │   │   │       target = -2,
    │   │   │   │       start = 1,
    │   │   │   │       current = [2,2,2,3]
    │   │   │   │   )
    │   │   │   │
    │   │   │   │   target < 0
    │   │   │   │
    │   │   │   │   🔴 RETURN
    │   │   │   │
    │   │   │   │   ↩️ Return
    │   │   │   │
    │   │   │   │   ↩️ Undo
    │   │   │   │   current = [2,2,2]
    │   │   │   │
    │   │   │   ├── i = 2 → choose 6 🟢
    │   │   │   │
    │   │   │   │   current = [2,2,2,6]
    │   │   │   │   target  = 1 - 6 = -5
    │   │   │   │   start   = 2
    │   │   │   │
    │   │   │   │   🔵 Recursive call
    │   │   │   │
    │   │   │   │   target < 0
    │   │   │   │
    │   │   │   │   🔴 RETURN
    │   │   │   │
    │   │   │   │   ↩️ Return
    │   │   │   │
    │   │   │   │   ↩️ Undo
    │   │   │   │   current = [2,2,2]
    │   │   │   │
    │   │   │   └── i = 3 → choose 7 🟢
    │   │   │
    │   │   │       current = [2,2,2,7]
    │   │   │       target  = 1 - 7 = -6
    │   │   │       start   = 3
    │   │   │
    │   │   │       🔵 Recursive call
    │   │   │
    │   │   │       target < 0
    │   │   │
    │   │   │       🔴 RETURN
    │   │   │
    │   │   │       ↩️ Return
    │   │   │
    │   │   │       ↩️ Undo
    │   │   │       current = [2,2,2]
    │   │   │
    │   │   └── loop finished
    │   │       ↩️ RETURN
    │   │
    │   │   ↩️ Return to [2,2]
    │   │
    │   │   ↩️ Undo
    │   │   current = [2,2]
    │   │
    │   ├── i = 1 → choose 3 🟢
    │   │
    │   │   current = [2,2,3]
    │   │   target  = 3 - 3 = 0
    │   │   start   = 1
    │   │
    │   │   🔵 Recursive call:
    │   │
    │   │   combinations(
    │   │       target = 0,
    │   │       start = 1,
    │   │       current = [2,2,3]
    │   │   )
    │   │
    │   │   target == 0
    │   │
    │   │   💾 SAVE [2,2,3]
    │   │
    │   │   ↩️ RETURN
    │   │
    │   │   ↩️ Return to [2,2]
    │   │
    │   │   ↩️ Undo
    │   │   current = [2,2]
    │   │
    │   ├── i = 2 → choose 6 🟢
    │   │
    │   │   current = [2,2,6]
    │   │   target  = 3 - 6 = -3
    │   │   start   = 2
    │   │
    │   │   🔵 Recursive call
    │   │
    │   │   target < 0
    │   │
    │   │   🔴 RETURN
    │   │
    │   │   ↩️ Return
    │   │
    │   │   ↩️ Undo
    │   │   current = [2,2]
    │   │
    │   └── i = 3 → choose 7 🟢
    │
    │       current = [2,2,7]
    │       target  = 3 - 7 = -4
    │       start   = 3
    │
    │       🔵 Recursive call
    │
    │       target < 0
    │
    │       🔴 RETURN
    │
    │       ↩️ Return
    │
    │       ↩️ Undo
    │       current = [2,2]
    │
    │   loop finished
    │   ↩️ RETURN
    │
    │   ↩️ Return to [2]
    │
    │   ↩️ Undo
    │   current = [2]
    │
    ├── i = 1 → choose 3 🟢
    │
    │   current = [2,3]
    │   target  = 5 - 3 = 2
    │   start   = 1
    │
    │   🔵 Recursive call:
    │
    │   combinations(
    │       target = 2,
    │       start = 1,
    │       current = [2,3]
    │   )
    │   │
    │   ├── i = 1 → choose 3 🟢
    │   │   │
    │   │   current = [2,3,3]
    │   │   target  = 2 - 3 = -1
    │   │   start   = 1
    │   │
    │   │   🔵 Recursive call
    │   │
    │   │   target < 0
    │   │
    │   │   🔴 RETURN
    │   │
    │   │   ↩️ Return
    │   │
    │   │   ↩️ Undo
    │   │   current = [2,3]
    │   │
    │   ├── i = 2 → choose 6 🟢
    │   │
    │   │   current = [2,3,6]
    │   │   target  = 2 - 6 = -4
    │   │   start   = 2
    │   │
    │   │   🔵 Recursive call
    │   │
    │   │   target < 0
    │   │
    │   │   🔴 RETURN
    │   │
    │   │   ↩️ Return
    │   │
    │   │   ↩️ Undo
    │   │   current = [2,3]
    │   │
    │   └── i = 3 → choose 7 🟢
    │
    │       current = [2,3,7]
    │       target  = 2 - 7 = -5
    │       start   = 3
    │
    │       🔵 Recursive call
    │
    │       target < 0
    │
    │       🔴 RETURN
    │
    │       ↩️ Return
    │
    │       ↩️ Undo
    │       current = [2,3]
    │
    │   loop finished
    │   ↩️ RETURN
    │
    │   ↩️ Return to [2]
    │
    │   ↩️ Undo
    │   current = [2]
    │
    ├── i = 2 → choose 6 🟢
    │
    │   current = [2,6]
    │   target  = 5 - 6 = -1
    │   start   = 2
    │
    │   🔵 Recursive call
    │
    │   target < 0
    │
    │   🔴 RETURN
    │
    │   ↩️ Return
    │
    │   ↩️ Undo
    │   current = [2]
    │
    └── i = 3 → choose 7 🟢
        │
        current = [2,7]
        target  = 5 - 7 = -2
        start   = 3
        │
        🔵 Recursive call
        │
        target < 0
        │
        🔴 RETURN
        │
        ↩️ Return
        │
        ↩️ Undo
        current = [2]
    │
    │
    │ loop finished
    │ ↩️ RETURN
    │
    ↩️ Return to []
    │
    ↩️ Undo
    current = []
    
    
    ├── i = 1 → choose 3 🟢
    │
    │   current = [3]
    │   target  = 7 - 3 = 4
    │   start   = 1
    │
    │   🔵 Recursive call:
    │
    │   combinations(
    │       target = 4,
    │       start = 1,
    │       current = [3]
    │   )
    │   │
    │   ├── i = 1 → choose 3 🟢
    │   │   │
    │   │   current = [3,3]
    │   │   target  = 4 - 3 = 1
    │   │   start   = 1
    │   │
    │   │   🔵 Recursive call:
    │   │
    │   │   combinations(
    │   │       target = 1,
    │   │       start = 1,
    │   │       current = [3,3]
    │   │   )
    │   │   │
    │   │   ├── i = 1 → choose 3 🟢
    │   │   │
    │   │   │   current = [3,3,3]
    │   │   │   target  = 1 - 3 = -2
    │   │   │   start   = 1
    │   │   │
    │   │   │   🔵 Recursive call
    │   │   │
    │   │   │   target < 0
    │   │   │
    │   │   │   🔴 RETURN
    │   │   │
    │   │   │   ↩️ Return
    │   │   │
    │   │   │   ↩️ Undo
    │   │   │   current = [3,3]
    │   │   │
    │   │   ├── i = 2 → choose 6 🟢
    │   │   │
    │   │   │   current = [3,3,6]
    │   │   │   target  = 1 - 6 = -5
    │   │   │   start   = 2
    │   │   │
    │   │   │   🔵 Recursive call
    │   │   │
    │   │   │   target < 0
    │   │   │
    │   │   │   🔴 RETURN
    │   │   │
    │   │   │   ↩️ Return
    │   │   │
    │   │   │   ↩️ Undo
    │   │   │   current = [3,3]
    │   │   │
    │   │   └── i = 3 → choose 7 🟢
    │   │
    │   │       current = [3,3,7]
    │   │       target  = 1 - 7 = -6
    │   │       start   = 3
    │   │
    │   │       🔵 Recursive call
    │   │
    │   │       target < 0
    │   │
    │   │       🔴 RETURN
    │   │
    │   │       ↩️ Return
    │   │
    │   │       ↩️ Undo
    │   │       current = [3,3]
    │   │
    │   │   loop finished
    │   │   ↩️ RETURN
    │   │
    │   │   ↩️ Return to [3]
    │   │
    │   │   ↩️ Undo
    │   │   current = [3]
    │   │
    │   ├── i = 2 → choose 6 🟢
    │   │
    │   │   current = [3,6]
    │   │   target  = 4 - 6 = -2
    │   │   start   = 2
    │   │
    │   │   🔵 Recursive call
    │   │
    │   │   target < 0
    │   │
    │   │   🔴 RETURN
    │   │
    │   │   ↩️ Return
    │   │
    │   │   ↩️ Undo
    │   │   current = [3]
    │   │
    │   └── i = 3 → choose 7 🟢
    │
    │       current = [3,7]
    │       target  = 4 - 7 = -3
    │       start   = 3
    │
    │       🔵 Recursive call
    │
    │       target < 0
    │
    │       🔴 RETURN
    │
    │       ↩️ Return
    │
    │       ↩️ Undo
    │       current = [3]
    │
    │   loop finished
    │   ↩️ RETURN
    │
    ↩️ Return to []
    │
    ↩️ Undo
    current = []
    
    
    ├── i = 2 → choose 6 🟢
    │
    │   current = [6]
    │   target  = 7 - 6 = 1
    │   start   = 2
    │
    │   🔵 Recursive call:
    │
    │   combinations(
    │       target = 1,
    │       start = 2,
    │       current = [6]
    │   )
    │   │
    │   ├── i = 2 → choose 6 🟢
    │   │   │
    │   │   current = [6,6]
    │   │   target  = 1 - 6 = -5
    │   │   start   = 2
    │   │
    │   │   🔵 Recursive call
    │   │
    │   │   target < 0
    │   │
    │   │   🔴 RETURN
    │   │
    │   │   ↩️ Return
    │   │
    │   │   ↩️ Undo
    │   │   current = [6]
    │   │
    │   └── i = 3 → choose 7 🟢
    │
    │       current = [6,7]
    │       target  = 1 - 7 = -6
    │       start   = 3
    │
    │       🔵 Recursive call
    │
    │       target < 0
    │
    │       🔴 RETURN
    │
    │       ↩️ Return
    │
    │       ↩️ Undo
    │       current = [6]
    │
    │   loop finished
    │   ↩️ RETURN
    │
    ↩️ Return to []
    │
    ↩️ Undo
    current = []
    
    
    └── i = 3 → choose 7 🟢
        │
        current = [7]
        target  = 7 - 7 = 0
        start   = 3
        │
        🔵 Recursive call:
        │
        combinations(
            target = 0,
            start = 3,
            current = [7]
        )
        │
        target == 0
        │
        💾 SAVE [7]
        │
        ↩️ RETURN
        │
        ↩️ Return to []
        │
        ↩️ Undo
        current = []
        
    loop finished
    
    ↩️ RETURN