public class LC137 {
    public static void main(String[] args) {
        int[] nums = { -2, -2, 1, 1, 4, 1, 4, 4, -4, -2 };
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                if ((num & (1 << i)) >>> i == 1) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                ans = ans | (1 << i);
            }
        }
        System.out.println(ans);
    }
}

// Let's dry-run the algorithm for the array:

// nums = [2, 2, 3, 2]

// The unique number is 3.

// Step 1: Binary Representation

// Using 4 bits:

// 2 = 0010
// 2 = 0010
// 3 = 0011
// 2 = 0010

// We will check each bit position from 0 to 3.

// Bit Position 0 (i = 0)

// Extract the 0th bit using:

// (num >> 0) & 1
// Number Binary Bit 0
// 2 0010 0
// 2 0010 0
// 3 0011 1
// 2 0010 0

// Count:

// count = 1

// Now

// count % 3

// 1 % 3 = 1

// So set bit 0.

// ans

// 0000

// |

// 0001

// =

// 0001

// Current answer:

// 0001
// Bit Position 1 (i = 1)

// Extract:

// (num >> 1) & 1
// Number Binary Bit 1
// 2 0010 1
// 2 0010 1
// 3 0011 1
// 2 0010 1

// Count:

// 4

// Now

// 4 % 3 = 1

// So set bit 1.

// 0001
// 0010
// ----
// 0011

// Current answer:

// 0011
// Bit Position 2 (i = 2)

// Extract:

// (num >> 2) & 1
// Number Binary Bit 2
// 2 0010 0
// 2 0010 0
// 3 0011 0
// 2 0010 0

// Count:

// 0
// 0 % 3 = 0

// Do not set the bit.

// Current answer:

// 0011
// Bit Position 3 (i = 3)

// Every number has

// 0

// Count:

// 0

// Nothing changes.

// Final Answer

// Binary:

// 0011

// Decimal:

// 3
// Complete Table
// Bit Position Count of 1s count % 3 Set in Answer? Answer
// 0 1 1 ✅ Yes 0001
// 1 4 1 ✅ Yes 0011
// 2 0 0 ❌ No 0011
// 3 0 0 ❌ No 0011
// Why did count = 4 at bit position 1?

// At bit position 1:

// 2 = 0010 → 1
// 2 = 0010 → 1
// 3 = 0011 → 1
// 2 = 0010 → 1

// So:

// 1 + 1 + 1 + 1 = 4

// The three 2s contribute:

// 3 ones

// which disappear after:

// 3 % 3 = 0

// The extra 1 comes from the unique number 3:

// 4 % 3 = 1

// That remaining 1 tells us the unique number has a 1 in that bit position.
// This is exactly why the % 3 technique works.