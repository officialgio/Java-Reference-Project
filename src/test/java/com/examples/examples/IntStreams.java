package com.examples.examples;


import com.examples.beans.Person;
import com.examples.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class IntStreams {

    @Test
    public void range() throws Exception {
        System.out.println("with for loop");
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
        }

        //.range
        System.out.println("With int stream exclusive (limit) ");
        IntStream.range(0, 10).forEach(System.out::println);

        //.rangeClosed
        System.out.println("With int stream inclusive (limit) ");
        IntStream.rangeClosed(0, 10).forEach(System.out::println);

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("print array ");
        Arrays.stream(arr).forEach(s -> System.out.println(s));


    }

    // Loop through people using IntStream
    @Test
    public void rangeIteratingLists() throws Exception {
        List<Person> people = MockData.getPeople();
        IntStream.range(0, people.size())
                .forEach(index -> {
                    System.out.println(people.get(index));
                });


//        // Same
//        IntStream.range(0, people.size())
//                .forEach(index -> System.out.println(people.get(index)));

    }

    @Test
    public void intStreamIterate() {
        IntStream.iterate(0, value -> value + 1)
                .limit(11)
                .forEach(System.out::println);

    }
}
