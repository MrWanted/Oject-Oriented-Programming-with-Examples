# Object-Oriented Programming (OOP) – Java Notes & Examples

This repository contains concise explanations and Java examples covering core **Object-Oriented Programming** concepts, principles, and best practices.

---

## 1. Object-Oriented Programming (OOP)

OOP is a programming paradigm that models software using **objects** that represent real-world entities.
Objects encapsulate **state (data)** and **behavior (methods)** and interact with each other.

---

## 2. Core OOP Principles

### 2.1 Abstraction

Focuses on **what** an object does rather than **how** it does it.

```java
interface PaymentService {
    void pay(double amount);
}
```

---

### 2.2 Encapsulation

Bundles data and behavior together and restricts direct access to internal state.

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

Allows a class to reuse and extend another class.

```java
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
}
```

---

### 2.4 Polymorphism

Allows different objects to be treated as the same type while behaving differently.

```java
Animal animal = new Dog();
animal.sound(); // Dog barks
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
