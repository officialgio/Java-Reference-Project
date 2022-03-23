package com.examples.beans;

public class Student {

    // initialization of data fields
    private final String id;
    private final String firstName;
    private final String lastName;
    private final Integer age;
    private final Integer graduationYear;
    private final String gender;
    private final String email;
    private final String phoneNumber;
    private final String address;

    // constructor (you can create many)
    public Student(String id, String firstName, String lastName, Integer age, Integer graduationYear, String gender, String email, String phoneNumber, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.graduationYear = graduationYear;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    // NOTE: We don't have setters in this case because we're testing
    // getters
    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getGraduationYear() {
        return graduationYear;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    // toString
    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", graduationYear=" + graduationYear +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
