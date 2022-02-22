package com.example.demo.model;

public class Zoo {
    Animal animal;

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "animal=" + animal.toString() +
                '}';
    }
}
