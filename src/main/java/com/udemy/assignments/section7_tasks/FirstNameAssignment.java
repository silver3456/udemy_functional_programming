package com.udemy.assignments.section7_tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FirstNameAssignment {

    public static void main(String[] args) throws IOException {

        // /Users/alexander/workspace/tasks

        Path path = Paths.get("/Users/alexander/workspace/tasks/first_names");
        List<String> list = Files.readAllLines(path);

        // print the count of names that start with 'B'
//        System.out.println(
//                list.stream()
//                        .filter(s -> s.startsWith("B"))
//                        .count()
//        );


        // create a list of names which start with 'C' and contains 's' in it

//        List<String> names = list.stream()
//                .filter(s -> s.startsWith("C"))
//                .filter(s -> s.toLowerCase().contains("s"))
//                .collect(Collectors.toList());
//
//        names.stream().forEach(System.out::println);

        // print the total number of chars for all the names starting with 'M'

//        System.out.println(
//                list.stream()
//                        .map(String::trim)
//                        .filter(s -> s.startsWith("M"))
//                        .map(name -> name.length())
//                        .mapToInt(i -> i)
//                        .sum()
//        );

        // find the names that contain '-' and replace with a space; collect them into a list
        List<String> adjustedNames = list.stream()
                .filter(name -> name.contains("-"))
                .map(name -> name.replace("-", " "))
                .collect(Collectors.toList());

        // find the names which has the most number of chars

                list.stream()
                        .max(Comparator.comparing(name->name.length()))
                        .get();


    }
}
