package com.linkedlist;

import com.utils.Utils;

public class DeleteDuplicates {
    public static void main(String[] args) {

        Node head =  new SinglyLinkedList().CreateLinkedList(new int[] { 1, 5, 5, 5, 6, 7, 7 });
        Utils.prtLst(head);

        Utils.prtLst(deleteDuplicates(head));

    }

    public static Node deleteDuplicates(Node head) {

        Node current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;

    }

}