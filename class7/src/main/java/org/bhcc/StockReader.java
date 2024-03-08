package org.bhcc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class StockReader {
    private Stock stock;

    public   StockReader(File file) throws IOException, ClassNotFoundException {
        //  Create the IO Classes
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        //  Read Student from File
        this.stock = (Stock) objectInputStream.readObject();

        //  Don't forget to close the file
        objectInputStream.close();
    }


    public  Stock getStock(){
        return this.stock;
    }
}
