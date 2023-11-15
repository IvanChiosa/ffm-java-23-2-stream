package org.example;

import java.awt.geom.Path2D;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.sun.org.apache.xml.internal.utils.XMLChar.isValid;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numbers1 = Arrays.asList(1, 50, 3, 4, 56, 6, 7, 23, 9, 10);

        System.out.println();
        System.out.println("filter Method");
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);

        System.out.println("map Method");
        numbers.stream()
                .map(number -> number * 2)
                .forEach(System.out::println);


        System.out.println("");
        System.out.println("sorted Method");
        numbers1.stream()
                .sorted()
                .toList()
                .forEach(System.out::println);

        System.out.println("");
        System.out.println("reduce method");
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Die sum ist : " + sum);

        System.out.println("");
        System.out.println("collect method");
        numbers1.stream()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("Students Information mit Header");
        Path filePath = Path.of("students.csv");
        try {
            Files.lines(filePath)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Students Information ohne Header");
//        Path filePath1 = Path.of("students.csv");
//        try {
//            Files.lines(filePath1)
//                    .skip(1)
//                    .map(line -> {
//                        String[] parts = line.split(",");
//                        // ID, Name, postalCode, age
//                        int ID = Integer.parseInt(parts[0]);
//                        String Name = parts[1];
//                        String postalCode = parts[2];
//                        String age = parts[3];
//                        return new students.csv(ID, Name, postalCode, age);
//
//                    })
//                    .forEach(System.out::println);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Path filePath1 = Path.of("students.csv");
        try {
            // Using Files.lines to read the file line by line, skipping the header
            List<List<String>> studentRecords = Files.lines(filePath1)
                    .skip(1) // Skip the header
                    .map(line -> List.of(line.split(",")))
                    .filter(Main::isValid)
                    .distinct()
                    .collect(Collectors.toList());

            // Print the list of student records
            studentRecords.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static boolean isValid(List<String> studentRecord) {
        // Example: Check if the record has at least three fields
        return studentRecord.size() >= 4;
    }
}