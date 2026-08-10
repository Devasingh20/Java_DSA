public class LC190 {
    public static void main(String[] args) {
        int n = 43261596;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int bit = (n & (1 << i)) >>>i;
            System.out.print(bit);
            ans |= (bit << (31 - i));
           
        }
         System.out.println();
        System.out.println(ans);
    }
}


/*
===========================================================
LeetCode 190 - Reverse Bits
Example Input: n = 13
===========================================================

Binary representation of 13 (using 4 bits for understanding):

Decimal : 13
Binary  : 1101

Bit Positions

Position : 3   2   1   0
Bits     : 1   1   0   1

Our goal is to reverse the bits.

Original : 1101
Reversed : 1011

Binary 1011 = Decimal 11

-----------------------------------------------------------
Algorithm
-----------------------------------------------------------

1. Create an answer variable and initialize it to 0.

       ans = 0000

2. Traverse every bit from right to left.

3. Extract the ith bit.

       bit = (n & (1 << i)) >> i;

4. Move this bit to its reversed position.

       bit << (3 - i)

   (In LeetCode we use 31-i because int has 32 bits.
    Here we use 3-i because we are considering only 4 bits.)

5. Store it in the answer using OR.

       ans |= shiftedBit

-----------------------------------------------------------
Iteration 1 (i = 0)
-----------------------------------------------------------

Step 1 : Create Mask

1 << 0

0001

Step 2 : Perform AND

1101
0001
----
0001

Result = 0001

Step 3 : Shift back

0001 >> 0

0001

bit = 1

Step 4 : Move to reverse position

1 << (3-0)

1 << 3

1000

Step 5 : OR with answer

0000
1000
----
1000

Current Answer

1000

-----------------------------------------------------------
Iteration 2 (i = 1)
-----------------------------------------------------------

Mask

1 << 1

0010

AND

1101
0010
----
0000

Shift back

0000 >> 1

0000

bit = 0

Move to reverse position

0 << 2

0000

OR

1000
0000
----
1000

Current Answer

1000

-----------------------------------------------------------
Iteration 3 (i = 2)
-----------------------------------------------------------

Mask

1 << 2

0100

AND

1101
0100
----
0100

Notice:

Result is 0100 (decimal 4)

We don't want 4.

We only want to know whether the selected bit
is 0 or 1.

So we shift it back.

0100 >> 2

0001

bit = 1

Move to reverse position

1 << 1

0010

OR

1000
0010
----
1010

Current Answer

1010

-----------------------------------------------------------
Iteration 4 (i = 3)
-----------------------------------------------------------

Mask

1 << 3

1000

AND

1101
1000
----
1000

Shift back

1000 >> 3

0001

bit = 1

Move to reverse position

1 << 0

0001

OR

1010
0001
----
1011

Current Answer

1011

-----------------------------------------------------------
Final Answer
-----------------------------------------------------------

Binary

1011

Decimal

8 + 2 + 1 = 11

Therefore,

13 (1101)

↓

1011

↓

11

-----------------------------------------------------------
Why do we write

(n & (1 << i)) >> i ?

-----------------------------------------------------------

Suppose i = 2

Mask

1 << 2

0100

AND

1101
0100
----
0100

The result is 0100 (decimal 4).

We don't want the value 4.

We only want to know whether the selected bit
is present (1) or absent (0).

Therefore we shift it back.

0100 >> 2

↓

0001

Now the answer becomes either

0

or

1

which is exactly what we need.

-----------------------------------------------------------
Summary
-----------------------------------------------------------

(1 << i)
Creates a mask having only the ith bit set.

(n & (1 << i))
Keeps only the ith bit and makes all other bits 0.

>> i
Moves that bit back to the least significant position,
so the result becomes either 0 or 1.

bit << (31-i)
Moves the extracted bit to its reversed position.

ans |= shiftedBit
Stores that bit inside the final answer.

-----------------------------------------------------------
For LeetCode (32 bits)

for(int i=0;i<32;i++){

    int bit = (n & (1<<i)) >> i;

    ans |= (bit << (31-i));
}

This reverses all 32 bits of the integer.
===========================================================
*/