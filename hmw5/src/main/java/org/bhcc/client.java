package org.bhcc;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class client {
    /**
     * makes a request to a server, sends a date and receive a weather object
     * @param args date
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 8000);


        String date =   args[0];
        DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
        ObjectInputStream fromServer = new ObjectInputStream(socket.getInputStream());
        System.out.println("Date:  " + date);

        toServer.writeUTF(date);
        toServer.flush();
        Weather day = (Weather) fromServer.readObject();
        System.out.println("Weather is "+day.getWeather());
        System.out.println("Max temp is "+day.getTemp_max());
        System.out.println("Lowest temp is "+day.getTemp_min());
        System.out.println("precipitation is "+day.getPrecipitation());
        System.out.println("wind is "+day.getWind());
        socket.close();
    }
}
