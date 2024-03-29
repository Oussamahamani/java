package org.bhcc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class parseDataTest {

    @Test
    void parse() throws SQLException, IOException, ClassNotFoundException {

        Assertions.assertEquals(1461, parseData.parse());
    }
}