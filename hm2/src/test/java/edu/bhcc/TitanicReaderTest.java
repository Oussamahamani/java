package edu.bhcc;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class TitanicReaderTest {

    @Test
    void getNumPassengers() {
        TitanicReader titanic = new TitanicReader(new File("src/test/test_data/titanic.csv"));
        assertEquals(891, titanic.getNumPassengers());
    }

    @Test
    void getNumFirstClassPassengers() {
        TitanicReader titanic = new TitanicReader(new File("src/test/test_data/titanic.csv"));
        assertEquals(216, titanic.getNumFirstClassPassengers());
    }

    @Test
    void getNumSecondClassPassengers() {
        TitanicReader titanic = new TitanicReader(new File("src/test/test_data/titanic.csv"));
        assertEquals(184, titanic.getNumSecondClassPassengers());
    }

    @Test
    void getNumThirdClassPassengers() {
        TitanicReader titanic = new TitanicReader(new File("src/test/test_data/titanic.csv"));
        assertEquals(491, titanic.getNumThirdClassPassengers());
    }
}