package com.string;

import java.util.HashMap;
import java.util.Map;

import com.utils.Utils;

public class Valid_Anagram {

    public static void main(String[] args) {
        String s = "anagram";
        // s = "aacc";
        // s = "Hello";
        String t = "nagaram";
        // t = "ccac";
        // t = "hello";
        Utils.prtLn(isAnagram(s, t));
        Utils.prtLn(isAnagram1(s, t));
        Utils.prtLn(isAnagram2(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.toLowerCase().charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < t.length(); i++) {
            alphabet[t.toLowerCase().charAt(i) - 'a']--;
            if (alphabet[t.toLowerCase().charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isAnagram1(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        int cnt = 0;
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            cnt++;
        }

        System.out.println(cnt);
        System.out.println(map);

        for (char c : t.toCharArray()) {
            if (map.getOrDefault(c, 0) > 0) {
                map.put(c, map.getOrDefault(c, 0) - 1);
                cnt--;
            }
        }
        System.out.println(cnt);
        System.out.println(map);

        if (cnt == 0)
            return true;

        return false;
    }

    private static Object isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }

        Utils.prtArr(alphabet);

        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;
        }

        Utils.prtArr(alphabet);
        for (int i : alphabet)
            if (i != 0)
                return false;
        return true;
    }
}
