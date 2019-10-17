/* Remove Dups: Write code to remove duplicates from an
 * unsorted linked list
 * FOLLOW UP
 *
 * How would you solve this problem if a temporary buffer
 * is not allowed?
 *
 * Current solution time complexity = SEE BELOW
 */

import java.util.*; 
  
class exercise { 

    // nested class Node for singly linked list
    static class Node {
        Node next = null;
        int data;
        
        // constructor
        public Node(int d) {
            data = d;
        }
        
        // add element to tail of linked list
        void appendToTail(int d){
            Node end = new Node(d);
            Node n = this;
            while (n.next != null){
                n = n.next;
            }
            n.next = end;
        }

        // return data from the node
        int getData(){
            return data;
        }
    }

    // print singly linked list
    void printList(Node head){
        StringBuilder list = new StringBuilder();
        
        while (head.next != null){
            list.append(head.getData());
            list.append(", ");
            head = head.next;
        }
        list.append(head.getData());
        System.out.println(list.toString());
    }
   
    // COMPLEXITY: O(n) where n is the # of elements in the list
    // remove dups with a buffer
    // keep values in a simple hash table
    void removeDups(Node n){
        HashSet<Integer> set = new HashSet<Integer>();
        // "previous" used to modify previous node pointer
        // while we iterate through with n
        Node previous = null;

        // iterate through list
        while (n != null){
            // if found, move pointer to next
            // else add data to hashtable, and continue
            if (set.contains(n.data)){
                previous.next = n.next;
            }
            else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }

    // COMPLEXITY: O(1) space but O(n^2) time
    // remove dups with no buffer
    void removeDupsNoBuffer(Node head){
        Node currNode = head; 
        // iterate through list

        while (currNode != null){
            // remove future nodes that have same value
            // use a runner

            Node search = currNode;
            // iterate through list with runner
            // if "search" NEXT node has same data
            // change pointer to next next
            while (search.next != null){
                if (search.next.data == currNode.data){
                    search.next = search.next.next;
                }
                else {
                    search = search.next;
                }
            }
            // continue iterating through list
            currNode = currNode.next;
        }
    }
  
    public static void main(String args[]) { 
        exercise test = new exercise();
        
        // create a linked list
        Node head = new Node(9);
        head.appendToTail(10);
        head.appendToTail(1);
        head.appendToTail(9);
        head.appendToTail(23);
        head.appendToTail(1);
        head.appendToTail(9);
        head.appendToTail(31);
        head.appendToTail(10);
        head.appendToTail(50);
        head.appendToTail(23);
        head.appendToTail(100);
        head.appendToTail(9);

        System.out.println("LinkedList before removeDups: ");
        test.printList(head);
        
        // both work
        test.removeDupsNoBuffer(head);
        // test.removeDups(head);

        System.out.println("LinkedList after removeDups: ");
        test.printList(head);
    }
} 


