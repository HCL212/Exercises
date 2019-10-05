/* Palindrome Permutation: Given a string, write a function to check if it is a permutation of
 * a palindrome.  A palindrome is a word that is the same forwards and backwards.  A permutuation
 * is a rearrangement of letters.  The palindrome does not need to be limited to just dictionary words.
 *
 * EXAMPLE:
 * Input: Tact Coa
 * Output: True (permutations: "taco cat", "atco cta", etc.)
 *
 * Current solution time complexity = O(128*n)
 */

import java.util.*; 
  
class exercise { 
    
    boolean PalindromePermutation (String str) { 
        int oddCount = 0;
        
        // mod the string to be lower case and remove spaces
        String modString = str;
        modString = modString.toLowerCase();
        modString = modString.replaceAll("\\s","");

        // loop through ASCII alphabet, and check character count
        // inside the string with another loop, if odd add to oddCount
        for (char i = 0; i < 128 && oddCount <= 1; i++) {
            int charCount = 0;
            for (int j = 0; j < modString.length(); j++) {
                if (modString.charAt(j) == i)
                    charCount++;
            }
            if (charCount++ % 2 != 0)
                oddCount++;
        }

        // oddCount can only be <= 1, if more, it cannot be palindrome
        return oddCount <= 1;
    } 
  
    public static void main(String args[]) { 
        exercise test = new exercise();
        System.out.println(test.PalindromePermutation("Tact Coa"));
    }
} 
