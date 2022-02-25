package com.string.easy;

public class ReplaceString {

    /*
     * 1576. Replace All ?'s to Avoid Consecutive Repeating Characters
     * 
     * Given a string s containing only lowercase English letters and the '?'
     * character, convert all the '?' characters into lowercase letters such that
     * the final string does not contain any consecutive repeating characters. You
     * cannot modify the non '?' characters.
     * 
     * It is guaranteed that there are no consecutive repeating characters in the
     * given string except for '?'.
     * 
     * Return the final string after all the conversions (possibly zero) have been
     * made. If there is more than one solution, return any of them. It can be shown
     * that an answer is always possible with the given constraints.
     */
    public static void main(String... args) {
        String s = "a?zs";
        System.out.println(modifyString1(s));
    }

    public static String modifyString1(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '?') {
                for (int j = 0; j < 3; j++) {
                    
                    //skip if previous character is one of a,b,c                    
                    if (i > 0 && arr[i - 1] - 'a' == j) continue; 

                    //skip if next character is one of a,b,c
                    if (i + 1 < arr.length && arr[i + 1] - 'a' == j) continue;   
                                      
                    //set with the current character from a,b,c
                    arr[i] = (char) ('a' + j); 
                    break;
                }
            }
        }
        return String.valueOf(arr);
    }

    public static String modifyString2(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == '?') {
                for (char c = 'a'; c <= 'c'; c++) {
                    if (i > 0 && arr[i - 1] == c)
                        continue;
                    if (i + 1 < n && arr[i + 1] == c)
                        continue;
                    arr[i] = c;
                    break;
                }
            }
        }
        return String.valueOf(arr);
    }

}