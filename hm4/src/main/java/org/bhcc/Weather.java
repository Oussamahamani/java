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

    public double getPrecipitation() {
        return precipitation;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public double getWind() {
        return wind;
    }

    public String getWeather() {
        return weather;
    }

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


}
