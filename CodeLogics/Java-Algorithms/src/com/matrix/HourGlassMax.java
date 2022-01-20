package com.matrix;

public class HourGlassMax {

    public static void main(String... args) throws Exception {
        int[][] mat = {
                { 1, 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 0, 0 },
                { 1, 1, 1, 0, 0, 0 },
                { 0, 0, 2, 4, 4, 0 },
                { 0, 0, 0, 2, 0, 0 },
                { 0, 0, 1, 2, 4, 0 } };
        maxHourGlassSum(mat);
        System.out.println("==================");
        int[][] mat2 = {
                { -9, -9, -9, 1, 1, 1 },
                { 0, -9, 0, 4, 3, 2 },
                { -9, -9, -9, 1, 2, 3 },
                { 0, 0, 8, 6, 6, 0 },
                { 0, 0, 0, -2, 0, 0 },
                { 0, 0, 1, 2, 4, 0 } };
        maxHourGlassSum(mat2);
    }

public static void maxHourGlassSum(int[][] arr) {
    int[][] org = arr.clone();
    int row = arr.length;
    int col = arr[0].length;
    System.out.println(row + " x " + col);
    int maxSum = Integer.MIN_VALUE;
    int sum = 0;

    for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
            System.out.print(org[i][j] + " ");
        }
        System.out.println();
    }

for (int i = 0; i < row; i++) {
    for (int j = 0; j < col; j++) {

    if (i > 1 && j > 1) {
        sum = arr[i][j] + arr[i][j - 1] + arr[i][j - 2]
                        + arr[i - 1][j - 1]
            + arr[i - 2][j] + arr[i - 2][j - 1] + arr[i - 2][j - 2];

        System.out.print(sum + " ");

        if (sum > maxSum) {
            maxSum = sum;
        }
    }
    }
    System.out.println();
}
    System.out.println("maxSum is:" + maxSum);
}

}