package com.string;

import java.util.HashMap;
import java.util.Map;

public class MatchingStrings {

    public static void main(String[] args) {

        String[] strs = { "ab", "ab", "abc" };
        String[] queries = { "ab", "abc", "bc" };
        matchingStrings(strs, queries);
    }

    public static void matchingStrings(String[] strs, String[] queries) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < strs.length; i++) {
            if (map.containsKey(strs[i])) {
                map.put(strs[i], map.getOrDefault(strs[i], 0) + 1);
            } else {
                map.put(strs[i], 1);
            }
        }

        for (int i = 0; i < queries.length; i++) {
            Integer count = map.get(queries[i]);
            System.out.println(count == null ? 0 : count.intValue());
        }

    }
}
