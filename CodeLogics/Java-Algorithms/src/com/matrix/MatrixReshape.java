package com.matrix;

import com.utils.Utils;

public class MatrixReshape {
    public static void main(String[] args) {

        int[][] matrix = { { 1, 2 }, { 3, 4 } };
        int r = 1, c = 4;

        Utils.prt2D(matrix);
        //Utils.prtArr(matrix);        
        Utils.prt2D(matrixReshape(matrix, r, c));

    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        if (nums.length == 0 || r * c != nums.length * nums[0].length)
            return nums;
        int rows = 0, cols = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                res[rows][cols] = nums[i][j];
                cols++;
                if (cols == c) {
                    rows++;
                    cols = 0;
                }
            }
        }
        return res;
    }

}