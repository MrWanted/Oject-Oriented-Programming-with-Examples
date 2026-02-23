# Object-Oriented Programming (OOP) – Java Notes & Examples

This repository contains concise explanations and Java examples covering core **Object-Oriented Programming** concepts, principles, and best practices.

---
## Contents

1. Object-Oriented Programming (OOP)
2. Core OOP Principles
    - 2.1 Abstraction
    - 2.2 Encapsulation
    - 2.3 Inheritance
    - 2.4 Polymorphism
3. SOLID Principles
    - S – Single Responsibility Principle (SRP)
    - O – Open/Closed Principle (OCP)
    - L – Liskov Substitution Principle (LSP)
    - I – Interface Segregation Principle (ISP)
    - D – Dependency Inversion Principle (DIP)
4. Dependency Injection (DI)
5. Method Overriding
6. Anemic vs Rich Domain Model
7. Collections & Polymorphism
8. Static vs Non-Static Methods
9. Summary

---

## 1. Object-Oriented Programming (OOP)

OOP is a programming paradigm that models software using **objects** that represent real-world entities.
Objects encapsulate **state (data)** and **behavior (methods)** and interact with each other.

---

## 2. Core OOP Principles

### 2.1 Abstraction

Focuses on **what** an object does rather than **how** it does it.
In Java, abstraction is achieved in two ways:
```java
interface PaymentService {
    void pay(double amount);
}

abstract class Animal {
   String name;

   // Abstract method - no implementation
   abstract void makeSound();
}
```

---

### 2.2 Encapsulation

Bundles data and behavior together and restricts direct access to internal state.
It's achieved using access modifiers + getters and setters.
```java
class Account {
    private double balance;

    public double getBalance() {
        return balance;
    }
}
```

---

### 2.3 Inheritance

Inheritance allows a class to acquire the properties and behaviors of another class, promoting code reuse.

```java
// Parent class
public class Animal {
   String name;
   int age;

   public Animal(String name, int age) {
      this.name = name;
      this.age = age;
   }
   public void sleep() {
   }
}
// Child class
public class Dog extends Animal {
   String breed;

   public Dog(String name, int age, String breed) {
      super(name, age); // calls Animal's constructor
      this.breed = breed;
   }
   // Overriding parent behavior (Polymorphism 👀)
   @Override
   public void eat() {
      System.out.println(name + " is eating dog food.");
   }
}
```

---

### 2.4 Polymorphism

The ability of one object to behave differently depending on the context.
```java
//1. Compile-Time Polymorphism (Method Overloading)
class Calculator {
   // Same method name, different parameters
   public int add(int a, int b) {
      return a + b;
   }

   public double add(double a, double b) {
      return a + b;
   }

   public int add(int a, int b, int c) {
      return a + b + c;
   }
}

//2. Runtime Polymorphism (Method Overriding)
class Shape {
   public void draw() {
   }
}

class Circle extends Shape {
   @Override
   public void draw() {
   }
}

class Rectangle extends Shape {
   @Override
   public void draw() {
   }
}

// Parent reference, child objects — this is the magic
//The reference type is Shape, but Java looks at the actual object at runtime to decide which draw() to call. 
// This is called Dynamic Method Dispatch.
Shape s1 = new Circle();
Shape s2 = new Rectangle();

s1.draw(); 
s2.draw();
//Another example
Shape[] shapes = { new Circle(), new Rectangle(), new Triangle() };

for (Shape shape : shapes) {
        shape.draw(); // each behaves differently!
}

```

---

## 3. SOLID Principles

### S – Single Responsibility Principle (SRP)

A class should have only one reason to change.

```java
// ❌ Bad - this class does too much
class Employee {
   public void calculateSalary() { }
   public void saveToDatabase() { }
   public void generatePayslipPDF() { }
}

// ✅ Good - each class has one responsibility
//If salary logic changes, only SalaryCalculator changes. Nothing else is affected.
class SalaryCalculator {
   public void calculateSalary() { }
}

class EmployeeRepository {
   public void saveToDatabase() { }
}

class PayslipGenerator {
   public void generatePayslipPDF() { }
}
```
---

### O – Open/Closed Principle (OCP)

Classes should be open for extension but closed for modification.
```java
// ❌ Bad - every new shape requires modifying this class
class AreaCalculator {
   public double calculate(Object shape) {
      if (shape instanceof Circle) {
         // calculate circle area
      } else if (shape instanceof Rectangle) {
         // calculate rectangle area
      }
      // adding Triangle means editing this class again!
   }
}

// ✅ Good - extend without touching existing code
interface Shape {
   double calculateArea();
}

class Circle implements Shape {
   double radius;
   public double calculateArea() { return Math.PI * radius * radius; }
}

class Rectangle implements Shape {
   double width, height;
   public double calculateArea() { return width * height; }
}

// Adding a new shape? Just create a new class. Nothing else changes.
class Triangle implements Shape {
   double base, height;
   public double calculateArea() { return 0.5 * base * height; }
}
```
---

### L – Liskov Substitution Principle (LSP)

Subclasses must be usable wherever their parent class is expected.
If S extends P, you should be able to use S wherever P is expected — without surprises.
---
```java
// Violating Liskov Substitution Principle

class Bird {
   public void fly() {
      System.out.println("This bird can fly.");
   }
}

class Eagle extends Bird {
   // Eagles can fly, so we don't change anything here.
}

class Penguin extends Bird {
   @Override
   public void fly() {
      throw new UnsupportedOperationException("Penguins can't fly.");
   }
}

// Correcting Liskov Substitution Principle

interface Flyable {
   void fly();
}

class Bird {
   public void eat() {
      System.out.println("This bird is eating.");
   }
}

class Eagle extends Bird implements Flyable {
   @Override
   public void fly() {
      System.out.println("This eagle can fly.");
   }
}

class Penguin extends Bird {
   // Penguins cannot fly, so we don't implement Flyable here.
}
```

### I – Interface Segregation Principle (ISP)

Clients should not depend on methods they do not use.

```java
// A class should not be forced to implement interfaces it doesn't use
// ❌ Bad - not all workers can do all things
interface Worker {
   void work();
   void eat();
   void sleep();
}

class Robot implements Worker {
   public void work() { System.out.println("Working..."); }
   public void eat() { } // ❓ Robots don't eat — forced to implement this!
   public void sleep() { } // ❓ Robots don't sleep either!
}

// ✅ Good - split into focused interfaces
interface Workable {
   void work();
}

interface Eatable {
   void eat();
}

interface Sleepable {
   void sleep();
}

class Human implements Workable, Eatable, Sleepable {
   public void work() { System.out.println("Working..."); }
   public void eat() { System.out.println("Eating..."); }
   public void sleep() { System.out.println("Sleeping..."); }
}

class Robot implements Workable {
   public void work() { System.out.println("Working..."); }
   // No forced empty implementations!
}
```

---

### D – Dependency Inversion Principle (DIP)

Depend on abstractions, not concrete implementations.

---

## 4. Dependency Injection (DI)

Dependencies are provided to a class instead of being created inside it.

```java
interface MessageService {
    void send(String message);
}

class EmailService implements MessageService {
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}

class NotificationService {
    private final MessageService messageService;

    public NotificationService(MessageService messageService) {
        this.messageService = messageService;
    }
}
```

---

## 5. Method Overriding

Occurs when a subclass provides its own implementation of a superclass method.

```java
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
```

---

## 6. Anemic vs Rich Domain Model

### Anemic Domain Model

Business logic lives in services, not domain objects.

```java
class Account {
    private double balance;
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}
```

---

### Rich Domain Model

Business logic lives inside the domain object.

```java
class Account {
    private double balance;

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalStateException("Insufficient funds");
        }
        balance -= amount;
    }
}
```

---

## 7. Collections & Polymorphism

```java
List<String> names = new ArrayList<>();
names.add("Alice");
names.add("Bob");

List<String> otherNames = new LinkedList<>();
otherNames.add("Charlie");
otherNames.add("David");
```

**Polymorphism:**
Both lists are treated as `List<String>`.

---

## 8. Static vs Non-Static Methods

A static method cannot directly call a non-static method.

```java
class Example {
    void nonStaticMethod() {
        System.out.println("Non-static");
    }

    static void staticMethod() {
        Example example = new Example();
        example.nonStaticMethod();
    }
}
```

---

## 9. Summary

* OOP promotes **maintainable, reusable, and scalable code**
* Encapsulation + Abstraction reduce complexity
* Polymorphism + Interfaces enable flexibility
* SOLID principles guide good OO design

---
