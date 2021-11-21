package com.matrix;

import java.util.ArrayList;
import java.util.List;

import com.utils.Utils;

public class DiagonalDifference {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 8, 9 } };
        Utils.prt2D(matrix);
        // Utils.prtMatArr(matrix);
        System.out.println(diagonalDifference(matrix));
        System.out.println(diagonalDifference());
    }

    private static int diagonalDifference(int[][] matrix) {
        int n = matrix.length;
        int lDig = 0; int rDig = 0;

        for (int i = 0; i < n; i++) {
            lDig += matrix[i][i];
            rDig += matrix[i][n - i - 1];
            // System.out.print(matrix[i][i]+" ");
            // System.out.print(matrix[i][n - i - 1]);
            // System.out.println();
        }

        System.out.println(lDig);
        System.out.println(rDig);

        int rst = Math.abs(lDig - rDig);
        return rst;
    }

    public static int diagonalDifference() {

        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        List<Integer> list3 = new ArrayList<Integer>();
        list3.add(9);
        list3.add(8);
        list3.add(9);

        arr.add(list1);
        arr.add(list2);
        arr.add(list3);

        System.out.println(arr);

        int lDig = 0, rDig = 0;
        int n = arr.size();
        //System.out.println(n);
        for (int i = 0; i < n; i++) {
            lDig += arr.get(i).get(i);
            rDig += arr.get(i).get(n - i - 1); 
        }
        System.out.println(lDig);
        System.out.println(rDig);
        return Math.abs(rDig - lDig);
    }
}