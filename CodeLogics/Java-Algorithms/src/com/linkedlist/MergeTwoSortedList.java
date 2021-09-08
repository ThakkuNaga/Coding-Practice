package com.linkedlist;

import com.utils.Utils;

public class MergeTwoSortedList {
    public static void main(String[] args) {

        Node head1 = new SinglyLinkedList().CreateLinkedList(new int[] { 1, 2, 4 });
        Utils.prtLst(head1);

        Node head2 = new SinglyLinkedList().CreateLinkedList(new int[] { 1, 3, 4 });
        Utils.prtLst(head2);

        Utils.prtLst(mergeTwoLists(head1, head2));

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