package oop.basics;

public class ObjectExample {

    public static void main(String[] args) {
        Person person = new Person("John", 30);
        person.introduce();
    }
}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void introduce() {
        System.out.println("My name is " + name + " and I am " + age + " years old.");
    }
}
