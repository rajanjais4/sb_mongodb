package com.mongo.example.sb_mongo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Students")
public class Student {
    int id;
    String Name;
    int age;
    String city;
    public Student(){

    }

    public Student(int id, String name, int age, String city) {
        this.id = id;
        Name = name;
        this.age = age;
        this.city = city;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
