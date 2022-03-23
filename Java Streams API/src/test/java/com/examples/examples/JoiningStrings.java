package com.examples.examples;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class JoiningStrings {

    //Exercise
    // Join Strings
    @Test
    public void joiningStrings() throws Exception {
        List<String> names = List.of("anna", "john", "marcos", "helena", "yasmin");
        // "Anna, John, Marcos, Helena, Yasmin"
        // IMPERATIVE WAY
        StringBuilder join = new StringBuilder();

        for (String name : names) {
            join.append(name.substring(0, 1).toUpperCase())
                    .append(name.substring(1))
                    .append(", ");
        }

        System.out.println(join);
        System.out.println(join.substring(0, join.length() - 2)); // this will remove "," at the end


    }

    @Test
    public void joiningStringsWithStream()  {
        List<String> names = List.of("anna", "john", "marcos", "helena", "yasmin");
        // "Anna, John, Marcos, Helena, Yasmin"
        String join = names.stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .collect(Collectors.joining(", "));

        System.out.println(join);

    }

}
