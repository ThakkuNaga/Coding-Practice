package com.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.utils.Utils;

public class SingleNumberII {

    // 137. Single Number II
    // Every element appears three times except for one.

    public static void main(String[] args) {
        int[] nums = { 2, 2, 3, 2, 4, 4, 4 };
        Utils.prtLn(singleNumber_HashMap(nums));
    }

    public static int singleNumber_HashMap(int[] nums) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int num : nums)
            hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);

        for (int k : hashmap.keySet())
            if (hashmap.get(k) == 1)
                return k;
        return -1;
    }

    public static int singleNumber_Set(int[] nums) {
        Set<Long> set = new HashSet<>();
        long sumSet = 0, sumArray = 0;
        for (int n : nums) {
            sumArray += n;
            set.add((long) n);
        }
        for (Long s : set)
            sumSet += s;
        return (int) ((3 * sumSet - sumArray) / 2);
    }

    public static int singleNumber(int[] nums) {
        int seenOnce = 0, seenTwice = 0;

        for (int num : nums) {
            // first appearence:
            // add num to seen_once
            // don't add to seen_twice because of presence in seen_once

            // second appearance:
            // remove num from seen_once
            // add num to seen_twice

            // third appearance:
            // don't add to seen_once because of presence in seen_twice
            // remove num from seen_twice
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }

        return seenOnce;
    }

}