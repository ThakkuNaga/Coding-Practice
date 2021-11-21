package com.main;

public class Pattern2 {

    public static void main(String[] args) {
        String IP = "000.12.12.034";
        IP = "000.12.234.23.23";
        String zeroTo255 = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
        String pattern = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;

        /* 1) \\d{1,2} catches any one or two digit number
           2) (0|1)\\d{2} catches any three digit number starting with 0 or 1.
           3) 2[0-4]\\d catches numbers between 200 and 249.
           4) 25[0-5] catches numbers between 250 and 255.
           Note that \d represents digits in regular expressions, same as [0-9]
        */
        System.out.println(IP.matches(pattern));
    }
}