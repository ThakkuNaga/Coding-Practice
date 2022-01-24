package com.string;

import java.util.ArrayList;
import java.util.List;

import com.utils.Utils;

class LongestStrings {

    public static void main(String[] args) {
        String[] s = { "aba", "aa", "ad", "vcd", "aba" };
        Utils.prtArr(allLongestStrings(s));
    }

    static String[] allLongestStrings(String[] strs) {
        List<String> list = new ArrayList<String>();
        int max = 0;
        for (String s : strs) {
            if (max < s.length())
                max = s.length();
        }
        for (String s : strs) {
            if (s.length() == max)
                list.add(s);
        }
        return list.toArray(new String[list.size()]);

    }

}