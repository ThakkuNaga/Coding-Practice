package com.main;

public class Main {
    public static void main(String... args) throws Exception {

        String str = "WELCOME";

        char[] chrArr = str.toCharArray();

        int left = 0, right = 0;
        right = chrArr.length - 1;

        while (left < right) {

            char tmp = chrArr[left];

            chrArr[left] = chrArr[right];
            chrArr[right] = tmp;
            left++;
            right--;
        }

        System.out.println(new String(chrArr));

    }

}