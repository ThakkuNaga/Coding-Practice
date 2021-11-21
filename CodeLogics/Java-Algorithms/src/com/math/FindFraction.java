package com.math;

import java.util.Arrays;
import java.util.List;

public class FindFraction {

    public static void main(String[] args) {
        double numP = 0;
        double numN = 0;
        double numZ = 0;
        List<Integer> arr = Arrays.asList(1, 1, 0, -1, -1);

        for (int val : arr) {

            if (val < 0) {
                numN++;
            }
            if (val > 0) {
                numP++;
            }
            if (val == 0) {
                numZ++;
            }
        }
        double fp = numP / arr.size();
        double fn = numN / arr.size();
        double fz = numZ / arr.size();
        System.out.printf("%f%n", fp);
        System.out.printf("%f%n", fn);
        System.out.printf("%f%n", fz);
    }

}