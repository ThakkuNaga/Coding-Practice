package com.string.easy;

public class BalancedStringSplit {

    public static void main(String... args) throws Exception {
        String s = "RLRRLLRLRL";
        System.out.println(balancedStringSplit(s));
    }

    public static int balancedStringSplit(String s) {
        int res = 0, cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L')
                cnt--;
            else
                cnt++;

            if (cnt == 0)
                res++;
        }
        return res;
    }
}