package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    public static void main(String[] args) {

     Logger logger=   LoggerFactory.getLogger(Main.class);
        logger.info("This is an info message");
        logger.warn("This is a warning");
        logger.error("This is an error");
        System.out.println("Hello jioji!");
    }
}