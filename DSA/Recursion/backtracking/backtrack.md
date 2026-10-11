# Maze Path Problem — Recursion Explanation in Java

Your code solves the Maze Path Counting problem using recursion.

The goal is to count how many different paths exist to reach the destination in a grid when you can move only Right and Down.

Let's understand why we start with `count(3, 3)`, what `row` and `column` mean, and how the recursion works.

## 1. Why do we start with `count(3, 3)`?

```java
System.out.println(count(3, 3));
```

We start with `3, 3` because we are considering a maze of 3 rows and 3 columns.

Imagine this grid:

```text
S → →
↓   ↓
↓ → D
```

- `S` = Start (top-left)
- `D` = Destination (bottom-right)

We want to move from the top-left cell to the bottom-right cell.

For a `3 × 3` grid, we must move:

- 2 steps Right
- 2 steps Down

There are different orders in which we can make these moves, so we need to count all possible paths.

**Important:** `count(3, 3)` represents the dimensions of the remaining grid, not the coordinates `(3, 3)` of a cell. Your code is using a recursive counting approach.

## 2. What do `row` and `column` mean?

```java
static int count(int row, int column)
```

Here, `row` and `column` represent the size of the grid we are considering in the recursive problem.

For example:

- `count(3, 3)` means a 3-row, 3-column problem.
- `count(2, 3)` means a 2-row, 3-column problem.
- `count(3, 2)` means a 3-row, 2-column problem.
- `count(1, 3)` means a 1-row, 3-column problem.

When we reduce `row` or `column` by one, we are moving toward a smaller subproblem.

## 3. Understand your code line by line

```java
static int count(int row, int column) {

    if (row == 1 || column == 1) {
        return 1;
    }

    int left = count(row - 1, column);
    int right = count(row, column - 1);

    return left + right;
}
```

### Step 1: Base condition

```java
if (row == 1 || column == 1) {
    return 1;
}
```

**Why do we return `1`?**

When one dimension is `1`, there is only one possible way to finish: keep moving in the remaining direction.

For example, in a `1 × 3` grid:

```text
1 → 2 → 3
```

Only one path: Right → Right.

Similarly, a `3 × 1` grid has only one path: Down → Down.

Therefore, the answer is `1`.

### Step 2: Recursive calls

```java
int left = count(row - 1, column);
int right = count(row, column - 1);
```

We divide the problem into two smaller problems.

- `count(row - 1, column)` reduces the number of rows by one.
- `count(row, column - 1)` reduces the number of columns by one.

These represent the two possible directions of movement in the usual maze interpretation.

### Step 3: Add both answers

```java
return left + right;
```

We add the number of paths from both smaller problems because each represents a different possible first move.

This gives us the recurrence:

$$
f(r,c)=f(r-1,c)+f(r,c-1)
$$

With the base case:

$$
f(r,c)=1 \quad \text{if } r=1 \text{ or } c=1
$$

## 4. Complete recursion tree for `count(3, 3)`

Let's trace exactly how the calls execute.

```text
count(3, 3)
    ├── left  → count(2, 3)
    └── right → count(3, 2)
```

Each call branches again until a dimension becomes `1`.

### Calculate `count(2, 3)`

```text
count(2, 3)
    ├── count(1, 3) = 1
    └── count(2, 2) = 2
```

Therefore:

```text
count(2, 3)
= count(1, 3) + count(2, 2)
= 1 + 2
= 3
```

### Calculate `count(3, 2)`

```text
count(3, 2)
    ├── count(2, 2) = 2
    └── count(3, 1) = 1
```

Therefore:

```text
count(3, 2)
= count(2, 2) + count(3, 1)
= 2 + 1
= 3
```

### Final result

**6 paths**

Thus:

$$
\begin{aligned}
f(3,3)&=f(2,3)+f(3,2)\\
&=3+3\\
&=\boxed{6}
\end{aligned}
$$

Your program prints:

```text
6
```

## 5. What is the overall approach?

Remember these four points:

1. **Start:** `count(3, 3)` defines the size of the original problem.
2. **Break down:** Reduce either the row or column dimension to represent one of the two possible moves.
3. **Stop:** When `row == 1` or `column == 1`, return `1`.
4. **Combine:** Add the answers from both recursive calls.

One subtle point: your code counts paths, not the actual movement sequences. It doesn't create a maze array or check blocked cells; it assumes an unobstructed rectangular grid and movement in only two directions.

**Time complexity:** `O(2^(r+c))` as a simple upper bound for the recursive implementation, because it repeats many subproblems. The same problem can be optimized using dynamic programming.