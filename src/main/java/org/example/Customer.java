package org.example;
import java.util.Scanner;

public class Customer implements Runnable {
        public int balance;
        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
        Thread depositThread = new Thread(() -> {
            try {
                System.out.println("Enter deposit amount");
                int deposit = scanner.nextInt();
                balance =+ deposit;
                System.out.println("Processing deposit...");
                Thread.sleep(1000);
                System.out.println("Deposit successful. New balance: €"+balance);
            } catch (InterruptedException e) {
                System.err.println("Thread was interrupted");
            }
        });
            depositThread.start();
    }
    public static void main(String[] args) {
        Customer customer = new Customer();
        Thread customerThread = new Thread(customer);
        customerThread.start();
        Customer customer2 = new Customer();
        Thread customerThread2 = new Thread(customer2);
        customerThread2.start();
    }
}