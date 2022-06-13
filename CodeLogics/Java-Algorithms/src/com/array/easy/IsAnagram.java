package com.array.easy;

class IsAnagram {

    public static void main(String... args) {
        String s = "anagram", t = "nagaram";
        boolean rtn = isAnagram(s, t);
        System.out.println(rtn);

        String p = "A man, a plan, a canal: Panama";
        System.out.println(p.replaceAll("[^A-Za-z0-9]", ""));
        System.out.println(p.toLowerCase().replaceAll("\\W+", ""));
    }

    public static boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++)
            alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;
            if (alphabet[t.charAt(i) - 'a'] < 0)
                return false;
        }
        for (int i : alphabet)
            if (i != 0)
                return false;
        return true;
    }

}