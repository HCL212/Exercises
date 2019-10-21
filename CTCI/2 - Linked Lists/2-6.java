/* Palindrome: Implement a function to check if a linked list
 * is a palindrome
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
   
    // reverse list and compare both
    boolean isPalindrome(Node head){
        // revList is a new list
        // origList to keep track of original
        Node origList = head;
        Node revList = null;
       
        // iterate through the original list
        // and create new nodes for the reverse list
        // which point to the next node
        while (head != null){
            Node n = new Node(head.data);
            n.next = revList;
            revList = n;
            head = head.next;
        }

        // debugging
        printList(revList);
        printList(origList);

        // comparing both lists
        while (origList != null && revList != null){
            if (origList.data == revList.data){
                origList = origList.next;
                revList = revList.next;
            } else {
                return false;
            }
        }

        return true;
    }
  
    public static void main(String args[]) { 
        exercise test = new exercise();
        
        // create a linked list
        Node list1 = new Node(7);
        list1.appendToTail(1);
        list1.appendToTail(6);
        list1.appendToTail(5);
        list1.appendToTail(6);
        list1.appendToTail(1);
        list1.appendToTail(7);

        Node list2 = new Node(5);
        list2.appendToTail(9);
        list2.appendToTail(5);
        list2.appendToTail(9);

        Node list3 = new Node(6);
        list3.appendToTail(1);
        list3.appendToTail(7);
        list3.appendToTail(7);
        list3.appendToTail(1);
        list3.appendToTail(6);

        Node list4 = new Node(2);
        list4.appendToTail(9);
        list4.appendToTail(2);

        Node list5 = new Node(10);
        list5.appendToTail(9);

        System.out.println(test.isPalindrome(list1)); // true
        System.out.println(test.isPalindrome(list2)); // false
        System.out.println(test.isPalindrome(list3)); // true
        System.out.println(test.isPalindrome(list4)); // true
        System.out.println(test.isPalindrome(list5)); // false
    }
} 


