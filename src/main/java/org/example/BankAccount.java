package org.example;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    public static List<BankAccount> allAccounts = new ArrayList<>();
    private double balance;
    private int id;

    public BankAccount(int id) {
        this.id = id;
        allAccounts.add(this);
    }

    public void deposit(double depositAmount) {
        balance = balance + depositAmount;
        System.out.println("Deposited €"+depositAmount+". New balance €"+balance);
    }

    public void withdraw(double withdrawalAmount){
        if ((balance-withdrawalAmount) >= 0){
            balance = balance - withdrawalAmount;
            System.out.println("Withdrawal successful. New balance €"+balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}