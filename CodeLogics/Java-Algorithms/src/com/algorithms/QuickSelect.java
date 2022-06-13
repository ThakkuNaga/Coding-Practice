package com.algorithms;

import java.util.Arrays;

public class QuickSelect {
    public static void main(String[] args) {
        int[] arr = { 4, 5, 10, 11, 1, 3, 19, 8, 7 };
        System.out.println("3rd largest->"+ getKthSmallestElement(arr, (int) 1, (int) 0, arr.length - 1));
        System.out.println(Arrays.toString(arr));
    }

    private static int getKthSmallestElement(int[] arr, int k, int left, int right) {
        int pivotPoint = getPivotPoint(arr, left, right);
        if (pivotPoint == k - 1) {
            return arr[pivotPoint];
        } else if (pivotPoint < k - 1) {
            return getKthSmallestElement(arr, k, pivotPoint + 1, right);
        } else {
            return getKthSmallestElement(arr, k, left, pivotPoint - 1);
        }

    }

    private static int getPivotPoint(int[] arr, int left, int right) {
        int pivotElement = arr[right];
        int pivotPoint = left;

        for (int i = left; i <= right; i++) {
            if (arr[i] > pivotElement) {
                int tmp = arr[i];
                arr[i] = arr[pivotPoint];
                arr[pivotPoint] = tmp;
                pivotPoint++;
            }

        }
        int tmp = arr[pivotPoint];
        arr[pivotPoint] = arr[right];
        arr[right] = tmp;

        return pivotPoint;
    }
}