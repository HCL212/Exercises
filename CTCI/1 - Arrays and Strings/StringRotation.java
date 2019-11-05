/* String Rotation: Assume you have a method isSubstring which checks
 * if one word is a substring of another.  Given two strings, s1 and s2,
 * write code to check if s2 is a rotation of s1 using only one call to
 * isSubstring
 *
 * EXAMPLE:
 * "waterbottle" is a rotation of "erbottlewat"
 *
 * Current solution time complexity = O(n)
 */

import java.util.*; 
  
class exercise { 
   
    boolean isRotation(String s1, String s2){
        int len = s1.length();

        // check that s1 and s2 are same length and not empty
        if (len == s2.length() && len > 0){
            // concatenate s1 and s1 within new buffer
            // EXAMPLE:
            // waterbottlewaterbottle will contain erbottlewat
            String s1s1 = s1 + s1;
            return isSubstring (s1s1, s2);
        }
        return false;
    }

    boolean isSubstring(String one, String two){ 
        return one.contains(two);        
    }
  
    public static void main(String args[]) { 
        exercise test = new exercise();
        
        System.out.println(test.isRotation("waterbottle", "erbottlewat")); // true
        System.out.println(test.isRotation("abcdef", "bcdefa")); // true
        System.out.println(test.isRotation("hithere", "hitheer")); // false
        System.out.println(test.isRotation("hugh", "ghhu")); // true
        System.out.println(test.isRotation("applepie", "pieapple")); // true
        System.out.println(test.isRotation("applepie", "piepaple")); // false
    }
} 


