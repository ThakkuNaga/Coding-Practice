package com.interviews;

public class RunLengthEncoding {

    public static void main(String[] args) {
        System.out.println(runLengthEncoding("aaabbbcddeeeaaa"));
        System.out.println(runLengthEncoding("alex"));
        System.out.println(runLengthEncoding("aaleexa"));
    }

    private static String runLengthEncoding(String str) {

        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        int i = 1;
        for (i = 1; i < str.length(); i++) {

            if (str.charAt(i) == str.charAt(i - 1)) {
                cnt++;
            } else {
                sb = sb.append(str.charAt(i - 1)).append(cnt);
                cnt = 1;
            }
        }
        sb = sb.append(str.charAt(i - 1)).append(cnt);

        return sb.toString();
    }

}