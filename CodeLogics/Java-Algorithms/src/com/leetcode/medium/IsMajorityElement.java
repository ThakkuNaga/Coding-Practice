package com.leetcode.medium;

import java.util.Arrays;

class IsMajorityElement {
    /*
     * Check for Majority Element in a sorted array
     * 
     * we need to write a function say isMajority() that takes an array (arr[] ),
     * array’s size (n) and a number to be searched (x) as parameters and returns
     * true if x is a majority element (present more than n/2 times).
     * 
     */

    public static void main(String[] args) {

        int arr1[] = { 1, 2, 3, 3, 3, 3, 10 }, x1 = 3;
        int arr2[] = { 1, 1, 2, 4, 4, 4, 6, 6 }, x2 = 4;
        int arr3[] = { 1, 1, 1, 2, 2 }, x3 = 1;
        int arr4[] = { 2, 4, 5, 5, 5, 5, 5, 6, 6 }, x4 = 5;
        System.out.println("Inp: " + Arrays.toString(arr1) + " x:" + x1);
        System.out.println("Out: " + isMajority(arr1, x1));

        System.out.println("Inp: " + Arrays.toString(arr2) + " x:" + x2);
        System.out.println("Out: " + isMajority(arr2, x2));

        System.out.println("Inp: " + Arrays.toString(arr3) + " x:" + x3);
        System.out.println("Out: " + isMajority(arr3, x3));

        System.out.println("Inp: " + Arrays.toString(arr4) + " x:" + x4);
        System.out.println("Out: " + isMajority(arr4, x4));

        System.out.println("Inp: " + Arrays.toString(arr4) + " x:" + x4);
        System.out.println("Out: " + isMajority2(arr4, x4));

        System.out.println(arr4.length / 2);
    }

    public static boolean isMajority(int[] nums, int k) {
        int n = nums.length;
        int major = 0, cnt = 0;
        System.out.print("> " + n / 2+"  times ");

        for (int num : nums) {
            if (cnt == 0)
                major = num;

            // System.out.println("cnt: "+cnt+" nums[n / 2]:"+ nums[n / 2]);
            if (cnt > (n / 2))
                return true;

            if (num == major)
                cnt++;
            else
                cnt--;
        }

        return false;
    }

    public static boolean isMajority2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l + n / 2 < n && nums[l + n / 2] == target;
    }

}