package org.example;
public class Main {
    public static void main(String[] args) {
        BankAccount sharedAccount = new BankAccount(1234);
        Customer customer = new Customer(sharedAccount);
        Thread customerThread = new Thread(customer);
        Customer customer2 = new Customer(sharedAccount);
        Thread customerThread2 = new Thread(customer2);
        customerThread.start();
        customerThread2.start();
    }
}