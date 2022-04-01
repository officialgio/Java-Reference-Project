package com.examples.examples;

import com.examples.beans.Student;
import org.junit.jupiter.api.Test;
import com.examples.mockdata.MockData;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class MoreFunctionalProgramming {
    @Test
    public void introToFunctionalProgramming() throws IOException {
        List<Student> people = MockData.getStudents();

        Map<String, List<Student>> listOfFemalesOnly = people.stream()
                .collect(Collectors.groupingBy(Student::getGender));

        listOfFemalesOnly.forEach((s, students) -> {
            System.out.println("Gender: " + s);
            students.forEach(System.out::println);
            System.out.println("------------");
        });


    }

    @Test
    public void numberOfFemales() throws IOException {
        List<Student> people = MockData.getStudents();

        Long female = people.stream()
                .filter(student -> student.getGender().equals("female"))
                .collect(Collectors.counting());

        System.out.println("Count of females: " + female);

    }

    @Test
    public void findNumberOfSameAge() throws IOException {
        List<Student> people = MockData.getStudents();

        List<Student> maleList = people.stream().filter(student -> student.getGender().equals("male"))
                .collect(Collectors.toList());

        maleList.forEach(System.out::println);


    }

    @Test
    public void findCountOfMales() throws IOException {
        List<Student> people = MockData.getStudents();

        Long maleCount = people.stream()
                .filter(student -> student.getGender().equals("male"))
                .collect(Collectors.counting());

        System.out.println("Male count: " + maleCount);


    }

    @Test
    public void usingReduce() throws IOException {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        Integer reduce = numbers.stream()
                .reduce(0, (a, b) -> Integer.sum(a, b));
        assertThat(reduce).isEqualTo(21);

        System.out.println(reduce);
    }

    @Test
    public void ParsingStrings() throws IOException {
        // parse strings to integers and return a new list of integers
        // that are less than 10
        List<String> str = List.of("1", "2", "10");

        List<Integer> collect = str.stream()
                .map(value -> Integer.parseInt(value))
                .filter(value -> value < 10).collect(Collectors.toList());
        collect.forEach(System.out::println);


    }
}
