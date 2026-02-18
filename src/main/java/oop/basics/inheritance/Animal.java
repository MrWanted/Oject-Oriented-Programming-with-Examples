package oop.basics.inheritance;

public class Animal {

    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void sound() {
        System.out.println("Animal makes a sound");
    }

    public String getName() {
        return name;
    }
}
