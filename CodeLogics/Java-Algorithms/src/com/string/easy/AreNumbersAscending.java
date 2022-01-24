package com.string.easy;

public class AreNumbersAscending {

    public static void main(String... args) throws Exception {
        String s = // "a baby has 2 eyes 2 legs";
                "1 box has 3 blue 4 red 6 green and 12 yellow marbles";
        System.out.println(areNumbersAscending(s));
    }

    public static boolean areNumbersAscending(String s) {
        int prev = 0;
        for (String token : s.split(" ")) {
            if (Character.isDigit(token.charAt(0))) {
                int num = Integer.parseInt(token);

                if (num <= prev)
                    return false;

                prev = num;
            }
        }

        return true;
    }
}