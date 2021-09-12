package com.linkedlist;

import java.util.HashSet;
import java.util.Set;

import com.utils.Utils;

public class Linked_List_Cycle {
    public static void main(String[] args) {

        Node head = new SinglyLinkedList().CreateLinkedList(new int[] { 3, 2, 0, -4 });
        Utils.prtLst(head);

        Utils.prt(hasCycle(head));
    }

    public static boolean hasCycle(Node head) {
        if (head == null) return false;
        
        Node slow = head;
        Node fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static boolean hasCycle2(Node head) { 
        Set<Node> nodesSeen = new HashSet<>(); 
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            }
            nodesSeen.add(head);
            head = head.next;
        }
        return false;
    }

}