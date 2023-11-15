package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numbers1 = Arrays.asList(1, 50, 3, 4, 56, 6, 7, 23, 9, 10);

        System.out.println("Ascending");
        System.out.println("filter Method");
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);

        System.out.println("map Method");
        numbers.stream()
                .map(number -> number * 2)
                .forEach(System.out::println);


        System.out.println("Ascending");
        System.out.println("sorted Method");
        numbers1.stream()
                .sorted()
                .toList()
                .forEach(System.out::println);

        System.out.println("Ascending");
        System.out.println("reduce method");
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Die sum ist : " + sum);

        System.out.println("Ascending");
        System.out.println("collect method");
        numbers1.stream()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("Danke Method!");

    }
}