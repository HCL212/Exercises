/* Given an integer array nums, find the contiguous subarray 
 * (containing at least one number) which has the largest sum and return its sum.
 *
 * EXAMPLE:
 * Input: [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * EXAMPLE:
 * Input: [-2,-3,4,-1,-2,1,5,-3]
 * Output: 7
 * Explanation: [4,-1,-2,1,5] has the largest sum = 7
 *
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution using 
 * the divide and conquer approach, which is more subtle.
 */

import java.util.*; 
  
// ONE PASS
// iterate through the array, add index element to currentSum
// if largestSum < currentSum, make largestSum = currentSum
// if currentSum < 0, reset to 0
//
// Time complexity : O(n). One loop.
// Space complexity : O(1). Only using two variables to keep track
class Solution {
    public int maxSubArray(int[] nums) {
        int largestSum = Integer.MIN_VALUE;
        int currentSum = 0;
        
        for (int i = 0; i < nums.length; i++){
            currentSum += nums[i];
            if (largestSum < currentSum)
                largestSum = currentSum;
            if (currentSum < 0)
                currentSum = 0;
        }
        return largestSum;
    }
}
