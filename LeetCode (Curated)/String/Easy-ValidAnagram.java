/* Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * EXAMPLE:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Follow up
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */

import java.util.*; 
  
// SORTING APPROACH
// put strings into character arrays
// sort using Arrays.sort method
// return boolean with Arrays.equals method
//
// Time complexity : O(n log n). Assume that n is the length of s, sorting costs O(n log n)
// and comparing two strings costs O(n). Sorting time dominates and the overall time 
// complexity is O(n log n).
//
// Space complexity : O(1). Space depends on the sorting implementation which, usually, 
// costs O(1) auxiliary space if heapsort is used. Note that in Java, toCharArray() makes 
// a copy of the string so it costs O(n) extra space, but we ignore this for complexity analysis because:
// It is a language dependent detail.
// It depends on how the function is designed. For example, the function parameter types can be changed to char[].
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        char[] string1 = s.toCharArray();
        char[] string2 = t.toCharArray();
        Arrays.sort(string1);
        Arrays.sort(string2);

        // String sorted1 = new String(string1);
        // String sorted2 = new String(string2);
        // if (!sorted1.equals(sorted2))
        //     return false;
        // return true;
        
        return Arrays.equals(string1,string2);
    }
}

// ARRAY APPROACH
// create an array that represents the alphabets 26 letters
// loop through the first string and increment the index (that matches the letter)
// IE: 'b' - 'a' = 1 (since index starts at 0, we want 'b' to be at index 1)
//
// loop through second string and decrement the index (that matches the letter)
// if we go below value 0 on any index, then it is not an anagram
//
// WE CAN ALSO INCREMENT AND DECREMENT IN SAME LOOP, THEN CHECK IF ANY OF THE COUNTER INDEXES
// IS NOT EQUAL TO ZERO TO RETURN FALSE (SEE HASH SOLUTION)
//
// Time complexity : O(n). Accessing the counter table is a constant time operation.
// Space complexity : O(1). Although we do use extra space, space complexity is O(1) 
// because the table's size stays constant no matter how large n is.
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++){
            table[s.charAt(i) - 'a']++;
        }

        // int[] counter = new int[26];
        // for (int i = 0; i < s.length(); i++) {
        //     counter[s.charAt(i) - 'a']++;
        //     counter[t.charAt(i) - 'a']--;
        // }
        // 
        // for (int count : counter) {
        //     if (count != 0)
        //           return false;
        // }

        for (int i = 0; i < t.length(); i++){
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) return false;
        }
        
        return true;
    }
}

// HASH TABLE (if it's unicode and not just a-z)
// same as above, but with a hash table
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)-1);
        }
        
        for (char x : map.keySet()){
            if (map.get(x) != 0) return false;
        }
        
        return true;
    }
}
