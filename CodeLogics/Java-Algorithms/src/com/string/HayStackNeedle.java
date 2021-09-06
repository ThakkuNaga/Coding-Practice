package com.string;

public class HayStackNeedle {

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(strStr(haystack, needle));

    }

    private static int strStr(String haystack, String needle) {

        int m = haystack.length();
        int n = needle.length();
        if (n == 0) {
            return 0;
        }
        if (n > m) {
            return -1;
        }

        for (int i = 0; i < m - n + 1; i++) {
            if (haystack.substring(i, i + n).equals(needle)) {
                return i;
            }
        }
        return -1;

        // for (int i = 0;; i++) {
        // for (int j = 0;; j++) {

        // if (j == needle.length()) {
        // return i;
        // }
        // if (i + j == haystack.length()) {
        // return -1;
        // }
        // if (needle.charAt(j) != haystack.charAt(i + j)) {
        // break;
        // }
        // }
        // }
    }
}