package com.array;

import com.utils.Utils;

public class FirstBadVersion {

    public static void main(String[] args) {
        int ver = 7;
        Utils.prtLn("Cur ver: " + ver);
        Utils.prtLn("Bad ver: " + firstBadVersion(ver));
    }

    public static int firstBadVersion(int n) {
        // whenever you find things sorted and you need to search always
        // go for binary search
        int left = 1, right = n;

        while (left <= right) { // exit loop when low > high
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean isBadVersion(int mid) {
        if (mid == 4)
            return true;
        return false;
    }

}