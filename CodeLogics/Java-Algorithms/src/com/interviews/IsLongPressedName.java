package com.interviews;

import java.util.Arrays;

class IsLongPressedName {
    // 925. Long Pressed Name

    public static void main(String[] args) {
        // System.out.println(isLongPressedName("alex", "aaleex"));
        // System.out.println(isLongPressedName("saeed", "ssaaedd"));
        // System.out.println(isLongPressedName("rick", "kirk"));
        System.out.println(isLongPressedName("alex", "aaleexa"));
    }

    public static boolean isLongPressedName(String name, String typed) {
        int m = name.length(), n = typed.length();
        int i = 0, j = 0;

        while (i < m && j < n) {
            char c1 = name.charAt(i), c2 = typed.charAt(j);
            if (c1 != c2)
                return false; // we are handling different chars, no!

            // count of consecutive c1/c2
            int count1 = 0;
            while (i < m && name.charAt(i) == c1) {
                count1++;
                i++;
            }

            // count of consecutive c1/c2
            int count2 = 0;
            while (j < n && typed.charAt(j) == c2) {
                count2++;
                j++;
            }

            if (count2 < count1)
                return false;
        }

        // they both reach the end
        return i == m && j == n;
    }

    public static boolean isLongPressedName1(String name, String typed) {
        int c = 0;
        for (int i = 0; i < typed.length(); i++) {
            if (c < name.length() && name.charAt(c) == typed.charAt(i))
                c++;
            else if (i == 0 || typed.charAt(i) != typed.charAt(i - 1))
                return false;
        }
        return c == name.length();
    }
   

    public static boolean isLongPressedName2(String name, String typed) {
        if (name.length() == 0 || typed.length() == 0)
            return false;
        if (name.length() > typed.length())
            return false;

        boolean rst = false;

        int[] typdChrs = new int[26];
        int[] nameChrs = new int[26];

        for (char c : name.toCharArray())
            nameChrs[c - 'a']++;

        int k = 0;
        int pos = 0;
        int newPos = 0;
        for (char c : typed.toCharArray()) {
            pos = c - 'a';
            if (k > 0) {
                if (newPos == pos) {

                }
            }
            typdChrs[c - 'a']++;
            newPos = pos;
        }

        // System.out.println(Arrays.toString(nameChrs));
        System.out.println(Arrays.toString(typdChrs));

        // if (name.length() == typed.length()) {
        // if ((name.charAt(0) - 'a') != (typed.charAt(0) - 'a')) {
        // return false;
        // }
        // }

        // int j = 0;
        // for (int i = 0; i < nameChrs.length; i++) {

        // // System.out.println("i "+nameChrs[i]+" j "+typdChrs[j]);
        // if (nameChrs[i] <= typdChrs[j++]) {
        // rst = true;
        // } else {
        // return false;
        // }
        // // System.out.println(rst);
        // }

        int j = 0;
        for (int i = 0; i < name.length(); i++) {

            System.out.println("i " + name.charAt(i) + " j " + typed.charAt(j));
            if (nameChrs[i] <= typdChrs[j++]) {
                rst = true;
            } else {
                return false;
            }
            // System.out.println(rst);
        }

        return rst;
    }
}