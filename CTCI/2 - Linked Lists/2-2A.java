/* Return Kth to Last: Implement an algorithm to find the kth
 * to last element of a singly linked list
 *
 * EXAMPLE:
 * List = [9, 8, 33, 44, 51, 12, 7]
 * Kth = 3rd
 * Returns 51
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
   
    int returnKthToLast(Node head, int kth){
        // get size of list
        Node sizeCount = head;
        int size = 0;
        while (sizeCount != null){
            size++;
            sizeCount = sizeCount.next;
        }

        // if kth request is smaller than list size
        // return invalid
        int k = size-kth;
        if (k < 1)
            return -1;

        int count = 0;
        while (head != null){
            if (count == k)
                return head.getData();
            else {
                count++;
                head = head.next;
            }
        }

        return -1;
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

        System.out.println(test.returnKthToLast(head, 3)); // return "23"
        System.out.println(test.returnKthToLast(head, 1)); // return "9"
        System.out.println(test.returnKthToLast(head, 11)); // return "1"
        System.out.println(test.returnKthToLast(head, 14)); // return "-1" (invalid)
    }
} 


