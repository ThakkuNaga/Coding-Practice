package com.search;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int target = 8;
        int[] arr = { 1, 3, 5, 6, 7 ,8 };

        System.out.println(Arrays.toString(arr));
        System.out.println(findKey(arr, target));
    }

    public static int findKey(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {

            mid = left + ((right - left) / 2);
            int midVal = nums[mid];

            if (target > midVal ) {
                left = mid + 1;
            } else if (target < midVal) {
                right = mid - 1;
            } else {
                return mid; // key found
            }
        }
        return left; // key not found
    }

}