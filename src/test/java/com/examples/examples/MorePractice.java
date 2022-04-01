package com.examples.examples;

import com.examples.beans.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MorePractice {

    public static void main(String[] args) {
        System.out.println("Welcome to Functional Programming");

        Person personOne = new Person(4, "g", "g", "g", "m", 4);
        List<String> str = List.of("Hello", "Good Morning!", "Good Evening!");

        // new list
        List<String> newList = newStrList(str);
        newList.forEach(System.out::println);

    }

    // Check if the word Hello exist in the list
    public static List<String> newStrList(List<String> str) {
        return str.stream()
                .filter(s -> s.equals("Hello"))
                .map(s -> s + " was found")
                .collect(Collectors.toList());
    }


}
