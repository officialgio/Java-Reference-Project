package com.examples.examples;

import com.examples.beans.Car;
import com.examples.beans.Person;
import com.examples.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {

    @Test
    public void sortingElements() throws IOException {
        List<Person> people = MockData.getPeople();
        // sorting names by first name
        List<String> sorted = people.stream()
                .map(person -> person.getFirstName()) // get first name
                .sorted() // sort the elements from A-Z in natural order
                .collect(Collectors.toList());

        sorted.forEach(System.out::println);
    }

    @Test
    public void sortingElementsInReverse() throws IOException {
        List<Person> people = MockData.getPeople();

        // Do the reverse sorting
        // Comparator compares objects
        List<String> sorted = people.stream()
                .map(person -> person.getFirstName())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        sorted.forEach(System.out::println);
    }

    @Test
    public void sortingOfObjects() throws IOException {
        List<Person> people = MockData.getPeople();

        // Sort all objects without mapping (if that's your case)
        List<Person> sort = people.stream()
                .sorted(Comparator.comparing(Person::getFirstName))
                .collect(Collectors.toList());

        sort.forEach(System.out::println);

    }

    // practice
    @Test
    public void sortingOfObjectsTwo() throws IOException {
        List<Person> people = MockData.getPeople();

        // Sort all objects without mapping (if that's your case)
        // you can also compare many things or sort many things at once
        // sort the objects by name(A-Z) and sort by age as well(1++)
        List<Person> sort = people.stream()
                .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getFirstName))
                .collect(Collectors.toList());

        sort.forEach(System.out::println);

    }

    // practice
    @Test
    public void sortingSteamOfObjetsThree() throws IOException {
        List<Person> people = MockData.getPeople();

        // Sort all objects without mapping (if that's your case)
        // sort emails (you can do with any data)
        List<String> sortedListOfEmails = people.stream()
                .filter(person -> person.getEmail().contains("gov"))
                .map(Person::getEmail)
                .sorted()
                .collect(Collectors.toList());


        sortedListOfEmails.forEach(System.out::println);


    }

    @Test
    public void topTenMostExpensiveBlueCars() throws IOException {
        List<Car> cars = MockData.getCars();

        List<Car> topTen = cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase("Blue"))
                .sorted(Comparator.comparing(Car::getPrice).reversed())
                .limit(10)
                .collect(Collectors.toList());

        topTen.forEach(System.out::println);


    }

    // Practice
    @Test
    public void topTenMostCheapestBlueCars() throws IOException {
        List<Car> cars = MockData.getCars();

        List<Double> topBlueCars = cars.stream()
                .filter(car -> car.getColor().equals("Blue"))
                .map(Car::getPrice)
                .sorted()
                .limit(10)
                .collect(Collectors.toList());

        topBlueCars.forEach(System.out::println);


    }


}
