/* One Away: There are three types of edits that can be performed on strings:
 * insert a character, remove a character, or replace a character.
 * Given two strings, write a function to check if they are one edit (or zero edits) away.
 *
 * EXAMPLE:
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 *
 * Current solution time complexity = ???
 */

import java.util.*; 
  
class exercise { 
    
    boolean OneAway (String str1, String str2) {
        // compare two strings, length cannot be greater than 1
        // compare characters, if character diff is > 1, false
        
        return true;
    } 
  
    public static void main(String args[]) { 
        exercise test = new exercise();
        System.out.println(test.OneAway("pale", "ple"));
        System.out.println(test.OneAway("pales", "pale"));
        System.out.println(test.OneAway("pale", "bale"));
        System.out.println(test.OneAway("pale", "bake"));
    }
} 


