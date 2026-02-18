package oop.basics.solid;

// Abstraction
interface Discount {
    double apply(double amount);
}

// Extension via new class (no modification)
class StudentDiscount implements Discount {
    @Override
    public double apply(double amount) {
        return amount * 0.9;
    }
}

class SeniorDiscount implements Discount {
    @Override
    public double apply(double amount) {
        return amount * 0.8;
    }
}

// Uses abstraction
class PriceCalculator {
    public double calculate(double amount, Discount discount) {
        return discount.apply(amount);
    }
}

public class OpenClosedPrinciple {

    public static void main(String[] args) {
        PriceCalculator calculator = new PriceCalculator();

        System.out.println(calculator.calculate(100, new StudentDiscount()));
        System.out.println(calculator.calculate(100, new SeniorDiscount()));
    }
}
