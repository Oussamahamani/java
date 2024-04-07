package org.bhcc;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8000);

        //  Get radius from command line

        int limit =   Integer.parseInt(args[0]);
        DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
        DataInputStream fromServer = new DataInputStream(socket.getInputStream());

        System.out.println("Sending limit:  " + limit);
        toServer.writeDouble(limit);
        toServer.flush();
        int randomInt = fromServer.readInt();
        System.out.println("Received randomInt:  " + randomInt);
        socket.close();
    }
}
