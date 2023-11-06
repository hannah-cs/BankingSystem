package org.example;
import java.util.Scanner;

public class Customer implements Runnable {
        public double balance;
        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
        Thread depositThread = new Thread(() -> {
            try {
                System.out.println("Enter account number");
                int accountId = scanner.nextInt();
                for (BankAccount bankAccount : BankAccount.allAccounts) {
                    if (bankAccount.getId() == accountId) {
                        Thread.sleep(1000);
                        System.out.println("Enter deposit amount");
                        double deposit = scanner.nextDouble();
                        System.out.println("Processing deposit...");
                        bankAccount.deposit(deposit);
                    }
                }
            } catch (InterruptedException e) {
                System.err.println("Thread was interrupted");
            }
        });
            depositThread.start();
    }

}