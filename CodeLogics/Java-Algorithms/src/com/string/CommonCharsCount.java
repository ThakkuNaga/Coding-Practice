package com.string;

import java.util.Arrays;

import com.utils.Utils;

class CommonCharsCount {

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "adcaa";

        System.out.println(findCommonCHars(s1, s2));
    }

    private static int findCommonCHars(String s1, String s2) {
        
        Utils.prtChArr(s2);
        int len = s1.length(), res = 0;
        char[] arr = s1.toCharArray();

        for (int i = 0; i < len; i++) {
            int pos = s2.indexOf(arr[i]);
            if (pos != -1) {
                System.out.println(pos+" >" + s2.substring(0, pos) + "<" + s2.substring(pos + 1));
                s2 = s2.substring(0, pos) + s2.substring(pos + 1);
                res++;
            }
        }
        return res;
    }

}