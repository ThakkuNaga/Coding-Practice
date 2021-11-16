package com.utils;

import java.util.Arrays;

import com.linkedlist.Node;

public class Utils {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        String[] str = { "a", "b", "c", "d" };
        prtArr(nums);
        prtArr(str);
        prt2D(mat);
        prtMatArr(mat);
    }

    public static void prtArr(int[] nums) {
        System.out.println(Arrays.toString(nums));
        System.out.println();
    }

    public static void prtBin(int num) {
        if (num >= 8)
            System.out.print(String.format("%04d", Integer.parseInt(Integer.toBinaryString(num))));

        System.out.print(String.format("%03d", Integer.parseInt(Integer.toBinaryString(num))));
        //System.out.println();
    }

    public static String getBin(int num) {
        if (num >= 8)
            return String.format("%04d", Integer.parseInt(Integer.toBinaryString(num)));

        return String.format("%03d", Integer.parseInt(Integer.toBinaryString(num)));
    }

    public static void prt2D(int[][] mat) {
        for (int[] row : mat)
            System.out.println(Arrays.toString(row));
        System.out.println();

        // Loop through all rows
        // for (int i = 0; i < mat.length; i++)
        // // Loop through all elements of current row
        // for (int j = 0; j < mat[i].length; j++)
        // System.out.print(mat[i][j] + " ");

    }

    public static void prtMatArr(int[][] mat) {
        System.out.println(Arrays.deepToString(mat));
        System.out.println();
    }

    public static void prtArr(String[] inp) {
        System.out.println(Arrays.toString(inp));
        System.out.println();
    }

    public static void prtArr(char[] inp) {
        System.out.println(Arrays.toString(inp));
        System.out.println();
    }

     public static void prtLn(Object obj) {
         System.out.println(obj);
     }

     public static void prtLn(Object obj1,Object obj2) {
        System.out.println(obj1);
        System.out.println(obj2);
    }

    public static void prt(Object obj) {
         System.out.print(obj+" ");
    }

    public static void prt(Object obj1,Object obj2) {
        System.out.print(obj1+" ");
        System.out.print(obj2+" ");
   }

    // public static void prtLst(SinglyLinkedList Llist) {
    // Node head = Llist.head;
    // StringBuilder sb = new StringBuilder();
    // sb.append(head.val+"->");
    // Node current = head.next;
    // while(current!=null){
    // sb.append(current.val+"->");
    // current = current.next;
    // }
    // System.out.println(sb.toString());
    // }

    public static void prtLst(Node head) {
        StringBuilder sb = new StringBuilder();
        if (head != null) {
            sb.append(head.val + "->");
            Node current = head.next;
            while (current != null) {
                sb.append(current.val + "->");
                current = current.next;
            }
            System.out.println(sb.toString());
        }
    }

}