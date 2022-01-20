package com.math;

class Factorial {

	/*
	 * Java program to find factorial of given number
	 * 
	 * Factorial of a non-negative integer,
	 * is multiplication of all integers smaller than or equal to n.
	 * 
	 * For example factorial of 6 is 6*5*4*3*2*1 which is 720.
	 */

	public static void main(String[] args) {
		int num = 6;
		System.out.println("Factorial of " + num + " is " + factorial_R(num));
		System.out.println("Factorial of " + num + " is " + factorial_itr(num));
	}

	static int factorial_R(int n) {
		if (n == 0)
			return 1;

		return n * factorial_R(n - 1);
	}

	static int factorial_itr(int n) {
		int res = 1, i;
		for (i = 2; i <= n; i++)
			res *= i;
		return res;
	}

	int factorial_t(int n) {

		// single line to find factorial
		return (n == 1 || n == 0) ? 1 : n * factorial_t(n - 1);

	}

}
