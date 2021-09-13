package com.string; 

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {

        String ransomNote = "aa", magazine = "ba";
        System.out.println(ransomNote2(ransomNote, magazine));

    }

    public static boolean ransomNote(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--arr[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean ransomNote2(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        Map<Character, Integer> magazineCounts = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            magazineCounts.put(c, magazineCounts.getOrDefault(c, 0) + 1);
        }

        System.out.println(magazineCounts);

        // For each character in the ransom note:
        for (char c : ransomNote.toCharArray()) {
            // Get the current count for c in the magazine.
            int countInMagazine = magazineCounts.getOrDefault(c, 0);
            // If there are none of c left, return false.
            if (countInMagazine == 0) {
                return false;
            }
            // Put the updated count for c back into magazineCounts.
            magazineCounts.put(c, countInMagazine - 1);
        }

        return true;
    }
}