package com.matrix;

import com.utils.Utils;

class MatrixElementSum {

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 1, 1, 2 },
                { 0, 5, 0, 0 },
                { 2, 0, 3, 3 } };
        Utils.prt("Sum: " + matrixElementsSum(matrix));
    }

    static int matrixElementsSum(int[][] matrix) {

        System.out.println("Rows: " + matrix.length + " Cols: " + matrix[0].length);

        int sum = 0;
        for (int c = 0; c < matrix[0].length; c++) {
            for (int r = 0; r < matrix.length; r++) {
                sum += matrix[r][c];
                System.out.print(matrix[r][c] + " ");
                if (matrix[r][c] == 0)
                    break;
            }
            System.out.println();
        }
        return sum;

    }

}