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