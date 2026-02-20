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

---

### O – Open/Closed Principle (OCP)

Classes should be open for extension but closed for modification.

---

### L – Liskov Substitution Principle (LSP)

Subclasses must be usable wherever their parent class is expected.

---

### I – Interface Segregation Principle (ISP)

Clients should not depend on methods they do not use.

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
