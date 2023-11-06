package org.example;

public class Main {
    public static void main(String[] args) {
        BankAccount bank1 = new BankAccount(1234);
        BankAccount bank2 = new BankAccount(4321);
        Customer customer = new Customer();
        Thread customerThread = new Thread(customer);
        customerThread.start();
        Customer customer2 = new Customer();
        Thread customerThread2 = new Thread(customer2);
        customerThread2.start();
    }
}
