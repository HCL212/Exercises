/* Partition: Write code to partition a linked list around a value x, such
 * that all nodes less than x come before all nodes greater than or equal
 * to x.  If x is contained within the list, the values of x only need
 * to be after the elements less than x (see below).  The partition element
 * x can appear anywhere in the "right partition"; it does not need to appear
 * between the left and right partitions.
 *
 * EXAMPLE:
 * Input: 3->5->8->5->10->2->1 [partition = 5]
 * Output: 3->1->2->10->5->5->8
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
   
    // start a "new" list with existing node
    // elements bigger are put at the tail
    // elements smaller are put at the head
    Node partition(Node node, int x){
        // head + tail are pointing to same node (by reference, like C++ pointers)
        Node head = node;
        Node tail = node;

        // iterate through the list
        while (node != null){
            // keep track of the next node for traversal
            Node next = node.next;

            // do task on current node
            // starting node will always point at itself
            // non starting nodes will point at the head or tail
            // accordingly, and head/tail pointers will move each time
            if (node.data < x){
                // insert node at head
                node.next = head;
                head = node;
            }
            else {
                //insert node at tail
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;

        // the head has changed, so we need to return it to the user
        return head;
    }
  
    public static void main(String args[]) { 
        exercise test = new exercise();
        
        // create a linked list
        Node head = new Node(3);
        head.appendToTail(5);
        head.appendToTail(8);
        head.appendToTail(5);
        head.appendToTail(10);
        head.appendToTail(2);
        head.appendToTail(1);

        test.printList(head);
        test.printList(test.partition(head, 5));
    }
} 


