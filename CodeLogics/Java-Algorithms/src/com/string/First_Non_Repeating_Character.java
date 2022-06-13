package com.string;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class First_Non_Repeating_Character {

    public static void main(String[] args) {
        String s = "aaabcccdeeef";
        s = "leetcode";
        System.out.println("firstUniqChar1: " + firstUniqChar1(s));
        System.out.println("firstUniqChar2: " + firstUniqChar2(s));
        // System.out.println("approach_1: " + approach_1(s));
        // System.out.println("approach_2: " + approach_2(s));
        // System.out.println("approach_3: " + approach_3(s));
    }

    public static int firstUniqChar1(String s) {
        int[] count = new int[26];
        char[] chars = s.toCharArray();

        // build char count bucket : <charIndex, count>
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            count[index]++;
        }

        // find the index
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (count[index] == 1)
                return i;
        }

        return -1;
    }

    public static int firstUniqChar2(String s) {
        int[] count = new int[26];
        // build char count bucket
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        // find the index
        for (int i = 0; i < s.length(); ++i) {
            if (count[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }

    public static char firstUniqChar3(String s) {
        Map<Character, Integer> LHP = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                if (LHP.get(s.charAt(i)) != null) {
                    LHP.remove(s.charAt(i));
                }
            } else {
                LHP.put(s.charAt(i), i);
                set.add(s.charAt(i));
            }
        }
        return LHP.size() == 0 ? ' ' : s.charAt(LHP.entrySet().iterator().next().getValue());
    }

    public static char approach_1(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return s.charAt(i);
            }
        }
        return '_';
    }

    public static char approach_2(String s) {
        int[] chars = new int[26];
        for (char c : s.toCharArray())
            chars[c - 'a']++;
        for (char c : s.toCharArray())
            if (chars[c - 'a'] == 1)
                return c;

        return '_';
    }

    public static char approach_3(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            else
                map.put(s.charAt(i), 1);
        }
        for (char c : map.keySet())
            if (map.get(c) == 1)
                return c;

        return '_';
    }

}