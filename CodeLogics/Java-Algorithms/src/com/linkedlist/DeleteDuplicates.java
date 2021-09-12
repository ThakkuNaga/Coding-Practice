package com.linkedlist;

import com.utils.Utils;

public class DeleteDuplicates {
    public static void main(String[] args) {
        // [1,1,2]
        // [1,1,1]
        // [1,1,2,3,3]

        Node head = new SinglyLinkedList().CreateLinkedList(new int[] { 1, 1, 1 });
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