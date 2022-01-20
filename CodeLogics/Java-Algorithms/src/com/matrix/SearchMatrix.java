package com.matrix;

import com.utils.Utils;

public class SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                    { 1, 3, 5, 7 },
                    { 10, 11, 16, 20 }, 
                    { 23, 30, 34, 60 } };
        int target = 16;

        Utils.prt2D(matrix);
        Utils.prtMatArr(matrix);
        System.out.println(searchMatrix(matrix, target));
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int pivot, left = 0;
        int right = (m * n) - 1;

        while (left <= right) {

            pivot = left + (right - left) / 2;
            System.out.print("pivot: " + pivot + " ");

            int pivot_val = matrix[pivot / n][pivot % n];
            System.out.println("Mid val: " + pivot_val);

            if (target == pivot_val)
                return true;

            if (target < pivot_val) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }

        }

        return false;
    }

}