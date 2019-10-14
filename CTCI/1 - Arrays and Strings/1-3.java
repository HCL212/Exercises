/* URLify: Write a method to replace all spaces in a string with '%20'.
 * You may assume that the string has sufficient space at the end to hold the
 * additional characters, and that you are given the "true" length of the string.
 * (Note: If implementing in Java, please use a character array so that you can perform
 * this operation in place.)
 *
 * EXAMPLE:
 * Input: "Mr_John_Smith____", 13
 * Output: "Mr%20John%20Smith"
 *
 * Current solution time complexity = ???
 */

import java.util.*; 
  
class exercise { 
    
    void URLify (String str, int trueLength) { 
        // convert string to char array
        char[] string = str.toCharArray();

        int spaceCount = 0;
        // count how many spaces in string
        // ignores spaces at end of the string b/c true length is given
        for (int i = 0; i < trueLength; i++) {
            if (string[i] == ' ') {
                spaceCount++;
            }
        }

        // index = total # of characters needed for edited string
        int index = (trueLength - spaceCount) + spaceCount * 3;

        // '\0' used to terminate char array since it stores a string (ONLY for string)
        if (trueLength < string.length)
            string[trueLength] = '\0';

        // iterate backwards through the array
        // if char is a ' ', replace with '%20'
        // else keep as it and keep iterating
        for (int i = trueLength - 1; i >= 0; i--) {
            if (string[i] == ' ') {
                string[index - 3] = '%';
                string[index - 2] = '2';
                string[index - 1] = '0';
                index -= 3;
            }
            else {
                string[index - 1] = string[i];
                index--;
            }
        }
        System.out.println(string);
    } 
  
    public static void main(String args[]) { 
        exercise test = new exercise();
        test.URLify("Mr John Smith    ", 13);
    }
} 
