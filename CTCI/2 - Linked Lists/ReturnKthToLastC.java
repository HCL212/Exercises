import java.io.*;

public class MyLinkedList {
    // head of list
    Node head;

    // node class
    // static so main can access
    static class Node{
        Node next = null;
        int data;
        
        //constructor
        public Node(int x){
            data = x;
        }
    }

    public static MyLinkedList addToTail(MyLinkedList list, int x){
        // create a node to add to end
        Node toAdd = new Node(x);

        // check if list is empty and do operations
        // if empty, make new node the head
        // else create node to traverse and add to end
        if (list.head == null){
            list.head = toAdd;
        } else {
            Node temp = list.head;
            while (temp.next != null){
                temp = temp.next;
            }
            
            // add node to end
            temp.next = toAdd;
        }

        // return the list by head
        return list;
    }

    public static Node returnKthToLast(MyLinkedList list, int k){
        // two pointers to traverse the list at same pace
        Node p1 = list.head;
        Node p2 = list.head;

        // move one pointer k nodes into the list
        for (int i = 0; i < k; i++){
            if (p1 == null) return null;
            p1 = p1.next;
        }

        // move both pointers at the same pace
        while (p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }

        // return the kth node
        return p2;
    }

    // print the list
    public static void printList(MyLinkedList list){
        StringBuilder listString = new StringBuilder();
        Node temp = list.head;

        // traverse list, and print data
        while (temp != null){
            listString.append(temp.data + " ");
            temp = temp.next;
        }

        System.out.println(listString.toString());
    }

    public static void main(String args[]) {
        MyLinkedList demo = new MyLinkedList();

        // create a linked list
        demo = addToTail(demo, 1);
        demo = addToTail(demo, 24);
        demo = addToTail(demo, 16);
        demo = addToTail(demo, 7);
        demo = addToTail(demo, 10);
        demo = addToTail(demo, 55);
        demo = addToTail(demo, 90);
        demo = addToTail(demo, 4);
        demo = addToTail(demo, 1);
        demo = addToTail(demo, 39);

        printList(demo); // return 1 24 16 7 10 55 90 4 1 39
        System.out.println(returnKthToLast(demo, 5).data); // return 55
        System.out.println(returnKthToLast(demo, 1).data); // return 39
        System.out.println(returnKthToLast(demo, 4).data); // return 90
        System.out.println(returnKthToLast(demo, 6).data); // return 10
        System.out.println(returnKthToLast(demo, 3).data); // return 4
    }
}
