/* Intersection: Given two (singly) linked lists, determine if the two lists intersect.
 * Return the intersecting node.  Note that the intersection is defined based on reference,
 * not value.  That is, if the kth node of the first linked list is the exact same node
 * (by reference) as the jth node of the second linked list, then they are intersecting.
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
   
    Node intersecting(Node head1, Node head2){
        while (head1 != null || head2 != null){
            if (head1 == null) return null;
            if (head2 == null) return null;

            if (head1 == head2) return head1;

            head1 = head1.next;
            head2 = head2.next;
        }

        return null;
    }
  
    public static void main(String args[]) { 
        exercise test = new exercise();
        
        // create a linked list
        Node list1 = new Node(5);
        list1.appendToTail(1);
        list1.appendToTail(6);
        list1.appendToTail(7);

        Node list2 = new Node(5);
        list2.appendToTail(1);
        list2.appendToTail(6);
        list2.appendToTail(7);

        Node list3 = list1;

        System.out.println(test.intersecting(list1, list2)); // null
        System.out.println((test.intersecting(list1, list3).data)); // 5
    }
} 


