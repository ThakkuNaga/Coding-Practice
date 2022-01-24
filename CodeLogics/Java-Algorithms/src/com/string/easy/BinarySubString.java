package com.string.easy;

public class BinarySubString {

    public static void main(String... args) throws Exception {
        String s = "0110";
        System.out.println(queryString(s,4));
        System.out.println(queryString2(s, 3));
        System.out.println(queryString3(s, 3));
    }

    public static boolean queryString(String s, int n) {
        if (s.length() == 1)
            return true;
        for (int i = 1; i <= n; ++i) {
            System.out.println(Integer.toBinaryString(i));
            if (!s.contains(Integer.toBinaryString(i)))
                return false;
        }
        return true;
    }

    public static boolean queryString2(String S, int N) {
        for (int i = N; i > N / 2; --i)
            if (!S.contains(Integer.toBinaryString(i)))
                return false;
        return true;
    }

    public static Boolean queryString3(String S, int N) {
        for (int i = N; i >= N / 2; --i)
            if (!S.contains(Integer.toBinaryString(i)))
                return false;
        return true;
    }
}