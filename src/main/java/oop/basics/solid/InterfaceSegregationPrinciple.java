package oop.basics.solid;

// Small, specific interfaces
interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

// Class implements only what it needs
class SimplePrinter implements Printer {
    @Override
    public void print() {
        System.out.println("Printing document");
    }
}

class MultiFunctionPrinter implements Printer, Scanner {
    @Override
    public void print() {
        System.out.println("Printing document");
    }

    @Override
    public void scan() {
        System.out.println("Scanning document");
    }
}

public class InterfaceSegregationPrinciple {

    public static void main(String[] args) {
        Printer printer = new SimplePrinter();
        printer.print();
    }
}
