package com.string;

import com.utils.Utils;
public class ReverseString_SpcChar {

    public static void main(String[] args) {
        String str = "H,ell#o";
        Utils.prt(reverseStr(str));
    }

    public static String reverseStr(String str) {
        char[] ch = str.toCharArray();

        int left = 0, right = ch.length - 1;
        while (left < right) {

            // Ignore special characters
            if (!Character.isAlphabetic(ch[left]))
                left++;
            else if (!Character.isAlphabetic(ch[right]))
                right--;
            else {
                char tmp = ch[left];
                ch[left] = ch[right];
                ch[right] = tmp;
                left++;
                right--;
            }
        }
        return String.valueOf(ch);
    }

}
