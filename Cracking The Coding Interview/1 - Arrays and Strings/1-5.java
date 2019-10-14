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
        // if string length difference is > 1, false
        int stringDiff = Math.abs(str1.length() - str2.length());
        if (stringDiff > 1)
            return false;

        // puts the longer string first to compare
        String string1 = str1.length() > str2.length() ? str1 : str2;
        String string2 = str1.length() > str2.length() ? str2 : str1;

        // count the number of differences between both
        // out of bounds check for i < string2.length()
        // increment numOfDiff if neither the curr char or
        // char + 1 of string 1 is equal to the char of
        // string 2
        int numOfDiff = 0;
        for (int i = 0; i < string1.length(); i++){
            if (i < string2.length()){
                if (string1.charAt(i) != string2.charAt(i)){
                    if (string1.charAt(i+1) != string2.charAt(i))
                        numOfDiff++;
                }
            }
        } 
        
        return numOfDiff <= 1;
    } 
  
    public static void main(String args[]) { 
        exercise test = new exercise();
        System.out.println(test.OneAway("pale", "ple")); // true
        System.out.println(test.OneAway("pales", "pale")); // true
        System.out.println(test.OneAway("pale", "bale")); // true
        System.out.println(test.OneAway("pale", "bake")); // false
        System.out.println(test.OneAway("pale", "palepale")); // false
        System.out.println(test.OneAway("palepale", "pale")); // false
        System.out.println(test.OneAway("pale", "pal")); // true
    }
} 


