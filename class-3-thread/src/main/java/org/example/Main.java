package org.example;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Main {
    public static void main(String[] args) {

//        System.out.println("Hello world!");
//
//        PrintGoodby by = new PrintGoodby();
//        Thread threadby = new Thread(by);
//        threadby.run();
//
//        PrintHello hello = new PrintHello();
//        Thread threadhello = new Thread(hello);
//        threadhello.run();



//        Thread thread1 = new Thread("object")
//                thread1.run();

        BankAccount bankAccount = new BankAccount();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new DepositTask(bankAccount));
        executor.execute(new WithdrawTask(bankAccount));
        executor.shutdown();
        System.out.println("Thread 1\t\tThread 2\t\tBalance");
    }
}