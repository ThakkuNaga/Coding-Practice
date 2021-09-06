package com.array;

import com.utils.Utils;

public class RoatateArray {

    public static void main(String[] args) {

        int k = 3;
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        // nums = { 1, 1, 2 };
        Utils.prtArr(nums);
       // roatateArray(nums, k);
       // Utils.prtArr(nums);

        rotate(nums, k);
    }

    // Approach #1 (reverse) [Accepted]
    public static void roatateArray(int[] nums, int k) {
        k %= nums.length; // makes sure that k is less than the length of the array.
        reverse(nums, 0, nums.length - 1); // 7 6 5 4 3 2 1
        reverse(nums, 0, k - 1); // 4 3 2 1 5 6 7
        reverse(nums, k, nums.length - 1); // 5 6 7 1 2 3 4
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // Approach #2 (Extra array) [Accepted]
    public static void rotate(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

}