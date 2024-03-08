package org.bhcc;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
public class ServerHandler implements Runnable{
    private Socket socket;
    private DataInputStream inputFromClient;
    private DataOutputStream outputToClient;

    public ServerHandler(Socket socket) throws IOException {
        this.socket = socket;
        this.inputFromClient = new DataInputStream(socket.getInputStream());;
        this.outputToClient = new DataOutputStream(socket.getOutputStream());;
    }

    @Override
    public void run() {
        double radius = inputFromClient.read
}
