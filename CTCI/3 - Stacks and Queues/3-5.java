/* Sort Stack: Write a program to sort a stack such that the
 * smallest items are on the top.  You can use an additional temporary
 * stack, but you may not copy the elements into any other data structure
 * (such as an array).  The stack supports the following operations: push,
 * pop, peek, and isEmpty.
 *
 * Current solution time complexity = ???
 */

import java.util.*; 
  
class exercise { 
    
    void sortStack (Stack<Integer> stack) {
        Stack<Integer> r = new Stack<Integer>();
        while (!stack.isEmpty()){
            // insert each element in stack in sorted order into r
            int temp = stack.pop();
            while (!r.isEmpty() && r.peek() > temp){
                stack.push(r.pop());
            }
            r.push(temp);
        }

        // copy the elements from r back to stack
        while (!r.isEmpty()){
            stack.push(r.pop());
        }
    } 
  
    public static void main(String args[]) { 
        exercise test = new exercise();

        Stack<Integer> stackOfInts = new Stack<Integer>();
        stackOfInts.push(3);
        stackOfInts.push(13);
        stackOfInts.push(5);
        stackOfInts.push(390);
        stackOfInts.push(33);
        stackOfInts.push(45);
        stackOfInts.push(24);
        stackOfInts.push(2);
        stackOfInts.push(88);
        stackOfInts.push(1);
        stackOfInts.push(22);

        System.out.println(stackOfInts);
        test.sortStack(stackOfInts);
        System.out.println(stackOfInts);
    }
} 



