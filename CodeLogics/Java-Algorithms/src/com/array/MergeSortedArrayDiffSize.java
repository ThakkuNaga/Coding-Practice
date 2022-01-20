package com.array;

import java.util.Arrays;

public class MergeSortedArrayDiffSize {
    public static void main(String[] args) {

        // O(n log n) for unsorted arrays
        // O(n) for sorted arrays
        int[] arr1 = { 1, 3, 5, 7, 9 };
        int[] arr2 = { 2, 4, 6, 8, 10, 11, 12, 16 };
        mergeSortedArray(arr1, arr1.length, arr2, arr2.length);
    }

    public static void mergeSortedArray(int[] arr1, int s1, int[] arr2, int s2) {

        int[] res = new int[s1 + s2];

        int i = 0, j = 0, k = 0;
        while (i < s1 && j < s2) {

            if (arr1[i] < arr2[j]) {
                res[k++] = arr1[i++];
            } else {
                res[k++] = arr2[j++];
            }
        }
        while (i < s1)
            res[k++] = arr1[i++];
        while (j < s2)
            res[k++] = arr2[j++];

        System.out.println(Arrays.toString(res));

    }

}
