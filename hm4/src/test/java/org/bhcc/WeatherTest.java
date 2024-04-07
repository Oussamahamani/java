package org.bhcc;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class WeatherTest {

    @Test
    void getPrecipitation() throws IOException {
        Weather day = new Weather("2012-01-02");
        assertEquals(10.9,day.getPrecipitation());
    }

    @Test
    void getTemp_max ()throws IOException {
        Weather day = new Weather("2012-01-02");
        assertEquals(10.6,day.getTemp_max());
    }

    @Test
    void getTemp_min ()throws IOException {
        Weather day = new Weather("2012-01-02");
        assertEquals(2.8,day.getTemp_min());
    }

    @Test
    void getWind ()throws IOException {
        Weather day = new Weather("2012-01-02");
        assertEquals(4.5,day.getWind());
    }

    @Test
    void getWeather ()throws IOException {
        Weather day = new Weather("2012-01-02");
        assertEquals("rain",day.getWeather());
    }
}