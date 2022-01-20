package com.search;

import java.util.Arrays;

public class BinarySearch1 {

    public static void main(String... args) {

        int target = 88;
        int n = 100;
        int arr[] = new int[n];

        // Adding elements in the array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(findVal(arr, target));

    }

    static int findVal(int[] arr, int target) {
        int N = arr.length;
        int left = 0, right = N - 1, pivot;

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