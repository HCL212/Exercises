/* Check Permutation: Given two strings, write a method to decide 
 * if one is a permutation of the other
 *
 * Current solution time complexity =
 * Time complexity of this method depends upon the sorting technique used. In the implementation, 
 * quickSort is used which may be O(n^2) in worst case. If we use a O(nLogn) sorting algorithm like merge sort, 
 * then the complexity becomes O(nLogn)
 */

import java.util.*; 
  
class exercise { 
    
    boolean checkPermutation (String str1, String str2) 
    { 
        // check string lengths against each other
        if (str1.length() != str2.length()) {
            return false;
        }

        // if same length, sort strings and compare
        // sort by converting string to char array
        // then using Arrays.sort
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        String sorted1 = new String(chars1);
        String sorted2 = new String(chars2);

        if (!sorted1.equals(sorted2))
            return false;

        return true;
    } 
  
    public static void main(String args[]) 
    { 
        exercise test = new exercise();

        if (args.length > 1 && args.length < 3) {  
            String string1 = args[0];
            String string2 = args[1];

            if (test.checkPermutation(string1, string2))
                System.out.println(true);
            else
                System.out.println(false);
        }
        else
            System.out.println("Invalid arguments");
    } 
} 
