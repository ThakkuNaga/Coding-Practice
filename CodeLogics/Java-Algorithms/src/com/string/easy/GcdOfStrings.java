package com.string.easy;

public class GcdOfStrings {

    /*
     * 1071. Greatest Common Divisor of Strings
     * 
     * Input: str1 = "ABCABC", str2 = "ABC"
     * Output: "ABC"
     * 
     * Input: str1 = "ABABAB", str2 = "ABAB"
     * Output: "AB"
     * 
     * Input: str1 = "LEET", str2 = "CODE"
     * Output: ""
     */

    public static void main(String... args) throws Exception {
        String //str1 = "ABABAB", str2 = "ABAB";
        str1 = "LEET", str2 = "CODE";

        System.out.println(gcdOfStrings(str1, str2));
    }

    public static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1))
            return "";

        int gcdVal = gcd(str1.length(), str2.length());
        return str2.substring(0, gcdVal);
    }

    public static int gcd(int p, int q) {
        if (q == 0)
            return p;
        else
            return gcd(q, p % q);
    }

}