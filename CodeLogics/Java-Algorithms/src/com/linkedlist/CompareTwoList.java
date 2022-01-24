package com.linkedlist;

import com.utils.Utils;

class CompareTwoList {

    public static void main(String[] args) {
        int[] num1 = { 2, 4, 3 };
        int[] num2 = { 2, 4, 3 };

        Node lL1 = new SinglyLinkedList().CreateLinkedList(num1);
        Node lL2 = new SinglyLinkedList().CreateLinkedList(num2);

        Utils.prtLst(lL1);
        Utils.prtLst(lL2);

        Utils.prt(compareLists(lL1, lL2));
    }

    static int compareLists(Node head1, Node head2) {
        while (head1 != null && head2 != null && head1.val == head2.val) {
            head1 = head1.next;
            head2 = head2.next;
        }
        return (head1 == head2) ? 1 : 0;

    }

}