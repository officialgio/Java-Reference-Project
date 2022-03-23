package com.examples.examples;

import com.examples.beans.Person;
import com.examples.beans.Student;
import com.examples.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UnderstandingStreams {

    @Test
    public void collect() throws IOException {
        List<String> emails = MockData.getPeople()
                .stream()
                .map(Person::getEmail)
                .collect(
                        () -> new ArrayList<String>(),
                        (list, e) -> list.add(e),
                        (list1, c) -> list1.addAll(c)
                );
        emails.forEach(System.out::println);
    }

    @Test
    public void collectNames() throws IOException {
        List<Student> students = MockData.getStudents();
        // Collect Address into a new List
        ArrayList<String> collect = students.stream()
                .map(student -> student.getAddress()) // get address
                .collect(() -> new ArrayList<String>(),
                        (list, s) -> list.add(s),
                        (list, list2) -> list.addAll(list2));

        collect.forEach(System.out::println);


    }

    // Practice
    @Test
    public void collectNamesAndAgeKeyValue() throws IOException {
        List<Student> students = MockData.getStudents();

        Map<String, List<Student>> map = students.stream()
                .collect(Collectors.groupingBy(student -> student.getFirstName()));
        map.forEach((s, students1) -> {
            System.out.println("Name: " + s);
            students1.forEach(System.out::println);
            System.out.println("-------------");
        });
    }

    @Test
    public void lazy() throws Exception {
        /**
         * Streams are lazy
         * You must end your stream with a terminal line like collect so it will execute!
         *
         *
         * This is also an illustration how streams are executed
         */
        System.out.println(
                MockData.getCars()
                        .stream()
                        .filter(car -> {
                            System.out.println("filter car " + car);
                            return car.getPrice() < 10000;
                        })
                        .map(car -> {
                            System.out.println("mapping car " + car);
                            return car.getPrice();
                        })
                        .map(price -> {
                            System.out.println("mapping price " + price);
                            return price + (price * .14);
                        })
                        .collect(Collectors.toList())
        );
    }
}
