package com.java8;

import java.util.Arrays;

class LambdaTest {

    public static void main(String[] args) {
        String[] nums = { "three", "two", "one" };
        Arrays.stream(nums).forEach(num -> System.out.println(num));

        byte[] test = "test".getBytes();
        Arrays.stream(new String[] { "test", "dd" }).forEach(b -> System.out.println(b));
    }

}