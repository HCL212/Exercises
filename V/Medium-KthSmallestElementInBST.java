/* Given a binary search tree, write a function kthSmallest to 
 * find the kth smallest element in it.
 *
 * Note: You may assume k is always valid, 1 = k = BST's total elements.
 *
 * EXAMPLE:
 * Input: root = [3,1,4,null,2], k = 1
 *      3
 *     / \
 *    1   4
 *     \
 *      2
 * Output: 1
 *
 * EXAMPLE:
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *         5
 *        / \
 *       3   6
 *      / \
 *     2   4
 *    /
 *   1
 * Output: 3
 *
 * FOLLOW UP:
 * What if the BST is modified (insert/delete operations) often and you need 
 * to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 */

import java.util.*; 
  
// RECURSION
// It's a very straightforward approach with O(N) time complexity. The idea is
// to build an inorder traversal of BST which is an array sorted in the ascending order. 
// Now the answer is the k - 1th element of this array.
//
// Time complexity : O(N) to build a traversal.
// Space complexity : O(N) to keep an inorder traversal.
//
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // in order traversal
    public ArrayList<Integer> inOrder(TreeNode root, ArrayList<Integer> arr){
        // base case
        if (root == null) return arr;
        
        // left -> curr -> right
        inOrder(root.left, arr);
        arr.add(root.val);
        inOrder(root.right, arr);
        return arr;
    }
    
    public int kthSmallest(TreeNode root, int k) {
        // array to store the nums in tree, from smallest to largest
        ArrayList<Integer> nums = inOrder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }
}

// ITERATION
// The above recursion could be converted into iteration, with the help of stack. 
// This way one could speed up the solution because there is no need to build the 
// entire inorder traversal, and one could stop after the kth element.
//
// Time complexity :O(H+k), where H is a tree height. This complexity is defined by the stack, 
// which contains at least H + k elements, since before starting to pop out one has to go down 
// to a leaf. This results in O(logN+k) for the balanced tree and O(N+k) for completely 
// unbalanced tree with all the nodes in the left subtree.
//
// Space complexity : O(H+k), the same as for time complexity, O(N+k) in the worst case, 
// and O(logN+k) in the average case.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public int kthSmallest(TreeNode root, int k) {
    LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

    while (true) {
      while (root != null) {
        stack.add(root);
        root = root.left;
      }
      root = stack.removeLast();
      if (--k == 0) return root.val;
      root = root.right;
    }
  }
}

// FOLLOW UP??????
