package org.bhcc;
import java.io.*;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * handle a weather request
 */
public class ServerHandler implements Runnable {

    private final Socket socket;
    private final DataInputStream inputFromClient;
    private final ObjectOutputStream objectOutputToClient;

    /**
     * Constructor
     */
    public ServerHandler(Socket socket) throws IOException {
        this.socket = socket;
        this.inputFromClient = new DataInputStream(socket.getInputStream());
        this.objectOutputToClient = new ObjectOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {

        try {
            String date = inputFromClient.readUTF();
            System.out.println("Received a request to find weather for "+date);
            Weather day = new Weather(date);
            objectOutputToClient.writeObject(day);
            objectOutputToClient.flush();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
