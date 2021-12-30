package com.array.medium;

import java.util.HashMap;

public class LongestArithSeqLength {

    /*
     * 1027. Longest Arithmetic Subsequence
     * 
     * Given an array nums of integers, return the length of the longest arithmetic
     * subsequence in nums.
     * 
     * Recall that a subsequence of an array nums is a list nums[i1], nums[i2], ...,
     * nums[ik] with 0 <= i1 < i2 < ... < ik <= nums.length - 1, and that a sequence
     * seq is arithmetic if seq[i+1] - seq[i] are all the same value (for 0 <= i <
     * seq.length - 1).
     * 
     * Input: nums = [3,6,9,12]
     * Output: 4
     * Explanation:
     * The whole array is an arithmetic sequence with steps of length = 3.
     * 
     * Input: nums = [9,4,7,2,10]
     * Output: 3
     * Explanation:
     * The longest arithmetic subsequence is [4,7,10].
     * 
     * Input: nums = [20,1,15,3,10,5,8]
     * Output: 4
     * Explanation:
     * The longest arithmetic subsequence is [20,15,10,5].
     * 
     */
    public static void main(String... args) throws Exception {
        int[] nums = { 1, 2, 3, 5 };
        System.out.println(longestArithSeqLength(nums));
    }

    // dp[index][diff] equals to the length of arithmetic sequence at index with
    // difference diff.
    public static int longestArithSeqLength(int[] A) {
        int res = 2, n = A.length;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for (int j = 0; j < A.length; j++) {
            dp[j] = new HashMap<>();
            for (int i = 0; i < j; i++) {
                int d = A[j] - A[i];
                dp[j].put(d, dp[i].getOrDefault(d, 1) + 1);
                res = Math.max(res, dp[j].get(d));
            }
        }
        return res;
    }

}