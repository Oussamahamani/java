package org.bhcc;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Hello world!");
        File file = new File("stocks");

        Stock stock = new Stock("AAPL", 170.12,-4.98,"2.84%");
        StockWriter writer = new StockWriter(file,stock);
        writer.write();

        StockReader reader = new StockReader(file);
        Stock newStock = reader.getStock();
        System.out.println(newStock.currentValue);





    }
}