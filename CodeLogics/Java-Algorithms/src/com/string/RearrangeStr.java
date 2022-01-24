package com.string;

import com.utils.Utils;

public class RearrangeStr {
    public static void main(final String... args) throws Exception {

        Utils.prt(reorganizeString("anvhdreos"));
    }

    public static String reorganizeString(String S) {
        StringBuilder sb = new StringBuilder();
        int[] hash = new int[26];
        for (int i = 0; i < S.length(); i++) {
            hash[S.charAt(i) - 'a']++;
        }
        // Utils.prtArr(hash);

        char[] str = S.toCharArray();
        Utils.prtArr(str);
        char[] res = new char[str.length];
        int left = 0;
        int right = S.length()-1;
        for (int i = right; i >= 0; i--) {
        
            if (str[left] > str[right]) {
                 res[i] = str[left];
                 left++; 
            } else {
                res[i] = str[right];
                right--;
            }
        }
        System.out.println(res);

        return sb.toString();
    }

}