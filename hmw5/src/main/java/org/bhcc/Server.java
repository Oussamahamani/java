package org.bhcc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final int DEFAULT_NUM_THREADS = 6;

    public static void main(String[] args) throws IOException {

        System.out.println("Starting server at:  " + new Date());
        ServerSocket serverSocket = new ServerSocket(8000);

        //  Create Thread Pool
        ExecutorService executor = Executors.newFixedThreadPool(DEFAULT_NUM_THREADS);
        while (true) {
            // Wait for new connection
            Socket socket = serverSocket.accept();
            //  Handle new Request via Thread Pool
            ServerHandler request = new ServerHandler(socket);
            executor.execute(request);
        }
    }
}
