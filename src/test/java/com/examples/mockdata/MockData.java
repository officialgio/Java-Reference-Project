package com.examples.mockdata;


import com.examples.beans.Car;
import com.examples.beans.Person;
import com.examples.beans.Student;
import com.google.common.io.Files;
import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MockData {

    public static List<Person> getPeople() throws IOException {
        // Read the file
        InputStream inputStream = Resources.getResource("people.json").openStream();
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        // Assume you want to parse a JSON to Java class with Gson library.
        // Now, you have to specifically tell Gson, that:
        // You want this JSON to be translated to a List of User objects.
        Type listType = new TypeToken<ArrayList<Person>>() {
        }.getType();
        return new Gson().fromJson(json, listType);
    }

    public static List<Car> getCars() throws IOException {
        InputStream inputStream = Resources.getResource("cars.json").openStream();
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        Type listType = new TypeToken<ArrayList<Car>>() {
        }.getType();
        return new Gson().fromJson(json, listType);
    }

    public static List<Student> getStudents() throws IOException {
        InputStream inputStream = Resources.getResource("students.json").openStream();
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        Type listType = new TypeToken<ArrayList<Student>>() {
        }.getType();
        return new Gson().fromJson(json, listType);
    }

}
