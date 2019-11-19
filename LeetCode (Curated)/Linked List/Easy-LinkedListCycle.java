/* Given a linked list, determine if it has a cycle in it.
 *
 * To represent a cycle in the given linked list, we use an integer pos 
 * which represents the position (0-indexed) in the linked list where tail 
 * connects to. If pos is -1, then there is no cycle in the linked list.
 *
 * EXAMPLE:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 * EXAMPLE:
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 * EXAMPLE:
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 */

import java.util.*; 
  
// HASH TABLE APPROACH
// iterate through the list with a while loop
// if node is already in set, it is a cycle
// if not, add node to set and continue loop
//
// Time complexity : O(n). We visit each of the n elements in the list at most once. 
// Adding a node to the hash table costs only O(1)O(1) time.
//
// Space complexity: O(n). The space depends on the number of elements added 
// to the hash table, which contains at most n elements.
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        
        while (head != null) {
            if (set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }
}

// TWO POINTERS
// we have a slow pointer and a fast pointer
// slow pointer moves one by one, fast pointer moves 2 at a time
// while slow != fast, we loop through the list
// if fast ever reaches null, that means there is no cycle since
// there is no null in a cycle list, so return false
//
// keep looping until slow == fast, then break loop and return true
// since we found the cycle
// 
// Time complexity : O(n). Let us denote n as the total number of nodes in the 
// linked list. To analyze its time complexity, we consider the following two cases separately.
// List has no cycle: The fast pointer reaches the end first in n steps
// List has a cycle:
// We break down the movement of the slow pointer into two steps, the non-cyclic part and the cyclic part:
// 1) The slow pointer takes "non-cyclic length" steps to enter the cycle. 
// At this point, the fast pointer has already reached the cycle. Number of iterations = non-cyclic length = N
// 2) Both pointers are now in the cycle. K = almost the length of the cycle.
// So we get O(N+K) which is just O(n)
//
// Space complexity : O(1). We only use two nodes (slow and fast) so the space complexity is O(1).
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
