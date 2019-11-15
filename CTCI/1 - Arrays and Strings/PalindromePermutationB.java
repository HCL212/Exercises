/* Palindrome Permutation: Given a string, write a function to check if it is a permutation of
 * a palindrome.  A palindrome is a word that is the same forwards and backwards.  A permutuation
 * is a rearrangement of letters.  The palindrome does not need to be limited to just dictionary words.
 *
 * EXAMPLE:
 * Input: Tact Coa
 * Output: True (permutations: "taco cat", "atco cta", etc.)
 *
 * Current solution time complexity = O(n)
 */

import java.util.*; 
  
class exercise { 
    
    boolean PalindromePermutation (String str) {
        // change string to lowercase and remove spaces
        String modString = str;
        modString = modString.toLowerCase();
        modString = modString.replaceAll("\\s","");

        // create HashMap to store characters and increment
        // the count each time you find one in the string
        // HashMap <Key,Value> name
        HashMap <Character,Integer> map = new HashMap<>();
        for (int i = 0; i < modString.length(); i++) {
            // getOrDefault returns a default value whenever the 
            // value was not found using the key specified on the HashMap
            // increment by 1 in the map for the character
            map.put(modString.charAt(i), map.getOrDefault(modString.charAt(i), 0) + 1);
        }

        int oddCount = 0;

        // loop through the HashMap keyset
        // if odd, add to oddCount
        for (char key : map.keySet()) {
            oddCount += map.get(key) % 2;
        }
        
        return oddCount <= 1;
    } 
  
    public static void main(String args[]) { 
        exercise test = new exercise();
        System.out.println(test.PalindromePermutation("Tact Coa"));
        System.out.println(test.PalindromePermutation("no U canNot do Eet"));
        System.out.println(test.PalindromePermutation("yy9yyyp6v66qq wwqqqq6qq99 999rr55rrw vyppp"));
    }
} 
