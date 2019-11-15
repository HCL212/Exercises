/* Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 *
 * An input string is valid if:
 * 1) Open brackets must be closed by the same type of brackets.
 * 2) Open brackets must be closed in the correct order.
 * 3) Note that an empty string is also considered valid.
 *
 * EXAMPLE:
 * Input: "()"
 * Output: true
 *
 * EXAMPLE:
 * Input: "()[]{}"
 * Output: true
 * 
 * EXAMPLE:
 * Input: "(]"
 * Output: false
 *
 * EXAMPLE:
 * Input: "([)]"
 * Output: false
 *
 * EXAMPLE:
 * Input: "{[]}"
 * Output: true
 */

import java.util.*; 
  
// STACK APPROACH
// use HashMap to store key, value pairs of the brackets
// key = closing bracket, value = opening bracket
//
// create a stack to help determine if string is valid
// loop through the string
// if character is a opening bracket, push onto stack
// if it is a closing bracket, compare it to the top of stack using the map
// if it is not a match, return false, if it is, continue
// if stack is empty at the end, it is valid
//
// Time complexity : O(n) because we simply traverse the given string one character 
// at a time and push and pop operations on a stack take O(1) time.
//
// Space complexity : O(n) as we push all opening brackets onto the stack and in the worst case, 
// we will end up pushing all the brackets onto the stack. e.g. ((((((((((.
class Solution {
    
    private Map<Character, Character> mappings;
    
    public Solution() {
        this.mappings = new HashMap<Character,Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            // if map contain closing bracket
            if (mappings.containsKey(c)){
                // if stack is empty put dummy value '#', otherwise pop from stack
                // and store into topOfStack variable
                char topOfStack = stack.empty() ? '#' : stack.pop();
                
                // compare topOfStack variable to 'c' value in the map
                if (topOfStack != this.mappings.get(c)){
                    return false;
                }
            } else {
                // push opening brackets onto the stack
                stack.push(c);
            }
        }
        
        // if stack is empty, it's valid
        return stack.isEmpty();
    }
}
