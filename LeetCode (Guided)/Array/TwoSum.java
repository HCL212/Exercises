/* Given an array of integers, return indices of the two numbers such 
 * that they add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, 
 * and you may not use the same element twice.
 *
 * EXAMPLE:
 * Input: [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9
 * Output: [0, 1]
 */

import java.util.*; 
  
// BRUTE FORCE
// iterate through the array and check if any ints later in 
// the array added to current index equals to target
//
// Time complexity : O(n^2) For each element, we try to find its complement by looping 
// through the rest of array which takes O(n) time. Therefore, the time complexity is O(n^2).
// 
// Space complexity : O(1)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] solution = {i,j};
                    return solution;
                }
            }
        }
    return null;
    }
}

// ONE PASS HASH TABLE
// nature of map has no duplicate keys
// iterate through the array, check against hash table to see if the complement has been found, if so return solution array
// if not, add to map and continue iterating
//
// Time complexity : O(n) We traverse the list containing n elements only once. Each look up in the table costs only O(1) time.
// Space complexity : O(n) The extra space required depends on the number of items stored in the hash table, which stores at most n elements
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length; i++) {
            int lookingFor = target - nums[i];
            if (map.containsKey(lookingFor)){
                return new int[] {map.get(lookingFor), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
