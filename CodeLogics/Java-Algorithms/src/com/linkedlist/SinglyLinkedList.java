package com.linkedlist;

public class SinglyLinkedList {
    public Node head;

    public Node getHead() {
        if (head == null) {
            head = new Node();
        }
        return head;
    }

    public void append(int val) {
        if (head == null) {
            head = new Node(val);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(val);
    }

    public void prepend(int val) {
        Node newHead = new Node(val);
        newHead.next = head;
        head = newHead;
    }

    public void deleteNodeVal(int val) {
        if (head == null)
            return;
        if (head.val == val) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public Node CreateLinkedList(int[] inp) {
        Node head = null;
        for (int i = inp.length - 1; i >= 0; i--) {
            Node newHead = new Node(inp[i]);
            newHead.next = head;
            head = newHead;
        }
        return head;
    }

}
