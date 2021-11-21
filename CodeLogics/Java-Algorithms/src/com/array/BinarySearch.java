package com.array;

import com.utils.Utils;

public class BinarySearch {
    public static void main(String[] args) {

        int target = 6;
        int[] nums = { 1, 3, 5, 6 };

        Utils.prtArr(nums);
        System.out.println(searchInsert(nums, target));
        //Utils.prtArr(nums);

    }

    public static int searchInsert(int[] nums, int target) {

        int mid, left = 0, right = nums.length - 1;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

}