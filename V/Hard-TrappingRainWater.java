/* Given n non-negative integers representing an elevation map where the 
 * width of each bar is 1, compute how much water it is able to trap after raining.
 *
 * EXAMPLE:
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * 
 * w = water
 * |            |
 * |            |
 * |            |
 * |       X    |
 * |   XwwwXXwX |
 * |_XwXXwXXXXXX|
 */ 010210132121 

import java.util.*; 
  
// 2 POINTERS
// We can say that if there is a larger bar at one end (say right), 
// we are assured that the water trapped would be dependant on height of bar 
// in current direction (from left to right). As soon as we find the bar at 
// other end (right) is smaller, we start iterating in opposite direction 
// (from right to left). We must maintain leftMax and rightMax during the iteration, 
// but now we can do it in one iteration using 2 pointers, switching between the two.
//
// Time complexity : O(n) one iteration through the array
// Space complexity : O(1) only constant space required for left, right, leftMax, rightMax
class Solution {
    public int trap(int[] height) {
        // initialize left pointer to 0 and right pointer to size-1
        int left = 0, right = height.length-1;
        int ans = 0, leftMax = 0, rightMax = 0;
        
        // while the pointers have not met, proceed with algo
        while (left < right){
            if (height[left] < height[right]){
                if (height[left] >= leftMax){
                    leftMax = height[left];
                } else {
                    ans += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax){
                    rightMax = height[right];
                } else {
                    ans += rightMax - height[right];
                }
                right--;
            }
        }
        return ans;
    }
}
