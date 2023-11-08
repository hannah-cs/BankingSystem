package org.example;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        BankAccount sharedAccount = new BankAccount(1234);
        Customer customer = new Customer(sharedAccount);
        Customer customer2 = new Customer(sharedAccount);
        executor.submit(customer);
        executor.submit(customer2);
        executor.shutdown();
    }
}