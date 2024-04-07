package org.bhcc;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class server {

    public static void main(String[] args) throws IOException {

        System.out.println("Starting server at:  " + new Date());

        //  Start Server
        ServerSocket serverSocket = new ServerSocket(8000);

        // Wait for Client Connection
        Socket socket = serverSocket.accept();
        InetAddress inetAddress = socket.getInetAddress();
        System.out.println("Got client request from:  " + inetAddress.getHostAddress());

        //  Set up the In/Out Streams
        DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
        DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

        // Receive radius from the client
        int limit = inputFromClient.readInt();
        // Compute area
        int randomInt = (int) Math.floor(Math.random() *limit  );

        // Track Progress
        System.out.println("Got limit:  " + limit);
        System.out.println("generated number:  " + randomInt);

        // Send result back to client
        outputToClient.writeInt(randomInt);
        outputToClient.flush();

        //  Stop everything
        socket.close();
        serverSocket.close();
        System.out.println("Stopping server at:  " + new Date());
    }
}
