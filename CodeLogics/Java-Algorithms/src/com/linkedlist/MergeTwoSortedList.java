package com.linkedlist;

class Node {
    int val;
    Node next;
    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, Node next) { this.val = val; this.next = next; }
}

public class MergeTwoSortedList {
    public static void main(String[] args) {

        // SinglyLinkedList L1 = new SinglyLinkedList();
        // L1.append(1);
        // L1.append(2);
        // L1.append(4);

        // Utils.prtLst(L1.getHead());
        
        // SinglyLinkedList L2 = new SinglyLinkedList();
        // L2.append(1);
        // L2.append(3);
        // L2.append(4);        
        
        // Utils.prtLst(L2.getHead());

        Node l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(3);
        prtList(l1);
        Node l2 = new Node(1);
        l2.next = new Node(3);
        l2.next.next = new Node(4);
        prtList(l2);

        prtList(mergeTwoLists(l1,l2));

    }

    public static void prtList(Node head) {
        
        StringBuilder sb = new StringBuilder();
        sb.append(head.val+"->");
        Node current = head.next;
        while(current!=null){
            sb.append(current.val+"->");
            current = current.next;
        }
        System.out.println(sb.toString());
    }

     

    public static Node mergeTwoLists(Node l1, Node l2) { 
        // maintain an unchanging reference to node ahead of the return node.
        Node prehead = new Node(-1);

        Node prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // At least one of l1 and l2 can still have nodes at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

}