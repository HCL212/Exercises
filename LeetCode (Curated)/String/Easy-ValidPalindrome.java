/* Given a string, determine if it is a palindrome, considering only 
 * alphanumeric characters and ignoring cases.
 * 
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * EXAMPLE:
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 *
 * EXAMPLE:
 * Input: "race a car"
 * Output: false
 */

import java.util.*; 
  
// make string all lower case and remove spaces
// loop through string and put any chars that are letters or digits
// into string builder
// 
// loop through new string, and use pincer approach to compare
class Solution {
    public boolean isPalindrome(String s) {        
        String lower = s.toLowerCase();
        lower = lower.replaceAll("\\s","");
                
        StringBuilder cleanString = new StringBuilder();
        
        for (int i = 0; i < lower.length(); i++){
            if (Character.isLetterOrDigit(lower.charAt(i))){
                cleanString.append(lower.charAt(i));
            }
        }
                        
        for (int i = 0; i < cleanString.length()/2; i++){
            if (cleanString.charAt(i) != cleanString.charAt(cleanString.length()-1-i)){
                return false;   
            }
        }
        
        return true;
    }
}

// initialize start and end points
// use while loop to move pointers if they are not letters or digits
// if they are, compare
class Solution {
    public boolean isPalindrome(String s) {
        int start = 0; 
        int end = s.length() - 1;

        while (start <= end) {
            while (start <= end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while (start <= end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            if (start <= end && Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
