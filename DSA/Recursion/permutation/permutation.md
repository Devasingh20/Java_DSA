# Permutations II — LeetCode 47

---

# 1. What is the Question?

Given an integer array `nums` that may contain duplicate elements, return all **unique permutations**.

## Example

```text
nums = [1, 1, 2]

If we treat the two 1s as different elements, we could generate:
112
112
121
121
211
211

But the question asks for unique permutations.
Therefore:
[1,1,2]
[1,2,1]
[2,1,1]

Main Challenge
The main challenge is:
Generate all permutations without generating duplicate permutations.
```
## 2. Approach
This solution uses Backtracking with p and up lists.
p  = selected elements

up = unselected / remaining elements

For example:
p  = [1,2]

up = [1,2]

means:
Selected elements : [1,2]

Remaining elements: [1,2]

At every step:
Choose → Explore → Undo

The code follows exactly this pattern:
```text
p.add(num);        // Choose
up.remove(i);

permute(p, up, ans);   // Explore

up.add(i, num);    // Undo
p.remove(p.size() - 1);
```
## 3. Step 1 — Sort the Array
Arrays.sort(nums);

For:
nums = [2,2,1,1]

after sorting:
nums = [1,1,2,2]

## We sort because equal elements become adjacent.
## That allows us to detect duplicates using:
```java
if (i > 0 && up.get(i).equals(up.get(i - 1))) {
    continue;
}
```
## 4. Meaning of p and up
p
p contains the elements that have already been selected.
Example:
p = [1,2]

means:
Current permutation = [1,2]

up
up contains the elements that are still available.
Example:
p  = [1,2]

up = [1,2]

means:
Selected : [1,2]

Remaining: [1,2]

## 5. Base Case
if (up.isEmpty()) {
    ans.add(new ArrayList<>(p));
    return;
}

When:
up = []

there are no elements left to select.
Therefore p is a complete permutation.
Example:
p  = [1,2,1,2]

up = []

So:
SAVE [1,2,1,2]

## 6. Choosing an Element
The loop:
```java
for (int i = 0; i < up.size(); i++)
```
tries every available element.
Then:
```text
int num = up.get(i);
```
gets the selected number.
We move it from up to p:
p.add(num);
up.remove(i);

So:
up → p

Then:
```text
permute(p, up, ans);
```
explores that choice.
After recursion returns, we undo:
```text
up.add(i, num);
p.remove(p.size() - 1);
```
So the previous state is restored.
## 7. Duplicate Check
The most important line for Permutations II is:
if (i > 0 && up.get(i).equals(up.get(i - 1))) {
    continue;
}

Suppose:
up = [1,1,2,2]

At this recursion level:
i = 0 → choose 1 ✅

i = 1 → choose 1 ❌

i = 2 → choose 2 ✅

i = 3 → choose 2 ❌

## Why?
Because choosing the first 1 and choosing the second 1 at the same recursion level creates the same value-level branch.
Similarly for the two 2s.
Important
This does not mean we can never use the duplicate value again.
For example:
```text
[] / [1,1,2,2]
       |
       | choose 1
       ↓
[1] / [1,2,2]
       |
       | choose 1
       ↓
[1,1] / [2,2]
```
This is valid.
The duplicate check prevents the same value from creating multiple branches at the same level.
## 8. Complete Recursive Tree
For:
nums = [2,2,1,1]

after sorting:
nums = [1,1,2,2]
```text
The complete tree is:
                         [] / 1122
                       /            \
                      /              \
             1 / 122                  2 / 112
               /    \                  /      \
              /      \                /        \
        11 / 22     12 / 12      21 / 12     22 / 11
             |       /    \         /    \        |
             |      /      \       /      \       |
       112 / 2   121 / 2  122 / 1  211 / 2  212 / 1  221 / 1
             |      |        |       |        |        |
             ↓      ↓        ↓       ↓        ↓        ↓
           1122   1212     1221    2112     2121     2211
             ✓      ✓        ✓       ✓        ✓        ✓
```
## 9. Understanding the Tree
At the root:
```text
[] / [1,1,2,2]

Possible choices:
i = 0 → 1 ✅

i = 1 → 1 ❌ duplicate

i = 2 → 2 ✅

i = 3 → 2 ❌ duplicate

Therefore only:
                    [] / 1122
                   /          \
                  /            \
             1 / 122          2 / 112

are created.
Branch 1 — Choose 1
[] / [1,1,2,2]
       |
       ↓
[1] / [1,2,2]

From here:
i = 0 → 1 ✅

i = 1 → 2 ✅

i = 2 → 2 ❌ duplicate

Therefore:
              1 / 122
               /      \
              /        \
        11 / 22       12 / 12

Branch 11 / 22
Choose 2:
11 / 22
   |
   ↓
112 / 2
   |
   ↓
1122 / []
   |
   ↓
SAVE

Result:
[1,1,2,2]

Branch 12 / 12
From:
12 / 12

we have two different values.
Choose 1
121 / 2
   |
   ↓
1212 / []

Save:
[1,2,1,2]

Choose 2
122 / 1
   |
   ↓
1221 / []

Save:
[1,2,2,1]

So the first major branch produces:
[1,1,2,2]
[1,2,1,2]
[1,2,2,1]
```
## 10. Branch 2 — Choose 2
From the root:
```text
[] / [1,1,2,2]
       |
       ↓
[2] / [1,1,2]

Now:
i = 0 → 1 ✅

i = 1 → 1 ❌ duplicate

i = 2 → 2 ✅

Therefore:
                  2 / 112
                 /        \
                /          \
          21 / 12        22 / 11

Branch 21 / 12
Choose 1:
21 / 12
   |
   ↓
211 / 2
   |
   ↓
2112 / []

Save:
[2,1,1,2]

Choose 2:
212 / 1
   |
   ↓
2121 / []

Save:
[2,1,2,1]

Branch 22 / 11
Choose 1:
22 / 11
   |
   ↓
221 / 1
   |
   ↓
2211 / []

Save:
[2,2,1,1]
```
## 11. Duplicate Branches That Are Skipped
At the root:
```text 
[] / 1122

├── choose first 1  ✅
├── choose second 1 ❌
├── choose first 2  ✅
└── choose second 2 ❌

At:
1 / 122

we have:
├── choose 1        ✅
├── choose first 2  ✅
└── choose second 2 ❌

At:
2 / 112

we have:
├── choose first 1  ✅
├── choose second 1 ❌
└── choose 2        ✅
```
The duplicate check therefore removes redundant branches.
## 12. One Complete Branch With Return and Undo
Let's trace the first branch completely:
```text
[] / [1,1,2,2]

Choose 1:
[1] / [1,2,2]

Choose 1:
[1,1] / [2,2]

Choose 2:
[1,1,2] / [2]

Choose 2:
[1,1,2,2] / []

Now:
up.isEmpty()

so:
SAVE [1,1,2,2]

Then:
RETURN

We return to:
[1,1,2] / [2]

Now undo:
up.add(0, 2);
p.remove(p.size() - 1);

State becomes:
[1,1] / [2,2]

Now the loop continues.
The next 2 is:
duplicate 2 → SKIP

Then the function returns to:
[1] / [1,2,2]

Undo the first 1:
[] / [1,1,2,2]
```
Now the root can try its next valid choice:
choose 2

This is the exact:
Choose
   ↓
Explore
   ↓
Return
   ↓
Undo
   ↓
Next choice

flow of backtracking.
## 13. Final Result
The six unique permutations are:
[1,1,2,2]

[1,2,1,2]

[1,2,2,1]

[2,1,1,2]

[2,1,2,1]

[2,2,1,1]

## 14. Complete Code
```java
class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {

        // Sort so duplicate values become adjacent
        Arrays.sort(nums);

        // p = selected elements
        List<Integer> p = new ArrayList<>();

        // up = remaining elements
        List<Integer> up = new ArrayList<>();

        for (int num : nums) {
            up.add(num);
        }

        List<List<Integer>> ans = new ArrayList<>();

        permute(p, up, ans);

        return ans;
    }

    static void permute(
            List<Integer> p,
            List<Integer> up,
            List<List<Integer>> ans) {

        // Base case
        if (up.isEmpty()) {
            ans.add(new ArrayList<>(p));
            return;
        }

        for (int i = 0; i < up.size(); i++) {

            // Skip duplicate choices at this level
            if (i > 0 && up.get(i).equals(up.get(i - 1))) {
                continue;
            }

            // Choose
            int num = up.get(i);

            p.add(num);
            up.remove(i);

            // Explore
            permute(p, up, ans);

            // Undo
            up.add(i, num);
            p.remove(p.size() - 1);
        }
    }
}
```
## Complete Recursive Tree
I'll use:
- 🟢 = choose
- 🔴 = duplicate → skip
- 💾 = save answer
- ↩️ = return
- ↩️ undo = restore up and p
```text
For:
permute([], [1,1,2,2])

the complete recursive execution is:
permute([], [1,1,2,2])
│
├── i=0 → choose 1 🟢
│   │
│   │   p  = [1]
│   │   up = [1,2,2]
│   │
│   └── permute([1], [1,2,2])
│       │
│       ├── i=0 → choose 1 🟢
│       │   │
│       │   │   p  = [1,1]
│       │   │   up = [2,2]
│       │   │
│       │   └── permute([1,1], [2,2])
│       │       │
│       │       ├── i=0 → choose 2 🟢
│       │       │   │
│       │       │   │   p  = [1,1,2]
│       │       │   │   up = [2]
│       │       │   │
│       │       │   └── permute([1,1,2], [2])
│       │       │       │
│       │       │       └── i=0 → choose 2 🟢
│       │       │           │
│       │       │           │   p  = [1,1,2,2]
│       │       │           │   up = []
│       │       │           │
│       │       │           └── permute([1,1,2,2], [])
│       │       │               │
│       │       │               ├── up.isEmpty()
│       │       │               ├── 💾 SAVE [1,1,2,2]
│       │       │               └── ↩️ RETURN
│       │       │
│       │       │           ↩️ undo
│       │       │
│       │       │           p  = [1,1,2]
│       │       │           up = [2]
│       │       │
│       │       │       loop finished
│       │       │       ↩️ RETURN
│       │       │
│       │       ├── ↩️ undo
│       │       │
│       │       │   p  = [1,1]
│       │       │   up = [2,2]
│       │       │
│       │       └── i=1 → duplicate 2 🔴 SKIP
│       │           │
│       │           │   up[1] == up[0]
│       │           │   2 == 2
│       │           │
│       │           └── loop finished
│       │               ↩️ RETURN
│       │
│       ├── ↩️ undo
│       │
│       │   p  = [1]
│       │   up = [1,2,2]
│       │
│       ├── i=1 → choose 2 🟢
│       │   │
│       │   │   p  = [1,2]
│       │   │   up = [1,2]
│       │   │
│       │   └── permute([1,2], [1,2])
│       │       │
│       │       ├── i=0 → choose 1 🟢
│       │       │   │
│       │       │   │   p  = [1,2,1]
│       │       │   │   up = [2]
│       │       │   │
│       │       │   └── permute([1,2,1], [2])
│       │       │       │
│       │       │       └── i=0 → choose 2 🟢
│       │       │           │
│       │       │           └── permute([1,2,1,2], [])
│       │       │               │
│       │       │               ├── 💾 SAVE [1,2,1,2]
│       │       │               └── ↩️ RETURN
│       │       │
│       │       │           ↩️ undo
│       │       │
│       │       │           p  = [1,2,1]
│       │       │           up = [2]
│       │       │
│       │       │       ↩️ RETURN
│       │       │
│       │       ├── ↩️ undo
│       │       │
│       │       │   p  = [1,2]
│       │       │   up = [1,2]
│       │       │
│       │       └── i=1 → choose 2 🟢
│       │           │
│       │           │   p  = [1,2,2]
│       │           │   up = [1]
│       │           │
│       │           └── permute([1,2,2], [1])
│       │               │
│       │               └── i=0 → choose 1 🟢
│       │                   │
│       │                   └── permute([1,2,2,1], [])
│       │                       │
│       │                       ├── 💾 SAVE [1,2,2,1]
│       │                       └── ↩️ RETURN
│       │
│       │                   ↩️ undo
│       │
│       │                   p  = [1,2,2]
│       │                   up = [1]
│       │
│       │               ↩️ RETURN
│       │
│       ├── ↩️ undo
│       │
│       │   p  = [1]
│       │   up = [1,2,2]
│       │
│       └── i=2 → duplicate 2 🔴 SKIP
│           │
│           │   up[2] == up[1]
│           │   2 == 2
│           │
│           └── ↩️ RETURN
│
├── ↩️ undo
│   │
│   │   p  = []
│   │   up = [1,1,2,2]
│
├── i=1 → duplicate 1 🔴 SKIP
│   │
│   │   up[1] == up[0]
│   │   1 == 1
│   │
│   └── no recursive call
│
├── i=2 → choose 2 🟢
│   │
│   │   p  = [2]
│   │   up = [1,1,2]
│   │
│   └── permute([2], [1,1,2])
│       │
│       ├── i=0 → choose 1 🟢
│       │   │
│       │   │   p  = [2,1]
│       │   │   up = [1,2]
│       │   │
│       │   └── permute([2,1], [1,2])
│       │       │
│       │       ├── i=0 → choose 1 🟢
│       │       │   │
│       │       │   └── permute([2,1,1], [2])
│       │       │       │
│       │       │       └── i=0 → choose 2 🟢
│       │       │           │
│       │       │           └── permute([2,1,1,2], [])
│       │       │               │
│       │       │               ├── 💾 SAVE [2,1,1,2]
│       │       │               └── ↩️ RETURN
│       │       │
│       │       │           ↩️ undo
│       │       │
│       │       │           p  = [2,1,1]
│       │       │           up = [2]
│       │       │
│       │       │       ↩️ RETURN
│       │       │
│       │       ├── ↩️ undo
│       │       │
│       │       │   p  = [2,1]
│       │       │   up = [1,2]
│       │       │
│       │       └── i=1 → choose 2 🟢
│       │           │
│       │           └── permute([2,1,2], [1])
│       │               │
│       │               └── i=0 → choose 1 🟢
│       │                   │
│       │                   └── permute([2,1,2,1], [])
│       │                       │
│       │                       ├── 💾 SAVE [2,1,2,1]
│       │                       └── ↩️ RETURN
│       │
│       │                   ↩️ undo
│       │
│       │                   p  = [2,1,2]
│       │                   up = [1]
│       │
│       │               ↩️ RETURN
│       │
│       ├── ↩️ undo
│       │
│       │   p  = [2]
│       │   up = [1,1,2]
│       │
│       ├── i=1 → duplicate 1 🔴 SKIP
│       │
│       └── i=2 → choose 2 🟢
│           │
│           │   p  = [2,2]
│           │   up = [1,1]
│           │
│           └── permute([2,2], [1,1])
│               │
│               ├── i=0 → choose 1 🟢
│               │   │
│               │   └── permute([2,2,1], [1])
│               │       │
│               │       └── i=0 → choose 1 🟢
│               │           │
│               │           └── permute([2,2,1,1], [])
│               │               │
│               │               ├── 💾 SAVE [2,2,1,1]
│               │               └── ↩️ RETURN
│               │
│               │           ↩️ undo
│               │
│               │           p  = [2,2,1]
│               │           up = [1]
│               │
│               │       ↩️ RETURN
│               │
│               ├── ↩️ undo
│               │
│               │   p  = [2,2]
│               │   up = [1,1]
│               │
│               └── i=1 → duplicate 1 🔴 SKIP
│
├── ↩️ undo
│   │
│   │   p  = []
│   │   up = [1,1,2,2]
│
└── i=3 → duplicate 2 🔴 SKIP
    │
    │   up[3] == up[2]
    │   2 == 2
    │
    └── no recursive call
```
```text
Core Idea to Remember
Sort
  ↓
Use p = selected elements
  ↓
Use up = remaining elements
  ↓
Choose an element
  ↓
Move up → p
  ↓
Recursive call
  ↓
Explore
  ↓
Return
  ↓
Undo
  ↓
Skip duplicate values at the SAME recursion level
```
**The most important concept is:**
Duplicate check = same value should not create
multiple branches at the same recursion level.

But:
Duplicate value CAN be selected again
at a deeper recursion level.

That is why:
[1,1,2,2]

can correctly produce:
[1,1,2,2]

while avoiding duplicate branches.



# Understanding `add()` and `addAll()` in Java Permutations

In your permutation code, `add()` and `addAll()` are used at different levels. The key difference is:

- `add()` adds **one element** to a collection.
- `addAll()` adds **all elements** from another collection.

Let's understand both using your code.

## 1. Understand the data types

```java
List<Integer> p;
List<List<Integer>> ans;
```

- `p` stores one permutation, for example `[2, 1, 3]`.
- `ans` stores multiple permutations, for example `[[2, 1, 3], [1, 2, 3]]`.

The data types determine what each list can contain.

## 2. `result.add(new ArrayList<>(p))`

Your base case:

```java
if (index == arr.length) {
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>(p));
    return result;
}
```

Suppose:

```java
p = [2, 1, 3];
```

First, this creates a copy of `p`:

```java
new ArrayList<>(p)
```

The copy is `[2, 1, 3]`.

Then:

```java
result.add(new ArrayList<>(p));
```

adds the entire permutation as **one element** inside `result`.

Before `add()`:

```java
result = []
```

After `add()`:

```java
result = [
    [2, 1, 3]
]
```

The outer list contains one element, which is itself a list of integers.

**Why create a copy?** It ensures that the saved permutation is independent of the original list if that list is modified later.

## 3. `f.add(num)`

Consider this part:

```java
int num = arr[index];

List<Integer> f = new ArrayList<>(p.subList(0, i));
List<Integer> s = new ArrayList<>(p.subList(i, p.size()));

f.add(num);
```

Suppose:

```java
p = [2, 3];
num = 1;
i = 1;
```

The list is split at index `1`:

```java
f = [2];
s = [3];
```

Then:

```java
f.add(num);
```

adds the single integer `1` to `f`.

Result:

```java
f = [2, 1];
```

Here, `add()` adds one integer, not another list.

## 4. `f.addAll(s)`

Next:

```java
f.addAll(s);
```

Before the operation:

```java
f = [2, 1];
s = [3];
```

`addAll()` appends every element of `s` to the end of `f`.

After the operation:

```java
f = [2, 1, 3];
```

Notice that `f.addAll(s)` does **not** add `s` as a nested list. It adds the elements inside `s`.

## 5. `ans.addAll(permute(f, arr, index + 1))`

This is the most important line:

```java
ans.addAll(permute(f, arr, index + 1));
```

The recursive call returns a `List<List<Integer>>`, meaning it can return multiple complete permutations.

Suppose the recursive call returns:

```java
[
    [2, 1, 3],
    [2, 3, 1]
]
```

And your current `ans` is:

```java
ans = [
    [1, 2, 3]
];
```

When you execute:

```java
ans.addAll(permute(f, arr, index + 1));
```

both returned permutations are appended individually to `ans`.

Result:

```java
ans = [
    [1, 2, 3],
    [2, 1, 3],
    [2, 3, 1]
];
```

## 6. What if you use `ans.add(...)` instead?

Suppose you replace:

```java
ans.addAll(permute(f, arr, index + 1));
```

with:

```java
ans.add(permute(f, arr, index + 1));
```

Assume the recursive call returns:

```java
[
    [2, 1, 3],
    [2, 3, 1]
]
```

And before the call:

```java
ans = [
    [1, 2, 3]
];
```

### Using `ans.addAll(...)`

```java
ans.addAll(permute(f, arr, index + 1));
```

Result:

```java
ans = [
    [1, 2, 3],
    [2, 1, 3],
    [2, 3, 1]
];
```

Both permutations are added individually.

### Using `ans.add(...)`

```java
ans.add(permute(f, arr, index + 1));
```

**This causes a compilation error in your current code.**

Why?

- `ans` is `List<List<Integer>>`.
- `ans.add()` expects one `List<Integer>`.
- `permute(...)` returns `List<List<Integer>>`.

You are trying to add a list of permutations where one permutation is expected.

Conceptually, if Java allowed this nested structure, it would look like:

```java
ans = [
    [1, 2, 3],
    [
        [2, 1, 3],
        [2, 3, 1]
    ]
];
```

However, this structure is not valid for your declared Java type.

## 7. Summary of all four operations

| Statement | What gets added? | Purpose |
|---|---|---|
| `result.add(new ArrayList<>(p))` | One complete permutation | Save a permutation at the base case |
| `f.add(num)` | One integer | Insert the current number |
| `f.addAll(s)` | All integers in `s` | Reconstruct the permutation after insertion |
| `ans.addAll(permute(...))` | All returned permutations | Collect solutions from recursive calls |

## Final rule to remember

**`add()` adds one element; `addAll()` adds all elements from another compatible collection.**

The element can itself be a list. Therefore, `add()` can add a complete permutation to a list of permutations, while `addAll()` can combine multiple returned permutations into the same answer list.



# Why Does `f.add(s)` Cause an Error in Java?

The error occurs because of this line:

```java
f.add(s);
```

Your declarations are:

```java
List<Integer> f = new ArrayList<>();
List<Integer> s = new ArrayList<>();
```

Both `f` and `s` are lists of integers.

- `f.add(num)` works because `num` is an `int`, and `f` expects an `Integer`.
- `f.add(s)` causes a **compilation error** because `s` is a `List<Integer>`, but `f.add()` expects a single `Integer`.

## 1. Understand with an example

Suppose:

```java
f = [1];
s = [2, 3];
```

If you write:

```java
f.add(s); // Compilation error
```

Java expects an integer, but you are passing a list.

## 2. How to fix it

Use:

```java
f.addAll(s);
```

Now, all elements of `s` are added to `f`.

Before:

```java
f = [1];
s = [2, 3];
```

After:

```java
f.addAll(s);
```

Result:

```java
f = [1, 2, 3];
```

## 3. Corrected code

```java
static List<List<Integer>> permute(
        List<Integer> p, int[] arr, int index) {

    if (index == arr.length) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(p));
        return result;
    }

    int num = arr[index];
    List<List<Integer>> ans = new ArrayList<>();

    for (int i = 0; i <= p.size(); i++) {
        List<Integer> f =
                new ArrayList<>(p.subList(0, i));

        List<Integer> s =
                new ArrayList<>(p.subList(i, p.size()));

        f.add(num);
        f.addAll(s); // Corrected

        ans.addAll(permute(f, arr, index + 1));
    }

    return ans;
}
```

## 4. Remember the difference

| Method | What it does |
|---|---|
| `f.add(num)` | Adds one integer to `f` |
| `f.add(s)` | Compilation error because `s` is a list, not an integer |
| `f.addAll(s)` | Adds all integers from `s` to `f` |

**Key takeaway:** In your permutation algorithm, `f` represents one permutation. Therefore, use `f.addAll(s)` to append the remaining integers from `s` to `f`.
