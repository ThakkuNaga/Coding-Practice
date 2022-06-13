package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/*
1023. Camelcase Matching

For each string, macth it with the pattern and pass the result.
The match process uses i for query pointer and j for pattern pointer, each iteration;

If current char query[i] matches pattern[j], increase pattern pointer;
if does not match and query[i] is lowercase, keep going;
if does not match and query[i] is captalized, we should return false.
If this pattern matches, j should equal length of pattern at the end.

Use new ArrayList<>(queries.length) to allocate capacity up-front. This can avoid resizing and copying as the size of the array grows.
queryArr[i] >= 'A' && queryArr[i] <= 'Z' can be replaced by built-in static method Character.isUpperCase().

*/

class CamelMatch {

    public static void main(String[] args) {
        String queries[] = { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" },
                pattern = "FB";
        System.out.println(camelMatch(queries, pattern));
    }

    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();

        char[] patternArr = pattern.toCharArray();
        for (String query : queries) {
            boolean isMatch = match(query.toCharArray(), patternArr);
            res.add(isMatch);
        }

        return res;
    }

    private static boolean match(char[] queryArr, char[] patternArr) {
        int j = 0;
        for (int i = 0; i < queryArr.length; i++) {
            if (j < patternArr.length && queryArr[i] == patternArr[j]) {
                j++;
            } else if (queryArr[i] >= 'A' && queryArr[i] <= 'Z') {
                return false;
            }
        }

        return j == patternArr.length;
    }
}
