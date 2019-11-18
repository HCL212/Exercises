/* Given a string s that consists of only uppercase English letters, 
 * you can perform at most k operations on that string.
 * 
 * In one operation, you can choose any character of the string and 
 * change it to any other uppercase English character.
 * 
 * Find the length of the longest sub-string containing all repeating 
 * letters you can get after performing the above operations.
 *
 * EXAMPLE:
 * Input: s = "ABAB", k = 2
 * Output: 4
 * 
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 *
 * EXAMPLE:
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * 
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA". 
 * The substring "BBBB" has the longest repeating letters, which is 4.
 */

import java.util.*; 

// SLIDING WINDOW
// We are only interested in the longest valid substring so our window never shrinks.
// Even if the window is 'currently' covering an invalid substring.
// Grow window = increase on the right side (append a char to it).
// Shifting window = move entire window right by one index.
//
// We only grow the window when the 'count' of the new character appended is greater than a previous max.
// We do not care about accurate max count of current window, only if max count exceeds the previous max.
// 
// Time complexity : O(n). We make one loop over the string, and accessing the array is constant
// Space complexity : 
class Solution {
    public int characterReplacement(String s, int k) {
        int[] countChars = new int[128];
        int max = 0;
        int start = 0;

        // 'end' pointer is used to loop through the string and grow the window
        for (int end = 0; end < s.length(); end++) {
            // max is either the previous max or a character count that is greater than that
            // ++countChars increments the count in the array first before we compare with Math.max
            max = Math.max(max, ++countChars[s.charAt(end)]);

            // max + k cannot be less than or equal to the current window otherwise it would be invalid
            // since max+k represents the greatest # of chars we counted + # of changes we're allowed to make
            // therefore we slide the window to the right in this case
            if (max + k <= end - start){
                // slide window to the right, decrement the character count in the array
                // and increment start index to move window right
                // start++ increments start AFTER the counter is decreased
                countChars[s.charAt(start++)]--;
            }
        }
        // this gives the current window (which is also the largest since we never shrink the window)
        return s.length() - start;
    }
}
