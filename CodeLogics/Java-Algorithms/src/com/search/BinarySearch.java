package com.search;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int target = 9;
        int[] arr = { 1, 3, 5, 6, 7 ,8 };

        System.out.println(Arrays.toString(arr));
        System.out.println(findKey(arr, target));
    }

    public static int findKey(int[] arr, int key) {

        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left <= right) {

            mid = left + ((right - left) / 2);
            int midVal = arr[mid];

            if (midVal < key) {
                left = mid + 1;
            } else if (midVal > key) {
                right = mid - 1;
            } else {
                return mid; // key found
            }
        }
        return -(left + 1); // key not found
    }

}