package com.example.demo.model;

public class Animal {

    String id;

    String name,age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    Animal(String name,String age){
        this.name=name;
        this.age=age;
    }
}
