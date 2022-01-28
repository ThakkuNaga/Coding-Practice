package com.math;

public class FindCentury {

    public static void main(String... args) throws Exception {

        //System.out.println(findCentury(245));
        System.out.println(centuryFromYear(0));

    }

    static int centuryFromYear(int year) {
        if (year % 100 != 0)
            return year / 100 + 1;
        return year / 100;
    }

    private static int findCentury(int year) {
        boolean b = false;
        int pop = 0;

        if (year % 10 > 0)
            b = true;

        if (year < 101) {
            return 1;
        } else if (year < 1000) {
            while (year > 9) {
                pop = year % 10;
                year = year / 10;
            }
        } else if (year >= 1000) {
            while (year > 20) {
                pop = year % 10;
                year = year / 10;
            }

        }

        System.out.println(pop + " " + year + " b " + b);

        return b ? year + 1 : year;
    }

}