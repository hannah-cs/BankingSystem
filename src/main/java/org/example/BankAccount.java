package org.example;

public class BankAccount {
    private double balance;
    public void deposit(double depositAmount) {
        balance += depositAmount;
        System.out.println("Deposited €"+depositAmount+". New balance €"+balance);
    }

    public void withdraw(double withdrawalAmount){
        if ((balance-withdrawalAmount) >= 0){
            balance -= withdrawalAmount;
            System.out.println("Withdrawal successful. New balance €"+balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}