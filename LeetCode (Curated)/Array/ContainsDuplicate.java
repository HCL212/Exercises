/* Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value appears at least twice in the array, 
 * and it should return false if every element is distinct.
 *
 * EXAMPLE:
 * Input: [1,2,3,1]
 * Output: true
 *
 * EXAMPLE:
 * Input: [1,2,3,4]
 * Output: false
 *
 * EXAMPLE:
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */

import java.util.*; 
  
// HASH SET
// hash set cannot have duplicates
// iterate through the array, if hashset contains the index element
// return true, otherwise add to hashset and continue iterating
//
// Time complexity : O(n). We do search() and insert() for n times and each operation takes constant time.
// Space complexity : O(n). The space used by a hash table is linear with the number of elements in it.
class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1) return false;
        
        HashSet<Integer> stored = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if (stored.contains(nums[i]))
                return true;
            stored.add(nums[i]);
        }
        return false;
    }
}

// SORTING
// sort the array, and compare element i with element i+1
//
// Time complexity : O(n log n). Sorting is O(n log n) and the sweeping is O(n). 
// The entire algorithm is dominated by the sorting step, which is O(n log n).
// 
// Space complexity : O(1). Space depends on the sorting implementation which, 
// usually, costs O(1) auxiliary space if heapsort is used.
class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length <= 1) return false;
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i] == nums[i+1]) return true;
        }
        return false;
    }
}
