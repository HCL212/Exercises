/* You are given an array of positive integers nums.
 * Count and print the number of (contiguous) subarrays where 
 * the product of all the elements in the subarray is less than k.
 *
 * EXAMPLE:
 * Input: nums = [10, 5, 2, 6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are: 
 * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 */

import java.util.*; 
  
// SLIDING WINDOW APPROACH
// KEYWORD HERE IS SUBARRAY (continous arrays within the array)
// KEYWORD HERE IS ALSO LESS THAN K, NOT "OR EQUAL TO"
//
// base case, if k <= 1, automatic 0
// we use right to grow the window and multiply element into prod
// while temp is greater than k, we divide by left element and
// increment left after
// NOTE: also takes care of the case where a element is >= k
//      it would bring prod down to 1, left would get iterated
//      right - left + 1 = 0
//      0 gets added to the answer
//      iterate right and continue
// ans += right - left + 1 explanation:
//      ie: [..., 5, 10, 9, 6, 20, ...] is current window
//      index 3 is element 5, index 7 is element 20
//      the FIVE new subarrays we are adding are:
//      NOTE: [10] was added previously
//          [5, 10, 9, 6, 20]
//          [10] [9] [6] [20]
//      so we are adding 7-3+1 = 5
//
// Time Complexity: O(N), where N is the length of nums. 
// left can only be incremented at most N times.
//
// Space Complexity: O(1), the space used by prod, left, and ans.
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int ans = 0, left = 0, prod = 1;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (temp >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }
}
