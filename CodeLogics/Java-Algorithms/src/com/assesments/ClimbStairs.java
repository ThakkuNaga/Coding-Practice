package com.assesments;

public class ClimbStairs {

	// 70. Climbing Stairs

	// Program to find n-th stair
	// using step size 1 or 2 or 3.
	// A recursive function used by countWays

	public static void main(String argc[]) {
		int n = 52;
		System.out.println(climbStairs(n));
		System.out.println(climbStairs2(n));
	}

	public static int climbStairs(int n) {
		int[] res = new int[n + 1];
		res[0] = 1;
		res[1] = 1;
		res[2] = 2;

		for (int i = 3; i <= n; i++)
			res[i] = res[i - 1] + res[i - 2] + res[i - 3];

		return res[n];
	}

	public static int climbStairs2(int n) {
		int a = 1, b = 1;
		while (n > 0) {
			a = (b += a) - a;
			n--;
		}
		return a;
	}

}
