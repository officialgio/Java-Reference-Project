package com.examples.examples;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class DistinctAndSets {

    @Test
    public void distinct() throws Exception {
        List<Integer> numbers = List.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);
        List<Integer> distinct = numbers.stream().distinct().collect(Collectors.toList()); // self-check
        assertThat(distinct).hasSize(9); // it will check that the size is 9
        System.out.println(distinct);


    }

    @Test
    public void distinctWithSet() throws Exception {
        List<Integer> numbers = List.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);
        Set<Integer> distinct = numbers.stream().collect(Collectors.toSet()); // no duplicates by default
        assertThat(distinct).hasSize(9);
        System.out.println(distinct);


    }

    // Practice
    @Test
    public void distinctPractice() throws Exception {
        List<Integer> numbers = List.of(1, 2, 2, 3, 4, 5, 10, 12, 12);
        List<Integer> distinct = numbers.stream().distinct().collect(Collectors.toList());
        assertThat(distinct).hasSize(7);
        System.out.println(distinct);
    }

    // With Strings
    @Test
    public void distinctPracticeTwo() throws Exception {
        List<String> names = List.of("Giovanny", "Giovanny", "Hi", "Oh", "Oh");
        List<String> namesTwo = names.stream()
                .distinct()
                .collect(Collectors.toList());
        assertThat(namesTwo).hasSize(3);
        namesTwo.forEach(System.out::println);


    }
}
