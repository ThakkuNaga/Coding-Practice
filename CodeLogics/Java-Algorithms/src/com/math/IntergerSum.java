package com.math;

public class IntergerSum {

    public static void main(String... args) throws Exception {
        int n = 290;
        System.out.println(intSum(n));
    }

    private static int intSum(int n) {
        int sum = 0;
        int pop = 0;
        while (n > 0) {
            pop = n % 10;
            n = n / 10;
            sum += pop;
            System.out.print(pop + " " + n + " " + sum + "\n");
        }
        return sum;
    }

}