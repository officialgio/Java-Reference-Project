package com.examples.examples;

import com.examples.beans.Car;
import com.examples.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filtering {

    @Test
    public void filter() throws Exception {
        List<Car> cars = MockData.getCars();
        // filter tales a predicate (returns a boolean value)
        // NOTE: you may have as many filters

        // less
        List<Car> carsLessThan20k = cars.stream()
                .filter(car -> car.getPrice() < 20_000.00) // checks if car price is < 20k
                .filter(car -> car.getColor().equals("Yellow")) // checks if car color == "Yellow"
                .collect(Collectors.toList());


        carsLessThan20k.forEach(System.out::println); // loop


    }

    //Practice
    @Test
    public void filterPractice() throws Exception {
        List<Car> cars = MockData.getCars();

        // greater
        Predicate<Car> yellow = car -> car.getColor().equals("Yellow");
        Predicate<Car> carPredicate = car -> car.getPrice() > 20_000.00;
        List<Car> carsGreaterThan20k = cars.stream()
                .filter(carPredicate)
                .filter(yellow)
                .collect(Collectors.toList());

        carsGreaterThan20k.forEach(System.out::println);


    }

    // Practice 2
    @Test
    public void filterPracticeTwo() throws Exception {
        List<Car> cars = MockData.getCars();
        Predicate<Car> carIsLessThan10k = car -> car.getPrice() < 10_000.00;
        Predicate<Car> carIsRed = car -> car.getColor().equals("Red");
        List<Car> redCarIsLessThan10k = cars.stream()
                .filter(carIsLessThan10k)
                .filter(carIsRed)
                .collect(Collectors.toList());

        redCarIsLessThan10k.forEach(System.out::println);


    }


    @Test
    public void dropWhile() throws Exception {
        System.out.println("using filter");
        Stream.of(2, 4, 6, 8, 9, 10, 12).filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
        System.out.println("using dropWhile");
        Stream.of(2, 4, 6, 8, 9, 10, 12).dropWhile(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));

    }

    @Test
    public void takeWhile() throws Exception {
        // using filter
        System.out.println("using filter");
        Stream.of(2, 4, 6, 8, 9, 10, 12).filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));

        System.out.println();
        // takeWhile = as long as the condition is met else skips the rest
        System.out.println("using take while");
        Stream.of(2, 4, 6, 8, 9, 10, 12).takeWhile(n -> n % 2 == 0)
                .forEach(System.out::println);


    }

    @Test
    public void findFirst() throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 3, 10};
        // find a value else return some other value
        // findFirst returns a optional but in this case it's not
        // findFirst finds the first occurrence then returns that
        int result = Arrays.stream(numbers).filter(n -> n == 9) // if some element == 9
                .findFirst() // find that element
                .orElse(-1); // otherwise, return -1
        System.out.println(result);


    }

    @Test
    public void findAny() throws Exception {
        // if the object, int, etc is the same it will find those elements
        // this finds all occurrences
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10};
        int result = Arrays.stream(numbers).filter(n -> n == 9)
                .findAny()
                .orElse(-1);
        System.out.println(result);
    }

    @Test
    public void allMatch() throws Exception {
        int[] even = {2, 4, 6, 8, 10};
        // check if all elements match a certain condition
        // allMatch returns a boolean
        boolean allMatch = Arrays.stream(even).allMatch(n -> n % 2 == 0);
        System.out.println(allMatch);
    }

    @Test
    public void anyMatch() throws Exception {
        int[] evenAndOneOdd = {2, 4, 6, 8, 10, 11};

        // at least some elements match at least one condition
        boolean anyMatch = Arrays.stream(evenAndOneOdd).anyMatch(n -> !(n % 2 == 0));
        System.out.println(anyMatch);
    }

}



