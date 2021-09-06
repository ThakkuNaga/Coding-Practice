package com.array;

import com.utils.Utils;

public class RoatateMatrix {

    public static void main(String[] args) {

        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        Utils.prt2D(matrix);
        Utils.prtArr(matrix);
        rotate2(matrix);
        Utils.prt2D(matrix);
        Utils.prtArr(matrix);
    }

    // Approach #1 (Rotate Groups of Four Cells) [Accepted]
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    // Approach #2 (Reverse on Diagonal and then Reverse Left to Right) [Accepted]

    public static void rotate2(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }

    public static void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }

    public static void reflect(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

}