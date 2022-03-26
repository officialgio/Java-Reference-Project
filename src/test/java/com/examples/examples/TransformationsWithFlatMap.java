package com.examples.examples;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TransformationsWithFlatMap {

    private static final List<List<String>> arrayListOfNames = List.of(
            List.of("Mariam", "Alex", "Ismail"),
            List.of("John", "Alesha", "Andre"),
            List.of("Susy", "Ali")
    );

    @BeforeEach // this just means print before every test is executed
    void setUp() {
        System.out.println(arrayListOfNames);
    }

    @Test
    public void withoutFlatMap() throws Exception {
        // [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]
        List<String> names = new ArrayList<>();

        // 1st method
        arrayListOfNames.forEach(names::addAll);

        //2nd method
        for (List<String> strings : arrayListOfNames) {
            names.addAll(strings);
        }
        System.out.println(names);

    }

    @Test
    public void withFlatMap() throws Exception {
        // [Mariam, Alex, Ismail, John, Alesha, Andre, Susy, Ali]
        // Combine the List of Lists to one single List
        List<String> names = arrayListOfNames.stream()
                .flatMap(strings -> strings.stream())
                .collect(Collectors.toList());
        System.out.println(names);


    }

    @Test
    public void flatMapWithOptionals() {
        List<Optional<String>> optionals = List.of(
                Optional.of("Oh"),
                Optional.of("Wow")
        );

        // combine to a single list (optionals) \
        List<String> list = optionals.stream()
                .flatMap(s -> s.stream())
                .collect(Collectors.toList());
        System.out.println(list);


    }
}

