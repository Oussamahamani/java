package org.bhcc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class StockWriter {
    private final File file;
    private Stock stock;

    public StockWriter(File file, Stock stock) {
        this.file = file;
        this.stock = stock;
    }

    public void write() throws IOException {
        //  Create the IO Classes
        FileOutputStream fileOutputStream = new FileOutputStream(this.file);
        ObjectOutputStream objectOutStream = new ObjectOutputStream(fileOutputStream);

        //  Write Products to File
        objectOutStream.writeObject(this.stock);

        //  Don't forget to close the file
        objectOutStream.close();
    }

}
