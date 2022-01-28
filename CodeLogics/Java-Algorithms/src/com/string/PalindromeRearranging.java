package com.string;

import java.util.Arrays;

import com.utils.Utils;

public class PalindromeRearranging {

    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(solution(s));
    }

    static boolean solution(String str) {

        int count[] = new int[26];
        for (char c : str.toCharArray())
            count[c - 'a']++;

        Utils.prtArr(count);
        // Count odd occurring characters
        int odd = 0;
        for (int i : count)
            if (i % 2 != 0) {
                odd++;               
            }
        // Return true if odd count is 0 or 1,
        return odd<=1;

    }

}