package com.array;

import java.util.Arrays;

// Move all negative elements at the end of array
public class MoveNegativeEnd {
    public static void main(String[] args) {
        int[] arr = { 1, -1, 3, 2, -7, -5, 11, 6 };
        int n = arr.length;
        System.out.println(Arrays.toString(arr));
        moveNegative(arr, n);
        System.out.println(Arrays.toString(arr));
    }

    public static void moveNegative(int[] arr, int n) {
        int i = 0;
        int j = n - 1;
        while (i < j) {
            if (arr[i] < 0 && arr[j] >= 0) {
                // When [i] index are have negative value
                // And [j] is positive then swapping elements values
                swap(arr, i, j);
                // Modified index
                i++;
                j--;
            } else if (arr[i] >= 0) {
                // When element of [i] is not negative
                i++;
            } else {
                j--;
            }
        }
    }

    public static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

}