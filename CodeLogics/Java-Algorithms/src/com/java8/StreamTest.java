
package com.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Java 8 Stream API example
 * 
 * @author www.codejava.net
 */
public class StreamTest {

    public static void main(String[] args) {
        List<Student> listStudents = new ArrayList<>();

        listStudents.add(new Student("Alice", 82));
        listStudents.add(new Student("Bob", 90));
        listStudents.add(new Student("Carol", 67));
        listStudents.add(new Student("David", 80));
        listStudents.add(new Student("Eric", 55));
        listStudents.add(new Student("Frank", 49));
        listStudents.add(new Student("Gary", 88));
        listStudents.add(new Student("Henry", 98));
        listStudents.add(new Student("Ivan", 66));
        listStudents.add(new Student("John", 52));

        ///////////////////////////////////////////////////////
        // find students whose score >= 70
        List<Student> listGoodStudents = new ArrayList<>();
        for (Student student : listStudents) {
            if (student.getScore() >= 70) {
                listGoodStudents.add(student);
            }
        }
        for (Student student : listGoodStudents) {
            System.out.println(student);
        }

        // find students whose score >= 70
        listGoodStudents = listStudents.stream().filter(s -> s.getScore() >= 70).collect(Collectors.toList());
        listGoodStudents.stream().forEach(System.out::println);

        ///////////////////////////////////////////////////////
        // calculate average score of all students
        double sum = 0.0;
        for (Student student : listStudents) {
            sum += student.getScore();
        }
        double average = sum / listStudents.size();
        System.out.println("Average score: " + average);

        // calculate average score of all students
        average = listStudents.stream().mapToInt(s -> s.getScore()).average().getAsDouble();
        System.out.println("Average score: " + average);

        // Top 3 Students by Score
        List<Student> top3Students = listStudents.stream().filter(s -> s.getScore() >= 70).sorted().limit(3)
                .collect(Collectors.toList());
        top3Students.forEach(s -> System.out.println(s));
    }
}