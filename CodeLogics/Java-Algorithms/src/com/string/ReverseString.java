package com.string;

import com.utils.Utils;
public class ReverseString {
    public static void main(String[] args) {
        String str = "Hello ";
        Utils.prt(reverseStr(str), reverseStr1(str));
        Utils.prt(reverseStr2(str));
    }

    public static String reverseStr(String str) {
        char[] ch = str.toCharArray();

        int left = 0, right = ch.length - 1;
        while (left < right) {
            char tmp = ch[left];
            ch[left] = ch[right];
            ch[right] = tmp;
            left++;
            right--;
        }
        return String.valueOf(ch);
    }

    public static String reverseStr1(String str) {
        char ch;
        String nstr = "";
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i); // extracts each character
            nstr = ch + nstr; // adds each character in front of the existing string
        }
        return nstr;
    }

    public static String reverseStr2(String str) {
        char[] ch = str.toCharArray();
        StringBuilder sb = new StringBuilder(ch.length);

        for (int i = ch.length - 1; i >= 0; i--) {
            sb.append(ch[i]);
        }
        return sb.toString();

    }
}
