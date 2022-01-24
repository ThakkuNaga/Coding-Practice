package com.main;

public class Solution2 {

    public static void main(String... args) throws Exception {
        String s = "aabaa";
        System.out.println(solution(s));
    }

    static boolean solution(String s) {
        if (s.length() == 0)
            return false;
        if (s.length() == 1)
            return true;

        char[] chars = s.toCharArray();
        int j = s.length() - 1;
        int mid = s.length() / 2;
        for (int i = 0; i < chars.length; ++i) {
            if (j < mid)
                return true;
            if (chars[i] == chars[j]) {
                j--;
                continue;
            } else {
                return false;
            }
        }

        return false;
    }
}