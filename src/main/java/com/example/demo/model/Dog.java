package com.example.demo.model;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("Animal")
public class Dog extends Animal {

    String sound;


    public Dog(String name, String age) {
        super(name, age);
        sound = "mung mung";
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id='" + id + '\'' +
                "sound='" + sound + '\'' +
                '}';
    }
}
