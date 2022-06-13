package com.linkedlist;

import com.utils.Utils;

public class ReverseLinkedList {
    public static void main(String[] args) {

        Node head = new SinglyLinkedList().CreateLinkedList(new int[] { 1, 2, 3, 4 });
        Utils.prtLst(head);
        Utils.prtLst(reverseList(head));
        //reversePrint(head);
        //Utils.prtLst(reverseList2(head));
    }
    
    //Approach #1 (Iterative)
    public static Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node tmpNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmpNext;
        }
        return prev;
    }
    
    //Approach #2 (Recursive)
    public static Node reverseList2(Node head) {
        if (head == null || head.next == null)
            return head;
        Node p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void reversePrint(Node head) {
        
        if(head == null) return;
        reversePrint(head.next);
        System.out.print(head.val+" ");

        // OR

        if (head != null) {
        reversePrint(head.next);
        System.out.print(head.val+" "); 
        }

    }

}