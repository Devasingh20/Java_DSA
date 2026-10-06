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