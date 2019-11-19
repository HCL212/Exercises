/* Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * EXAMPLE:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */

import java.util.*; 
  
// RECURSIVE APPROACH
// if either is null, return the other
// if value in list 1 is smaller than value in list 2
// we return l1 and move to the next l1 value recursively
//
// if value in list 2 is smaller than or equal to value in list 1
// we return l2 and move to the next l2 value recursively
//
// will have stack overflow if list is too long, will eat up a lot of space on the stack
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

// ITERATIVE APPROACH
// if l1 is empty, return l2 and vice versa
// create a new node with a garbage variable to create a new list
// create a curr node to help get the solution list
// while both list pointers are not null
//      if l1 is less than l2, make next node = l1, and move l1 pointer
//      else make next node = l2, and move l2 pointer
//      iterate curr node so we can continue
// when either pointer reaches null, determine if l1 is null
//      if so, make curr.next point to remainder of l2, 
//      else point to remainder of l1
// return the garbage variable node's next
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode temp = new ListNode(0);
        ListNode curr = temp;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        // if l1 is null, curr.next = l2
        // else curr.next = l1
        curr.next = l1 == null ? l2 : l1;
        return temp.next;
    }
}
