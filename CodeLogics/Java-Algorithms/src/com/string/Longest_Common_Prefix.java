package com.string;

public class Longest_Common_Prefix {

    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };
        String[] strs1 = { "dog", "racecar", "car" };
        System.out.println(longestCommonPrefix(strs1));
        //System.out.println(longestCommonPrefix2(strs1));
    }

    // Approach 1: Horizontal scanning
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++){
        //System.out.println("strs["+i+"] == "+strs[i]);
        //System.out.println("strs["+i+"].indexOf("+prefix+") "+strs[i].indexOf(prefix));
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                System.out.println(prefix);
                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }

    // Approach 2: Vertical scanning
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            System.out.println(c);
            for (int j = 1; j < strs.length; j++) {
                System.out.println(strs[j].charAt(i));
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}