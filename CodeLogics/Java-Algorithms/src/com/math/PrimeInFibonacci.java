package com.math;

import java.util.Arrays;

class PrimeInFibonacci {

    public static void main(String[] args) {
        int n = 10;

        int[] x = getPrimeInFibonacci(n);
    }

    static int fib(int n) {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    static boolean isPrime(int num){
        boolean isPrme=true;
        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                isPrme = false;
                break;
            }
        }
        return isPrme;
    }

    private static int[] getPrimeInFibonacci(int n) {
        int[] fibos = new int[n];
        for (int i = 0; i < n; i++) {
            int num = fib(i);
            if(isPrime(num))
            fibos[i]=num;
        }      

        System.out.println(Arrays.toString(fibos));
        return null;

    }

}