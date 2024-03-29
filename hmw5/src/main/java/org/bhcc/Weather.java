package org.bhcc;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;
import java.io.IOException;
import java.sql.*;
public class Weather implements Serializable {

    public double precipitation, temp_max, temp_min,wind;
    public String weather;




    /**
     * Constructor
     */
    public Weather(String date) throws IOException, ClassNotFoundException, SQLException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
//        // to see how IntelliJ IDEA suggests fixing it.
        Class.forName("com.mysql.cj.jdbc.Driver");

        //  Create connect string
        String connectUrl = "jdbc:mysql://localhost/sample";

        //  Create JDBC Connection
        Connection connection = DriverManager.getConnection(connectUrl, "user", "password");

        //  Create the SQL Statement
        Statement statement = connection.createStatement();


        //  To query for data, use executeQuery()
        ResultSet resultSet = statement.executeQuery("select * from weather WHERE DATE = \"" +date+"\"");

        while (resultSet.next()) {
            this.precipitation = resultSet.getDouble("precipitation");
            this.temp_max = resultSet.getDouble("temp_max");
            this.temp_min = resultSet.getDouble("temp_min");
            this.wind = resultSet.getDouble("wind");
            this.weather = resultSet.getString("weather");
        }
        System.out.println("found one for "+this.weather);
        //  Clean up
        connection.close();
    }

    /**
     * @return weather precipitation
     */
    public double getPrecipitation() {
        return precipitation;
    }

    /**
     * @return weather max temperature
     */
    public double getTemp_max() {
        return temp_max;
    }

    /**
     * @return weather minimum temperature
     */
    public double getTemp_min() {
        return temp_min;
    }

    /**
     * @return weather wind for the day
     */
    public double getWind() {
        return wind;
    }

    /**
     * @return the weather of the day
     */
    public String getWeather() {
        return weather;
    }
}
