/* Loop Detection: Given a circular linked list, implement an algorithm
 * that returns the node at the beginning of the loop
 *
 * DEFINITION:
 * Circular linked list: A (corrupt) linked list in which a node's next pointer
 * points to an earlier node, so as to make a loop in the linked list.
 *
 * EXAMPLE:
 * Input: A->B->C->D->E->C (the same C as earlier)
 * Output: C
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
   
    Node loopDetect(Node head){
        HashSet<Node> set = new HashSet<Node>();

        while (head != null){
            if (set.contains(head)) return head;

            set.add(head);
            head = head.next;
        }
        return head;
    }
  
    public static void main(String args[]) { 
        exercise test = new exercise();
        
        // create a linked list
        Node list = new Node(5);
        list.appendToTail(1);
        list.appendToTail(6);
        list.appendToTail(7);

        // not tested
    }
} 


