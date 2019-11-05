/* Delete Middle Node: Implement an algorithm to delete a node in the middle
 * (i.e., any node but the first and last node, not necessarily the exact middle)
 * of a singly linked list, give only access to that node.
 *
 * EXAMPLE:
 * Input: the node c from the linked list a->b->c->d->e->f
 * Result: nothing is returned, but the new linked list looks like
 * a->b->d->e->f
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
   
    boolean deleteMiddle(Node n){
        // checks if node is null or last node
        if (n == null || n.next == null){
            return false;
        }

        // copy data from next node to curr node
        // point curr node to next.next node
        // and delete next node
        Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
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

        test.printList(head);
        test.deleteMiddle(test.getNode(head, 4));
        test.printList(head);
    }
} 


