package com.search;

import java.util.Arrays;

public class BinarySearch1 {

    public static void main(String... args) {

        int target = 8;
        int n = 11;
        int arr[] = new int[n];

        // Adding elements in the array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(findVal(arr, target));

    }

    static int findVal(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;
        int pivot = 0;

        while (left <= right) {
            pivot = (left + (right - left) / 2);

            if (target == arr[pivot]) {
                return pivot;
            }

            if (target < arr[pivot]) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }

        return left;

    }

}