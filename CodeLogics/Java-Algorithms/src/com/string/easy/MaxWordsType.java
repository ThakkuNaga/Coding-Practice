package com.string.easy;

import java.util.HashSet;
import java.util.Set;

public class MaxWordsType {

    public static void main(String... args) throws Exception {
        String strs = "flower flow flight";
        System.out.println(maxWordsType(strs,"t"));
    }

    private static int maxWordsType(String text, String brokenLetters) {
        Set<Character> no = new HashSet<>();
        for (char c : brokenLetters.toCharArray()) {
            no.add(c);
        }
        int cnt = 0;
        outer:
        for (String word : text.split("\\s")) {
            for (char c : word.toCharArray()) {
                if (no.contains(c)) {
                    continue outer;
                }
            }
            ++cnt;
        }
        return cnt;
    }

}