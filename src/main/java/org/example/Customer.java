package org.example;

import java.util.Scanner;

public class Customer implements Runnable {
    private BankAccount bankAccount;
    public Customer(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        Thread depositThread = new Thread(() -> {
            try {
                System.out.println("Enter deposit amount");
                double deposit = scanner.nextDouble();
                System.out.println("Processing deposit...");
                Thread.sleep(1000);
                bankAccount.deposit(deposit);
            } catch (InterruptedException e) {
                System.err.println("Thread was interrupted");
            }
        });

        depositThread.start();
    }
}