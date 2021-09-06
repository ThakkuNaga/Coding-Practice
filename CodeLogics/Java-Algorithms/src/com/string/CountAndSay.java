package com.string;

public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(2));
        System.out.println(countAndSay2(4));
    }

    private static String countAndSay2(int n) {
        if (n == 1)
            return "1";

        StringBuilder res = new StringBuilder();

        String s = countAndSay2(n - 1) + "0";

        for (int i = 0, c = 1; i < s.length() - 1; i++, c++) {
            if (s.charAt(i + 1) != s.charAt(i)) {
                res.append(c).append(s.charAt(i));
                c = 0;
            }
        }

        return res.toString();
    }

    public static String countAndSay(int n) {
        String s = "1";
        if (n == 1) return s;
        s = countAndSay(n - 1);

        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);
        int count = 1;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            } else {
                sb.append(count).append(c);
                c = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count).append(c);
        return sb.toString();
    }
}