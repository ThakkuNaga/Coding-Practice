package com.string;

class PrintSubStrings {

    public static void main(String[] args) {
        String s = "geeks";
        prtAllSubStr(s.toCharArray(), s.length());
    }

    private static void prtAllSubStr(char s[], int n) {
        // for (int i = 0; i < s.length(); i++) {
        // for (int j = i+1; j <= s.length(); j++) {
        // System.out.println(s.substring(i, j));
        // }
        // }

        // Pick starting point
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    System.out.print(s[k]+" ");
                }
                System.out.println();
            }
        }
    }
}