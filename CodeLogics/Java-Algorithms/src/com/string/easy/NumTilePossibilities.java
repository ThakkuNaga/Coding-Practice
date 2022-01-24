package com.string.easy;

import java.util.Arrays;

public class NumTilePossibilities {

    public static void main(String... args) throws Exception {
        String strs = "AAB";
        System.out.println(numTilePossibilities(strs));
    }

    public static int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        for (char c : tiles.toCharArray()) count[c - 'A']++;
        System.out.println(Arrays.toString(count));
        return dfs(count);
    }
    
    static int dfs(int[] arr) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) continue;
            sum++;
            arr[i]--;
            sum += dfs(arr);
            arr[i]++;
        }
        return sum;
    }

}