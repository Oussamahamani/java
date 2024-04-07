package org.bhcc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * reads from a file 
 */
public class TextReader {
    private final File file;
    private final ArrayList<String> lines = new ArrayList<>();

    /**
     * Constructor
     */
    public TextReader(File file) throws IOException {
        this.file = file;

        // Create the IO Classes
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        //  Read in the Lines
        String line = bufferedReader.readLine();
        while (line != null) {
            lines.add(line);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
    }

    /**
     * Get the File Contents.
     *
     * @return ArrayList of String Objects.
     */
    public ArrayList<String> getContent() {
        return lines;
    }

}
