package com.array;

import java.util.Arrays;

/*
  Java program for
  Segregate even and odd numbers in array
*/
public class SegregateOddEven {

    public static void main(String[] args) {
        int[] arr1 = { 1, 8, 7, 3, 9, 4, 2, 5, 10 };
        System.out.println(Arrays.toString(arr1));
        segregateElement(arr1, arr1.length);
        System.out.println(Arrays.toString(arr1));

        System.out.println();
        
        int[] arr2 = { 9, 8, 2, 7, 6, 2, 4, 9, 7, 4 };
        System.out.println(Arrays.toString(arr2));
        segregateElement(arr2, arr2.length);
        System.out.println(Arrays.toString(arr2));
    }

    public static void segregateElement(int[] arr, int size) {
        int j = 0;

        for (int i = 0; i < size; ++i) {
            if (arr[i] % 2 == 0) {
                swap(arr, j, i);
                j++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}