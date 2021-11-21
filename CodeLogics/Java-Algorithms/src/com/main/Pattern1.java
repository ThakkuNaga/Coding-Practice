package com.main;

public class Pattern1 {

    public static void main(String[] args) {
        String s = "Fsd Dsad  -d Sdsa's sds,d dsd?";
        System.out.println(s);
        s = s.replaceAll("[ \"!,?._'@\". ]"," "); // ^a-zA-Z
        System.out.println(s);
        s = s.replaceAll("\\s+", " ");
        System.out.println(s);
        s = s.trim();
        System.out.println(s);
        if (s.length() > 0) {
            String[] sarr = s.split(" ");
            if (sarr.length > 0) {
                System.out.println(sarr.length+" tokens");
                for (String w : sarr) {
                    System.out.println(w);
                }
            } else {
                System.out.println(sarr.length);
            }
        } else {
            System.out.println(s.length());
        }
        
    }
}