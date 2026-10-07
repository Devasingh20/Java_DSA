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