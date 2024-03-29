package org.bhcc;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class parseData {


    /**
     *  function that reads line from a file and saves them one by one into sql database
     * @return number of records that were added to the database
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    static int parse() throws IOException, ClassNotFoundException, SQLException {
        File file = new File("src/main/resources/seattle-weather.csv");
        TextReader reader = new TextReader(file);

        ArrayList<String> lines = reader.getContent();

        //  Load the MySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //  Create connect string
        String connectUrl = "jdbc:mysql://localhost/sample";

        //  Create JDBC Connection
        Connection connection = DriverManager.getConnection(connectUrl, "user", "password");

        Statement statement = connection.createStatement();
        lines.remove(0);
        int recordsAdded = 0;
        for (String line : lines) {


            PreparedStatement preparedStatement = connection.prepareStatement("insert into weather " +
                    "(date, precipitation, temp_max,temp_min,wind,weather)  values (?, ?, ?,?,?,?) ;");


            String[] lineArr = line.split(",");

            String date = lineArr[0];
            double precipitation = Double.parseDouble(lineArr[1]);
            double temp_max = Double.parseDouble(lineArr[2]);
            double temp_min = Double.parseDouble(lineArr[3]);
            double wind = Double.parseDouble(lineArr[4]);
            String weather = lineArr[5];

            preparedStatement.setString(1, date);
            preparedStatement.setDouble(2, precipitation);
            preparedStatement.setDouble(3, temp_max);
            preparedStatement.setDouble(4, temp_min);
            preparedStatement.setDouble(5, wind);
            preparedStatement.setString(6, weather);


            recordsAdded += preparedStatement.executeUpdate();
        }
        System.out.println("Total number of records added:  " + recordsAdded);

        connection.close();
        return recordsAdded;
    }
}
