package com.leetcode.easy;

import java.util.Arrays;

class SortColors {

    /*
     * 75. Sort Colors
     * 
     * Given an array nums with n objects colored red, white, or blue,
     * sort them in-place so that objects of the same color are
     * adjacent, with the colors in the order red, white, and blue.
     * 
     * We will use the integers 0, 1, and 2 to represent the color
     * red, white, and blue, respectively.
     * 
     * You must solve this problem without using the library's
     * sort function.
     * 
     * Input: nums = [2,0,2,1,1,0]
     * Output: [0,0,1,1,2,2]
     * 
     * Input: nums = [2,0,1]
     * Output: [0,1,2]
     */

    public static void main(String[] args) {
        int nums[] = { 2, 0, 2, 1, 1, 0 };
        System.out.println(Arrays.toString(nums));

        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        // 1-pass
        int p1 = 0, p2 = nums.length - 1, index = 0;
        while (index <= p2) {
            if (nums[index] == 0) {
                nums[index] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            if (nums[index] == 2) {
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                index--;
            }
            index++;
        }
    }
}