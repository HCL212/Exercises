/* Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * EXAMPLE 1:
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 *
 * EXAMPLE 2:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 */

import java.util.*; 
  
// RECURSION
// One compares the node value with its upper and lower limits if they are available. 
// Then one repeats the same step recursively for left and right subtrees.
//
// Time complexity : O(n) since we visit each node exactly once.
// Space complexity : O(n) since we keep up to the entire tree.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { 
 *          val = x; 
 *     }
 * }
 */
class Solution {
    public boolean helper(TreeNode node, Integer lower, Integer upper){
        // base case
        if (node == null) return true;
        
        int val = node.val;
        // if going down left, there is no lower limit since
        // left descendents <= n
        // if going down right, there is no upper limit since
        // n <= right descendents
        
        // going down left condition
        if (upper != null && val >= upper) return false;
        // going down right condition
        if (lower != null && val <= lower) return false;
        
        // check right node recursively, upper = null, lower = val
        if (!helper(node.right, val, upper)) return false;
        // check left node recursively, lower = null, upper = val
        if (!helper(node.left, lower, val)) return false;
        
        // if everything checks out return true;
        return true;
    }
    
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
}
