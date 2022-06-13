package com.leetcode.medium;

import java.util.Arrays;

public class InPlaceSort {

    public static void main(String[] args) {

        int nums[] = { 4, 5, 3, 2, 1, 6 };
        System.out.println(Arrays.toString(nums));

        inPlaceSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void bubbleSort(int[] array) {
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < array.length - j; i++) {
                if (array[i] > array[i + 1]) {
                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }

    private static void inPlaceSort(int[] nums, int left, int right) {
        if (left >= right)
            return;
        int pivot = nums[left + (right - left) / 2];
        int partitionIdx = partition(nums, left, right, pivot);
        inPlaceSort(nums, left, partitionIdx - 1);
        inPlaceSort(nums, partitionIdx, right);
    }

    private static int partition(int[] nums, int left, int right, int pivot) {
        while (left <= right) {

            while (nums[left] < pivot)
                left++;
            while (nums[right] > pivot)
                right--;

            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

}