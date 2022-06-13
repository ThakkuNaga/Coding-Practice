package com.leetcode.easy;

import com.utils.Utils;

class CountOdds {
    static Utils u = new Utils();
    /*
     * the count of odd numbers between 1 and low - 1 is low / 2
     * the count of odd numbers between 1 and high is (high + 1 ) / 2
     */

    public static void main(String[] args) {
        u.pt(countOdds(3, 7)); 
        u.pt(countOdds2(8, 10));            
    }

    public static int countOdds(int low, int high) {
        System.out.println("low " + low + " high " + high);

        System.out.println(low % 2);
        System.out.println((high + 1) % 2);

        System.out.println("1 and low  -> " + low / 2);
        System.out.println("1 and high -> " + (high + 1) / 2);

        return (high + 1) / 2 - low / 2;
    }

    public static int countOdds2(int low, int high) {
		if(low%2 == 0)
			low += 1;
		if(high%2 == 0)
			high -= 1;
		return (high - low)/2 + 1;
	}
}