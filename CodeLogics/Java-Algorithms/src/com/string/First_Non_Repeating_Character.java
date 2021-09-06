package com.string;

import java.util.LinkedHashMap;

public class First_Non_Repeating_Character {

    public static void main(String[] args) {
        String s = "aaabcccdeeef";
        System.out.println("firstNonRepeatingCharacter is: " + approach_1(s));
        System.out.println("firstNonRepeatingCharacter is: " + approach_2(s));
        System.out.println("firstNonRepeatingCharacter is: " + approach_3(s));
    }

    private static char approach_1(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return s.charAt(i);
            }
        }
        return '_';
    }

    private static char approach_2(String s) {
        int[] chars = new int[26];
        for (char c : s.toCharArray())
            chars[c - 'a']++;
        for (char c : s.toCharArray())
            if (chars[c - 'a'] == 1)
                return c;
                
        return '_';
    }

    private static String approach_3(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            else
                map.put(s.charAt(i), 1);
        }
        for (char c : map.keySet())
            if (map.get(c) == 1)
                return String.valueOf(c);

        return null;
    }

}