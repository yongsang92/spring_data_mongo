package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Document("Animal")
public class Cat extends Animal {

    String sound;

    public Cat(String name, String age) {
        super(name, age);
        sound = "yaong yaong";
    }

    @Override
    public String toString() {
        return "Cat{" + "id='" + id +
                "sound='" + sound + '\'' +
                '}';
    }
}
