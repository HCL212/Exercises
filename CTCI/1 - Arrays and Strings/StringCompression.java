/* String Compression: Implement a method to perform basic string compression
 * using the counts of repeated characters.  If the "compressed" string would
 * not be smaller than the original string, your method should return the
 * original string.  You can assume the string has only upper and lower case letters
 *
 * EXAMPLE:
 * Input: aabcccccaaa
 * Output: a2b1c5a3
 *
 * Current solution time complexity = O(p)
 * if we don't use stringbuilder and only string concatenation it would be O(p * k^2)
 * because string concatenation takes O(n^2) time
 */

import java.util.*; 
  
class exercise { 
    
    String stringCompress (String str){
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;

        // loop through the string, add to count each time
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            // if next character is different than current, append
            // this character to result and reset count
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }

        String x = compressed.toString();
        System.out.println(x);
        
        // return shorter of the two
        return compressed.length() < str.length() ? compressed.toString() : str;
    }
  
    public static void main(String args[]) { 
        exercise test = new exercise();
        
        System.out.println(test.stringCompress("aabcccccaaa")); // a2b1c5a3
        System.out.println(test.stringCompress("abcdef")); // abcdef
        System.out.println(test.stringCompress("ssaaalinnnaaa")); // s2a3l1i1n3a3
        System.out.println(test.stringCompress("huugh")); // huugh
    }
} 


