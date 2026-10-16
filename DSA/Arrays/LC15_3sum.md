# LeetCode 15 — 3Sum: Java Code Explanation

The goal of 3Sum is to find all unique triplets in an array whose sum is equal to `0`.

Problem link: [LeetCode 15 — 3Sum](https://leetcode.com/problems/3sum/)

For example:

```java
nums = [-1, 0, 1, 2, -1, -4];
```

Output:

```text
[[-1, -1, 2], [-1, 0, 1]]
```

Both triplets have a sum of zero:

- `-1 + (-1) + 2 = 0`
- `-1 + 0 + 1 = 0`

We must return unique triplets, so the same combination must not appear more than once.

## 1. Concepts Used in This Code

### Sorting

Arrange the array in ascending order so that moving the left and right pointers helps us control the sum.

### Two Pointers

Fix one number, then use `left` and `right` to search for the other two numbers.

### Duplicate Handling

Skip repeated values to avoid returning the same triplet multiple times.

## 2. Step 1 — Initialize the Result

```java
List<List<Integer>> result = new ArrayList<>();
```

This creates a list that stores all valid triplets.

Why `List<List<Integer>>`?

- The outer list stores multiple triplets.
- Each inner list stores three integers.

For example:

```text
[
    [-1, -1, 2],
    [-1, 0, 1]
]
```

## 3. Step 2 — Sort the Array

```java
Arrays.sort(nums);
```

Original array:

```text
[-1, 0, 1, 2, -1, -4]
```

After sorting:

| Index | Value |
|---:|---:|
| 0 | -4 |
| 1 | -1 |
| 2 | -1 |
| 3 | 0 |
| 4 | 1 |
| 5 | 2 |

### Why Is Sorting Important?

Because the array is sorted:

- If the sum is too small, increase `left`.
- If the sum is too large, decrease `right`.

This lets us avoid checking every possible combination.

## 4. Step 3 — Fix the First Number Using a `for` Loop

```java
for (int i = 0; i < nums.length - 2; i++) {
```

We select one number and then find two other numbers that make the total zero.

For an array of length `6`, `i` can go from `0` to `3`.

### Why `nums.length - 2`?

Because we need at least two elements after the fixed element to form a triplet.

For example, when `i = 1`:

```text
[-4, -1, -1, 0, 1, 2]
      ↑
    nums[i]
```

The fixed number is `-1`. Now we search for two other numbers whose sum is `1`, because:

\[
-1 + x + y = 0
\]

Therefore:

\[
x + y = 1
\]

## 5. Step 4 — Skip Duplicate Fixed Elements

```java
if (i > 0 && nums[i] == nums[i - 1]) {
    continue;
}
```

This prevents the same fixed number from starting another identical search.

Consider:

```text
[-4, -1, -1, 0, 1, 2]
      ↑   ↑
     i=1  i=2
```

When `i = 1`, we process the first `-1`.

When `i = 2`, the current value is also `-1`, and the previous value is `-1`.

Therefore, we skip `i = 2`.

**Important:** We skip duplicate values at the fixed index, not every repeated number in the array. Repeated numbers can still be part of a valid triplet, such as `[-1, -1, 2]`.

## 6. Step 5 — Initialize the Two Pointers

```java
int left = i + 1;
int right = nums.length - 1;
```

- `left` starts immediately after the fixed element.
- `right` starts at the last index of the array.

For `i = 1`:

```text
Index:   0    1    2    3    4    5
Value:  -4   -1   -1    0    1    2
              ↑    ↑              ↑
            Fixed Left           Right
```

Fixed value = `-1`, left value = `-1`, right value = `2`.

## 7. Step 6 — Search While the Pointers Have Not Crossed

```java
while (left < right) {
    int sum = nums[i] + nums[left] + nums[right];
```

The `while` loop continues as long as `left < right`.

We calculate the sum of three numbers:

\[
sum = nums[i] + nums[left] + nums[right]
\]

There are three possible cases.

### Case 1: The Sum Equals Zero

```java
if (sum == 0) {
    result.add(Arrays.asList(
        nums[i], nums[left], nums[right]
    ));

    left++;
    right--;
}
```

We have found a valid triplet, so we add it to the result.

For example:

```text
Fixed = -1
Left  = -1
Right =  2

Sum = -1 + (-1) + 2 = 0
```

We store:

```text
[-1, -1, 2]
```

Then move both pointers inward:

```java
left++;
right--;
```

### Why Move Both?

We have already found a valid combination. Moving both pointers allows us to search for another combination without reusing the same pair of positions.

### Case 2: The Sum Is Less Than Zero

```java
else if (sum < 0) {
    left++;
}
```

Suppose:

```text
Fixed = -1
Left  = -1
Right =  1

Sum = -1 + (-1) + 1 = -1
```

The sum is negative. We need a larger sum.

Since the array is sorted, we move `left` to the right to get a larger value.

```text
Before: [-4, -1, -1, 0, 1, 2]
                    ↑     ↑
                   Left  Right

Move left →
```

### Case 3: The Sum Is Greater Than Zero

```java
else {
    right--;
}
```

Suppose:

```text
Fixed = -1
Left  =  0
Right =  2

Sum = -1 + 0 + 2 = 1
```

The sum is positive. We need a smaller sum.

Because the array is sorted, we decrease `right` to select a smaller value.

```text
Before: [-4, -1, -1, 0, 1, 2]
                     ↑     ↑
                    Left  Right

Move right ←
```

## 8. Step 7 — Skip Duplicate Left Values

```java
while (left < right &&
       nums[left] == nums[left - 1]) {
    left++;
}
```

After finding a valid triplet, this loop skips repeated left-side values.

If `left` moves onto a value that is equal to the value just used, we skip it.

Otherwise, we might add the same triplet again.

The condition `left < right` ensures the pointers have not met or crossed.

## 9. Step 8 — Skip Duplicate Right Values

```java
while (left < right &&
       nums[right] == nums[right + 1]) {
    right--;
}
```

This does the same thing for the right pointer.

After finding a triplet, we compare the current right value with the previously used right value. If they are equal, we skip the duplicate.

### Why Do We Use `right + 1`?

Because we already executed:

```java
right--;
```

So `right + 1` refers to the previous right position, whose value was just used.

## 10. Complete Dry Run

Let's trace the code using the example input.

```java
nums = [-1, 0, 1, 2, -1, -4];
```

After sorting:

```text
[-4, -1, -1, 0, 1, 2]
```

### Step-by-Step Pointer Movement

| Fixed (`i`) | Left | Right | Sum | Action |
|---:|---:|---:|---:|---|
| -4 | -1 | 2 | -3 | Sum too small; move `left` |
| -4 | -1 | 2 | -3 | Sum too small; move `left` |
| -4 | 0 | 2 | -2 | Sum too small; move `left` |
| -4 | 1 | 2 | -1 | Sum too small; move `left` |
| -1 | -1 | 2 | 0 | Save `[-1, -1, 2]` |
| -1 | 0 | 1 | 0 | Save `[-1, 0, 1]` |

The second `-1` is skipped as a duplicate fixed element.

The final result is:

```java
[
    [-1, -1, 2],
    [-1, 0, 1]
]
```

## 11. Why Is the Time Complexity \(O(n^2)\)?

The outer `for` loop runs up to \(n\) times.

For each fixed element, the two pointers traverse the remaining array in \(O(n)\) time. They move inward and never move backward during that search.

Therefore:

\[
T(n) = O(n) \times O(n) = O(n^2)
\]

Sorting takes \(O(n\log n)\), which is dominated by \(O(n^2)\).

- **Time complexity:** \(O(n^2)\)
- **Auxiliary space:** Typically \(O(\log n)\) for Java's primitive-array sorting implementation, excluding the output and accounting for sorting-stack space.
- **Output space:** Depends on the number of unique triplets.

## 12. The Most Important Logic to Remember

```java
if (sum == 0) {
    // Save triplet
    left++;
    right--;
} else if (sum < 0) {
    left++;
} else {
    right--;
}
```

This is the heart of the algorithm.

- Sum is too small → move `left`.
- Sum is too large → move `right`.
- Sum is zero → save the triplet and move both pointers.

The duplicate checks make sure each unique triplet is returned only once.

## Reference

- [LeetCode 15 — 3Sum: Official Problem Statement](https://leetcode.com/problems/3sum/)
- [Java Arrays API — `Arrays.sort()`](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Arrays.html)