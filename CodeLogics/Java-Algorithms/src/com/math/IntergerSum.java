package com.math;

public class IntergerSum {

    public static void main(String... args) throws Exception {

        int n = 5678;
        System.out.println(intSum(n));

        //String line = "5678";
        //System.out.println(intSum2(line));

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

    private static int intSum2(String line) {

        String s = "";
        int k = 0;
        int c = 1;
        for (int i = line.length() - 1; i >= 0; i--, c++) {

            if (c % 2 == 0) {
                k = Character.getNumericValue(line.charAt(i));
                s += k * 2;
            } else {
                s += line.charAt(i);
            }

        }
        System.out.println(s);
        int n = Integer.parseInt(s);
        return intSum(n);
    }

}