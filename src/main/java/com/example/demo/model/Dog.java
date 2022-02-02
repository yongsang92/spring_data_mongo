package com.example.demo.model;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("dog")
public class Dog {

    String id,age;
    @Field("name_is")
    String name;

    public Dog(String name, String age) {
        this.name = name;
        this.age = age;
    }
    public Dog(){

    }


    @Override
    public String toString() {
        return "Dog{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

}
