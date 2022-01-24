package com.string.easy;

import java.util.TreeMap;
import java.util.TreeSet;

public class SortString {

    /*
     * You are given a string s. Reorder the string using the following algorithm:
     * 
     * 1.Pick the smallest character from s and append it to the result.
     * 2.Pick the smallest character from s which is greater than the last appended
     * 3.Repeat step 2 until you cannot pick more characters.
     * 4.Pick the largest character from s and append it to the result.
     * 5.Pick the largest character from s which is smaller than the last appended
     * 6.Repeat step 5 until you cannot pick more characters.
     * Repeat the steps from 1 to 6 until you pick all characters from s.
     * In each step, If the smallest or the largest character appears more than once
     * you can choose any occurrence and append it to the result.
     */

    public static void main(String... args) throws Exception {
        String s = "aabbcczz";
        System.out.println(sortString(s));
    }

    public static String sortString(String s) {
        int[] chars = new int[26];

        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();

        while (sb.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (chars[i] != 0) {
                    sb.append((char) (i + 'a'));
                    chars[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (chars[i] != 0) {
                    sb.append((char) (i + 'a'));
                    chars[i]--;
                }
            }
        }

        return sb.toString();
    }

    public String sortString2(String s) {
        StringBuilder ans = new StringBuilder();
        int[] count = new int[26];
        for (char c : s.toCharArray())
            ++count[c - 'a'];
        while (ans.length() < s.length()) {
            add(count, ans, true);
            add(count, ans, false);
        }
        return ans.toString();
    }

    private void add(int[] cnt, StringBuilder ans, boolean asc) {
        for (int i = 0; i < 26; ++i) {
            int j = asc ? i : 25 - i;
            if (cnt[j]-- > 0)
                ans.append((char) (j + 'a'));
        }
    }

    public String sortString3(String s) {
        StringBuilder ans = new StringBuilder();
        TreeMap<Character, Integer> tm = new TreeMap<>();
        for (char c : s.toCharArray()) {
            tm.put(c, 1 + tm.getOrDefault(c, 0));
        }
        boolean asc = true;
        while (!tm.isEmpty()) {
            for (char c : asc ? new TreeSet<>(tm.keySet()) : new TreeSet<>(tm.descendingKeySet())) {
                ans.append(c);
                tm.put(c, tm.get(c) - 1);
                tm.remove(c, 0);
            }
            asc = !asc; // same as asc ^= true;
        }
        return ans.toString();
    }

}