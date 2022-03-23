package com.examples.examples;


import com.examples.beans.Car;
import com.examples.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GroupingData {

    @Test
    public void simpleGrouping() throws Exception {
        Map<String, List<Car>> map = MockData.getCars()
                .stream()
                .collect(Collectors.groupingBy(car -> car.getMake()));

        map.forEach((s, cars) -> {
            System.out.println("Make: " + s);
            cars.forEach(System.out::println);
            System.out.println("-----------");

        });
    }

    // Practice (colors)
    @Test
    public void groupingPractice() throws Exception {
        // Get all the cars that are less than 10k and group them by color
        Predicate<Car> carIsLessThan10k = car -> car.getPrice() < 10_000.00;
        Map<String, List<Car>> map = MockData.getCars()
                .stream()
                .filter(carIsLessThan10k) // check car is less than 10k
                .collect(Collectors.groupingBy(car -> car.getColor())); // group by color
        System.out.println("Cars that are less than 10k"); // print
        System.out.println("---------------------------"); // print
        // print the grouping
        map.forEach((s, cars) -> {
            System.out.println("Color " + s);
            cars.forEach(System.out::println);
            System.out.println("-----------");
        });


    }

    @Test
    public void groupingAndCounting() throws Exception {
        // Group and count Number of occurrences of each element (useful)
        List<String> names = List.of(
                "John",
                "John",
                "Mariam",
                "Alex",
                "Giovanny",
                "Giovanny",
                "Chris",
                "Alex",
                "Alex"
        );
        //1st method
        Map<String, Long> firstMap = names.stream()
                .collect(Collectors.groupingBy(s -> s, // group by element
                        Collectors.counting())); // count those elements
        System.out.println(firstMap);

        System.out.println("----------------------------------------------");
        //2nd method
        Map<String, Long> secondMap = names.stream()
                .collect(Collectors.groupingBy( // group by element and with their corresponding count
                        Function.identity(), // represents the elements of the List
                        Collectors.counting()) // count the number of elements
                );
        System.out.println(secondMap);

    }

    @Test
    public void countNumOfCarsInRedThatAreLessThan20k() throws Exception {
        List<Car> cars = MockData.getCars();

        Predicate<Car> redCarsOnly = car -> car.getColor().equals("Red");
        Predicate<Car> carLessThan20k = car -> car.getPrice() < 20_000.00;
        Long redCars = cars.stream()
                .filter(redCarsOnly) // check to get red cars only
                .filter(carLessThan20k) // check to get prices < 20k
                .collect(Collectors.counting());

        System.out.println("Red cars that are less than 20k: " + redCars); // 12

    }

    @Test
    public void countNumOfRedCars() throws Exception {
        List<Car> cars = MockData.getCars();

        Long numOfRedCars = cars.stream()
                .filter(car -> car.getColor().equals("Red"))
                .collect(Collectors.counting());

        System.out.println("Number of Red Cars: " + numOfRedCars); // 67

    }
}