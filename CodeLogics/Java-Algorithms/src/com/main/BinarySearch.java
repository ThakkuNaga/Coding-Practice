package com.main;

import com.utils.Utils;

class BinarySearch {

    public static void main(String... args) {

        int target = 98;
        int[] nums = { 0, 5, 13, 19, 22, 41, 55, 68, 72, 81, 98};

        Utils.prtArr(nums);
        System.out.println(findVal(nums, target));        

    }

    private static int findVal(int[] nums, int target) {
        int N = nums.length;
        int left = 0, right = N - 1, pivot;

        while (left <= right) {
            pivot = (left + (right - left) / 2);

            if (target == nums[pivot]) {
                return pivot;
            }

            if (target < nums[pivot]) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }

       return left;

    }

}