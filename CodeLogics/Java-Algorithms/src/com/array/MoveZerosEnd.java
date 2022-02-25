package com.array;

import java.util.Arrays;

/*
  Java program for
  Move all zeroes to end of array
*/
public class MoveZerosEnd {

    public static void main(String[] args) {
        int[] arr = { 0, 1, 4, 7, 2, 2, 1, 2, 0, 0, 6, 0, 1, 1, 0 };
        int n = arr.length;

        prt(arr);
        moveZeroToEnd(arr, n);
        prt(arr);
    }

    public static void moveZeroToEnd(int[] arr, int n) {
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (arr[right] == 0) {
                right--;
            } else if (arr[left] == 0) {
                swap(arr, left, right);
                left++;
                right--;
            } else {
                left++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void prt(int[] arr) {
        System.out.print(Arrays.toString(arr));
        System.out.println();
    }

}