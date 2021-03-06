/* Given an array nums of n integers where n > 1,  return an array output such 
 * that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * EXAMPLE:
 * Input: [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * EXAMPLE:
 * Input: [4,5,1,8,2]
 * Output: [80,64,320,40,160]
 *
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity? 
 * (The output array does not count as extra space for the purpose of space complexity analysis.)
 */

import java.util.*; 

// NOT ALLOWED SOLUTION (using division)
// take the product of all the elements in the given array and then, for each index x,
// divide by x and put into solution array
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] solution = new int[nums.length];
        int product = 1;
        
        for (int i = 0; i < nums.length; i++){
            product *= nums[i];
        }
        for (int j = 0; j < solution.length; j++){
            solution[j] = product/nums[j];
        }
        return solution;
    }
}

// BRUTE FORCE (time limit exceeded)
// iterate through the array with 2 loops, keep track of
// product and add to solutions array
//
// Time complexity : O(n^2)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] solution = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++){
            int product = 1;
            for (int j = 0; j < nums.length; j++){
                if (i != j)
                    product *= nums[j];
            }
            solution[i] = product;
        }
        return solution;
    }
}

// SPLIT ARRAY INTO TWO
// Input array: [4, 5, 1, 8, 2]
// Left Array: [1, 4, 20, 20, 160]
// Right Array: [80, 16, 16, 2, 1]
// Solution Array: [80,64,320,40,160]
//
//                  [4, 5, 1, 8, 2]
//    [1, 4, 20, 20, 160]    [80, 16, 16, 2, 1]
//                        =
//               [80,64,320,40,160]
//
// Explanation: If for example we want i = 1 (index/position of input array)
// Product of everything left of i from the input array will be in Left[i]
// Product of everything right of i from the input array will be in Right[i]
// Multiply Left[i] with Right[i] to get solution[i]
//
// Time complexity : O(N) where N represents the number of elements in the input array. 
// We use one iteration to construct the Left array
// We use one iteration to construct the Right array 
// We use one iteration to construct the Solution array using Left and Right.
// 
// Space complexity : O(N) used up by the two intermediate arrays that we constructed 
// to keep track of product of elements to the left and right.
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] solution = new int[length];
        int[] left = new int[length];
        int[] right = new int[length];
        
        // Left[i] will contain the product of ALL the numbers left of i from the INPUT array
        // Left[0] = 1 since there is nothing to the left of input[0]
        // Left[i-1] already contains the previous products
        // Multiplying Left[i-1] with nums[i-1] would give the product of all elements to the LEFT of index 'i'
        for (int i = 1; i < length; i++){
            left[i] = left[i-1] * nums[i-1];
        }
        
        // NOTE: Right will be done in reverse of what we did in Left
        // Right[i] will contain the product of ALL the numbers right of i from the INPUT array
        // Right[length-1] = 1 since there is nothing to the right of input[length-1]
        // Right[i+1] already contains the previous products
        // Multiplying Right[i+1] with nums[i+1] would give the product of all elements to the RIGHT of index 'i'
        right[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--){
            right[i] = right[i+1] * nums[i+1];
        }
       
        // multiply left[i] with right[i] and put into solution array
        for (int i = 0; i < length; i++){
            solution[i] = left[i] * right[i];
        }
        
        return solution;
    }
}

// FOLLOW UP 
// same as previous solution, except we do not build Right array
// build left array with left[0] = 1, etc (see previous explanation)
//
// Time complexity : O(N) where N represents the number of elements in the input array. 
// We use one iteration to construct the array "left", one to update the array with solution.
// O(2N) = O(N) since we drop constants
//
// Space complexity : O(1) since we don't use any additional array for our computations. 
// The problem statement mentions that using the solution array doesn't add to the space complexity.
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] solution = new int[length];
        
        // same as "left" from above solution
        solution[0] = 1;
        for (int i = 1; i < length; i++){
            solution[i] = solution[i-1] * nums[i-1];
        }
        
        // after solution array is built with "left" products elements
        // we iterate backwards through the solution array
        // using "int right" as a placeholder for right products
        // and multiply into solution array
        int right = 1;
        for (int i = length - 1; i >= 0; i--){
            solution[i] *= right;
            right *= nums[i];
        }
        
        return solution;
    }
}

