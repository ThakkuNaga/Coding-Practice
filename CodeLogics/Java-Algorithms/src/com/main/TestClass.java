package com.main;

public class TestClass {

    public static void main(String... args) {
        //  Utils u = new Utils();
        // // u.pt("strawberries".substring(2, 5));

        // // boolean b1 = true, b2 = false;
        //  int i1 = 6, i2 = -6;

        //  u.pt(i1 & i2);
        // u.pt(i1 ^ i2);
        // u.pt(i1 | i2);

        // String s1 = "apple";
        // String s2 = "banana";
        // System.out.print(s1.compareTo(s2));

        // final double d = 1 / 2d;
        // System.out.print(d);

        // String s = "a?zs";

        // System.out.println(modifyString1(s));

        //String str ="abaaccddddefg";
        
        // Map<String, Integer> map = new HashMap<>();
 
        // for(char c: str.toCharArray()){
        //     if(map.containsKey(c)){
        //         map.put(c, map.getOrDefault(c, null)+1);
        //     }else{
        //         map.put(c, 1);
        //     }
        // }
        //System.out.println(map);

    }

    public static String modifyString1(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '?') {
                for (int j = 0; j < 3; j++) {
                    if (i > 0 && arr[i - 1] - 'a' == j)
                        continue;
                    if (i + 1 < arr.length && arr[i + 1] - 'a' == j)
                        continue;
                    arr[i] = (char) ('a' + j);
                    break;
                }
            }
        }
        return String.valueOf(arr);
    }

    public static String modifyString2(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == '?') {
                for (char c = 'a'; c <= 'c'; c++) {
                    if (i > 0 && arr[i - 1] == c)
                        continue;
                    if (i + 1 < n && arr[i + 1] == c)
                        continue;
                    arr[i] = c;
                    break;
                }
            }
        }
        return String.valueOf(arr);
    }

}