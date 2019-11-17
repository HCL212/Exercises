/* Given a string, find the length of the longest substring without repeating characters.
 *
 * EXAMPLE:
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3. 
 * 
 * EXAMPLE: Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * EXAMPLE: Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

import java.util.*; 
  
// SLIDING WINDOW USING HASH SET
// Use set to determine if the character already exists
// We have two pointers I and J, J moves along while I stays until
// we find a duplicate
// If set doesn't have element at index J, add element to the set, increment j
// determine max using Math.max and continue loop
//
// if set DOES contain element at index J, remove element from the set, increment i
// and continue loop
//
// EXAMPLE: "V D X D F"
// if currently, i = 0, j = 2, max would be 3, continue loop
// j is now = 3, but element j exists already in the set
// so increment i++, i = 1,
// element j still exists in the set, so increment i again, i = 2
// j doesn't exist in set anymore, so add j to the set, and determine max again
// etc.
//
// Time complexity : O(2n) = O(n). In the worst case each character will be visited twice by i and j.
// Space complexity : O(min(m, n)). We need O(k) space for the sliding window, where k is the size of the Set. 
// The size of the Set is upper bounded by the size of the string n and the size of the charset/alphabet m.
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> set = new HashSet<>();
        int max = 0, i = 0, j = 0;
        
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                // Note: set.add(s.charAt(j++)); (the j++ works because we add j 
                // first then increment since ++ comes AFTER 'j')
                set.add(s.charAt(j++));
                // "j - 1" helps figure out how long the substring is currently
                max = Math.max (max, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }
}

// SLIDING WINDOW OPTIMIZED
// same as above, but instead of increasing i little by little, we jump straight to the next
// index after the original duplicate by storing the index of elements + 1 into the map as a value
// EXAMPLE:        V D X D F
// string index  = 0 1 2 3 4
// HashMap Value = 1 2 3 4 5
//
// so when we need to move i quickly to the next element (when we find a duplicate), we just
// make i = the value of the key(element) that's already in the map
// ie: when we see 'D' as a duplicate, we can move i straight to index 2 'X' and skip the original 'D'
//
// Two pointers I and J, J moves while I stays in place until we find a duplicate
// If no duplicates found, determine max between (max, j-i+1), +1 due to j not being incremented yet
// If no duplicates found, put element j in map with value j+1, +1 due to j not being incremented yet
// and so that i can jump ahead to the next element after original duplicate
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for (int j = 0, i = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            max = Math.max(max, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        
        return max;
    }
}
