/* Given an array of n integers, are there elements a, b, c in nums such 
 * that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * EXAMPLE:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 *  [-1, 0, 1],
 *  [-1, -1, 2]
 * ]
 */

import java.util.*; 
  
// USING 2SUM APPROACH
// sort array, iterate through the sorted array and apply 2sum logic
// using 2 pointers for pincer
//
// Time complexity : O(n^2)
// 
// Space complexity : O(1)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList();
        
        // nums.length-2 so we can look at last element
        for (int i = 0; i < nums.length-2; i++){
            // only proceed if we are at first element or
            // other elements do not equal the one before it
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])){
                int lookingFor = 0 - nums[i];
                // 2 pointers, p1 is index after i, p2 is end of array
                // pincer approach
                int p1 = i+1;
                int p2 = nums.length-1;
                
                // while pointer 1 is less than pointer 2
                // proceed with algorithm
                while (p1 < p2){
                    // if p1 + p2 = lookingFor, create array and add to answer
                    if (nums[p1] + nums[p2] == lookingFor){
                        ans.add(Arrays.asList(nums[i], nums[p1], nums[p2]));
                        // move pointers along if next value is same
                        while (p1 < p2 && nums[p1] == nums[p1+1]) p1++;
                        while (p1 < p2 && nums[p2] == nums[p2-1]) p2--;
                        // iterate to next indices
                        p1++;
                        p2--;
                    // if p1 + p2 > lookingFor, decrease p2
                    } else if (nums[p1] + nums[p2] > lookingFor){
                        p2--;
                    // if p1 + p2 < lookingFor, increase p1
                    } else {
                        p1++;
                    }
                }
            }            
        }
        return ans;
    }
}
