package com.examples.examples;

import com.examples.beans.Student;
import org.junit.jupiter.api.Test;
import com.examples.mockdata.MockData;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

}
