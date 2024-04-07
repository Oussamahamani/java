package org.bhcc;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Weather implements Serializable {

    public double precipitation, temp_max, temp_min,wind;
    public String weather;




    /**
     * Constructor
     */
    public Weather(String date) throws IOException {

        File file = new File("src/main/resources/seattle-weather.csv");
        TextReader reader = new TextReader(file);
        ArrayList<String> lines = reader.getContent();
        for (String line : lines) {

            if(Objects.equals(date, line.substring(0, 10))){
            System.out.println(line);
                String[] lineArr = line.split(",");
                this.precipitation = Double.parseDouble(lineArr[1]);
                this.temp_max = Double.parseDouble(lineArr[2]);
                this.temp_min = Double.parseDouble(lineArr[3]);
                this.wind = Double.parseDouble(lineArr[4]);
                this.weather = lineArr[5];

            }
        }
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
