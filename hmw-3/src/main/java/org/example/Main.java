package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        System.out.println("Weclome to Amazon.com!");
        LoadingDock dock = new LoadingDock();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.execute(new Robot("R1",dock));
        executor.execute(new Robot("R2",dock));
        executor.execute(new Robot("R3",dock));
        executor.execute(new Truck("T1",dock));
        executor.execute(new Truck("T2",dock));
        executor.shutdown();

    }
}