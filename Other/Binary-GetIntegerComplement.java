/* Get Integer Complement. Given an int N, find the complement of the number
 *
 * EXAMPLE:
 * Input: 50
 * Output: 13
 * Explanation: 50 => 110010
 *              13 => 001101
 */

import java.util.*; 

// use Integer.toBinaryString() to convert int to a binary string
// replace chars in the binary string in these steps
// 0 --> 2 (change to 2 first so we can do next step safely)
// 1 --> 0
// 2 --> 1
// use Integer.parseInt() with radix 2, to convert binary back to a int
public static int getIntegerComplement(int n) {
    String b = Integer.toBinaryString(n);
    b = b.replace('0', '2').replace('1', '0').replace('2', '1');
    int ans = Integer.parseInt(b, 2);

    return ans;
    }
} 



