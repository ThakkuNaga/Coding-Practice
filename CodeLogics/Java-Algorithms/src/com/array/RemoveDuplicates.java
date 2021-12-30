package com.array;

import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {

        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int[] nums2 = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        removeDuplicates(nums);
        System.out.println();
        removeDuplicates2(nums2);
    }

    // Approach #1 (2 pointers) [Accepted]
    public static int removeDuplicates(int[] nums) {

        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int i = 1;
        for (int j = 1; j < n; j++) {
            if (nums[j] != nums[j - 1]) {
                nums[i] = nums[j];
                i++;
            }
        }
        for (int j = 0; j < i; j++) {
            System.out.print(nums[j] + " ");
        }

        return i;
    }

    // Remove Duplicates from sorted Array without Xtra Space
    public static int removeDuplicates2(int[] arr) {
        int n = arr.length;
        int j = 0;
        for (int i = 0; i < n - 1; i++) {

            if (arr[i] != arr[i + 1]) {
                arr[j] = arr[i];
                j++;
            }
        }
        arr[j] = arr[n - 1];

        for (int i = 0; i <= j; i++) {
            System.out.print(arr[i] + " ");
        }

        return j + 1;
    }

    // Remove Duplicates from sorted Array with Xtra Space
    public static int removeDuplicates3(int[] nums) {

        int n = nums.length;
        int[] rstArr = new int[n];
        int j = 0;
        for (int i = 0; i < n - 1; i++) {

            if (nums[i] != nums[i + 1]) {
                rstArr[j] = nums[i];
                j++;
            }
        }
        rstArr[j] = nums[n - 1];
        System.out.println(Arrays.toString(rstArr));

        return j + 1;
    }

}