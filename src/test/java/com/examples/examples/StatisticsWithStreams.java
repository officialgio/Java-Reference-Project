package com.examples.examples;


import com.examples.beans.Car;
import com.examples.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Stream;

public class StatisticsWithStreams {
    // perform counting with streams
    @Test
    public void count() throws Exception {
        List<Car> cars = MockData.getCars();
        // find Fords that are greater than the year 2010
        long count = cars.stream()
                .filter(car -> car.getMake().equalsIgnoreCase("Ford"))
                .filter(car -> car.getYear() > 2010) // above 2010 year
                .count(); // returns a count of elements (Type long)

        System.out.println("Number of Fords that are above 2010: " + count);
        //Number of Fords that are above 2010: 10

    }

    @Test
    public void min() throws Exception {
        List<Car> cars = MockData.getCars();

        // find the cheapest car
        double min = cars.stream()
                .mapToDouble(car -> car.getPrice()) // get the price
                .min() // get the min
                .orElse(0); // if the list is empty return 0 (checks)
        System.out.println("Lowest car price: " + min);
        // Lowest car price: 5005.16

    }

    @Test
    public void max() throws Exception {
        List<Car> cars = MockData.getCars();
        // find the most expensive car
        double max = cars.stream()
                .mapToDouble(car -> car.getPrice())
                .max()
                .orElse(0);
        System.out.println("The most expensive car: " + max);


    }


    @Test
    public void average() throws Exception {
        // find average of cars
        List<Car> cars = MockData.getCars();

        double avg = cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);

        System.out.println(avg);


    }

    @Test
    public void sum() throws Exception {
        // find sum
        List<Car> cars = MockData.getCars();

        double sum = cars.stream()
                .mapToDouble(car -> car.getPrice()) // get price
                .sum(); // returns the sum

        // use BigDecimal to handle money
        System.out.println(BigDecimal.valueOf(sum));


    }

    @Test
    public void statistics() throws Exception {
        // use this if you need everything right away
        // otherwise use proper method for each single one
        List<Car> cars = MockData.getCars();
        DoubleSummaryStatistics statistics = cars.stream()
                .mapToDouble(Car::getPrice)
                .summaryStatistics();
        System.out.println("Count of Cars: " + statistics.getCount());
        System.out.println("Cheapest Car: " + statistics.getMin());
        System.out.println("Most Expensive Car: " + statistics.getMax());
        System.out.println("Average Car Price: " + statistics.getAverage());
        System.out.println("Sum of Cars: " + BigDecimal.valueOf(statistics.getSum()));


    }

}