/* Is Unique: Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 *
 * Current solution time complexity = O(n^2)
 */

import java.util.*; 
  
class exercise { 
    
    boolean isUnique(String str) 
    { 
        // loop through string, and check str.charAt(i) against future characters
        // in the string
        for (int i = 0; i < str.length(); i++) 
            for (int j = i + 1; j < str.length(); j++) 
                if (str.charAt(i) == str.charAt(j)) 
                    return false; 
  
        // If no duplicate characters encountered, 
        // return true 
        return true; 
    } 
  
    public static void main(String args[]) 
    { 
        exercise test = new exercise();

        if (args.length > 0) {            
            for (String s : args) {
                if (test.isUnique(s)) {
                    System.out.println(s + " is unique"); 
                }
                else
                    System.out.println(s + " is not unique");
            }
        }
        else
            System.out.println("No arguments");
    } 
} 
