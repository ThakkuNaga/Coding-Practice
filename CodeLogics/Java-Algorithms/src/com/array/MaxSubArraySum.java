package com.array;

import com.utils.Utils;

public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        Utils.prtLn(maxSumOfSubArr(nums));
    }
    /*
    Given an integer array nums, find the contiguous subarray (containing at least one number) 
    which has the largest sum and return its sum.A subarray is a contiguous part of an array.
    Example 1: Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6  Explanation: [4,-1,2,1] has the largest sum = 6.
    */

    // Kadane's Algorithm - Maximum Sum Subarray 
    public static Object maxSumOfSubArr(int[] nums) {

        int cur_sum = nums[0];
        int max_sum = cur_sum;
        for (int i = 1; i < nums.length; i++) {
            cur_sum = Math.max(cur_sum + nums[i], nums[i]);
            max_sum = Math.max(cur_sum, max_sum);
        }
        return max_sum;
    }

}