package com.array;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {

        int target = 6;
        int[] arr = { 1, 3, 5, 6 };

        System.out.println(Arrays.toString(arr));
        System.out.println(searchInsert(arr, target));
    }

    public static int searchInsert(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left <= right) {

            mid = left + ((right - left) / 2);

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}