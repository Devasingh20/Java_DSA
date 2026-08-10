//this solution is for the problem of dividing two integers without using multiplication, division and mod operator. The idea is to use bit manipulation to find the quotient. We keep subtracting the largest multiple of the divisor from the dividend until the dividend becomes less than the divisor. The largest multiple of the divisor can be found by left shifting the divisor until it becomes greater than the dividend. We keep track of how many times we can left shift the divisor and add that to the quotient. Finally, we print the quotient.
//this is valid for only when both dividend and divisor are positive integers. If either of them is negative, we need to handle the sign separately.
//Time complexity is O(log(dividend)) and space complexity is O(1)
//for example, if dividend = 576 and divisor = 13, we can left shift the divisor until it becomes greater than the dividend. The largest multiple of the divisor that is less than or equal to the dividend is 13 << 5 = 416. We subtract 416 from 576 and get 160. We can left shift the divisor again until it becomes greater than 160. The largest multiple of the divisor that is less than or equal to 160 is 13 << 3 = 104. We subtract 104 from 160 and get 56. We can left shift the divisor again until it becomes greater than 56. The largest multiple of the divisor that is less than or equal to 56 is 13 << 2 = 52. We subtract 52 from 56 and get 4. Now, the dividend is less than the divisor, so we stop and print the quotient which is (1 << 5) + (1 << 3) + (1 << 2) = 32 + 8 + 4 = 44.
//here temp is used for store the largest shifted divisor.
//largest shifted divisor means the largest multiple of the divisor that is less than or equal to the dividend. 
//quotient means how many times the divisor can be subtracted from the dividend.
// public class LC29 {
//     public static void main(String[] args) {
//         int dividend = 576;
//         int divisor = 13;
//         int quotient = 0;
//         while (dividend >= divisor) {
//             int temp = divisor;
//             int shift = 0;
//             while (temp <= dividend) {
//                 temp = temp << 1;
//                 shift++;
//             }
//             temp >>= 1;
//             shift--;
//             quotient = quotient + (1 << shift);
//             dividend = dividend - temp; // Subtract the largest multiple of divisor from dividend or we can use dividend
//                                         // = dividend - (divisor << shift);
//         }
//         System.out.println(quotient);
//     }
// }

//the below code is for the case when either dividend or divisor is negative. We need to handle the sign separately. We can use the same logic as above but we need to take the absolute value of both dividend and divisor. We also need to check if the result should be negative or not. If either of them is negative, the result should be negative. We can use the XOR operator to check if both are negative or not. If both are negative, the result should be positive. If one of them is negative, the result should be negative.
//Time complexity is O(log(dividend)) and space complexity is O(1)
//for example, if dividend = -576 and divisor = 13, we can take the absolute value of both and use the same logic as above. The largest multiple of the divisor that is less than or equal to the dividend is 13 << 5 = 416. We subtract 416 from 576 and get 160. We can left shift the divisor again until it becomes greater than 160. The largest multiple of the divisor that is less than or equal to 160 is 13 << 3 = 104. We subtract 104 from 160 and get 56. We can left shift the divisor again until it becomes greater than 56. The largest multiple of the divisor that is less than or equal to 56 is 13 << 2 = 52. We subtract 52 from 56 and get 4. Now, the dividend is less than the divisor, so we stop and print the quotient which is (1 << 5) + (1 << 3) + (1 << 2) = 32 + 8 + 4 = 44. Since one of them is negative, we print -44.
//it successfully handles the case when dividend is Integer.MIN_VALUE and divisor is -1. In this case, the result should be Integer.MAX_VALUE because the result of dividing Integer.MIN_VALUE by -1 is greater than Integer.MAX_VALUE. We can check for this case separately and return Integer.MAX_VALUE.
public class LC29 {
    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = -1;
        int quotient = 0;
        boolean negative = (dividend < 0) ^ (divisor < 0); // Check if the result should be negative
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            System.out.println(Integer.MAX_VALUE);
            return;
        }
        while (a >= b) {
            long temp = b;
            int shift = 0;
            while (temp <= a) {
                temp = temp << 1;
                shift++;
            }
            temp >>= 1;
            shift--;
            quotient = quotient + (1 << shift);
            a = a - temp; // Subtract the largest multiple of divisor from dividend or we can use dividend
                          // = dividend - (divisor << shift);
        }
        if (negative) {
            System.out.println(-quotient);
        } else {
            System.out.println(quotient);
        }
    }
}
