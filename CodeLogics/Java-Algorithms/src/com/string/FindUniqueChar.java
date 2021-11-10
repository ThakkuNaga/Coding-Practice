package com.string;

import java.util.HashMap;

import com.utils.Utils;

public class FindUniqueChar {

    public static void main(String[] args) {
        String s = "loveleetcode";
        Utils.prtArr(s.toCharArray());
        Utils.prtLn(findUniqueChar(s));
    }

    private static Object findUniqueChar(String s) {

        HashMap<Character, Integer> cntMap = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cntMap.put(c, cntMap.getOrDefault(c, 0) + 1);
        }

        for(int i=0;i<s.length();i++){
            if(cntMap.get(s.charAt(i))==1){
                return i;
            }
        }

        return -1;
    }
}
