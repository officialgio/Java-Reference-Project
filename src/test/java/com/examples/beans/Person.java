package com.examples.beans;

/**
 * NOTES:
 * It's ideal to have your data fields private and final so that they won't be accessed
 * You can have many constructors of your own.
 * In this case we only have getters because we're only retrieving data and not setting our own manually
 */

public class Person {

    // data fields
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String gender;
    private final Integer age;

    // constructor
    public Person(Integer id,
                  String firstName,
                  String lastName,
                  String email,
                  String gender,
                  Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.age = age;
    }

    // getters (just returns what you want)
    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}