/* Interleave Two Strings: Given two strings, interleave them and output result
 *
 * EXAMPLE:
 * Input: abc, def
 * Output: adbecf
 *
 * Current solution time complexity = ???
 */

import java.util.*; 
  
class exercise { 
    
    String Interleave (String str1, String str2) {
        if (str1.isEmpty())
            return str2;
        if (str2.isEmpty())
            return str1;

        String merged = "";

        if (str1.length() >= str2.length()){
            for (int i = 0; i < str1.length(); i++){
                merged += str1.charAt(i);
                if (i < str2.length()){
                    merged+= str2.charAt(i);
                }
            }
        }

        if (str2.length() > str1.length()){
            for (int i = 0; i < str2.length(); i++){
                if (i < str1.length())
                    merged += str1.charAt(i);
                merged += str2.charAt(i);
            }
        }
        
        return merged;
    } 
  
    public static void main(String args[]) { 
        exercise test = new exercise();

        System.out.println(test.Interleave("abc", "def"));
        System.out.println(test.Interleave("apple", "orange"));
        System.out.println(test.Interleave("aislonger", "b345"));
        System.out.println(test.Interleave("a123", "bislonger"));
        System.out.println(test.Interleave("", "empty1"));
        System.out.println(test.Interleave("empty2", ""));
    }
} 



