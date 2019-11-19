/* Reverse a singly linked list.
 *
 * Example:
 * Input: 1->2->3->4->5->NULL 
 * Output: 5->4->3->2->1->NULL
 */

import java.util.*; 
  
// ITERATIVE APPROACH
// create a node to store previous node
// create a node to store the head node (so we can start)
// iterate through the list using a while loop
// create temp node to store next node
// make curr.next = previous node (reversing it)
// make previous node = current node (moving the 1st pointer along)
// make curr node = the temp node we used to store next (moving the 2nd pointer)
//
// Time complexity : O(n). Assume that n is the list's length.
// Space complexity : O(1).
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prevNode = null;
        ListNode currNode = head;
        
        while (currNode != null) {
            ListNode temp = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            
            currNode = temp;
        }
        return prevNode;
    }
}
