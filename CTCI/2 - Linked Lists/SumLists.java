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
   
    // elementary math from least significant # to most significant
    Node sumLists(Node head1, Node head2){
        // sumList will be out result
        // curr is what we use to append elements to sumList
        // p and q are reference pointers
        Node sumList = new Node(0);
        Node p = head1;
        Node q = head2;
        Node curr = sumList;
        int carry = 0;

        while (p != null || q != null){
            // if p is not null then x = p.data, else x = 0
            // if q is not null then x = q.data, else x = 0
            int x = (p != null) ? p.data : 0;
            int y = (q != null) ? q.data : 0;

            // adding the column here
            int sum = carry + x + y;

            // deduct the new carry
            carry = sum / 10;

            // put result in next node
            curr.next = new Node(sum % 10);

            // iterate to next node in sum list
            curr = curr.next;

            // iterate the ref pointers
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        // if there is an extra carry by the end, append to list
        if (carry > 0) {
            curr.next = new Node(carry);
        }

        // return sumList.next because sumList head = 0 when initializing
        return sumList.next;
    }

    // unfinished
    void sumListsFollowUp(Node head1, Node head2){
        // determine length of both lists
        // if both lists are same length, then add them
        // otherwise pad the shorter list with 0's in the front
        // add the numbers recursively so that we can add
        // the smaller numbers first
        // see book for solution
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

        Node list5 = null;

        test.printList(list1);
        System.out.println("+");
        test.printList(list2);
        System.out.println("=");
        test.printList(test.sumLists(list1, list2));

        System.out.println("\n");

        test.printList(list3);
        System.out.println("+");
        test.printList(list4);
        System.out.println("=");
        // test.printList(test.sumListsFollowUp(list3, list4));
    }
} 


