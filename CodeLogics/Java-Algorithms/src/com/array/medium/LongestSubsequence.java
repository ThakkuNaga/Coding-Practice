package com.array.medium;

import java.util.HashMap;

public class LongestSubsequence {

    /*
     * 1218. Longest Arithmetic Subsequence of Given Difference
     * 
     * Given an integer array arr and an integer difference,
     * return the length of the longest subsequence in arr which is an
     * arithmetic sequence such that the difference between adjacent elements
     * in the subsequence equals difference.
     * 
     * A subsequence is a sequence that can be derived from arr by deleting some
     * or no elements without changing the order of the remaining elements.
     * 
     * Input: arr = [1,2,3,4], difference = 1
     * Output: 4
     * Explanation: The longest arithmetic subsequence is [1,2,3,4].
     * 
     * Input: arr = [1,5,7,8,5,3,4,2,1], difference = -2
     * Output: 4
     * Explanation: The longest arithmetic subsequence is [7,5,3,1].
     * 
     */
    public static void main(String... args) throws Exception {
        int[] nums1 = { 1, 2, 3, 5 };
        int k = 1;
        System.out.println(longestSubsequence(nums1, k));
    }

    public static int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int longest = 0;
        for (int i = 0; i < arr.length; i++) {
            dp.put(arr[i], dp.getOrDefault(arr[i] - difference, 0) + 1);
            longest = Math.max(longest, dp.get(arr[i]));
        }
        return longest;
    }

}