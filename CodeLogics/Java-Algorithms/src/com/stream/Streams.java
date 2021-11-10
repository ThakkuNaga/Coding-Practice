package com.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String... args) {

        List<Integer> number = new ArrayList<>();
        number = Arrays.asList(2, 3, 4, 5);
        System.out.println(number);

        number.stream().map(x -> x * x).forEach(x -> System.out.println(x));

        List<String> names = Arrays.asList("Reflection", "Collection", "Stream");

        List<String> result = names.stream().filter(s -> s.startsWith("S")).collect(Collectors.toList());
        System.out.println(result);

        result = names.stream().sorted().collect(Collectors.toList());
        System.out.println(result);

        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 8);
        int even = numbers.stream().filter(x -> x % 2 == 0).reduce(0, (ans, i) -> ans + i);
        System.out.println(even);


    }

}