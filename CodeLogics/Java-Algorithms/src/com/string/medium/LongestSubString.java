package com.string.medium;

import java.util.Arrays;

public class LongestSubString {

    /*
     * 395. Longest Substring with At Least K Repeating Characters
     * 
     * Given a string s and an integer k, return the length of the longest substring
     * of s such that the frequency of each character in this substring is greater
     * than or equal to k.
     * 
     * Input: s = "aaabb", k = 3
     * Output: 3
     * Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
     * 
     * Input: s = "ababbc", k = 2
     * Output: 5
     * Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and
     * 'b' is repeated 3 times.
     */

    public static void main(String... args) throws Exception {
        String s = "ababbc";
        System.out.println(longestSubstring(s, 2));
    }

    public static int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        int[] counts = new int[26];
        int h, i, j, idx, max = 0, unique, noLessThanK;

        for (h = 1; h <= 26; h++) {
            Arrays.fill(counts, 0);
            i = 0;
            j = 0;
            unique = 0;
            noLessThanK = 0;
            while (j < str.length) {
                if (unique <= h) {
                    idx = str[j] - 'a';
                    if (counts[idx] == 0)
                        unique++;
                    counts[idx]++;
                    if (counts[idx] == k)
                        noLessThanK++;
                    j++;
                } else {
                    idx = str[i] - 'a';
                    if (counts[idx] == k)
                        noLessThanK--;
                    counts[idx]--;
                    if (counts[idx] == 0)
                        unique--;
                    i++;
                }
                if (unique == h && unique == noLessThanK)
                    max = Math.max(j - i, max);
            }
        }

        return max;
    }
}