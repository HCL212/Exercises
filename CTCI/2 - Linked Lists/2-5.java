/* Sum Lists: You have two numbers represented by a linked list,
 * where each node contains a single digit.  The digits are stored
 * in reverse order, such that the 1's digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a
 * linked list.
 *
 * EXAMPLE:
 * Input: (7->1->6) + (5->9->2).  That is, 617 + 295.
 * Output: 2->1->9. That is 912.
 *
 * FOLLOW UP:
 * Suppose the digits are stored in forward order.  Repeat the above problem.
 *
 * Input: (6->1->7) + (2->9->5).  That is, 617 + 295.
 * Output: 9->1->2.  That is 912.
 *
 * Current solution time complexity = ???
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

        // return data
        int getData(){
            return data;
        }
    }

    // get node from position x in the list
    Node getNode(Node head, int x){
        int count = 0;
        while (head != null){
            if (count != x){
                count++;
                head = head.next;
            }
            else {
                return head;
            }
        }    
        return null;
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
   
    void sumLists(Node head1, Node head2){
        
    }
  
    public static void main(String args[]) { 
        exercise test = new exercise();
        
        // create a linked list
        Node list1 = new Node(7);
        list1.appendToTail(1);
        list1.appendToTail(6);

        Node list2 = new Node(5);
        list2.appendToTail(9);
        list2.appendToTail(2);

        Node list3 = new Node(6);
        list3.appendToTail(1);
        list3.appendToTail(7);

        Node list4 = new Node(2);
        list4.appendToTail(9);
        list4.appendToTail(5);

        test.printList(list1);
        test.printList(list2);
        test.sumLists(list1, list2);
    }
} 


