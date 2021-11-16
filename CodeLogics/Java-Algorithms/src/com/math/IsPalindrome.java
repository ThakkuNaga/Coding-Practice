package com.math;

public class IsPalindrome {

    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));
        System.out.println(isPalindrome1(x));
        System.out.println(isPalindrome2(x));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x != 0)
            return false;

        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }

        return x == rev || x == rev / 10;

    }

    private static boolean isPalindrome1(int x) {
        if (x < 0)
            return false;
        int r = 0;
        int sum = 0;
        int temp = x;
        while (x > 0) {
            r = x % 10; // getting remainder
            sum = (sum * 10) + r;
            x = x / 10;
        }
        if (temp == sum)
            return true;
        return false;
    }

    private static boolean isPalindrome2(int x) {
        if (x < 0)
            return false;
        int rev = 0;
        int org = x;

        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            if (rev == Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                rev = 0;
            if (rev == Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
                rev = 0;

            rev = rev * 10 + pop;
        }

        System.out.println(rev);
        if (rev == org)
            return true;

        return false;

    }
}