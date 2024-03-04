package org.example;

public class PrintHello implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000 ; i++) {
            System.out.print("hello");
        }
    }
}
