/* Given an integer array nums, find the contiguous subarray within an array 
 * (containing at least one number) which has the largest product.
 *
 * EXAMPLE:
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 *
 * EXAMPLE:
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */

import java.util.*; 
  
// ONE PASS
// set 3 variables to track result, min/max of contiguous array
// at each new element, u could either add the new element to the existing product, 
//  or start fresh the product from current index (wipe out previous results), hence the 2 Math lines
// if we see a negative number, the "candidate" for max should instead become the previous min product, 
//  because a bigger number multiplied by negative becomes smaller, hence swapping min and max
//
// EXAMPLE:
// [2, 3, -2, -4]
//   vars     |  @index 1 | @index 2  | @index 3
// max = 2    |     6     |  3 -> -2  | -12 -> 48
// min = 2    |     3     |  6 -> -12 |  -2 -> -4
// result = 2 |     6     |     6     |     48
//
// Time complexity : O(n). One loop.
// Space complexity : O(1). Only using three variables to keep track
class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        
        // store 0th index in 3 variables
        int result = nums[0];
        int min = nums[0];
        int max = nums[0];
        
        // iterate through array starting at 1
        for (int i = 1; i < nums.length; i++){
            int curr = nums[i];
            
            // create temporary array to sort the "candidates"
            // and put values into max/min accordingly
            int[] temp = {curr, curr*min, curr*max};
            Arrays.sort(temp);
            
            max = temp[2];
            min = temp[0];

            result = Math.max(result, max);
        }
        
        return result;
    }
}
