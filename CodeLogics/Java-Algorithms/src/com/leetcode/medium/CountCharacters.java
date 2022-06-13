package com.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;

// 1160. Find Words That Can Be Formed by Characters
/*
You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once).

Return the sum of lengths of all good strings in words.

 

Example 1:

Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation: The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
Example 2:

Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation: The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
*/

class CountCharacters {

    public static void main(String[] args) {
        String words[] = { "cat", "bt", "hat", "tree" }, chars = "atach";
        System.out.println(
                countCharacters(words, chars));
    }

    public static int countCharacters(String[] words, String chars) {
        if (chars == null || chars.isEmpty() || words == null || words.length == 0)
            return 0;

        int[] counts = new int[26];
        for (char ch : chars.toCharArray()) {
            ++counts[ch - 'a'];
        }

        System.out.println(Arrays.toString(counts));

        int res = 0;
        for (String w : words) {
            int[] wordCounts = new int[26];
            boolean possible = true;
            for (char ch : w.toCharArray()) {
                int idx = ch - 'a';
                ++wordCounts[idx];
                if (wordCounts[idx] > counts[idx]) {
                    possible = false;
                    break;
                }
            }

            if (!possible)
                continue;

            res += w.length();
            System.out.println(Arrays.toString(wordCounts));
        }
        
        return res;
    }

    public static int countCharacters1(String[] words, String chars) {
        int count = 0;
        int[] seen = new int[26];
		//Count char of Chars String
        for (char c : chars.toCharArray())
            seen[c - 'a']++;
		// Comparing each word in words
        for (String word : words) {
			// simple making copy of seen arr
            int[] tSeen = Arrays.copyOf(seen, seen.length); 
            int Tcount = 0;
            for (char c : word.toCharArray()) {
                if (tSeen[c - 'a'] > 0) {
                    tSeen[c - 'a']--;
                    Tcount++;
                }
            }
            if (Tcount == word.length())
                count += Tcount;
        }
        return count;
    }

    public static int countCharacters2(String[] words, String chars) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (char c : chars.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        int res = 0;
        HashMap<Character, Integer> copyMap;
        for (String word : words) {
            copyMap = (HashMap<Character, Integer>) countMap.clone();
            boolean fail = false;
            for (char c : word.toCharArray()) {
                if (copyMap.get(c) == null || copyMap.get(c) <= 0) {
                    fail = true;
                    break;
                } else {
                    copyMap.put(c, copyMap.get(c) - 1);
                }
            }
            if (!fail)
                res += word.length();
        }
        return res;
    }

    public static int countCharacters3(String[] words, String chars) {
        int cnt[] = new int[26], ans = 0;
        chars.chars().forEach(c -> ++cnt[c - 'a']); // count chars.
        outer: for (String w : words) {
            int[] count = cnt.clone();
            for (char c : w.toCharArray())
                if (--count[c - 'a'] < 0) // not enough, continue next word in words.
                    continue outer;
            ans += w.length();
        }
        return ans;
    }
}