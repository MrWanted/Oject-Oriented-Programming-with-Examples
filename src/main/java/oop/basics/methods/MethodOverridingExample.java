package oop.basics.methods;

// Parent class
class Animal {
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

// Child class
class Dog extends Animal {

    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}

public class MethodOverridingExample {

    public static void main(String[] args) {
        Animal animal = new Dog(); // Polymorphism
        animal.sound(); // Happens at runtime. Calls Dog's implementation
    }
}
