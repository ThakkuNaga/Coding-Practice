package com.array;

import com.utils.Utils;

public class SortedSquareArray {

    public static void main(String[] args) {
        int[] nums = { -6, -4, 1, 2, 3, 5 };
        // 0 1 2 3 4 5
        Utils.prtArr(sortedSquareArray(nums));

    }

    public static int[] sortedSquareArray(int[] nums) {
        int N = nums.length;
        int[] result = new int[N];

        int L = 0;
        int R = N - 1;
        for (int i = N - 1; i >= 0; i--) {

            if (Math.abs(nums[L]) > nums[R]) {
                result[i] = nums[L] * nums[L];
                L++;
            } else {
                result[i] = nums[R] * nums[R];
                R--;
            }

        }

        return result;
    }

}