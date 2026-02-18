package oop.basics;

public class EncapsulationExample {

    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.deposit(500);

        System.out.println("Balance: " + account.getBalance());
    }
}

class BankAccount {
    private double balance; // encapsulated data

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}
