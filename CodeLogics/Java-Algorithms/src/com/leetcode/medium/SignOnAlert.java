package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SignOnAlert {

    // 1604. Alert Using Same Key-Card Three or More Times in a One Hour Period

    // LeetCode company workers use key-cards to unlock office doors. Each time a
    // worker uses their key-card, the security system saves the worker's name and
    // the time when it was used. The system emits an alert if any worker uses the
    // key-card three or more times in a one-hour period.

    public static void main(String[] args) {
        String[] keyName = { "daniel", "daniel", "daniel", "luis", "luis", "luis", "luis" },
                keyTime = { "10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00" };
        System.out.println(
                alertNames(keyName, keyTime));
    }

    public static List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < keyName.length; i++) { // cache all visits for same person.
            String k = keyName[i];
            map.computeIfAbsent(k, g -> new ArrayList<>());
            map.get(k).add(getTime(keyTime[i]));
        }

        System.err.println(map);

        for (String k : map.keySet()) {
            List<Integer> l = map.get(k);
            Collections.sort(l); // sort to find the connective checkins
            for (int i = 2; i < l.size(); i++)
                if (l.get(i) - l.get(i - 2) <= 60) { // connective 3 within 60 mins.
                    res.add(k);
                    break;
                }
        }

        System.out.println(res);

        Collections.sort(res);
        return res;
    }

    private static int getTime(String t) { // transfer stirng to relative mins.
        String[] ss = t.split(":");
        return Integer.parseInt(ss[1]) + 60 * Integer.parseInt(ss[0]);
    }
}