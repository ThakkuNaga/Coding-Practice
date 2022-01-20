package com.linkedlist;

import com.utils.Utils;

class AddTwoNumbers {

    /*
     * Add Two Numbers
     * You are given two non-empty linked lists representing two non-negative
     * integers. The digits are stored in reverse order, and each of their nodes
     * contains a single digit. Add the two numbers and return the sum as a linked
     * list.
     * 
     * You may assume the two numbers do not contain any leading zero, except the
     * number 0 itself.
     * 
     * Example 1:
     * Input: l1 = [2,4,3],
     *        l2 = [5,6,4]
     * Output:     [7,0,8]
     * Explanation:342 + 465 = 807.
     */

    public static void main(String[] args) {
        int[] num1 = { 2, 4, 3 };
        int[] num2 = { 5, 6, 4, 5 };

        Node lL1 = new SinglyLinkedList().CreateLinkedList(num1);
        Node lL2 = new SinglyLinkedList().CreateLinkedList(num2);

        Utils.prtLst(lL1);
        Utils.prtLst(lL2);

        Utils.prtLst(addTwoNumbers(lL1, lL2));
    }

    private static Node addTwoNumbers(Node l1, Node l2) {
        Node prev = new Node(0);
        Node head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            Node cur = new Node(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;
            

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }

    public static Node addTwoNumbers2(Node l1, Node l2) {
        Node head = l1 != null ? l1 : l2;
        Node tail = head;
        
        int sum = 0;
        int carry = 0;
        
        while (l1 != null || l2 != null) {
            sum = carry + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            tail.val = sum % 10;
            carry = sum / 10;
            
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
            
            tail.next = l1 != null ? l1 : l2 != null ? l2 : carry != 0 ? new Node(carry) : null;
            tail = tail.next;
        }
        
        return head;
    }

}