package com.array.easy;
/*
 * Given an unsorted array of numbers, find the length of the longest sequence
 * of consecutive numbers in the array
 * 
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ConsecutiveArray {

    public static void main(String[] args) {
        // assert consecutive(new int[] { 1, 2, 3, 4, 5 }) == 5 : "Single sequence,sorted order";
        // assert consecutive(new int[] { 5, 4, 3, 2, 1 }) == 5 : "Single sequence,unsorted order";
        // assert consecutive(new int[] { 1, 2, 4, 5, 6 }) == 3 : "Multiple sequences,sorted order";
        // assert consecutive(new int[] { 2, 4, 1, 6, 5 }) == 3 : "Multiple sequences,unsorted order";
        // assert consecutive(new int[] { 100, 4, 200, 1, 3, 2 }) == 4 : "Multiple sequences, unsorted order";
        // System.out.println("Passed all test cases");

        int[] a = { 100, 4, 200, 1, 3, 2 };
        System.out.println(longestConsecutive2(a));
    }

    public static int longestConsecutive(int[] nums) { // O(n)
        if (nums == null || nums.length == 0)
            return 0;
        Set<Integer> set = new HashSet<>();
        for (int i : nums)
            set.add(i);
        int ans = 0;
        for (int num : nums) {
            int left = num - 1;
            int right = num + 1;
            while (set.remove(left))
                left--;
            while (set.remove(right))
                right++;
            ans = Math.max(ans, right - left - 1);
            if (set.isEmpty())
                return ans;// save time if there are items in nums, but no item in hashset.
        }
        return ans;
    }

    public static int longestConsecutive2(int[] nums) { // O(nlgn);
        if (nums.length == 0) {
            return 0;
        }
        int max = 1;
        int count = 1;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else if (nums[i] != nums[i - 1]) {
                max = Math.max(max, count);
                count = 1;
            }

        }
        return Math.max(max, count);
    }

    public static int consecutive(int[] a) {
        // Put all the values into a HashSet
        HashSet<Integer> values = new HashSet<>();
        for (int i : a) {
            values.add(i);
        }

        // For each value, check if its the first in a sequence of consecutive
        // numbers and iterate through to find the length of the consecutive
        // sequence
        int maxLength = 0;
        for (int i : values) {
            // If it is not the leftmost value in the sequence, don't bother
            if (values.contains(i - 1))
                continue;
            int length = 0;

            // Iterate through sequence
            while (values.contains(i++))
                length++;
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }

}