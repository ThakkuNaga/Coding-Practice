package com.array;

import com.utils.Utils;

public class SearchInsertPosition {

    public static void main(String[] args) {

        int[] nums = { 1, 3, 5, 6, 8, 9 };
        Utils.prtArr(nums);
        Utils.prtLn(searchInsert(nums, 7));
        
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if ( target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}