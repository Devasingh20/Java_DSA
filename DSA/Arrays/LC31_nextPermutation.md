# LeetCode 31 — Next Permutation (Java)

## Problem Statement

The **Next Permutation** problem asks us to find the next lexicographically greater arrangement of the given array.

If no greater arrangement exists, we must rearrange the array into its smallest possible order, which is ascending order.

Problem link: [LeetCode 31 — Next Permutation](https://leetcode.com/problems/next-permutation/)

### Example

**Input:**

```java
int[] nums = {1, 2, 3};
```

**Output:**

```text
[1, 3, 2]
```

The next permutation of `[1, 2, 3]` is `[1, 3, 2]`.

---

## 1. Approach Used

We can solve this problem using **two `for` loops and two pointers**.

Our approach consists of four steps:

1. Find the pivot index using the first `for` loop.
2. Find the successor of the pivot using the second `for` loop and swap them.
3. Reverse the suffix using two pointers.
4. If no pivot exists, reverse the entire array.

### What is a Pivot?

The pivot is the first index from the right where:

```java
nums[i] < nums[i + 1]
```

It identifies the position that must be increased to obtain the next greater permutation.

### What is a Successor?

The successor is the smallest element greater than the pivot in the suffix to its right.

Because the suffix is in descending order, scanning from right to left finds this element.

### What is a Suffix?

A suffix is the portion of an array beginning at a particular index and continuing to the end.

For example:

```text
[1, 2, 4, 3]
       └───┘
       Suffix
```

---

## 2. Complete Java Code

```java
import java.util.Arrays;

public class LC31_nextPermutation {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        int pivot = -1;

        // Step 1: Find the pivot index.
        // The pivot is the first index from the right where
        // nums[i] < nums[i + 1].

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        // Step 2: If the pivot exists, find the successor
        // by scanning from right to left and swap them.

        if (pivot != -1) {
            for (int i = nums.length - 1; i > pivot; i--) {
                if (nums[i] > nums[pivot]) {
                    int temp = nums[i];
                    nums[i] = nums[pivot];
                    nums[pivot] = temp;
                    break;
                }
            }
        }

        // Step 3: Reverse the suffix after the pivot.
        // If no pivot exists, reverse the entire array.

        int left = pivot == -1 ? 0 : pivot + 1;
        int right = nums.length - 1;

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }

        System.out.println(Arrays.toString(nums));
    }
}
```

---

## 3. Step 1 — Initialize the Pivot

```java
int pivot = -1;
```

We initialize `pivot` to `-1` to indicate that no pivot has been found yet.

If the array is entirely in descending order, no pivot will exist.

For example:

```text
[3, 2, 1]
```

This is already the largest possible permutation.

---

## 4. Step 2 — Find the Pivot Index

```java
for (int i = nums.length - 2; i >= 0; i--) {
    if (nums[i] < nums[i + 1]) {
        pivot = i;
        break;
    }
}
```

### Why start from `nums.length - 2`?

We compare `nums[i]` with `nums[i + 1]`.

Therefore, `i` must start at the second-last index so that `i + 1` is a valid index.

### Why scan from right to left?

We want the rightmost position where increasing the value can produce the next permutation.

### Example

```text
nums = [1, 2, 4, 3]
```

Scan from right to left:

| Index `i` | Comparison | Result |
|---:|---|---|
| 2 | `4 < 3` | False |
| 1 | `2 < 4` | True |

Therefore:

```java
pivot = 1;
```

The pivot value is:

```java
nums[pivot] = 2;
```

We stop immediately because we found the first valid pivot from the right.

---

## 5. Step 3 — Find the Successor and Swap

```java
if (pivot != -1) {
    for (int i = nums.length - 1; i > pivot; i--) {
        if (nums[i] > nums[pivot]) {
            int temp = nums[i];
            nums[i] = nums[pivot];
            nums[pivot] = temp;
            break;
        }
    }
}
```

If the pivot exists, we find the first element greater than it by scanning from right to left.

### Example

```text
Before swapping:

[1, 2, 4, 3]
    ↑
  Pivot = 2
```

The elements to the right of the pivot are:

```text
[4, 3]
```

We scan from right to left:

- `3 > 2` is true.
- Therefore, the successor is `3`.

We swap `2` and `3`.

```text
Before: [1, 2, 4, 3]
After:  [1, 3, 4, 2]
```

### Why scan from right to left?

The suffix is in descending order. The first element greater than the pivot from the right is the smallest element in that suffix that is greater than the pivot.

Choosing it ensures we increase the permutation by the smallest possible amount at the pivot position.

---

## 6. Step 4 — Reverse the Suffix Using Two Pointers

```java
int left = pivot == -1 ? 0 : pivot + 1;
int right = nums.length - 1;

while (left < right) {
    int temp = nums[left];
    nums[left] = nums[right];
    nums[right] = temp;

    left++;
    right--;
}
```

This step reverses the suffix to make it as small as possible.

### Why use `pivot == -1 ? 0 : pivot + 1`?

This is the ternary operator.

It means:

```java
int left;

if (pivot == -1) {
    left = 0;
} else {
    left = pivot + 1;
}
```

- If no pivot exists, start at index `0` to reverse the entire array.
- If a pivot exists, start at `pivot + 1` to reverse only the suffix.

### Example

After swapping:

```text
[1, 3, 4, 2]
       └───┘
       Suffix
```

We reverse the suffix `[4, 2]`.

```text
Before: [1, 3, 4, 2]
After:  [1, 3, 2, 4]
```

The final answer is:

```text
[1, 3, 2, 4]
```

### Why does reversing work?

Before the swap, the suffix is in descending order. After the swap, the suffix remains in descending order.

Reversing it puts the suffix into ascending order, which is its smallest possible arrangement.

This ensures we obtain the immediate next permutation rather than a larger permutation.

---

## 7. What Happens When No Pivot Exists?

Consider:

```java
int[] nums = {3, 2, 1};
```

The array is entirely in descending order.

The first loop never finds an index satisfying:

```java
nums[i] < nums[i + 1]
```

Therefore:

```java
pivot = -1;
```

The following statement sets `left` to `0`:

```java
int left = pivot == -1 ? 0 : pivot + 1;
```

The two-pointer loop reverses the entire array.

```text
Before: [3, 2, 1]
After:  [1, 2, 3]
```

This gives the smallest possible permutation.

---

## 8. Complete Dry Run for `{1, 2, 3}`

### Initial array

```text
[1, 2, 3]
```

### Step 1: Find the pivot

Start at index `1`:

```text
[1, 2, 3]
    ↑  ↑
    2  3
```

Since `2 < 3`, the pivot is index `1`.

### Step 2: Find the successor

Start from the last index:

```text
[1, 2, 3]
       ↑
       3
```

Since `3 > 2`, swap `2` and `3`.

```text
[1, 3, 2]
```

### Step 3: Reverse the suffix

The suffix begins at index `2` and contains only one element.

Therefore, no swap is needed.

Final output:

```text
[1, 3, 2]
```

---

## 9. Time and Space Complexity

### Time Complexity: \(O(n)\)

- Finding the pivot takes \(O(n)\).
- Finding the successor takes \(O(n)\).
- Reversing the suffix takes \(O(n)\).

Therefore:

\[
O(n)+O(n)+O(n)=O(n)
\]

### Auxiliary Space: \(O(1)\)

We modify the original array directly and use only a few variables, such as `pivot`, `left`, `right`, and `temp`.

No additional array or collection is required.

---

## 10. Final Summary

| Step | Operation | Purpose |
|---|---|---|
| 1 | First `for` loop | Find the pivot |
| 2 | Second `for` loop | Find the successor and swap |
| 3 | Two-pointer `while` loop | Reverse the suffix |
| 4 | Handle `pivot == -1` | Reverse the entire array when it is already the largest permutation |

**Remember the pattern:**

**Find Pivot → Find Successor → Swap → Reverse Suffix**

This algorithm modifies the array in place and finds the next lexicographical permutation in \(O(n)\) time and \(O(1)\) auxiliary space.