# 🍌 Koko Eating Bananas — Binary Search on Answer Space

##  Intuition

Koko has several piles of bananas and can eat at a fixed speed of `k` bananas per hour.

We need to find the **minimum eating speed** at which Koko can finish all the bananas within `h` hours.

The important observation is that we are **not searching for an element inside an array**.

Instead, we are searching for the **minimum possible answer** — the eating speed.



This is called:

> [!IMPORTANT]
> **Binary Search on Answer Space**

---

##  Search Space

Suppose:

```text
piles = [3, 6, 7, 11]
h = 8
```

The minimum possible speed is:

```text
1
```

The maximum possible speed is:

```text
max(piles) = 11
```

Therefore:

```text
Search Space = [1, 11]
```

Why can't the answer be greater than `max(piles)`?

Because if Koko eats at:

```text
k = max(piles)
```

then she can finish every pile in at most one hour per pile.

Eating faster than the largest pile cannot reduce the time for any pile below one hour.

Therefore:

```text
low = 1
high = max(piles)
```

---

# 🔄 Why Can We Use Binary Search?

For every possible eating speed, we can determine whether Koko can finish within `h` hours.

Suppose:

```text
speed = 3
```

If Koko can finish all bananas at speed `3`, then she can definitely finish them at:

```text
4, 5, 6, 7, ...
```

because increasing the eating speed can only reduce or maintain the required time.

Similarly, if speed `3` is too slow, smaller speeds will also be too slow.

Therefore, the answers have a monotonic pattern:

```text
Speed:
1   2   3   4   5   6   7   8   ...

Too Slow
                    ↑
              Minimum Valid Speed
```

This monotonic property is what allows Binary Search to work.

> [!IMPORTANT]
> If a particular speed is sufficient, every larger speed is also sufficient.

---

# ⚙️ How Do We Calculate the Required Hours?

Suppose:

```text
pile = 7
speed = 3
```

Koko eats:

```text
Hour 1 → 3 bananas
Hour 2 → 3 bananas
Hour 3 → 1 banana
```

Therefore:

```text
hours = 3
```

Mathematically:

```text
ceil(7 / 3) = 3
```

For every pile:

```text
hours required = ceil(pile / speed)
```

Therefore, total hours are:

```text
totalHours =
ceil(piles[0] / speed)
+ ceil(piles[1] / speed)
+ ...
+ ceil(piles[n-1] / speed)
```

---

#  Ceiling Division

Because `pile` and `speed` are positive integers:

```text
ceil(pile / speed)
```

can be calculated using:

```text
(pile + speed - 1) / speed
```

For example:

```text
pile = 7
speed = 3
```

Then:

```text
(7 + 3 - 1) / 3
= 9 / 3
= 3
```

Another example:

```text
pile = 8
speed = 3
```

```text
(8 + 3 - 1) / 3
= 10 / 3
= 3
```

Java integer division gives:

```text
10 / 3 = 3
```

which is exactly:

```text
ceil(8 / 3) = 3
```

---

# 🔁 Binary Search Logic

For every middle speed:

```text
mid = low + (high - low) / 2
```

we calculate the total number of hours required.

There are two cases.

## Case 1: `steps <= h`

Koko can finish all bananas within the required time.

Therefore, `mid` is a **valid speed**.

But we need the **minimum valid speed**.

So we try a smaller speed:

```text
high = mid - 1
```

If using the `ans` approach:

```text
ans = mid
high = mid - 1
```

---

## Case 2: `steps > h`

Koko needs more hours than allowed.

Therefore, `mid` is too slow.

We need a larger speed:

```text
low = mid + 1
```

---

#  Complete Binary Search Pattern

```text
low = 1
high = max(piles)

while (low <= high) {

    mid = low + (high - low) / 2

    calculate total hours at speed mid

    if (total hours <= h) {
        mid is valid
        save mid
        search left
    }
    else {
        mid is too slow
        search right
    }
}
```

---

#  Example

Consider:

```text
piles = [3, 6, 7, 11]
h = 8
```

Search space:

```text
[1, 11]
```

Try:

```text
mid = 6
```

Hours:

```text
ceil(3 / 6)  = 1
ceil(6 / 6)  = 1
ceil(7 / 6)  = 2
ceil(11 / 6) = 2
```

Total:

```text
1 + 1 + 2 + 2 = 6
```

Since:

```text
6 <= 8
```

speed `6` is valid.

But we want the minimum speed.

So search the left side:

```text
[1, 5]
```

---

Try:

```text
mid = 3
```

Hours:

```text
ceil(3 / 3)  = 1
ceil(6 / 3)  = 2
ceil(7 / 3)  = 3
ceil(11 / 3) = 4
```

Total:

```text
1 + 2 + 3 + 4 = 10
```

Since:

```text
10 > 8
```

speed `3` is too slow.

So search the right side:

```text
[4, 5]
```

---

Try:

```text
mid = 4
```

Hours:

```text
ceil(3 / 4)  = 1
ceil(6 / 4)  = 2
ceil(7 / 4)  = 2
ceil(11 / 4) = 3
```

Total:

```text
1 + 2 + 2 + 3 = 8
```

Since:

```text
8 <= 8
```

speed `4` is valid.

Now search for an even smaller valid speed.

Eventually:

```text
answer = 4
```

---

#  Visual Representation

```text
Speed:

1    2    3    4    5    6    7    8    9    10    11

               ↑
       Minimum Valid Speed
```

So:

```text
Answer = 4
```

---

#  Why Is This Called Binary Search on Answer?

In normal Binary Search, we search for a value inside a sorted array.

For example:

```text
arr = [1, 3, 5, 7, 9]
```

We search for:

```text
target = 7
```

Here, we are not searching the array for the answer.

Instead, we create a possible range of answers:

```text
[1, max(piles)]
```

Each number in this range represents a possible eating speed.

For each possible answer, we ask:

```text
"Can Koko finish all bananas within h hours at this speed?"
```

Therefore:

```text
Possible Answer
       ↓
Check whether it is valid
       ↓
Too slow → go right
Valid    → try left
```

This is **Binary Search on Answer Space**.

---

# ⚠️ Important: Use `long` for Total Hours

The total number of hours can become very large.

Therefore, it is safer to use:

```java
long hours = 0;
```

instead of:

```java
int hours = 0;
```

For example:

```java
hours += (pile + mid - 1) / mid;
```

If the input constraints are large, the total can exceed the range of `int`.

A safer implementation is:

```java
long hours = 0;

for (int pile : piles) {
    hours += (pile + mid - 1L) / mid;
}
```

The `1L` ensures the calculation is performed using `long`.

---

# 💻 Java Implementation

```java
class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = 0;

        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long hours = 0;

            for (int pile : piles) {
                hours += (pile + (long) mid - 1) / mid;
            }

            if (hours <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
```

---

#  Key Logic to Remember

```text
If hours <= h
        ↓
Speed is sufficient
        ↓
Try smaller speed
        ↓
high = mid - 1
```

```text
If hours > h
        ↓
Speed is too slow
        ↓
Need larger speed
        ↓
low = mid + 1
```

The entire problem can be remembered as:

```text
Find minimum speed
        ↓
Create answer space [1, max(pile)]
        ↓
Choose mid speed
        ↓
Calculate required hours
        ↓
hours <= h ?
   /          \
 YES           NO
  ↓             ↓
Valid          Too slow
  ↓             ↓
Go left       Go right
```

> [!TIP]
> ### 🧠 Remember
>
> **Koko Eating Bananas = Minimum Valid Speed**
>
> Search space:
>
> `1 → max(piles)`
>
> Condition:
>
> `requiredHours <= h`
>
> Valid → search left  
> Invalid → search right

---

#  Complexity

Let:

- `n` = number of piles
- `M` = maximum pile size

The binary search searches speeds from:

```text
1 to M
```

Therefore, the number of binary-search iterations is:

```text
O(log M)
```

For every speed, we scan all `n` piles to calculate the required hours:

```text
O(n)
```

Therefore:

```text
Time Complexity = O(n log M)
```

The algorithm uses only a few variables apart from the input array:

```text
Space Complexity = O(1)
```

So the final complexity is:

```text
Time:  O(n log M)
Space: O(1)
```

---

#  Common Mistakes

1. Starting `low` from `0`.

```text
❌ low = 0
✅ low = 1
```

Speed cannot be `0`.

2. Using:

```text
pile / mid
```

instead of ceiling division.

Use:

```text
(pile + mid - 1) / mid
```

or the safer Java form:

```java
(pile + (long) mid - 1) / mid
```

3. Forgetting that we need the **minimum valid speed**.

If the current speed works, we must continue searching toward smaller speeds.

4. Using the wrong direction:

```text
hours <= h → search LEFT
hours > h  → search RIGHT
```

5. Using `int` for total hours when the constraints can make the sum very large.

Use:

```java
long hours
```

---

# Final Mental Model

```text
Question:
What is the minimum eating speed?

        ↓

Answer lies between:

1 ---------------- max(piles)

        ↓

Binary Search

        ↓

For speed = mid:

Calculate total hours

        ↓

Is totalHours <= h?

       / \
     YES  NO
      ↓    ↓
    LEFT  RIGHT
```

> [!IMPORTANT]
> The most important idea is **not the binary search code itself**. The key is recognizing that the answer space is **monotonic**:
>
> **Too slow → Too slow → ... → Valid → Valid → ...**
>
> Once you identify this pattern, Binary Search on Answer becomes possible.

# Koko Eating Bananas — LeetCode 875

The most important idea is:

> Instead of trying every possible eating speed one by one, use binary search to find the smallest speed that allows Koko to finish within the given time.

## 1. What is the question?

Koko has several piles of bananas. The array `arr` represents the number of bananas in each pile, and `h` is the number of hours available.

Koko chooses an eating speed `k` bananas per hour.

- Each hour, Koko chooses one pile and eats up to `k` bananas from it.
- If the pile has fewer than `k` bananas remaining, she eats the whole pile and does not eat another pile during that hour.
- Find the minimum integer speed `k` that allows her to finish all piles within `h` hours.

### Example

```java
int[] arr = {3, 6, 7, 11};
int h = 8;
```

The answer is:

```text
4
```

At speed `4`, the time needed is:

| Pile | Calculation | Hours |
|---:|---|---:|
| 3 | `ceil(3 / 4)` | 1 |
| 6 | `ceil(6 / 4)` | 2 |
| 7 | `ceil(7 / 4)` | 2 |
| 11 | `ceil(11 / 4)` | 3 |
| **Total** | | **8** |

Speed `4` is sufficient, and no smaller speed can finish all the piles within 8 hours.

## 2. Why use Binary Search?

Suppose we try different speeds.

- At speed `1`, Koko eats very slowly.
- At speed `4`, she may finish within the available time.
- At speed `8`, she finishes faster.
- At speed `11`, she can finish every pile in at most one hour per pile.

Notice this important property:

- If a speed is too slow, every smaller speed will also be too slow.
- If a speed is fast enough, every larger speed will also be fast enough.

This monotonic property allows us to use binary search.

The search space:

```text
Speed too slow
       ↓
Find the smallest feasible speed
       ↓
Faster speeds are also feasible
```

Instead of checking all speeds from `1` to `max`, binary search repeatedly halves the search range.

## 3. Why can't the answer be greater than `max(piles)`?

This is one of the most important concepts in the problem.

Your code finds the maximum pile size:

```java
int max = arr[0];

for (int i = 0; i < arr.length; i++) {
    if (arr[i] > max) {
        max = arr[i];
    }
}
```

For example:

```text
arr = [3, 6, 7, 11]

max = 11
```

Therefore, the binary search range is:

```java
int start = 1;
int end = max;
```

So the search range is:

```text
[1, 11]
```

### Why is `max` sufficient as the upper bound?

Suppose Koko eats at a speed of `11` bananas per hour.

```text
Pile 1: 3 bananas  → 1 hour
Pile 2: 6 bananas  → 1 hour
Pile 3: 7 bananas  → 1 hour
Pile 4: 11 bananas → 1 hour
```

Every pile takes at most one hour because no pile contains more than 11 bananas.

Thus, Koko can finish all four piles in 4 hours. If the available time is at least the number of piles, speed `11` is sufficient.

Why not speed `12` or `100`?

Because eating faster than the largest pile cannot reduce the time needed for any pile below one hour. Koko cannot use the saved time to eat another pile during the same hour.

Therefore, any speed greater than `max` is unnecessary. The minimum feasible speed must be in this range:

$$
{1 \le k \le \max(\text{piles})}
$$

**Note:** This upper bound assumes the problem's guarantee that `h >= arr.length`. If `h` were smaller than the number of nonempty piles, no speed could finish the task under these rules.

## 4. How do we calculate the hours needed?

Your code uses:

```java
steps += (arr[i] + mid - 1) / mid;
```

This calculates the number of hours required for one pile at speed `mid`.

The mathematical formula is:

$$
\text{hours for a pile}
=
\left\lceil
\frac{\text{pile size}}{\text{speed}}
\right\rceil
$$

We use the ceiling because even a partially filled final hour counts as a complete hour.

### Example

Suppose:

```text
Pile size = 10
Speed     = 4
```

Koko eats:

```text
Hour 1 → 4 bananas
Hour 2 → 4 bananas
Hour 3 → 2 bananas
```

Total:

```text
ceil(10 / 4) = 3 hours
```

In Java, integer division truncates the decimal part. The expression

```java
(arr[i] + mid - 1) / mid
```

implements ceiling division for positive integers.

For example:

```text
(10 + 4 - 1) / 4
= 13 / 4
= 3
```

Then we add the hours for every pile:

```java
long steps = 0;

for (int i = 0; i < arr.length; i++) {
    steps += (arr[i] + mid - 1) / mid;
}
```

Here, `steps` represents the total hours required at the current speed.

Using `long` helps prevent overflow when adding up the hours for large inputs.

## 5. Complete binary search logic

Let's understand your main loop.

```java
int start = 1;
int end = max;
int ans = max;

while (start <= end) {
    int mid = start + (end - start) / 2;

    long steps = 0;

    for (int i = 0; i < arr.length; i++) {
        steps += (arr[i] + mid - 1) / mid;
    }

    if (steps <= h) {
        ans = mid;
        end = mid - 1;
    } else {
        start = mid + 1;
    }
}
```

### Case 1: `steps <= h`

```java
if (steps <= h) {
    ans = mid;
    end = mid - 1;
}
```

The current speed is sufficient.

But the question asks for the minimum sufficient speed, so we search for a smaller speed.

```text
Current speed is feasible
          ↓
Save it in ans
          ↓
Search the left half
          ↓
end = mid - 1
```

### Case 2: `steps > h`

```java
else {
    start = mid + 1;
}
```

The current speed is too slow.

We must increase the speed.

```text
Current speed is too slow
          ↓
Discard current speed and smaller speeds
          ↓
Search the right half
          ↓
start = mid + 1
```

This is binary search on the answer, because we're searching for the minimum valid speed rather than searching for an element in the input array.

## 6. Dry run using your exact input

Your input is:

```java
int[] arr = {
    805306368,
    805306368,
    805306368
};

int h = 1000000000;
```

The maximum pile size is:

```text
max = 805306368
```

The answer is `3`.

Why? At speed `3`, each pile requires:

$$
\left\lceil\frac{805306368}{3}\right\rceil
= 268435456
$$

Total hours:

```text
268435456 × 3 = 805306368
```

Since:

```text
805306368 <= 1000000000
```

speed `3` is feasible.

At speed `2`:

```text
ceil(805306368 / 2) = 402653184 hours per pile
```

Total:

```text
402653184 × 3 = 1207959552 hours
```

Since:

```text
1207959552 > 1000000000
```

speed `2` is too slow.

Therefore:

```text
Minimum feasible speed = 3
```

## 7. Why initialize `ans = max`?

```java
int ans = max;
```

This initializes the answer to a known feasible speed, provided `h >= arr.length`.

Since speed `max` finishes each pile in one hour or less, it gives us a valid upper-bound answer.

Whenever we find a smaller feasible speed, we update `ans`:

```java
ans = mid;
```

Then we keep searching for an even smaller feasible speed.

At the end:

```java
return ans;
```

returns the minimum feasible speed found.

## 8. Time and space complexity

Let:

- \(n\) = number of piles.
- \(M\) = maximum pile size.

| Complexity | Value | Reason |
|---|---|---|
| Time | \(O(n\log M)\) | Each binary-search iteration checks all `n` piles, and there are \(O(\log M)\) iterations. |
| Auxiliary space | \(O(1)\) | Only a fixed number of variables are used. |

One small improvement: for a more overflow-safe ceiling division, you can write:

```java
steps += (arr[i] - 1) / mid + 1;
```

This is equivalent for positive pile sizes and avoids the addition in `arr[i] + mid - 1`.

## Final notes to remember

1. Search space: `1` to `max(piles)`.
2. Why `max(piles)`? At that speed, every pile takes at most one hour.
3. Hours calculation: Sum the ceiling of each pile size divided by the speed.
4. If `steps <= h`: Speed is feasible; try a smaller speed.
5. If `steps > h`: Speed is too slow; try a larger speed.
6. Goal: Find the minimum feasible speed using binary search.


# Koko Eating Bananas — Understanding the Monotonic Property

Let's understand this using a simple example. The key is to see how eating speed affects the total hours required.

## 1. Suppose the piles are

```java
int[] piles = {3, 6, 7, 11};
int h = 8;
```

Koko has 8 hours to eat all the bananas.

Let's try different speeds.

| Speed (`k`) | Total hours required | Can finish within 8 hours? |
|---:|---:|---|
| 1 | 27 | ❌ No |
| 2 | 15 | ❌ No |
| 3 | 10 | ❌ No |
| 4 | 8 | ✅ Yes |
| 5 | 8 | ✅ Yes |
| 6 | 6 | ✅ Yes |
| 7 | 5 | ✅ Yes |
| 8 | 5 | ✅ Yes |
| 11 | 4 | ✅ Yes |

Notice the pattern:

```text
Speed:       1   2   3   4   5   6   7   8 ... 11
             |   |   |   |   |   |   |   |
Result:      ❌  ❌  ❌  ✅  ✅  ✅  ✅  ✅ ... ✅
```

All the speeds before `4` are too slow. Speed `4` and all speeds after it are sufficient.

## 2. What does “monotonic property” mean?

It means the results follow a consistent pattern rather than switching back and forth.

In this problem, the pattern is:

```text
Too slow → Too slow → Too slow → Fast enough → Fast enough → ...
```

### Rule 1: If a speed is too slow, smaller speeds are also too slow.

Suppose speed `3` requires 10 hours, but Koko has only 8 hours.

```text
Speed 3 → 10 hours ❌
```

If Koko reduces her speed to `2`, she eats more slowly, so she cannot finish in fewer hours.

Therefore, speed `2` and speed `1` must also fail.

### Rule 2: If a speed is fast enough, larger speeds are also fast enough.

Suppose speed `4` requires exactly 8 hours.

```text
Speed 4 → 8 hours ✅
```

If Koko increases her speed to `5`, she will not need more time than before.

Therefore, speed `5`, `6`, `7`, and so on will also be sufficient.

## 3. Why does this allow binary search?

We need the smallest speed that works.

From the example, the answer is `4`.

Instead of checking speeds `1, 2, 3, 4` one by one, binary search checks the middle speed first.

### Step 1: Initially

```java
start = 1;
end = 11;

mid = 1 + (11 - 1) / 2;
mid = 6;
```

At speed `6`, Koko finishes in 6 hours.

```text
6 hours <= 8 hours ✅
```

So speed `6` works. But perhaps a smaller speed works too!

We can discard `6` and all speeds above it, and search the left half:

```text
Possible speeds: 1  2  3  4  5
```

### Step 2: Search the left half

```java
start = 1;
end = 5;
mid = 3;
```

Speed `3` requires 10 hours, so it fails.

```text
10 hours > 8 hours ❌
```

Therefore, speeds `1`, `2`, and `3` all fail. We can discard them and search the right half:

```text
Possible speeds: 4  5
```

### Step 3: Find the minimum feasible speed

```java
start = 4;
end = 5;
mid = 4;
```

Speed `4` requires exactly 8 hours, so it works. We save `4` as the answer and search for anything smaller that might also work.

```java
ans = mid;
end = mid - 1;
```

Now `end = 3`, while `start = 4`. Since `start > end`, the loop stops.

There is no smaller candidate left, so the answer is `4`.

## 4. Remember this simple idea

### If the middle speed works

Save it, then search smaller speeds.

```java
ans = mid;
end = mid - 1;
```

### If the middle speed fails

Discard it and all smaller speeds, then search larger speeds.

```java
start = mid + 1;
```

**The main point:** Binary search works because once a speed fails, every smaller speed fails too; and once a speed succeeds, every larger speed succeeds too. That lets us discard half the possible answers at every step.

# Koko Eating Bananas — Interview Answer and Maximum Useful Speed

## 1. Interview Answer: Why Do We Use Binary Search?

If someone asks, **"Why do we use Binary Search in Koko Eating Bananas?"**, you can answer like this in an interview.

### Interview answer

We use **Binary Search on the Answer** because we need to find the minimum eating speed `k` that allows Koko to eat all the bananas within `h` hours.

The possible speeds range from `1` to `max(piles)`. These speeds have a monotonic property:

- If a speed is too slow, all smaller speeds will also be too slow.
- If a speed is sufficient, all larger speeds will also be sufficient.

Therefore, we can use binary search to eliminate half of the possible speeds in each iteration and find the minimum valid speed efficiently.

- **Brute-force time complexity:** \(O(n \times M)\)
- **Binary search time complexity:** \(O(n \log M)\)

Here, \(n\) is the number of piles and \(M\) is the maximum pile size.

### Short answer to remember

> We use binary search because the answer is a minimum feasible eating speed, and feasibility is monotonic. This allows us to search for the minimum valid speed in \(O(n\log M)\) time instead of checking every possible speed in \(O(nM)\) time.

---

## 2. Can We Say the Maximum Speed Equals the Largest Pile Size?

**Yes, exactly!** You can say:

> The maximum possible useful eating speed is equal to the size of the pile containing the most bananas, i.e., `max(piles)`.

For example:

```java
int[] piles = {3, 6, 7, 11};
```

The largest pile contains `11` bananas, so:

```java
int end = 11; // max(piles)
```

At a speed of `11` bananas per hour, Koko can finish each pile in at most one hour.

### Why not choose a higher speed?

If Koko eats at speed `12` or `100`, she still spends at least one hour on each non-empty pile. A speed higher than `max(piles)` cannot reduce the time required further, so it is unnecessary when searching for the minimum feasible speed.

Therefore, our binary search range is:

```java
int start = 1;
int end = max;
```

### Interview tip

Say **"maximum useful speed"** rather than simply **"maximum speed,"** because technically Koko could eat at a higher speed, but there is no benefit in doing so.
