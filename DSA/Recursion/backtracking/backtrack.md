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


## 6. recursion tree
```text 
                         count(3,3)
                        /          \
                 left /              \ right
                     /                \
              count(2,3)              count(3,2)
              /       \                /       \
             /         \              /         \
       count(1,3)  count(2,2)    count(2,2)  count(3,1)
           |          /    \          |          |
        return 1  count(1,2) count(2,1)        return 1
                      |          |
                   return 1   return 1
                      \          /
                       \        /
                       count(2,2) = 2
```

# Print Maze Paths — Recursion and Backtracking in Java

Your code prints all possible paths from the top-left corner to the bottom-right corner of a maze, assuming you can move only Down (`D`) and Right (`R`).

The most important thing to understand is that this problem uses recursion with two choices at each step. It is closely related to decision-tree recursion, not directly to the usual subsequence or permutation patterns.

## 1. First, understand the maze

You call:

```java
path("", 3, 3);
```

This means:

- `p = ""` — the path is initially empty.
- `row = 3` — there are 3 rows remaining.
- `column = 3` — there are 3 columns remaining.

Imagine a `3 × 3` grid:

```text
S  ·  ·
·  ·  ·
·  ·  D
```

- `S` = Start
- `D` = Destination

To reach the destination, you need exactly:

- 2 Down moves (`D`)
- 2 Right moves (`R`)

The possible movement sequences are:

- `DDRR`
- `DRDR`
- `DRRD`
- `RDDR`
- `RDRD`
- `RRDD`

Therefore, your code prints 6 paths.

## 2. Which approach does this code use?

| Algorithm pattern | Is it used here? | Why? |
|---|---|---|
| Recursion | Yes | The method calls itself with smaller dimensions. |
| Decision-tree recursion | Yes | Each call can choose Down or Right. |
| Backtracking | Related, but no explicit undo | Each recursive call explores a separate path; the path string is immutable. |
| Subsequences | No, not directly | You aren't deciding whether to include or exclude each element of an input array. |
| Permutations | Not the standard pattern | You aren't freely arranging distinct elements; you are arranging a fixed number of `D` and `R` moves subject to the maze rules. |

The best classification is: **recursive path generation using a decision tree.**

It has a similar branching structure to subsequence and permutation problems, but the choices and constraints are different.

## 3. Complete recursive tree for `path("", 3, 3)`

Let's trace every recursive call. Your code checks Down first (`D`) and Right second (`R`), so the tree explores all Down-first branches before the Right-first branches.

```text
path("", 3, 3)
│
├── D → path("D", 2, 3)
│   │
│   ├── D → path("DD", 1, 3)
│   │   │
│   │   └── R → path("DDR", 1, 2)
│   │       │
│   │       └── R → path("DDRR", 1, 1)
│   │           └── PRINT "DDRR"
│   │
│   └── R → path("DR", 2, 2)
│       │
│       ├── D → path("DRD", 1, 2)
│       │   │
│       │   └── R → path("DRDR", 1, 1)
│       │       └── PRINT "DRDR"
│       │
│       └── R → path("DRR", 2, 1)
│           │
│           └── D → path("DRRD", 1, 1)
│               └── PRINT "DRRD"
│
└── R → path("R", 3, 2)
    │
    ├── D → path("RD", 2, 2)
    │   │
    │   ├── D → path("RDD", 1, 2)
    │   │   │
    │   │   └── R → path("RDDR", 1, 1)
    │   │       └── PRINT "RDDR"
    │   │
    │   └── R → path("RDR", 2, 1)
    │       │
    │       └── D → path("RDRD", 1, 1)
    │           └── PRINT "RDRD"
    │
    └── R → path("RR", 3, 1)
        │
        └── D → path("RRD", 2, 1)
            │
            └── D → path("RRDD", 1, 1)
                └── PRINT "RRDD"
```

Every leaf reaches `(1, 1)`, so the path is printed.

### Output

```text
DDRR
DRDR
DRRD
RDDR
RDRD
RRDD
```

## 4. Understand the code line by line

### A. The initial call

```java
path("", 3, 3);
```

We start with an empty path because we haven't moved yet.

The recursion gradually builds the path by appending `D` or `R`.

### B. The base case

```java
if (row == 1 && column == 1) {
    System.out.println(p);
    return;
}
```

When both dimensions reach `1`, we have reached the destination.

We print the path accumulated so far and return to the previous recursive call.

**Why use `&&` instead of `||` here?**

Because we print a completed path only when both dimensions have reached `1`. If either dimension alone reaches `1`, movement along the other dimension may still be necessary.

### C. The Down choice

```java
if (row > 1) {
    path(p + 'D', row - 1, column);
}
```

If more than one row remains, we can move Down.

For example:

```java
path("", 3, 3);
```

makes this recursive call:

```java
path("D", 2, 3);
```

Notice two changes:

- `p + 'D'` changes the path from `""` to `"D"`.
- `row - 1` changes the remaining row dimension from `3` to `2`.

### D. The Right choice

```java
if (column > 1) {
    path(p + 'R', row, column - 1);
}
```

If more than one column remains, we can move Right.

For example:

```java
path("", 3, 3);
```

also makes this call:

```java
path("R", 3, 2);
```

The path becomes `"R"`, and the column dimension decreases by one.

**Important:** Both `if` statements are independent. We don't use `else` because both choices must be explored to generate all possible paths.

## 5. Why don't we need an undo statement?

Compare this with N-Queens:

```java
board[row][col] = 'Q';
solve(...);
board[row][col] = '.';
```

In N-Queens, we modify a shared board, so we must undo the modification.

Your maze code instead uses:

```java
path(p + 'D', row - 1, column);
```

Java creates a new `String` for `p + 'D'`. The original `p` remains unchanged.

For example, if the current path is `"D"`:

- Down creates `"DD"`.
- Right creates `"DR"`.

The two branches do not overwrite each other's paths. Therefore, no explicit undo statement is required.

## 6. How is this related to subsequences and permutations?

Consider these three patterns:

### Maze paths

Choose a valid direction at each step.

`D` or `R` → explore the remaining maze.

### Subsequences

Decide whether to include an element.

`Take` or `Skip` → process the next element.

### Permutations

Choose an unused element for the next position.

`Choose` → recurse → `Undo` the selection.

All three can use recursion trees. What changes is the meaning of the choices.

For a `3 × 3` maze, every complete path contains exactly two `D` moves and two `R` moves. Thus, the number of paths is also:

$$
\binom{4}{2}=\frac{4!}{2!\,2!}=6
$$

This combinatorial formula gives the same result, but your code obtains it by exploring the recursive tree.

## 7. Complexity

For a maze with \(r\) rows and \(c\) columns, where only Down and Right are allowed:

- **Time complexity:** \(O\left(\binom{r+c-2}{r-1}(r+c)\right)\) when accounting for constructing and printing each complete path, using a straightforward string-based implementation.
- **Auxiliary recursion depth:** \(O(r+c)\), excluding the output.

Remember the key distinction: Your code doesn't search a maze with obstacles. It generates all valid Down/Right movement sequences for an unobstructed rectangular grid.

## Recursion Tree

![Maze Path Recursion Tree](mazePath.png)

## Recursion Tree for printAllMazePath.java
```text
path("", 0, 0) [MARK F: (0,0)]
│
├── D: path("D", 1, 0) [MARK F: (1,0)]
│   │
│   ├── D: path("DD", 2, 0) [MARK F: (2,0)]
│   │   │
│   │   ├── D: out of bounds
│   │   ├── R: path("DDR", 2, 1) [MARK F: (2,1)]
│   │   │   │
│   │   │   ├── D: out of bounds
│   │   │   ├── R: path("DDRR", 2, 2)
│   │   │   │   └── PRINT "DDRR"; RETURN
│   │   │   │
│   │   │   ├── U: path("DDRU", 1, 1) [MARK F: (1,1)]
│   │   │   │   │
│   │   │   │   ├── D: (2,1) is false → RETURN
│   │   │   │   ├── R: path("DDRUR", 1, 2) [MARK F: (1,2)]
│   │   │   │   │   │
│   │   │   │   │   ├── D: path("DDRURD", 2, 2)
│   │   │   │   │   │   └── PRINT "DDRURD"; RETURN
│   │   │   │   │   ├── R: out of bounds
│   │   │   │   │   ├── U: path("DDRURU", 0, 2) [MARK F: (0,2)]
│   │   │   │   │   │   │
│   │   │   │   │   │   ├── D: (1,2) is false → RETURN
│   │   │   │   │   │   ├── R: out of bounds
│   │   │   │   │   │   ├── U: out of bounds
│   │   │   │   │   │   └── L: path("DDRURUL", 0, 1) [MARK F: (0,1)]
│   │   │   │   │   │       ├── D: (1,1) is false → RETURN
│   │   │   │   │   │       ├── R: (0,2) is false → RETURN
│   │   │   │   │   │       ├── U: out of bounds
│   │   │   │   │   │       └── L: (0,0) is false → RETURN
│   │   │   │   │   │       RESTORE (0,1) = true
│   │   │   │   │   │       ↩ RETURN to path("DDRURU", 0, 2)
│   │   │   │   │   │
│   │   │   │   │   RESTORE (0,2) = true
│   │   │   │   │   ↩ RETURN to path("DDRUR", 1, 2)
│   │   │   │   ├── L: (1,1) is false → RETURN
│   │   │   │   RESTORE (1,2) = true
│   │   │   │   ↩ RETURN to path("DDRU", 1, 1)
│   │   │   │
│   │   │   ├── U: path("DDRUU", 0, 1) [MARK F: (0,1)]
│   │   │   │   │
│   │   │   │   ├── D: (1,1) is false → RETURN
│   │   │   │   ├── R: path("DDRUUR", 0, 2) [MARK F: (0,2)]
│   │   │   │   │   │
│   │   │   │   │   ├── D: path("DDRUURD", 1, 2) [MARK F: (1,2)]
│   │   │   │   │   │   └── D: path("DDRUURDD", 2, 2)
│   │   │   │   │   │       └── PRINT "DDRUURDD"; RETURN
│   │   │   │   │   │       RESTORE (1,2) = true
│   │   │   │   │   │       ↩ RETURN to path("DDRUUR", 0, 2)
│   │   │   │   │   ├── R: out of bounds
│   │   │   │   │   ├── U: out of bounds
│   │   │   │   │   └── L: (0,1) is false → RETURN
│   │   │   │   │
│   │   │   │   RESTORE (0,2) = true
│   │   │   │   ↩ RETURN to path("DDRUU", 0, 1)
│   │   │   │
│   │   │   └── L: (2,0) is false → RETURN
│   │   │   RESTORE (1,1) = true
│   │   │   ↩ RETURN to path("DDR", 2, 1)
│   │   │
│   │   └── L: (2,0) is false → RETURN
│   │   RESTORE (2,1) = true
│   │   ↩ RETURN to path("DD", 2, 0)
│   │
│   ├── R: path("DR", 1, 1) [MARK F: (1,1)]
│   │   │
│   │   ├── D: path("DRD", 2, 1) [MARK F: (2,1)]
│   │   │   ├── D: out of bounds
│   │   │   ├── R: path("DRDR", 2, 2)
│   │   │   │   └── PRINT "DRDR"; RETURN
│   │   │   ├── U: (1,1) is false → RETURN
│   │   │   └── L: path("DRDL", 2, 0) [MARK F: (2,0)]
│   │   │       ├── D: out of bounds
│   │   │       ├── R: (2,1) is false → RETURN
│   │   │       ├── U: (1,0) is false → RETURN
│   │   │       └── L: out of bounds
│   │   │       RESTORE (2,0) = true
│   │   │       ↩ RETURN to path("DRD", 2, 1)
│   │   │   RESTORE (2,1) = true
│   │   │   ↩ RETURN to path("DR", 1, 1)
│   │   │
│   │   ├── R: path("DRR", 1, 2) [MARK F: (1,2)]
│   │   │   ├── D: path("DRRD", 2, 2)
│   │   │   │   └── PRINT "DRRD"; RETURN
│   │   │   ├── R: out of bounds
│   │   │   ├── U: path("DRRU", 0, 2) [MARK F: (0,2)]
│   │   │   │   ├── D: (1,2) is false → RETURN
│   │   │   │   ├── R: out of bounds
│   │   │   │   ├── U: out of bounds
│   │   │   │   └── L: path("DRRUL", 0, 1) [MARK F: (0,1)]
│   │   │   │       ├── D: (1,1) is false → RETURN
│   │   │   │       ├── R: (0,2) is false → RETURN
│   │   │   │       ├── U: out of bounds
│   │   │   │       └── L: (0,0) is false → RETURN
│   │   │   │       RESTORE (0,1) = true
│   │   │   │       ↩ RETURN to path("DRRU", 0, 2)
│   │   │   │   RESTORE (0,2) = true
│   │   │   └── L: (1,1) is false → RETURN
│   │   │   RESTORE (1,2) = true
│   │   │   ↩ RETURN to path("DR", 1, 1)
│   │   │
│   │   ├── U: (0,1) is false → RETURN
│   │   └── L: (1,0) is false → RETURN
│   │   RESTORE (1,1) = true
│   │   ↩ RETURN to path("D", 1, 0)
│   │
│   ├── U: out of bounds
│   └── L: out of bounds
│   RESTORE (1,0) = true
│   ↩ RETURN to path("", 0, 0)
│
└── R: path("R", 0, 1) [MARK F: (0,1)]
    │
    ├── D: path("RD", 1, 1) [MARK F: (1,1)]
    │   ├── D: path("RDD", 2, 1) [MARK F: (2,1)]
    │   │   ├── D: out of bounds
    │   │   ├── R: path("RDDR", 2, 2)
    │   │   │   └── PRINT "RDDR"; RETURN
    │   │   ├── U: (1,1) is false → RETURN
    │   │   └── L: path("RDDL", 2, 0) [MARK F: (2,0)]
    │   │       ├── D: out of bounds
    │   │       ├── R: (2,1) is false → RETURN
    │   │       ├── U: path("RDDLU", 1, 0) [MARK F: (1,0)]
    │   │       │   ├── D: (2,0) is false → RETURN
    │   │       │   ├── R: (1,1) is false → RETURN
    │   │       │   ├── U: (0,0) is true → path("RDDLUU", 0, 0)
    │   │       │   └── L: out of bounds
    │   │       │   RESTORE (1,0) = true
    │   │       │   ↩ RETURN to path("RDDL", 2, 0)
    │   │       └── L: out of bounds
    │   │       RESTORE (2,0) = true
    │   │   RESTORE (2,1) = true
    │     │   ↩ RETURN to path("RD", 1, 1)
    │   │
    │   ├── R: path("RDR", 1, 2) [MARK F: (1,2)]
    │   │   ├── D: path("RDRD", 2, 2)
    │   │   │   └── PRINT "RDRD"; RETURN
    │   │   ├── R: out of bounds
    │   │   ├── U: path("RDRU", 0, 2) [MARK F: (0,2)]
    │   │   │   ├── D: (1,2) is false → RETURN
    │   │   │   ├── R: out of bounds
    │   │   │   ├── U: out of bounds
    │   │   │   └── L: (0,1) is false → RETURN
    │   │   │   RESTORE (0,2) = true
    │   │   │   ↩ RETURN to path("RDR", 1, 2)
    │   │   └── L: (1,1) is false → RETURN
    │   │   RESTORE (1,2) = true
    │   │
    │   ├── U: (0,1) is false → RETURN
    │   └── L: (1,0) is false → RETURN
    │   RESTORE (1,1) = true
    │
    ├── R: path("RR", 0, 2) [MARK F: (0,2)]
    │   ├── D: path("RRD", 1, 2) [MARK F: (1,2)]
    │   │   ├── D: path("RRDD", 2, 2)
    │   │   │   └── PRINT "RRDD"; RETURN
    │   │   ├── R: out of bounds
    │   │   ├── U: (0,2) is false → RETURN
    │   │   └── L: path("RRDL", 1, 1) [MARK F: (1,1)]
    │   │       ├── D: (2,1) is true → path("RRDLD", 2, 1)
    │   │       │   ├── D: out of bounds
    │   │       │   ├── R: (2,2) → PRINT "RRDLDR"
    │   │       │   ├── U: (1,1) is false → RETURN
    │   │       │   └── L: path("RRDLDL", 2, 0) [MARK F: (2,0)]
    │   │       │       ├── D: out of bounds
    │   │       │       ├── R: (2,1) is false → RETURN
    │   │       │       ├── U: (1,0) is true → path("RRDLDLU", 1, 0)
    │   │       │       └── L: out of bounds
    │   │       │       RESTORE (2,0) = true
    │   │       │   RESTORE (2,1) = true
    │   │       ├── R: (1,2) is false → RETURN
    │   │       ├── U: (0,1) is false → RETURN
    │   │       └── L: path("RRDLL", 1, 0) [MARK F: (1,0)]
    │   │           ├── D: (2,0) is true → path("RRDLLD", 2, 0)
    │   │           ├── R: (1,1) is false → RETURN
    │   │           ├── U: (0,0) is true → path("RRDLLU", 0, 0)
    │   │           └── L: out of bounds
    │   │           RESTORE (1,0) = true
    │   │       RESTORE (1,1) = true
    │   │   RESTORE (1,2) = true
    │   └── L: (0,1) is false → RETURN
    │   RESTORE (0,2) = true
    │
    ├── U: out of bounds
    └── L: (0,0) is false → RETURN
    RESTORE (0,1) = true
    ↩ RETURN to path("", 0, 0)

RESTORE (0,0) = true
↩ END
---
[1, 0, 0]
[2, 0, 0]
[3, 4, 5]
DDRR

[1, 0, 0]
[2, 5, 6]
[3, 4, 7]
DDRURD

[1, 6, 7]
[2, 5, 8]
[3, 4, 9]
DDRUURDD

[1, 0, 0]
[2, 3, 0]
[0, 4, 5]
DRDR

[1, 0, 0]
[2, 3, 4]
[0, 0, 5]
DRRD

[1, 4, 5]
[2, 3, 6]
[0, 0, 7]
DRURDD

[1, 2, 0]
[0, 3, 0]
[0, 4, 5]
RDDR

[1, 2, 0]
[0, 3, 4]
[0, 0, 5]
RDRD

[1, 2, 0]
[4, 3, 0]
[5, 6, 7]
RDLDRR

[1, 2, 3]
[0, 0, 4]
[0, 0, 5]
RRDD

[1, 2, 3]
[0, 5, 4]
[0, 6, 7]
RRDLDR

[1, 2, 3]
[6, 5, 4]
[7, 8, 9]
RRDLLDRR
```

## uniquePaths — Complete Explanation

Your program uses **recursion, backtracking, and in-place visited-cell tracking** to find all valid paths from the starting cell to the destination in a grid.

Unlike the previous version, this implementation does not use a separate `boolean[][] maze` matrix. Instead, it temporarily modifies the original `grid` to mark visited cells and restores their original values after exploring each path.

We'll understand the problem first, then the approach, code execution, recursion, backtracking, and time and space complexity.

## 1. What is the problem?

You are given a 2D grid containing four types of cells:

| Value | Meaning |
|---|---|
| `1` | Starting cell |
| `0` | Empty cell |
| `2` | Destination cell |
| `-1` | Obstacle — cannot enter |

You must find the number of paths from the starting cell to the destination such that **every non-obstacle cell is visited exactly once**.

You can move in four directions:

- **Down:** `row + 1`
- **Up:** `row - 1`
- **Right:** `column + 1`
- **Left:** `column - 1`

Your input grid is:

```java
int[][] grid = {
    { 1, 0, 0, 0 },
    { 0, 0, 0, 0 },
    { 0, 0, 2, -1 }
};
```

There are 12 cells in total. One cell is an obstacle, so there are **11 non-obstacle cells**.

Therefore, a valid path must visit all 11 non-obstacle cells exactly once, including the starting and destination cells.

Since the starting cell is counted as step 1, the destination must be reached at **step 11**.

## 2. What is the approach?

Your approach is **Depth-First Search (DFS) with backtracking**.

The algorithm explores one possible route as far as it can, then returns to earlier cells to try alternative routes.

The basic process is:

1. Find the starting cell (`1`) and count all non-obstacle cells.
2. Start recursion from the starting cell with `steps = 1`.
3. Save the original value of the current cell.
4. Temporarily change the current cell to `-1` to mark it as visited.
5. Explore Down, Right, Up, and Left wherever movement is allowed.
6. When the destination (`2`) is reached, accept the route only if `steps == totalCells`.
7. Restore the original value of the current cell after exploring all directions.

The crucial distinction is that **reaching the destination does not automatically make a route valid**. Every non-obstacle cell must have been visited first.

## 3. Understand the `main()` method

### Step 1: Create the grid

```java
int[][] grid = {
    { 1, 0, 0, 0 },
    { 0, 0, 0, 0 },
    { 0, 0, 2, -1 }
};
```

This represents the actual maze. The values tell us which cell is the start, destination, empty, or obstacle.

### Step 2: Create the `path` matrix

```java
int[][] path = new int[grid.length][grid[0].length];
```

This matrix records the order in which cells are visited.

For example, a cell visited as the first cell gets `1`, the next gets `2`, and so on.

It is used only to visualize the path. It is not required to calculate the answer.

### Step 3: Count all required cells and find the start

```java
int totalCells = 0;
int startRow = 0;
int startCol = 0;

for (int r = 0; r < grid.length; r++) {
    for (int c = 0; c < grid[0].length; c++) {
        if (grid[r][c] != -1) {
            totalCells++;
        }

        if (grid[r][c] == 1) {
            startRow = r;
            startCol = c;
        }
    }
}
```
## Why Do We Use `totalCells` and `steps == totalCells`?
these two variables ensure that **every non-obstacle cell is visited exactly once before reaching the destination**.

### 1. Why Do We Use `totalCells`?

```java
int totalCells = 0;

for (int r = 0; r < grid.length; r++) {
    for (int c = 0; c < grid[0].length; c++) {
        if (grid[r][c] != -1) {
            totalCells++;
        }
    }
}
```

`totalCells` stores the total number of cells that must be visited. We exclude obstacles (`-1`) because they cannot be visited.

For your grid:

```java
int[][] grid = {
    { 1, 0, 0, 0 },
    { 0, 0, 0, 0 },
    { 0, 0, 2, -1 }
};
```

There are 12 cells in total, but one is an obstacle.


These 11 cells include:

- 1 starting cell
- 9 empty cells
- 1 destination cell

### 2. Why Do We Start `steps` at `1`?

Your recursive call is:

```java
int count = allPath(
    "", path, grid,
    startRow, startCol, 1, totalCells
);
```

We start `steps` at `1` because the starting cell itself counts as the first visited cell.

Suppose a route visits the cells in this order:

| Step | Meaning |
|---:|---|
| 1 | Starting cell |
| 2 | Second cell visited |
| 3 | Third cell visited |
| ... | ... |
| 11 | Eleventh cell visited |

This continues until the destination is reached.

Whenever you move to another cell, you pass:

```java
steps + 1
```

For example:

```java
allPath(
    p + 'D', path, grid,
    row + 1, column, steps + 1, totalCells
);
```

So, `steps` represents the **number of cells visited along the current route**, including the current cell. It does not represent the number of moves.

### 3. Why Do We Check `steps == totalCells`?

Your destination condition is:

```java
if (grid[row][column] == 2) {
    if (steps == totalCells) {
        return 1;
    } else {
        return 0;
    }
}
```

This condition checks whether the route visited every required cell before reaching the destination.

For your grid, `totalCells = 11`.

| When the destination is reached | `steps` | Result |
|---|---:|---|
| An incomplete route | 5 | `return 0` |
| An incomplete route | 8 | `return 0` |
| After visiting every required cell | 11 | `return 1` |

**Why reject a route that reaches the destination at step 8?**

Because three required cells would remain unvisited. Even though the destination was reached, the route does not satisfy the problem's conditions.

### 4. How Do These Two Variables Work Together?

The relationship is simple:

- `totalCells` tells us how many cells must be visited.
- `steps` tells us how many cells have been visited on the current route.
- `steps == totalCells` confirms that the entire route has covered every required cell when it reaches the destination.

The recursive calls increment `steps` as they move, while `totalCells` stays constant.

\[
\boxed{\text{Valid path: destination reached and steps}=\text{totalCells}}
\]

**Remember:** We use `totalCells` as the target and `steps` as the current progress. Together, they prevent the algorithm from counting paths that reach the destination too early.

The condition `grid[r][c] != -1` excludes obstacles from the count.

For your grid:

- Empty cells: 9
- Starting cell: 1
- Destination cell: 1
- Obstacle cells: 1
- Total required cells: **11**

The starting coordinates are `(0, 0)`.

### Step 4: Call the recursive function

```java
int count = allPath(
    "", path, grid,
    startRow, startCol, 1, totalCells
);

System.out.println(count);
```

The arguments mean:

| Argument | Purpose |
|---|---|
| `""` | Initially, the path string is empty |
| `path` | Stores the visit order for printing |
| `grid` | Stores the maze and tracks visited cells |
| `startRow`, `startCol` | Starting coordinates |
| `1` | The start is step 1 |
| `totalCells` | Number of cells that must be visited |

Notice that the `maze` matrix is no longer passed to the function. Your code uses `grid` itself to track visited cells.

## 4. Understand the `allPath()` method

### A. Reject an obstacle or visited cell

```java
if (grid[row][column] == -1) {
    return 0;
}
```

If the current cell contains `-1`, the route cannot continue.

This condition handles two situations:

- A permanent obstacle that was already present in the input.
- A cell that was temporarily marked as visited by the current recursive route.

`return 0` means this recursive branch contributes zero valid paths.

### B. Check whether the destination has been reached

```java
if (grid[row][column] == 2) {
    if (steps == totalCells) {
        path[row][column] = steps;

        for (int[] arr : path) {
            System.out.println(Arrays.toString(arr));
        }

        System.out.println(p);
        System.out.println();

        return 1;
    } else {
        return 0;
    }
}
```

This is the most important condition in the program.

- If the destination is reached after visiting every required cell, return `1`.
- Otherwise, return `0`.

Why return `1`? Because the method counts valid routes. Every valid completed route contributes one to the total count.

For your grid, a route reaching the destination at step 11 is valid. If it reaches the destination at step 8, it is invalid because some cells remain unvisited.

### C. Save the original value and mark the current cell

```java
int count = 0;

int original = grid[row][column];
grid[row][column] = -1;

path[row][column] = steps;
```

Before exploring the next cells:

- `count = 0` initializes the number of valid paths found from this position.
- `original` saves the current cell's original value.
- `grid[row][column] = -1` temporarily marks the cell as visited.
- `path[row][column] = steps` records the current step number.

The cell remains marked as visited while all four directions are explored.

### Why do we use `int original` instead of `boolean[][] maze`?

In the previous implementation, you used a separate matrix:

```java
boolean[][] maze = new boolean[grid.length][grid[0].length];
```

You marked a cell as visited using:

```java
maze[row][column] = false;
```

In your updated code, you modify the original grid instead:

```java
int original = grid[row][column];
grid[row][column] = -1;
```

Suppose the current cell contains `0`.

Before visiting:

```text
grid[row][column] = 0
```

After marking it visited:

```text
grid[row][column] = -1
```

After exploring all directions:

```java
grid[row][column] = original;
```

The cell becomes `0` again.

The variable `original` is necessary because the cell might originally contain `0` or `1`. You must restore its actual previous value, not always set it to `0`.

| Feature | Separate `boolean[][] maze` | Reusing `grid` with `int original` |
|---|---|---|
| Mark visited | `maze[row][column] = false` | `grid[row][column] = -1` |
| Restore state | `maze[row][column] = true` | `grid[row][column] = original` |
| Extra visited matrix | Required | Not required |
| Original grid during recursion | Unmodified | Temporarily modified |
| Additional space | One extra matrix | No extra visited matrix |

Both approaches are correct. Reusing `grid` is more space-efficient because it eliminates the separate visited matrix.

### D. Explore all four directions

```java
if (row < grid.length - 1) {
    count += allPath(
        p + 'D', path, grid,
        row + 1, column, steps + 1, totalCells
    );
}
```

This explores Down, provided the next row is within the grid.

The other three calls follow the same logic:

```java
// Right
if (column < grid[0].length - 1) {
    count += allPath(
        p + 'R', path, grid,
        row, column + 1, steps + 1, totalCells
    );
}

// Up
if (row > 0) {
    count += allPath(
        p + 'U', path, grid,
        row - 1, column, steps + 1, totalCells
    );
}

// Left
if (column > 0) {
    count += allPath(
        p + 'L', path, grid,
        row, column - 1, steps + 1, totalCells
    );
}
```

Each call explores a separate choice. The boundary checks prevent the recursion from moving outside the grid.

**Why use `count +=`?**

Suppose the Down branch finds 2 valid routes and the Right branch finds 3. Their combined contribution is:

\[
count = 2 + 3 = 5
\]

Every recursive call returns the number of valid routes found beneath that call.

### E. Backtrack and restore the state

```java
grid[row][column] = original;
path[row][column] = 0;

return count;
```

Once all directions have been explored, the function restores the current cell.

This is **backtracking**: undoing the current choice after exploring its consequences so that another route can use that cell.

For example:

1. Visit cell `(0, 0)` and save its original value, `1`.
2. Change the cell to `-1`.
3. Explore all possible routes starting from it.
4. Finish exploring those routes.
5. Restore `(0, 0)` to `1`.
6. Return the number of valid routes found.

Without restoration, other branches could incorrectly treat the cell as permanently unavailable.

**Important correction for path printing:** Your current code returns immediately when a valid destination is reached, leaving the destination's step number in `path`. If you want every printed matrix to represent only its own route, copy the matrix before printing or restore the destination cell after printing. Otherwise, a previously printed route's destination step may remain visible in later outputs.

## 5. Visualize the recursion

Suppose the algorithm starts at the top-left cell. It explores a tree of choices:

```text
Start (0, 0)
    |
    ├── Down
    |     └── Continue DFS
    |
    └── Right
          └── Continue DFS
```

The actual recursion tree is much larger because each cell can have up to four possible directions. Visited-cell tracking eliminates moves back into cells already used by the current route.

Your code explores Down before Right, then Up, then Left. Consequently, the order of the printed paths depends on this direction order.

## 6. Why are both `grid` and `path` used?

They serve different purposes.

| Matrix | Purpose | Required for counting? |
|---|---|---|
| `grid` | Represents the maze and tracks visited cells | Yes |
| `path` | Displays the order of visited cells | No |

Your current implementation is useful for learning because it separates the maze's cell information from the path visualization, while avoiding a separate visited matrix.

For a count-only solution, you can remove `path` and the path string `p` as well.

## 7. Complexity analysis

Let \(M\) be the number of non-obstacle cells.

- **Time complexity:** \(O(4^M)\) as a loose upper-bound estimate, because each visited cell can lead to up to four recursive choices. The visited-cell restriction makes the actual search smaller than this bound.
- **Auxiliary space complexity:** \(O(M)\) for the recursion stack, plus \(O(M)\) for the `path` matrix. The grid itself is input storage, although its cells are temporarily modified.

Your updated implementation saves the extra `boolean[][] maze` matrix.

## 8. Important concepts to remember

1. **DFS:** Explore one route deeply before trying another.
2. **Backtracking:** Restore the current state after exploring a route.
3. **Visited tracking:** Temporarily replace the current cell with `-1` to prevent revisiting it.
4. **Saving original state:** Store the cell's original value in `int original` so it can be restored correctly.
5. **Base cases:** Stop when an obstacle or visited cell is encountered, or when the destination is reached.
6. **Counting recursion:** Invalid branches return `0`; valid complete routes return `1`; parent calls add their children's results.
7. **Path visualization:** `path` records the order of cells but does not determine whether the route is valid.

The central idea is: **save the current cell, mark it visited, explore every possible continuation, restore the original value, and count only routes that visit every required cell exactly once.**

# N-Queens Problem — Recursion and Backtracking in Java

## 1. Problem Definition

The **N-Queens problem** is a classic backtracking problem. We need to place `N` queens on an `N × N` chessboard so that no two queens attack each other.

A queen can attack another queen in three directions:

- **Vertical:** Same column.
- **Horizontal:** Same row.
- **Diagonal:** Same diagonal.

### Main Idea

We follow one important rule:

**Place exactly one queen in each row.**

This automatically prevents two queens from sharing the same row. Therefore, we only need to check the column and diagonals before placing a queen.

The algorithm follows these steps:

1. Start from row `0`.
2. Try every column in the current row.
3. Check whether the position is safe.
4. If safe, place the queen.
5. Recursively solve the next row.
6. Remove the queen and try another column.
7. When all rows have been filled, count the solution.

The fundamental backtracking pattern is:

**Choose → Explore → Undo**

---

## 2. Complete Java Code

```java
public class Nqueens {

    public static void main(String[] args) {
        int n = 5;
        boolean[][] board = new boolean[n][n];

        System.out.println(queens(board, 0));
    }

    static int queens(boolean[][] board, int row) {

        // Base case: all queens have been placed
        if (row == board.length) {
            display(board);
            System.out.println();
            return 1;
        }

        int count = 0;

        // Try every column in the current row
        for (int col = 0; col < board.length; col++) {

            if (isSafe(board, row, col)) {

                // Choose
                board[row][col] = true;

                // Explore
                count += queens(board, row + 1);

                // Undo
                board[row][col] = false;
            }
        }

        return count;
    }

    static boolean isSafe(boolean[][] board, int row, int col) {

        // Check the same column above
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // Check the upper-left diagonal
        int maxLeft = Math.min(row, col);

        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }

        // Check the upper-right diagonal
        int maxRight = Math.min(row, board.length - col - 1);

        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }

        return true;
    }

    static void display(boolean[][] board) {
        for (boolean[] arr : board) {
            for (boolean element : arr) {
                if (element) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
```

---

## 3. Explanation of `main()`

```java
public static void main(String[] args) {
    int n = 5;
    boolean[][] board = new boolean[n][n];

    System.out.println(queens(board, 0));
}
```

### `int n = 5;`

We want to place five queens, so the board has five rows and five columns.

### `boolean[][] board = new boolean[n][n];`

This creates a two-dimensional boolean array.

Initially, all elements are `false`.

| Boolean value | Meaning |
|---|---|
| `true` | A queen is placed in this cell |
| `false` | The cell is empty |

Initially, the board looks like this:

```text
X X X X X
X X X X X
X X X X X
X X X X X
X X X X X
```

Here, `X` represents `false`.

### `queens(board, 0)`

We start placing queens from row `0`.

The `row` parameter indicates which row we are currently trying to fill.

The function returns the total number of valid arrangements, which is printed by `System.out.println()`.

---

## 4. Explanation of the `queens()` Method

```java
static int queens(boolean[][] board, int row) {

    if (row == board.length) {
        display(board);
        System.out.println();
        return 1;
    }

    int count = 0;

    for (int col = 0; col < board.length; col++) {

        if (isSafe(board, row, col)) {

            board[row][col] = true;

            count += queens(board, row + 1);

            board[row][col] = false;
        }
    }

    return count;
}
```

### A. Base Case

```java
if (row == board.length) {
    display(board);
    System.out.println();
    return 1;
}
```

For `n = 5`, valid row indices are:

```text
0, 1, 2, 3, 4
```

When `row == 5`, all five rows have successfully received a queen.

The recursive call has reached:

```java
queens(board, 5);
```

At this point:

1. `display(board)` prints the completed arrangement.
2. `return 1` indicates that one valid solution has been found.

**Important:** `return 1` does not mean the entire problem has only one solution. It means the current completed arrangement contributes one to the total count.

### B. Initialize `count`

```java
int count = 0;
```

This variable stores the number of valid solutions discovered through the current recursive call.

Initially, no solutions have been found by this call, so `count = 0`.

### C. Try Every Column

```java
for (int col = 0; col < board.length; col++)
```

For `n = 5`, the loop tries:

```text
col = 0
col = 1
col = 2
col = 3
col = 4
```

For each column, the algorithm checks whether a queen can safely be placed in the current row.

For example, when `row = 0`, the algorithm attempts:

```text
(0,0), (0,1), (0,2), (0,3), (0,4)
```

Each position represents a possible choice.

### D. Check Whether the Position Is Safe

```java
if (isSafe(board, row, col))
```

This calls the `isSafe()` method to check whether an existing queen can attack the proposed position.

- If it returns `true`, place the queen.
- If it returns `false`, skip that column and try the next one.

### E. Choose — Place the Queen

```java
board[row][col] = true;
```

This marks the selected cell as occupied by a queen.

For example, if `row = 0` and `col = 2`:

```text
X X Q X X
X X X X X
X X X X X
X X X X X
X X X X X
```

We have made one choice, but we do not yet know whether it will lead to a complete solution.

### F. Explore — Recursive Call

```java
count += queens(board, row + 1);
```

After placing a queen in the current row, we recursively try to place a queen in the next row.

The recursive calls may look like this:

```text
queens(board, 0)
    |
    └── queens(board, 1)
            |
            └── queens(board, 2)
                    |
                    └── queens(board, 3)
                            |
                            └── queens(board, 4)
                                    |
                                    └── queens(board, 5)
```

This is one possible chain of decisions. Unsafe branches are rejected, and a chain may terminate before reaching the base case.

#### Why do we use `count +=`?

Suppose a recursive call finds three valid solutions and returns `3`.

The current call adds those three solutions to its own count.

Mathematically:

\[
\text{count} = \text{count} + \text{solutions from child}
\]

This allows the algorithm to count every valid arrangement instead of stopping after finding the first one.

### G. Undo — Backtracking

```java
board[row][col] = false;
```

After the recursive call finishes exploring that choice, we remove the queen from the board.

Suppose we placed a queen at `(0, 2)`. The recursive function explores all arrangements that begin with that choice. Once those possibilities have been explored, we remove that queen before trying `(0, 3)`.

Otherwise, the next attempt would incorrectly retain the previous queen.

The fundamental backtracking pattern is:

```java
board[row][col] = true;          // Choose

count += queens(board, row + 1);  // Explore

board[row][col] = false;         // Undo
```

---

## 5. Explanation of the `isSafe()` Method

```java
static boolean isSafe(boolean[][] board, int row, int col)
```

This method checks three directions:

1. Vertical column.
2. Upper-left diagonal.
3. Upper-right diagonal.

It returns `true` if the position is safe; otherwise, it returns `false`.

### A. Vertical Check

```java
for (int i = 0; i < row; i++) {
    if (board[i][col]) {
        return false;
    }
}
```

This checks whether a queen already exists in the same column above the current position.

Suppose we want to place a queen at `(3, 2)`:

```text
X X X X X
X X Q X X
X X X X X
X X ? X X
X X X X X
```

The `?` represents the proposed position `(3, 2)`.

The loop checks:

```java
board[0][2]
board[1][2]
board[2][2]
```

If any of these positions contains a queen (`true`), the proposed position is unsafe.

**Why does the loop stop at `i < row`?**

Because queens are placed from top to bottom. Rows below the current row have not been processed yet.

### B. Upper-Left Diagonal Check

```java
int maxLeft = Math.min(row, col);

for (int i = 1; i <= maxLeft; i++) {
    if (board[row - i][col - i]) {
        return false;
    }
}
```

We move diagonally upward and to the left.

Both the row and column decrease by one at each step:

\[
(r,c)\rightarrow(r-1,c-1)
\]

For a proposed position `(3, 2)`, the diagonal positions are:

```text
(2,1)
(1,0)
```

The next step would leave the board.

Your code prevents this by calculating:

```java
int maxLeft = Math.min(row, col);
```

For `(3, 2)`:

```java
maxLeft = Math.min(3, 2); // 2
```

Therefore, the loop checks exactly two cells.

Why use `Math.min()`?

Because the number of steps is limited by whichever boundary we reach first: the top edge or the left edge.

### C. Upper-Right Diagonal Check

```java
int maxRight = Math.min(row, board.length - col - 1);

for (int i = 1; i <= maxRight; i++) {
    if (board[row - i][col + i]) {
        return false;
    }
}
```

Here, we move upward and to the right.

The row decreases while the column increases:

\[
(r,c)\rightarrow(r-1,c+1)
\]

For the proposed position `(3, 2)` on a `5 × 5` board, the positions checked are:

```text
(2,3)
(1,4)
```

The expression:

```java
board.length - col - 1
```

calculates how many steps remain before reaching the right boundary.

For this example:

```java
maxRight = Math.min(3, 5 - 2 - 1);

// maxRight = 2
```

So the loop checks two cells.

If either diagonal contains a queen, the method returns `false`.

### D. Return `true`

```java
return true;
```

This statement executes only when all three checks pass.

The proposed position is safe, so the `queens()` method can place a queen there.

### Why Don't We Check Below or in the Current Row?

- **Below:** Those rows have not been processed yet.
- **Current row:** The algorithm places exactly one queen in each row.
- **Above:** Previously placed queens may attack the proposed position.

Therefore, checking the column and the two upper diagonals is sufficient.

---

## 6. Explanation of the `display()` Method

```java
static void display(boolean[][] board) {

    for (boolean[] arr : board) {

        for (boolean element : arr) {

            if (element) {
                System.out.print("Q ");
            } else {
                System.out.print("X ");
            }
        }

        System.out.println();
    }
}
```

This method prints the board row by row.

- The outer enhanced `for` loop selects each row.
- The inner enhanced `for` loop visits every cell in that row.
- If the cell is `true`, it prints `Q`.
- Otherwise, it prints `X`.
- `System.out.println()` moves to the next line after each row.

For example, a valid arrangement might be displayed as:

```text
X Q X X X
X X X Q X
Q X X X X
X X Q X X
X X X X Q
```

This is an illustration of the display format, not a valid solution: the arrangement above contains attacking queens on a diagonal. Your program prints only arrangements that pass its safety checks.

---

## 7. How `count` Works With Backtracking

Suppose a recursive call explores two possible branches:

```text
                 queens(board, row)
                         |
                  Initial count = 0
                    /         \
                   /           \
              Branch A       Branch B
                  |               |
            Returns 2        Returns 3
                   \           /
                    \         /
                   Add both results
                         |
                   count = 2 + 3
                         |
                     count = 5
```

The numbers illustrate the counting mechanism; they are not the actual branch counts for `N = 5`.

Your code accumulates the return values of recursive calls:

```java
count += queens(board, row + 1);
```

Eventually, the initial call returns the total number of valid arrangements.

For `n = 5`, the expected final count is **10 solutions**.

---

## 8. Dry Run of the Algorithm

Initially:

```java
queens(board, 0);
```

The board is empty.

### Step 1: Process Row 0

The algorithm tries columns `0` through `4`.

Suppose it places a queen at `(0, 0)`.

```text
Q X X X X
X X X X X
X X X X X
X X X X X
X X X X X
```

Then it calls:

```java
queens(board, 1);
```

### Step 2: Process Row 1

The algorithm checks each column.

- Column `0` is unsafe because it shares a column with the first queen.
- Column `1` is unsafe because it shares a diagonal with the first queen.
- Columns `2`, `3`, and `4` can be explored.

Suppose it places a queen at `(1, 2)`.

```text
Q X X X X
X X Q X X
X X X X X
X X X X X
X X X X X
```

Then it calls:

```java
queens(board, 2);
```

### Step 3: Continue Recursively

The algorithm repeats the same process for each subsequent row.

If a row has no safe column, that branch cannot produce a solution. The recursive calls return, and the previous queen is removed.

### Step 4: Reach the Base Case

When all five rows contain a queen, the call reaches:

```java
if (row == board.length)
```

The board is displayed, and `return 1` reports one solution.

### Step 5: Backtrack and Explore Other Choices

The algorithm removes queens as recursive calls return and continues trying other columns.

When every possible branch has been explored, the initial call returns `10`.

---

## 9. Complexity Analysis

Let `N` be the size of the board.

### Time Complexity

The backtracking search is commonly described with an \(O(N!)\) search bound because each row must use a different column and invalid placements are pruned early.

The safety check requires up to \(O(N)\) time for each attempted placement.

The exact running time depends on the number of branches explored.

### Space Complexity

- **Board:** \(O(N^2)\), because the board has `N × N` cells.
- **Recursion stack:** \(O(N)\), because each recursive level processes one row.

Therefore, the total auxiliary space is:

\[
\boxed{O(N^2)}
\]

excluding printed output.

---

## 10. Final Summary

| Code | Purpose |
|---|---|
| `queens(board, 0)` | Start from row zero |
| `row == board.length` | All queens have been placed |
| `for (int col = 0; ...)` | Try each column |
| `isSafe(board, row, col)` | Check vertical and diagonal attacks |
| `board[row][col] = true` | Place a queen |
| `queens(board, row + 1)` | Explore the next row |
| `board[row][col] = false` | Undo the placement |
| `count += ...` | Accumulate the number of solutions |
| `return count` | Return the total to the caller |


# N-Queens (N = 4) — Complete Recursion Tree

This tree follows the Java implementation and shows:

- `isSafe()` returning `true` or `false`
- Queen placement: `board[row][col] = true`
- Recursive calls: `queens(board, row + 1)`
- Backtracking: `board[row][col] = false`
- `count += ...` and all return values

For this trace, use `int n = 4`.

## 1. Legend

| Statement | Meaning |
|---|---|
| `SAFE → true` | `isSafe()` returns `true` |
| `UNSAFE → false` | `isSafe()` returns `false`; skip the column |
| `MARK true` | Place a queen |
| `MARK false` | Remove a queen during backtracking |
| `return 1` | A complete solution is found |
| `return count` | Return the total solutions found by this call |
| `count += x` | Add the child's return value |

## 2. Complete Recursion Tree

```text

queens(board, 0)                         [count = 0]
│
├── col = 0
│   └── isSafe(board, 0, 0) → true
│       └── board[0][0] = true           [MARK Q at (0,0)]
│           │
│           └── queens(board, 1)         [count = 0]
│               │
│               ├── col = 0
│               │   └── isSafe → false  [same column]
│               │       └── SKIP
│               │
│               ├── col = 1
│               │   └── isSafe → false  [left diagonal]
│               │       └── SKIP
│               │
│               ├── col = 2
│               │   └── isSafe → true
│               │       └── board[1][2] = true
│               │           [MARK Q at (1,2)]
│               │           │
│               │           └── queens(board, 2) [count = 0]
│               │               │
│               │               ├── col = 0
│               │               │   └── isSafe → false [diagonal]
│               │               │       └── SKIP
│               │               │
│               │               ├── col = 1
│               │               │   └── isSafe → false [diagonal]
│               │               │       └── SKIP
│               │               │
│               │               ├── col = 2
│               │               │   └── isSafe → false [same column]
│               │               │       └── SKIP
│               │               │
│               │               └── col = 3
│               │                   └── isSafe → true
│               │                       └── board[2][3] = true
│               │                           [MARK Q at (2,3)]
│               │                           │
│               │                           └── queens(board, 3)
│               │                               [count = 0]
│               │                               │
│               │                               ├── col = 0
│               │                               │   └── isSafe → false
│               │                               │       [diagonal]
│               │                               │       └── SKIP
│               │                               │
│               │                               ├── col = 1
│               │                               │   └── isSafe → false
│               │                               │       [diagonal]
│               │                               │       └── SKIP
│               │                               │
│               │                               ├── col = 2
│               │                               │   └── isSafe → false
│               │                               │       [same column]
│               │                               │       └── SKIP
│               │                               │
│               │                               └── col = 3
│               │                                   └── isSafe → false
│               │                                       [same column]
│               │                                       └── SKIP
│               │
│               │                               return count; // 0
│               │
│               │                       count += 0; // count = 0
│               │                       board[2][3] = false
│               │                       [BACKTRACK]
│               │
│               │               return count; // 0
│               │
│               │       count += 0; // count = 0
│               │       board[1][2] = false
│               │       [BACKTRACK]
│               │
│               └── col = 3
│                   └── isSafe → true
│                       └── board[1][3] = true
│                           [MARK Q at (1,3)]
│                           │
│                           └── queens(board, 2) [count = 0]
│                               │
│                               ├── col = 0
│                               │   └── isSafe → false [same column]
│                               │       └── SKIP
│                               │
│                               ├── col = 1
│                               │   └── isSafe → true
│                               │       └── board[2][1] = true
│                               │           [MARK Q at (2,1)]
│                               │           │
│                               │           └── queens(board, 3)
│                               │               [count = 0]
│                               │               │
│                               │               ├── col = 0
│                               │               │   └── isSafe → false
│                               │               │       [diagonal]
│                               │               │       └── SKIP
│                               │               │
│                               │               ├── col = 1
│                               │               │   └── isSafe → false
│                               │               │       [same column]
│                               │               │       └── SKIP
│                               │               │
│                               │               ├── col = 2
│                               │               │   └── isSafe → false
│                               │               │       [diagonal]
│                               │               │       └── SKIP
│                               │               │
│                               │               └── col = 3
│                               │                   └── isSafe → false
│                               │                       [same column]
│                               │                       └── SKIP
│                               │
│                               │               return count; // 0
│                               │
│                               │       count += 0; // count = 0
│                               │       board[2][1] = false
│                               │       [BACKTRACK]
│                               │
│                               ├── col = 2
│                               │   └── isSafe → false [diagonal]
│                               │       └── SKIP
│                               │
│                               └── col = 3
│                                   └── isSafe → false [same column]
│                                       └── SKIP
│
│                           return count; // 0
│
│                   count += 0; // count = 0
│                   board[1][3] = false
│                   [BACKTRACK]
│
│           return count; // 0
│
│   count += 0; // ROOT count = 0
│   board[0][0] = false
│   [BACKTRACK]
│
├── col = 1
│   └── isSafe → true
│       └── board[0][1] = true        [MARK Q at (0,1)]
│           │
│           └── queens(board, 1)      [count = 0]
│               │
│               ├── col = 0 → isSafe = false [diagonal]
│               ├── col = 1 → isSafe = false [same column]
│               ├── col = 2 → isSafe = true
│               │   └── board[1][2] = true [MARK Q at (1,2)]
│               │       └── queens(board, 2)
│               │           │
│               │           ├── col = 0 → isSafe = false [diagonal]
│               │           ├── col = 1 → isSafe = false [same column]
│               │           ├── col = 2 → isSafe = false [same column]
│               │           └── col = 3 → isSafe = false [diagonal]
│               │
│               │           return count; // 0
│               │       count += 0
│               │       board[1][2] = false [BACKTRACK]
│               │
│               └── col = 3 → isSafe = true
│                   └── board[1][3] = true [MARK Q at (1,3)]
│                       └── queens(board, 2) [count = 0]
│                           │
│                           ├── col = 0 → isSafe = true
│                           │   └── board[2][0] = true [MARK Q at (2,0)]
│                           │       └── queens(board, 3) [count = 0]
│                           │           │
│                           │           ├── col = 0 → isSafe = false [same column]
│                           │           ├── col = 1 → isSafe = false [diagonal]
│                           │           ├── col = 2 → isSafe = true
│                           │           │   └── board[3][2] = true [MARK Q at (3,2)]
│                           │           │       └── queens(board, 4)
│                           │           │           ├── row == board.length
│                           │           │           ├── display(board)
│                           │           │           └── return 1 [SOLUTION 1]
│                           │           │
│                           │           │       count += 1; // count = 1
│                           │           │       board[3][2] = false [BACKTRACK]
│                           │           │
│                           │           └── col = 3 → isSafe = false [same column]
│                           │
│                           │           return count; // 1
│                           │       count += 1; // count = 1
│                           │       board[2][0] = false [BACKTRACK]
│                           │
│                           ├── col = 1 → isSafe = false [diagonal]
│                           ├── col = 2 → isSafe = false [diagonal]
│                           └── col = 3 → isSafe = false [same column]
│
│                       return count; // 1
│                   count += 1; // count = 1
│                   board[1][3] = false [BACKTRACK]
│
│           return count; // 1
│   count += 1; // ROOT count = 1
│   board[0][1] = false [BACKTRACK]
│
├── col = 2
│   └── isSafe → true
│       └── board[0][2] = true [MARK Q at (0,2)]
│           │
│           └── queens(board, 1) [count = 0]
│               │
│               ├── col = 0 → isSafe = true
│               │   └── board[1][0] = true [MARK Q at (1,0)]
│               │       └── queens(board, 2) [count = 0]
│               │           │
│               │           ├── col = 0 → isSafe = false [same column]
│               │           ├── col = 1 → isSafe = false [diagonal]
│               │           ├── col = 2 → isSafe = false [same column]
│               │           └── col = 3 → isSafe = true
│               │               └── board[2][3] = true [MARK Q at (2,3)]
│               │                   └── queens(board, 3)
│               │                       │
│               │                       ├── col = 0 → isSafe = false [diagonal]
│               │                       ├── col = 1 → isSafe = true
│               │                       │   └── board[3][1] = true [MARK Q at (3,1)]
│               │                       │       └── queens(board, 4)
│               │                       │           ├── row == board.length
│               │                       │           ├── display(board)
│               │                       │           └── return 1 [SOLUTION 2]
│               │                       │
│               │                       │       count += 1; // count = 1
│               │                       │       board[3][1] = false [BACKTRACK]
│               │                       │
│               │                       ├── col = 2 → isSafe = false [diagonal]
│               │                       └── col = 3 → isSafe = false [same column]
│               │
│               │                       return count; // 1
│               │                   count += 1; // count = 1
│               │                   board[2][3] = false [BACKTRACK]
│               │
│               └── remaining columns → unsafe
│
│           return count; // 1
│       count += 1; // count = 1
│       board[1][0] = false [BACKTRACK]
│
│   return count; // 1
│   count += 1; // ROOT count = 2
│   board[0][2] = false [BACKTRACK]
│
└── col = 3
    └── isSafe → true
        └── board[0][3] = true [MARK Q at (0,3)]
            │
            └── queens(board, 1) [count = 0]
                │
                ├── col = 0 → isSafe = true
                │   └── board[1][0] = true [MARK Q at (1,0)]
                │       └── queens(board, 2)
                │           │
                │           ├── col = 0 → isSafe = false [same column]
                │           ├── col = 1 → isSafe = true
                │           │   └── board[2][1] = true [MARK Q at (2,1)]
                │           │       └── queens(board, 3)
                │           │           │
                │           │           ├── all columns unsafe
                │           │           └── return count; // 0
                │           │
                │           │       count += 0
                │           │       board[2][1] = false [BACKTRACK]
                │           │
                │           └── remaining columns → unsafe
                │
                │       return count; // 0
                │       board[1][0] = false [BACKTRACK]
                │
                ├── col = 1 → isSafe = true
                │   └── board[1][1] = true [MARK Q at (1,1)]
                │       └── queens(board, 2)
                │           └── all columns unsafe
                │               return count; // 0
                │       count += 0
                │       board[1][1] = false [BACKTRACK]
                │
                └── remaining columns → unsafe

            return count; // 0
    count += 0; // ROOT count remains 2
    board[0][3] = false [BACKTRACK]

return count; // ROOT returns 2
```

## 3. Final Output

For `n = 4`, the program prints two valid arrangements and then the total:

```text
X Q X X
X X X Q
Q X X X
X X Q X

X X Q X
Q X X X
X X X Q
X Q X X

2
```

## 4. Important Points

1. `isSafe()` returning `false` skips a column without making a recursive call.
2. `board[row][col] = true` executes before the recursive call.
3. When the child returns, `count += queens(board, row + 1)` adds its result.
4. `board[row][col] = false` then restores the board for the next choice.
5. `return 1` executes only when `row == board.length`.
6. A dead-end call returns `0` because its local `count` remains zero.
7. The root call returns `2`, the total number of valid arrangements for four queens.


# N-Queens — Recurrence Relation

A simplified upper-bound recurrence relation model for the N-Queens backtracking algorithm is:

\[
T(N)=N \times T(N-1)+O(N^2)
\]

## 1. Why do we have \(N \times T(N-1)\)?

In the N-Queens code, we place one queen in each row:

```java
for (int col = 0; col < board.length; col++) {
    if (isSafe(board, row, col)) {
        board[row][col] = true;
        count += queens(board, row + 1);
        board[row][col] = false;
    }
}
```

For a board of size \(N \times N\):

- There are at most \(N\) columns to try in the current row.
- After placing a queen, the recursive call processes the next row, with one fewer row left to fill.

Therefore, the recurrence includes \(N \times T(N-1)\).

Strictly speaking, not all \(N\) positions are safe, so this is an upper-bound-style model.

## 2. Why is the additional work \(O(N^2)\)?

The `isSafe()` method checks three directions:

1. Vertical upward.
2. Left diagonal upward.
3. Right diagonal upward.

Each check can scan up to \(N-1\) cells.

Therefore, checking one position takes \(O(N)\) time:

\[
O(N)+O(N)+O(N)=O(N)
\]

The loop tries up to \(N\) columns in one row. If every candidate requires a safety check, the work at that recursive level is:

\[
N \times O(N)=O(N^2)
\]

So the simplified recurrence is:

\[
\boxed{T(N)=N\,T(N-1)+O(N^2)}
\]

The \(O(N^2)\) term represents the cost of checking candidate positions at one recursive level, using a worst-case upper bound.

## 3. Example: \(N=4\)

- **Row 0:** Try up to 4 columns. Each candidate can require a safety check costing \(O(N)\).
- **Row 1:** After a safe queen placement in row 0, try up to 4 columns again.
- **Row 2:** Repeat for the next row, checking vertical and diagonal attacks.
- **Row 3:** Try the remaining positions and continue until a solution is found or all choices fail.

At each recursive level, the number of rows remaining decreases, but the board dimension stays \(N \times N\).

## 4. Important distinction

The recurrence is a simplified upper-bound model. A more precise analysis accounts for the number of safe positions and the cost of each `isSafe()` call.

- \(N \times T(N-1)\): Recursive exploration of candidate columns.
- \(O(N^2)\): Worst-case work at a level when checking up to \(N\) columns, each requiring \(O(N)\) time.

**Note:** This is not the exact tight recurrence for N-Queens because many positions are rejected and the number of recursive branches varies. It is a simplified model for understanding the backtracking process.


# N-Knights Problem in Java — Complete Explanation

Your code solves the N-Knights problem using recursion and backtracking. Let's understand the approach, how each function works, why we use four safety checks, how the recursion explores the board, and how the final count is calculated.

## 1. What is the N-Knights problem?

The goal is to place \(N\) knights on an \(N \times N\) chessboard so that no two knights attack each other.

For your example:

```java
int n = 4;
boolean[][] board = new boolean[n][n];
System.out.println(nights(board, 0, 0, 4));
```

- Board size: \(4 \times 4\)
- Knights to place: \(4\)
- Initially, all cells are `false`, meaning empty.
- `true` means a knight occupies that cell.

### Initial board

```text
X X X X
X X X X
X X X X
X X X X
```

`X` = empty cell. Initially, all 16 cells are empty.

The function explores possible placements and prints every valid arrangement of four knights.

## 2. The main approach: recursion + backtracking

Your algorithm follows five steps:

1. Choose a cell: Start from `(0,0)` and process cells from left to right, top to bottom.
2. Check safety: Determine whether a knight can be placed at the current cell without attacking an existing knight.
3. Explore placement: If safe, place the knight and recursively process the next cell with one fewer knight remaining.
4. Backtrack: After the placement branch returns, remove the knight and restore the board.
5. Explore skipping: Process the next cell without placing a knight at the current cell.

The two choices are:

- Place: `count += nights(board, row, col + 1, knight - 1);`
- Skip: `count += nights(board, row, col + 1, knight);`

This ensures that your algorithm considers both possibilities for every cell.

## 3. Understanding the `main()` method

```java
public static void main(String[] args) {
    int n = 4;
    boolean[][] board = new boolean[n][n];
    System.out.println(nights(board, 0, 0, 4));
}
```

Each statement has a specific purpose:

- `int n = 4;` sets the board dimensions to \(4 \times 4\).
- `new boolean[n][n]` creates the board. All values initially default to `false`.
- `nights(board, 0, 0, 4)` starts recursion at row 0, column 0, with four knights left to place.
- `System.out.println(...)` prints the total number of valid arrangements returned by the function.

The `nights()` function returns an integer because you want to count the solutions, not just print them.

## 4. The `nights()` function, line by line

### A. Base case: all knights have been placed

```java
if (knight == 0) {
    display(board);
    System.out.println();
    return 1;
}
```

Here, `knight` means the number of knights still to place.

Suppose the function reaches:

```java
nights(board, 2, 3, 0);
```

Four knights have already been placed somewhere on the board. The function:

1. Prints the board.
2. Prints a blank line.
3. Returns `1`, because this branch has found one valid arrangement.

Why return `1` instead of `0`?

Because we are counting solutions. A completed valid arrangement contributes one to the total.

### B. Base case: the row is out of bounds

```java
if (row == board.length) {
    return 0;
}
```

For a \(4 \times 4\) board, valid row indices are `0`, `1`, `2`, and `3`.

If the function reaches `row == 4` while knights are still left to place, every cell has been considered and this branch has failed.

Therefore, it returns `0` solutions.

This check also prevents the algorithm from accessing a row that does not exist.

### C. Move to the next row

```java
if (col == board.length) {
    return nights(board, row + 1, 0, knight);
}
```

For a board of size 4, columns range from `0` to `3`.

When `col` becomes `4`, the current row is finished. The function moves to the next row and resets the column to zero.

For example:

```text
nights(board, 0, 4, 2)
            |
            v
nights(board, 1, 0, 2)
```

Notice that `knight` remains `2`. Moving to another row does not place a knight.

Also, the `return` is important: it returns the number of solutions found by the next-row call instead of discarding that result.

### D. Initialize the counter

```java
int count = 0;
```

Each recursive call maintains its own local `count`.

It accumulates the number of solutions found by the placement and skip branches.

### E. Placement branch

```java
if (isSafe(board, row, col)) {
    board[row][col] = true;

    count += nights(board, row, col + 1, knight - 1);

    board[row][col] = false;
}
```

This branch runs only when the current cell is safe.

The three important actions are:

1. Place: Set the cell to `true`.
2. Recurse: Move to the next column and reduce the number of remaining knights by one.
3. Undo: Set the cell back to `false` after the recursive call returns.

The last step is backtracking. Without it, the knight would remain on the board when the algorithm explores other arrangements.

### F. Skip branch

```java
count += nights(board, row, col + 1, knight);
```

This explores the possibility of leaving the current cell empty.

Notice that `knight` does not decrease because no knight was placed.

This statement runs whether the current cell was safe or unsafe. If it was unsafe, the placement branch was simply skipped.

### G. Return the total

```java
return count;
```

The current call returns the sum of all solutions found in its branches.

Mathematically:

$$
\begin{aligned}
\text{count} ={}& \text{placement solutions}\\
&+ \text{skip solutions}
\end{aligned}
$$

For example, if the placement branch finds 5 solutions and the skip branch finds 7, the current call returns \(5+7=12\).

## 5. The `isSafe()` function

```java
static boolean isSafe(boolean[][] board, int row, int col) {
    if (isValid(board, row - 2, col + 1)) {
        if (board[row - 2][col + 1]) {
            return false;
        }
    }

    if (isValid(board, row - 2, col - 1)) {
        if (board[row - 2][col - 1]) {
            return false;
        }
    }

    if (isValid(board, row - 1, col + 2)) {
        if (board[row - 1][col + 2]) {
            return false;
        }
    }

    if (isValid(board, row - 1, col - 2)) {
        if (board[row - 1][col - 2]) {
            return false;
        }
    }

    return true;
}
```

A knight attacks in an L-shape: two squares in one direction and one square perpendicular to it.

There are eight possible attacking positions, but your algorithm processes the board in row-major order. Therefore, only four positions can contain previously placed knights:

| Position checked | Reason |
|---|---|
| `(row - 2, col + 1)` | Two rows above, one column right |
| `(row - 2, col - 1)` | Two rows above, one column left |
| `(row - 1, col + 2)` | One row above, two columns right |
| `(row - 1, col - 2)` | One row above, two columns left |

For each position:

1. `isValid()` checks that the position lies inside the board.
2. If valid, `board[...]` checks whether a knight occupies it.
3. If an attacking knight exists, `isSafe()` returns `false`.
4. If none of the four positions contains a knight, it returns `true`.

Why four checks? Because all cells in later rows, and cells to the right in the current row, are still unprocessed. They cannot already contain a knight in your algorithm.

## 6. The `isValid()` function

```java
static boolean isValid(boolean[][] board, int row, int col) {
    return row >= 0 && row < board.length
            && col >= 0 && col < board.length;
}
```

This checks whether both coordinates are within the board's boundaries.

For a \(4 \times 4\) board:

- `(0,0)` is valid.
- `(3,3)` is valid.
- `(-1,2)` is invalid.
- `(2,4)` is invalid.

The function uses `&&`, so all four comparisons must be true.

This prevents `ArrayIndexOutOfBoundsException` when checking possible knight moves.

## 7. The `display()` function

```java
static void display(boolean[][] board) {
    for (boolean[] arr : board) {
        for (boolean element : arr) {
            if (element) {
                System.out.print("K ");
            } else {
                System.out.print("X ");
            }
        }
        System.out.println();
    }
}
```

This prints the board row by row:

- `K` represents a knight (`true`).
- `X` represents an empty cell (`false`).

For example:

```text
K K X X
X X X K
K X X X
X K X X
```

The display function is called only when `knight == 0`, meaning all four knights have been placed.

## 8. Complete recursion flow

Let's combine everything into one flowchart.

```text
nights(board, row, col, knight)
                |
                v
           knight == 0?
            /        \
          Yes         No
           |           |
        display    row == n?
        return 1    /     \
                  Yes      No
                   |        |
                return 0  col == n?
                           /      \
                         Yes       No
                          |         |
                  Move next row   count = 0
                                   |
                                   v
                               isSafe()?
                               /       \
                             Yes        No
                              |          |
                         Place K         |
                              |          |
                         Recurse         |
                         knight - 1      |
                              |          |
                         Add count       |
                              |          |
                         Undo K          |
                              |          |
                              └────┬─────┘
                                   |
                                   v
                            Skip current cell
                                   |
                                   v
                             Add skip count
                                   |
                                   v
                              return count
```

## 9. Time and space complexity

Let \(n\) be the board dimension, so the board contains \(n^2\) cells.

**Time complexity:** \(O(2^{n^2})\) as a loose upper bound, because each cell can be included or skipped. Safety checking takes \(O(1)\) time because it checks only four positions. The algorithm also stops early when all knights have been placed.

**Space complexity:** \(O(n^2)\), including the board and the maximum recursion depth, since each recursive call advances through at most \(n^2\) cells.

The output itself can require substantial additional space if every arrangement is printed.

## 10. Important concepts to remember

- `knight` is the number of knights remaining, not the number already placed.
- `knight == 0` means a solution has been found, so return `1`.
- `row == board.length` means the board has been exhausted without completing that branch, so return `0`.
- `count += ...` accumulates solutions from both placement and skip branches.
- `board[row][col] = false` restores the board after exploring a placement.
- Four safety checks are sufficient because cells are processed from left to right and top to bottom.

For your \(4 \times 4\) board with four knights, this implementation counts 412 valid arrangements.

The central idea is that recursion explores each choice, while backtracking restores the board so that other choices can be explored independently.

# A small recursion tree for understanding
Legend
- P — place a knight.
- S — skip a cell.
- U — undo a placement.
- PRINT — print a valid board.
- R → parent — return to the immediate caller shown.
- × — unsafe placement; skip the placement branch.

```text

main()
└── knight(0,0,4)
    │
    ├── P (0,0)
    │   └── knight(0,1,3)
    │       │
    │       ├── P (0,1)
    │       │   └── knight(0,2,2)
    │       │       │
    │       │       ├── P (0,2)
    │       │       │   └── knight(0,3,1)
    │       │       │       │
    │       │       │       ├── P (0,3)
    │       │       │       │   └── knight(0,4,0)
    │       │       │       │       ├── PRINT
    │       │       │       │       └── R → knight(0,3,1)
    │       │       │       │
    │       │       │       ├── U (0,3)
    │       │       │       │
    │       │       │       └── S → knight(0,4,1)
    │       │       │           │
    │       │       │           └── knight(1,0,1)
    │       │       │               │
    │       │       │               ├── (1,0) UNSAFE
    │       │       │               │
    │       │       │               └── S → knight(1,1,1)
    │       │       │                   │
    │       │       │                   ├── P (1,1)
    │       │       │                   │   └── knight(1,2,0)
    │       │       │                   │       ├── PRINT
    │       │       │                   │       └── R → knight(1,1,1)
    │       │       │                   │
    │       │       │                   ├── U (1,1)
    │       │       │                   │
    │       │       │                   └── S → knight(1,2,1)
    │       │       │                       │
    │       │       │                       ├── (1,2) UNSAFE
    │       │       │                       │
    │       │       │                       └── S → knight(1,3,1)
    │       │       │                           │
    │       │       │                           ├── (1,3) UNSAFE
    │       │       │                           │
    │       │       │                           └── S → knight(1,4,1)
    │       │       │                               │
    │       │       │                               └── knight(2,0,1)
    │       │       │                                   │
    │       │       │                                   ├── (2,0) UNSAFE
    │       │       │                                   │
    │       │       │                                   └── S → knight(2,1,1)
    │       │       │                                       │
    │       │       │                                       ├── (2,1) UNSAFE
    │       │       │                                       │
    │       │       │                                       └── S → knight(2,2,1)
    │       │       │                                           │
    │       │       │                                           ├── (2,2) UNSAFE
    │       │       │                                           │
    │       │       │                                           └── S → knight(2,3,1)
    │       │       │                                               │
    │       │       │                                               ├── (2,3) UNSAFE
    │       │       │                                               │
    │       │       │                                               └── S → knight(2,4,1)
    │       │       │                                                   │
    │       │       │                                                   └── knight(3,0,1)
    │       │       │                                                       │
    │       │       │                                                       ├── P (3,0)
    │       │       │                                                       │   └── knight(3,1,0)
    │       │       │                                                       │       ├── PRINT
    │       │       │                                                       │       └── R → knight(3,0,1)
    │       │       │                                                       │
    │       │       │                                                       ├── U (3,0)
    │       │       │                                                       │
    │       │       │                                                       └── S → knight(3,1,1)
    │       │       │                                                           │
    │       │       │                                                           ├── P (3,1)
    │       │       │                                                           │   └── knight(3,2,0)
    │       │       │                                                           │       ├── PRINT
    │       │       │                                                           │       └── R → knight(3,1,1)
    │       │       │                                                           │
    │       │       │                                                           ├── U (3,1)
    │       │       │                                                           │
    │       │       │                                                           └── S → knight(3,2,1)
    │       │       │                                                               │
    │       │       │                                                               ├── P (3,2)
    │       │       │                                                               │   └── knight(3,3,0)
    │       │       │                                                               │       ├── PRINT
    │       │       │                                                               │       └── R → knight(3,2,1)
    │       │       │                                                               │
    │       │       │                                                               ├── U (3,2)
    │       │       │                                                               │
    │       │       │                                                               └── S → knight(3,3,1)
    │       │       │                                                                   │
    │       │       │                                                                   ├── P (3,3)
    │       │       │                                                                   │   └── knight(3,4,0)
    │       │       │                                                                   │       ├── PRINT
    │       │       │                                                                   │       └── R → knight(3,3,1)
    │       │       │                                                                   │
    │       │       │                                                                   ├── U (3,3)
    │       │       │                                                                   │
    │       │       │                                                                   └── S → knight(3,4,1)
    │       │       │                                                                       ├── END OF LAST ROW
    │       │       │                                                                       └── R → knight(3,3,1)
    │       │       │
    │       │       │   [All these returns unwind through their callers]
    │       │       │
    │       │       ├── U (0,2)
    │       │       └── S → knight(0,3,2)
    │       │           └── Explore its complete subtree
    │       │
    │       ├── U (0,1)
    │       └── S → knight(0,2,3)
    │           └── Explore its complete subtree
    │
    ├── U (0,0)
    └── S → knight(0,1,4)
        └── Explore its complete subtree
```
