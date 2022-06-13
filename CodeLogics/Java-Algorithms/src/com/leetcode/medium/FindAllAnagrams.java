package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

class FindAllAnagrams {
    public static void main(String[] args) {

        String s = "cbaebabacd", p = "abc";
        List<Integer> rst = findAllAnagrams(s, p);
        System.out.println(rst);

    }

    private static List<Integer> findAllAnagrams(String s, String p) {
        /// We will use sliding window template
        ArrayList<Integer> soln = new ArrayList<Integer>();

        if (s.length() == 0 || p.length() == 0 || s.length() < p.length()) {
            return new ArrayList<Integer>();
        }

        int[] chars = new int[26];
        for (Character c : p.toCharArray())
            chars[c - 'a']++;

        int start = 0, end = 0, len = p.length(), diff = len; 
        char temp;
        for (end = 0; end < len; end++) {

            temp = s.charAt(end);
            chars[temp - 'a']--;
            if (chars[temp - 'a'] >= 0) {
                diff--;
            }
        }

        if (diff == 0) {
            soln.add(0);
        }

        while (end < s.length()) {

            temp = s.charAt(start);
            if (chars[temp - 'a'] >= 0) {
                diff++;
            }
            chars[temp - 'a']++;
            start++;
            
            temp = s.charAt(end);
            chars[temp - 'a']--;

            if (chars[temp - 'a'] >= 0) {
                diff--;
            }
            if (diff == 0) {
                soln.add(start);
            }
            end++;
        }
        return soln;
    }

}