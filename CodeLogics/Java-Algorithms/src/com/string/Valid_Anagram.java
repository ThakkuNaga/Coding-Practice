package com.string;

import com.utils.Utils;

public class Valid_Anagram {

    public static void main(String[] args) {
        String s = "aacc";
        // "aacc";
        String t = "ccac";
        // "ccac";
        Utils.prt(isAnagram(s, t));
    }

    private static Object isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
            System.out.println("s: " + (s.charAt(i) - 'a'));
        }
        Utils.prtArr(alphabet);

        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;
            System.out.println("t: " + (t.charAt(i) - 'a'));
        }
        Utils.prtArr(alphabet);
        for (int i : alphabet)
            if (i != 0)
                return false;
        return true;
    }
}
