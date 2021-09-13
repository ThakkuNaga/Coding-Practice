package com.linkedlist;

import com.utils.Utils;

public class RemoveElementFrmList {
    public static void main(String[] args) {

        Node head = new SinglyLinkedList().CreateLinkedList(new int[] { 1, 2, 6, 3, 4, 5, 6 });
        Utils.prtLst(head);
        int val = 6;

        Utils.prtLst(removeElementFrmList(head, val));

    }

    public static Node removeElementFrmList(Node head, int val) {
        Node preHead = new Node(0);
        preHead.next = head;

        Node prev = preHead, curr = head;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return preHead.next;
    }

}