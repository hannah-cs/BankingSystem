package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class BankAccount {
    public static List<BankAccount> allAccounts = new ArrayList<>();
    private double balance;
    private int id;
    private ExecutorService executor;

    public BankAccount(int id) {
        this.id = id;
        allAccounts.add(this);
        executor = Executors.newCachedThreadPool();
    }
    public Future<Double> deposit(double depositAmount) {
        return executor.submit(() -> {
            balance = balance + depositAmount;
            System.out.println("Deposited €" + depositAmount + ". New balance €" + balance);
            return balance;
        });
    }


    public Future<Double> withdraw(double withdrawalAmount) {
        return executor.submit(() -> {
            if ((balance - withdrawalAmount) >= 0) {
                balance = balance - withdrawalAmount;
                System.out.println("Withdrawal successful. New balance €" + balance);
                return balance;
            } else {
                System.out.println("Insufficient funds.");
                return -1.0;
            }
        });
    }
}