package com.leetcode.easy;

class CountOfChars {
    public static void main(String[] args) {

        String s = "dog";
        countOfChars(s);
    }

    private static void countOfChars(String s) {
        int nonACount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != 'a' && s.charAt(i) != 'A') {
                ++nonACount;
            }
        }
        // Get the count of a's in the string
        int aCount = s.length() - nonACount;
        System.out.println(
                (nonACount * 2 + 2) - aCount);
    }

}