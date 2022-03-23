package com.examples.examples;

import com.examples.beans.Car;
import com.examples.beans.Person;
import com.examples.beans.PersonDTO;
import com.examples.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class TransformationsMapAndReduce {

    @Test
    void yourFirstTransformationWithMap() throws IOException {
        // map takes a function (returns one result)
        List<Person> people = MockData.getPeople();
        Function<Person, PersonDTO> personPersonDTOFunction = person -> new PersonDTO( // transform it to a new type class DTO
                person.getId(),
                person.getFirstName(),
                person.getAge());
        List<PersonDTO> dtos = people.stream()
                .filter(person -> person.getAge() > 20) // check people that age is < 20
                .map(personPersonDTOFunction)
                .collect(Collectors.toList()); // returns a new list of PersonDTO

        //assertThat(people.size()).isEqualTo(dtos.size()); (check same size to get same list transformed)
        dtos.forEach(System.out::println);
    }

    @Test
    void PracticeTransformationWithMap() throws IOException {
        // Get people whose name is Allister and transform it to a DTO.
        System.out.println("Allister PersonDTO");
        List<Person> people = MockData.getPeople();
        List<PersonDTO> allisterList = people.stream()
                .filter(person -> person.getFirstName().equals("Allister")) // getting people whose name is Allister
                .map(person -> new PersonDTO(
                        person.getId(),
                        person.getFirstName(),
                        person.getAge()))
                .collect(Collectors.toList());
        allisterList.forEach(System.out::println);

        System.out.println("-----------");

        System.out.println("Male only PersonDTO");
        List<PersonDTO> maleOnly = people.stream()
                .filter(person -> person.getGender().equals("Male"))
                .map(person -> new PersonDTO(
                        person.getId(),
                        person.getFirstName(),
                        person.getAge()
                ))
                // sort it and make sure to sort it by name and age 1-100..(age) && A-Z(name)
                .sorted(Comparator.comparing((PersonDTO personDTO) -> personDTO.getAge()).thenComparing(personDTO1 -> personDTO1.getName()))
                .collect(Collectors.toList());

        assertThat(allisterList).hasSize(2);

        maleOnly.forEach(System.out::println);


    }


    @Test
    void mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> cars = MockData.getCars();
        // map to double and get the average price

        double avg = cars.stream()
                .mapToDouble(car -> car.getPrice()) // get the price
                .average() // method to find average
                .orElse(0);// what if the list is empty = return 0
        System.out.println(avg); // 52693.19979

    }

    @Test
    public void reduce() {
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};
        // addition and subtraction operations using reduce
        int sum = Arrays.stream(integers).reduce(0, (a, b) -> a + b); // addition
        int sub = Arrays.stream(integers).reduce(0, (a, b) -> a - b); // subtraction
        System.out.println(sum);
        System.out.println(sub);


    }
}

