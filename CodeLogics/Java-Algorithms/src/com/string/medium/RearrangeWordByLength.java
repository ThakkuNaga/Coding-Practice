package com.string.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import com.utils.Utils;

public class RearrangeWordByLength {

    /*
     * 1451. Rearrange Words in a Sentence
     * 
     * Input: "Leetcode is cool"
     * Output: "Is cool leetcode"
     *
     * Input: text = "Keep calm and code on"
     * Output: "On and keep calm code"
     * 
     * Input: text = "To be or not to be"
     * Output: "To be or to be not"
     */

    public static void main(String[] args) {
        String s = "Leetcode is cool";
        s = "Keep calm and code on";
        // s = "To be or not to be";
        System.out.println(arrangeWords2(s));
    }

    public static String arrangeWords1(String text) {
        String[] str = text.toLowerCase().split(" ");
        // sort the array on word length
        Arrays.sort(str, (a, b) -> a.length() - b.length());

        StringBuilder sb = new StringBuilder();
        for (String word : str)
            sb.append(word + " ");
        return Character.toUpperCase(sb.charAt(0)) + sb.substring(1);
    }

    public static String arrangeWords2(String text) {
        String words[] = text.toLowerCase().split(" ");
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        String result = String.join(" ", words);
        return Character.toUpperCase(result.charAt(0)) + result.substring(1);
    }

    public static String arrangeWords3(String text) {
        String[] words = text.toLowerCase().split(" ");
        TreeMap<Integer, List<String>> map = new TreeMap<>();

        for (String word : words) {
            map.putIfAbsent(word.length(), new LinkedList<>());
            map.get(word.length()).add(word);
        }
        StringBuilder sb = new StringBuilder();
        for (int k : map.keySet()) {
            for (String word : map.get(k)) {
                sb.append(word).append(" ");
            }
        }
        return Character.toUpperCase(sb.charAt(0)) + sb.substring(1);
    }

}