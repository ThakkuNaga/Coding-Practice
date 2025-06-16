package com.utils;

import java.util.Arrays;
import java.util.List;

import com.linkedlist.Node;

public class Utils {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        String[] str = { "a", "b", "c", "d" };
        List<Integer> lst = Arrays.asList(1, 2, 3, 4, 5);
        prtArr(nums);
        prtArr(str);
        prt2D(mat);
        prtMatArr(mat);
        prtArr(lst);
    }

    public static void prtArr(int[] nums) {
        System.out.println(Arrays.toString(nums));
        System.out.println();
    }

    public static void prtChArr(String s) {
        char ch[] = s.toCharArray();
        System.out.println(Arrays.toString(ch));
        int j =0;
        for (char c : ch)
            System.out.print(" "+ ++j +" ");
            System.out.println();
    }

    public static void prtArrIdx(int[] nums) {
        System.out.println(Arrays.toString(nums));
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(i);
            int val = nums[i];
            int length = (int)(Math.log10(val)+1);
            if(i != nums.length-1){
                if(length>1)
                    System.out.print(",  ");
                else
                    System.out.print(", ");      
            }
                    
            if(i == nums.length-1)
                if(length>1)
                    System.out.print(" ");
                   

        }
        System.out.print("]");
        System.out.println();
    }

    public static void prtArrSrt(int[] nums) {
        Arrays.sort(nums);
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

    public void pt(Object obj) {
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

    public static void prtArr(List<Integer> lstOfIntegers) {
        StringBuilder sb = new StringBuilder();
        for (Integer i : lstOfIntegers) {
            sb.append(i + " ");
        }
        System.out.println(sb.toString());
    }

}