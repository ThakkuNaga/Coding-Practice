package com.string;

import com.utils.Utils;

public class ReverseString {

    static char[] s = { 'h', 'e', 'l', 'l', 'o' };

    public static void main(String[] args) {

        
        reverseStr(s);
        Utils.prtArr(s);

    }

    public static void reverseStr(char[] s) {

        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }

        // for (var i = 0; i < s.length / 2; i++) {
        //     var tmp = s[i];
        //     s[i] = s[s.length - i - 1];
        //     s[s.length - i - 1] = tmp;
        // }

        // StringBuilder sb = new StringBuilder(s.length);

        // for (int i = s.length - 1; i >= 0; i--) {
        //     sb.append(s[i]);           
        // }
        // s = sb.toString().toCharArray();         
        // System.out.println(s);
    }
}
