/* Minimal Tree: Given a sorted (increasing order) array with unique
 * integer elements, write an algorithm to create a binary search tree
 * with minimal height.
 *
 * Current solution time complexity = ???
 */

import java.util.*; 
  
// recursive method
// passes a subsection of the array and returns the root node
// algorithm:
// 1) insert into the tree the middle element of the array
// 2) insert into the left subtree the left subarray elements
// 3) insert into the right subtree the right subarray elements
// 4) recurse
TreeNode createMinimalBST(int array[]) {
    return createMinimalBST(array, 0, array.length - 1);
}

TreeNode createMinimalBST(int arr[], int start, int end) {
    if (end < start) return null;

    int mid = (start + end) / 2;
    TreeNode n = new TreeNode(arr[mid]);
    n.left = createMinimalBST(arr, start, mid - 1);
    n.right = createMinimalBST(arr, mid + 1, end);
    return n;
}



