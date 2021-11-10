package com.array;

import com.utils.Utils;

public class SortedSquareArray {

    public static void main(String[] args) {
        int[] nums = { -6, -4, 1, 2, -3, -5 };
        // 0 1 2 3 4 5
        Utils.prtArr(sortedSquareArray(nums));
    }

    public static int[] sortedSquareArray(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];

        int left = 0;
        int right = len - 1;
        for (int i = len - 1; i >= 0; i--) {

            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[i] = nums[left] * nums[left];
                left++;
            } else {
                result[i] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }

}