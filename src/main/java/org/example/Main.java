package org.example;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        BankAccount sharedAccount = new BankAccount(1234);
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer(sharedAccount);
        Customer customer2 = new Customer(sharedAccount);
        executor.submit(customer);
        executor.submit(customer2);
        executor.shutdown();
    }
}