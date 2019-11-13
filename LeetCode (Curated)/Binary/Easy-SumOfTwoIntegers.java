/* Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -. 
 *
 * EXAMPLE:
 * Input: a = 1, b = 2
 * Output: 3
 *
 * Input: a = -2, b = 3
 * Output: 1
 */

import java.util.*; 

// Explanation
// 3 + 2 = 5
// the carry will be in ()
// 3 => 011
// 2 => 010
//   1(1)01
// Here we will forward the carry at the second bit to get the result.
//
// Which bitwise operator can do this? A simple observation says that XOR can do that,
// but it just falls short in dealing with the carry properly, 
// but correctly adds when there is no need to deal with carry.
// XOR example (without a need for carry):
// 1   => 001 
// 2   => 010 
// 1^2 => 011 (2+1=3)
//
// XOR example (with a need for carry/doesn't work)
// 3   => 011 
// 2   => 010 
// 3^2 => 001 (incorrect answer)  
//
// Here we can see XOR just fell short with the carry generated at the second bit.
// So how can we find the carry? The carry is generated when both the bits are set, 
// i.e (1,1) will generate carry but (0,1 or 1,0 or 0,0) won't generate a carry, 
// so which bitwise operator can do that ? AND gate of course.
// AND example (to find the carry)
// 3   => 011 
// 2   => 010 
// 3&2 => 010
//
// Now we need to add the carry to the previous value we generated i.e ( 3 ^ 2), 
// but the carry should be added to the left bit of the one which genereated it.
// So we left shift it by one so that it gets added at the right spot.
//
// Hence (3&2)<<1 => 100
// so we can now do
// 3 ^ 2    =>  001 
// (3&2)<<1 =>  100 
//
// Now XOR them, which will give 101 => 5, we can continue this until the carry becomes zero.
class Solution {
    public int getSum(int a, int b) {
        int carry;
        
        while(b != 0) {
            carry = a & b;
            a = a ^ b;
            b = (carry)<<1;
        }
        return a;
    }
}
